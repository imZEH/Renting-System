/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental_Gui;

import Rental.Methods.*;
import Rental.model.Collection;
import Rental.model.Customer;
import Rental.model.Map;
import Rental.model.Stall;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public final class mangersview extends javax.swing.JFrame implements ActionListener {
   Timer clockTimer;
   java.sql.Connection con1 = null;
    java.sql.Connection con2 = null;
    PreparedStatement pst = null;
   ResultSet rs = null;
   
    
     
    
    public mangersview() {
        initComponents();
        clockTimer = new Timer(1000,this );
        clockTimer.start();
        date.setEditable(false);
        date.setText(getDate());
        setResizable(false);
        Map();
        time.setEditable(false);
        mapupdate.setEditable(false);
        jLabel12.setVisible(false);
        }
   
   
    
    
   public void Map(){
     try{
    con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
     con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
     
     String get = "Select * from ZEH.Map M";
      pst = (PreparedStatement) con1.prepareStatement(get);
      pst = (PreparedStatement) con2.prepareStatement(get);
     rs = pst.executeQuery();
     if(rs.last()){
     String mapdate = rs.getString("Date_Update");
     byte[] imagedata = rs.getBytes("Map_Image") ;
            Image img = Toolkit.getDefaultToolkit().createImage(imagedata);
            ImageIcon icon =new ImageIcon(img);
            lablemap.setIcon(icon);
            mapupdate.setText(mapdate);
     }
     con1.close();con1.close();
     }catch(Exception e){
     JOptionPane.showMessageDialog(null,e);}
     }
    
    
    
    public String getDate()
   {
      DateFormat dateFormat = new SimpleDateFormat( "MMMMMMMMM d, yyyy" );
      Calendar calendar = Calendar.getInstance();
      return dateFormat.format( calendar.getTime() );
   }
    
    public void Increment(){
        //setVisible(false);
        int z = 0;
        new AddCustomer().setVisible(true);
        try{
        con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
        con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
        
            
        String sql = "select * from ZEH.Customer";
         pst = (PreparedStatement) con1.prepareStatement(sql);
         rs = pst.executeQuery();
      pst = (PreparedStatement) con2.prepareStatement(sql);
        
        AddCustomer.idnum.setEditable(false);
        AddCustomer.idnum.setText(Integer.toString(4000));
        if (rs.last()) {
             String Cus_Num = rs.getString(1);
             z = Integer.parseInt(Cus_Num);
             z = z+1;
             AddCustomer.idnum.setText(Integer.toString(z));
             
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);}
        
        }
    public void INCREMENT(){
       // setVisible(false);
         new addStall().setVisible(true);
         try{
         
         con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
         con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
         
         
         String sql = "select * from ZEH.Stall ST";
         pst = (PreparedStatement) con1.prepareStatement(sql);
      pst = (PreparedStatement) con2.prepareStatement(sql);
         rs = pst.executeQuery();
         addStall.stallnum.setEditable(false);
         addStall.stallnum.setText(Integer.toString(6000));
         if (rs.last()) {
         String Stall_Num = rs.getString(1);
         int z = Integer.parseInt(Stall_Num );
         z = z+1;
         addStall.stallnum.setText(Integer.toString(z));
         }
         }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);}
        }
    
    public void UPDATE(){
        try{
        con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
        con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
        
        
        int row = stalltable.getSelectedRow();
        String TableClick = (stalltable.getModel().getValueAt(row, 0).toString());
        String sql = "select ST.Stall_Num,ST.Stall_Name,ST.Stall_Status,RATE.SRH_Price,S.Section_Num,S.Section_Type,S.Section_Description from ZEH.Section S "
                    + "INNER JOIN ZEH.Stall ST ON ST.Section_Num = S.Section_Num "
                    + " INNER JOIN ZEH.Stall_Rate_History RATe On RATe.Stall_Num = ST.Stall_Num where ST.Stall_Num ='"+TableClick+"'";
        
        pst = (PreparedStatement) con1.prepareStatement(sql);
        pst = (PreparedStatement) con2.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs.next()){
        int Joption = JOptionPane.showConfirmDialog(null,"Do you want to Edit this Information?","prompt",JOptionPane.YES_NO_OPTION);
        if(Joption == JOptionPane.YES_OPTION){
        //setVisible(false);
        new UpdateStall().setVisible(true);
        }
        else if(Joption == JOptionPane.NO_OPTION){
        }
             
             int StallNum = (Integer.parseInt(rs.getString("Stall_Num")));
             String StallName = rs.getString("Stall_Name");
             String SecNum = rs.getString("Section_Num");
             String StallLocation = rs.getString("Section_Description");
             String StallSection = rs.getString ("Section_Type");
             double StallPrice = (Double.parseDouble(rs.getString("SRH_Price")));
             String ST = rs.getString("Stall_Status");
             Rental_Gui.UpdateStall.updatestallnum.setEditable(false);
             Rental_Gui.UpdateStall.updatestallnum.setText(Integer.toString(StallNum));
             Rental_Gui.UpdateStall.updatesname.setText(StallName);
             Rental_Gui.UpdateStall.updateloc.setSelectedItem(StallLocation);
             Rental_Gui.UpdateStall.updatesec.setSelectedItem(StallSection);
             Rental_Gui.UpdateStall.updateprice.setText(Double.toString(StallPrice));
             Rental_Gui.UpdateStall.status.setSelectedItem(ST);
             Rental_Gui.UpdateStall.SEC.setText(SecNum);
             }
             }
        
        catch(Exception e){
        JOptionPane.showMessageDialog(null,"Select Stall from List to Update","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(){
       try{
       con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
        con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
       int row = custable.getSelectedRow();
       String TableClick = (custable.getModel().getValueAt(row, 0).toString());
       String sql = "SELECT Cus.Cus_LName, Cus.Cus_FName, Cus.Cus_MidName ,Cus.Cus_Num,Cus.Cus_Address,Cus.Cus_ContactNum,Cus.Cus_Path,Cus.Cus_Image,ST.Stall_Num,ST.Stall_Name,RATE.SRH_Price from ZEH.Stall_Rent_History SRH"
               + " INNER JOIN ZEH.Customer Cus ON SRH.Cus_Num = Cus.Cus_Num "
               + " INNER JOIN ZEH.Stall ST ON ST.Stall_Num = SRH.Stall_Num "
               + " INNER JOIN ZEH.Stall_Rate_History RATE ON RATE.Stall_Num = ST.Stall_Num where Cus.Cus_Num ='"+TableClick+"'";
       String sql1 = "Select Section_Num , Section_Type, Section_Description from Section";
       pst = (PreparedStatement) con1.prepareStatement(sql);
       pst = (PreparedStatement) con2.prepareStatement(sql);
       pst = (PreparedStatement) con1.prepareStatement(sql1);
       pst = (PreparedStatement) con2.prepareStatement(sql1);
       
       rs = pst.executeQuery();
       while(rs.next()){
       int Joption = JOptionPane.showConfirmDialog(null,"Do you want to Edit this Information?","prompt",JOptionPane.YES_NO_OPTION);
       if(Joption == JOptionPane.YES_OPTION){
       // setVisible(false);
       new UpdateCustomer().setVisible(true);
       }
       else if(Joption == JOptionPane.NO_OPTION){
            
       }  
             int Id = (Integer.parseInt(rs.getString("Cus_Num")));
             String Fname = rs.getString("Cus_FName");
             String MName = rs.getString("Cus_MidName");
             String LName = rs.getString ("Cus_LName");
             String Address = rs.getString("Cus_Address");
             String ConNum = rs.getString("Cus_ContactNum");
             String StallNum = rs.getString("Stall_Num");
             String Stallname = rs.getString("Stall_Name");
             String Path = rs.getString("Cus_Path");
             byte[] imagedata = rs.getBytes("Cus_Image") ;
             Image img = Toolkit.getDefaultToolkit().createImage(imagedata);
             ImageIcon icon =new ImageIcon(img);
             lablemap.setIcon(icon);
      while (rs.next()){
             String SECNum = rs.getString("Section_Num");
             String SecType = rs.getString("Section_Type");
             String SECDes = rs.getString("Section_Description");
             
             Rental_Gui.UpdateCustomer.idnum.setEditable(false);
             Rental_Gui.UpdateCustomer.updatetext.setEditable(false);
             Rental_Gui.UpdateCustomer.idnum.setText(Integer.toString(Id));
             Rental_Gui.UpdateCustomer.fname.setText(Fname);
             Rental_Gui.UpdateCustomer.mname.setText(MName);
             Rental_Gui.UpdateCustomer.lname.setText(LName);
             Rental_Gui.UpdateCustomer.add.setText(Address);
             Rental_Gui.UpdateCustomer.connum.setText(ConNum);
             Rental_Gui.UpdateCustomer.pat.setText(Path);
             Rental_Gui.UpdateCustomer.updatetext.setText(StallNum);
             Rental_Gui.UpdateCustomer.updateStallCombo.addItem(StallNum);
             Rental_Gui.UpdateCustomer.stallname.setText(Stallname);
             Rental_Gui.UpdateCustomer.stallLoc.setText(SECDes);
             Rental_Gui.UpdateCustomer.stallsec.setText(SecType);
             Rental_Gui.UpdateCustomer.icon.setIcon(icon);
             Rental_Gui.UpdateCustomer.SECT.setText(SECNum);
             }
             }
        }
        
        catch(Exception e){
       JOptionPane.showMessageDialog(null,"Select Customer from List to Update","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CustomerView = new javax.swing.JPopupMenu();
        Customer = new javax.swing.JMenu();
        CustomerAdd = new javax.swing.JMenuItem();
        UpdateCustomer = new javax.swing.JMenuItem();
        viewu = new javax.swing.JMenuItem();
        help = new javax.swing.JMenuItem();
        signout = new javax.swing.JMenuItem();
        deact = new javax.swing.JMenuItem();
        StallView = new javax.swing.JPopupMenu();
        Menu = new javax.swing.JMenu();
        StallAdd = new javax.swing.JMenuItem();
        UpdateStall = new javax.swing.JMenuItem();
        viewuser = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        Signout = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        custable = new javax.swing.JTable();
        clear = new javax.swing.JButton();
        Lname = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Picture = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stalltable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        stallnum = new javax.swing.JTextField();
        filter = new javax.swing.JComboBox();
        jScrollPane8 = new javax.swing.JScrollPane();
        stalltable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cusreport = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        CustomerMenu = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        stallreport = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        stall = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Month = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        Year = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        mnth = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        totalMN = new javax.swing.JTable();
        year = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        map = new javax.swing.JPanel();
        lablemap = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        mapupdate = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        sigout = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        CustomerView.setComponentPopupMenu(CustomerView);

        Customer.setText("Menu");

        CustomerAdd.setText("Add Customer");
        CustomerAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerAddActionPerformed(evt);
            }
        });
        Customer.add(CustomerAdd);

        UpdateCustomer.setText("Update Customer");
        UpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateCustomerActionPerformed(evt);
            }
        });
        Customer.add(UpdateCustomer);

        viewu.setText("View Users");
        viewu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewuActionPerformed(evt);
            }
        });
        Customer.add(viewu);

        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        Customer.add(help);

        signout.setText("Log out");
        signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutActionPerformed(evt);
            }
        });
        Customer.add(signout);

        deact.setText("DeActivate");
        deact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deactActionPerformed(evt);
            }
        });
        Customer.add(deact);

        CustomerView.add(Customer);

        Menu.setText("Menu");

        StallAdd.setText("Add Stall");
        StallAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StallAddActionPerformed(evt);
            }
        });
        Menu.add(StallAdd);

        UpdateStall.setText("Update Stall");
        UpdateStall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateStallActionPerformed(evt);
            }
        });
        Menu.add(UpdateStall);

        viewuser.setText("View Users");
        viewuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewuserActionPerformed(evt);
            }
        });
        Menu.add(viewuser);

        jMenuItem1.setText("Help");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Menu.add(jMenuItem1);

        Signout.setText("Log out");
        Signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignoutActionPerformed(evt);
            }
        });
        Menu.add(Signout);

        StallView.add(Menu);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jPanel2.setBackground(java.awt.Color.orange);
        jPanel2.setComponentPopupMenu(CustomerView);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Customers List");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Search");

        custable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        custable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Number", "Full Name", "Address", "Contact Number", "Status", "Stall Purchase", "Amount", "DueDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        custable.setComponentPopupMenu(CustomerView);
        custable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        custable.getTableHeader().setReorderingAllowed(false);
        custable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                custableMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(custable);
        custable.getColumnModel().getColumn(0).setResizable(false);
        custable.getColumnModel().getColumn(0).setPreferredWidth(100);
        custable.getColumnModel().getColumn(1).setResizable(false);
        custable.getColumnModel().getColumn(1).setPreferredWidth(200);
        custable.getColumnModel().getColumn(2).setResizable(false);
        custable.getColumnModel().getColumn(2).setPreferredWidth(150);
        custable.getColumnModel().getColumn(3).setResizable(false);
        custable.getColumnModel().getColumn(3).setPreferredWidth(150);
        custable.getColumnModel().getColumn(4).setResizable(false);
        custable.getColumnModel().getColumn(5).setResizable(false);
        custable.getColumnModel().getColumn(5).setPreferredWidth(100);
        custable.getColumnModel().getColumn(6).setResizable(false);
        custable.getColumnModel().getColumn(7).setResizable(false);
        custable.getColumnModel().getColumn(7).setPreferredWidth(150);

        clear.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        clear.setText("Clear Field");
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        Lname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Lname.setText("By FirstName Or Surname Or MiddleName");
        Lname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LnameMouseClicked(evt);
            }
        });
        Lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LnameActionPerformed(evt);
            }
        });
        Lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LnameKeyTyped(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Picture", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), java.awt.Color.orange)); // NOI18N

        Picture.setBackground(new java.awt.Color(204, 204, 204));
        Picture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Picture.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Picture, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(Picture, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(340, 340, 340))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Lname, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clear))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(Lname, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                        .addGap(0, 11, 11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Customers", jPanel2);

        jPanel3.setBackground(java.awt.Color.orange);
        jPanel3.setComponentPopupMenu(StallView);

        stalltable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stalltable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stall Number", "Stall Name", "Location", "Section", "Status", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stalltable.setComponentPopupMenu(StallView);
        stalltable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stalltable.getTableHeader().setReorderingAllowed(false);
        stalltable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stalltableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(stalltable);
        stalltable.getColumnModel().getColumn(0).setResizable(false);
        stalltable.getColumnModel().getColumn(1).setResizable(false);
        stalltable.getColumnModel().getColumn(2).setResizable(false);
        stalltable.getColumnModel().getColumn(3).setResizable(false);
        stalltable.getColumnModel().getColumn(4).setResizable(false);
        stalltable.getColumnModel().getColumn(5).setResizable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Stall Information");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Search");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText("Clear Field");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        stallnum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        stallnum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stallnum.setText("By Stall Number Or Status");
        stallnum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stallnumMouseClicked(evt);
            }
        });
        stallnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stallnumActionPerformed(evt);
            }
        });
        stallnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stallnumKeyReleased(evt);
            }
        });

        filter.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        filter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "View All", "Branch 1", "Branch 2" }));
        filter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterItemStateChanged(evt);
            }
        });
        filter.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                filterPropertyChange(evt);
            }
        });

        stalltable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stall Number", "Stall_Name", "Location", "Section", "Status", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(stalltable1);
        stalltable1.getColumnModel().getColumn(0).setResizable(false);
        stalltable1.getColumnModel().getColumn(1).setResizable(false);
        stalltable1.getColumnModel().getColumn(2).setResizable(false);
        stalltable1.getColumnModel().getColumn(3).setResizable(false);
        stalltable1.getColumnModel().getColumn(4).setResizable(false);
        stalltable1.getColumnModel().getColumn(5).setResizable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setText("Branch 2");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel15.setText("Branch 1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 515, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(stallnum, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(102, 102, 102)
                        .addComponent(jLabel13)
                        .addGap(224, 224, 224))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(stallnum, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filter)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Stalls", jPanel3);

        jPanel6.setBackground(java.awt.Color.orange);

        jTabbedPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        cusreport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cusreport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Number", "Full Name", "Active/InActive", "Purchase Stall", "Date of Stall Purchase", "Stall Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cusreport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cusreport.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(cusreport);
        cusreport.getColumnModel().getColumn(0).setResizable(false);
        cusreport.getColumnModel().getColumn(0).setPreferredWidth(150);
        cusreport.getColumnModel().getColumn(1).setResizable(false);
        cusreport.getColumnModel().getColumn(1).setPreferredWidth(200);
        cusreport.getColumnModel().getColumn(2).setResizable(false);
        cusreport.getColumnModel().getColumn(3).setResizable(false);
        cusreport.getColumnModel().getColumn(4).setResizable(false);
        cusreport.getColumnModel().getColumn(5).setResizable(false);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search By:");

        CustomerMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose:", "Active", "InActive" }));
        CustomerMenu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CustomerMenuItemStateChanged(evt);
            }
        });
        CustomerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustomerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CustomerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jTabbedPane3.addTab("Customers Report", jPanel7);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        stallreport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stallreport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stall Number", "Stall Name", "Section", "Location", "Status", "Date Update Price", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stallreport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stallreport.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(stallreport);
        stallreport.getColumnModel().getColumn(0).setResizable(false);
        stallreport.getColumnModel().getColumn(1).setResizable(false);
        stallreport.getColumnModel().getColumn(2).setResizable(false);
        stallreport.getColumnModel().getColumn(3).setResizable(false);
        stallreport.getColumnModel().getColumn(4).setResizable(false);
        stallreport.getColumnModel().getColumn(5).setResizable(false);
        stallreport.getColumnModel().getColumn(6).setResizable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Search By:");

        stall.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose:", "Available", "UnAvailable" }));
        stall.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                stallItemStateChanged(evt);
            }
        });
        stall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1152, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stall, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(stall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Stalls Report", jPanel8);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        Month.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Month.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User", "Month", "Stall Name", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Month.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Month.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(Month);
        Month.getColumnModel().getColumn(0).setResizable(false);
        Month.getColumnModel().getColumn(0).setPreferredWidth(200);
        Month.getColumnModel().getColumn(1).setResizable(false);
        Month.getColumnModel().getColumn(1).setPreferredWidth(150);
        Month.getColumnModel().getColumn(2).setResizable(false);
        Month.getColumnModel().getColumn(3).setResizable(false);

        Year.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Year.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Year", "Totoal UnCollected", "Total Collection", "Total Arrears Collected"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Year.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Year.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(Year);
        Year.getColumnModel().getColumn(0).setResizable(false);
        Year.getColumnModel().getColumn(1).setResizable(false);
        Year.getColumnModel().getColumn(2).setResizable(false);
        Year.getColumnModel().getColumn(3).setResizable(false);

        jLabel8.setBackground(java.awt.Color.orange);
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Monthly Collection");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Yearly Collection");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Search By:");

        mnth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose:", "January", "February", "March", "April", "May", "June", "July", "August", "Sepetember", "October", "November", "December" }));
        mnth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mnthItemStateChanged(evt);
            }
        });

        totalMN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalMN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Month", "Total Collection"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        totalMN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane5.setViewportView(totalMN);
        totalMN.getColumnModel().getColumn(0).setResizable(false);
        totalMN.getColumnModel().getColumn(1).setResizable(false);

        year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose:", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));
        year.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(187, 187, 187))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mnth, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(mnth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Collections Report", jPanel1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reports", jPanel6);

        jPanel5.setBackground(java.awt.Color.orange);

        map.setBackground(new java.awt.Color(0, 0, 0));
        map.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Map", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), java.awt.Color.orange)); // NOI18N

        lablemap.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lablemap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout mapLayout = new javax.swing.GroupLayout(map);
        map.setLayout(mapLayout);
        mapLayout.setHorizontalGroup(
            mapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lablemap, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        mapLayout.setVerticalGroup(
            mapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapLayout.createSequentialGroup()
                .addComponent(lablemap, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Attached Map");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        print.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        print.setText("Print Map");
        print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Map Date Modified:");

        mapupdate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        mapupdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mapupdate.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(map, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mapupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(map, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapupdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(print)
                            .addComponent(jLabel14))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("View Map", jPanel5);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Date :");

        date.setBackground(java.awt.Color.orange);
        date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        date.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Time:");

        time.setBackground(java.awt.Color.orange);
        time.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        time.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        time.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                timeMouseMoved(evt);
            }
        });
        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });
        time.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                timePropertyChange(evt);
            }
        });
        time.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                timeKeyReleased(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenu4.setText("| Menu |");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Add Customer");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Update Customer");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Add Stall");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Update Stall");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("View Users");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("| Log out |");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });

        sigout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        sigout.setText("Log out");
        sigout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigoutActionPerformed(evt);
            }
        });
        jMenu2.add(sigout);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("| Help |");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(time))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
       /*try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZEH", "root", "1234");
	JasperDesign jasperDesign = JRXmlLoader.load("report2.jrxml");
        String sql = "Select  * from Map";
        JRDesignQuery newQuery = new JRDesignQuery();
        newQuery.setText(sql);
        jasperDesign.setQuery(newQuery);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign );
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
        JasperViewer.viewReport(jasperPrint);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }*/
    }//GEN-LAST:event_printActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFrame frame = null;
        JFileChooser chooser;
        String path = null;
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        File selFile = fc.getSelectedFile();
        path=selFile.getPath();
        ImageIcon icon1 = new ImageIcon(path);
        lablemap.setIcon(icon1);
        jLabel12.setText(path);
        }
        String Date = date.getText();
        String image = jLabel12.getText();
        
        Map m = new Map(image,Date);
        AddMap add = new AddMap();
        
        try {
            add.Add(m);
            JOptionPane.showMessageDialog(null,"Information Succesfully added");
            mapupdate.setText(Date);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CustomerAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerAddActionPerformed
       Increment();
    }//GEN-LAST:event_CustomerAddActionPerformed

    private void StallAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StallAddActionPerformed
       INCREMENT();
    }//GEN-LAST:event_StallAddActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        int Joption = JOptionPane.showConfirmDialog(null,"This action proceed to exit\n want to Proceed?","prompt",JOptionPane.YES_NO_OPTION);
        if(Joption == JOptionPane.YES_OPTION){
        setVisible(false);
        new Home().setVisible(true);
        }
        else if(Joption == JOptionPane.NO_OPTION){
            
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    private void custableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custableMouseClicked
       try{
        int row = custable.getSelectedRow();
        String TableClick = (custable.getModel().getValueAt(row, 0).toString());
        
        con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
      con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
        
        String PICTURE = "Select * from ZEH.Customer Cus where  Cus.Cus_Num  = '"+TableClick+"'";
        pst = (PreparedStatement) con1.prepareStatement(PICTURE);
      pst = (PreparedStatement) con2.prepareStatement(PICTURE);
         rs = pst.executeQuery();
        if (rs.next()){
        byte[] imagedata = rs.getBytes("Cus_Image") ;
             Image img = Toolkit.getDefaultToolkit().createImage(imagedata);
            ImageIcon icon =new ImageIcon(img);
            
            Picture.setIcon(icon);
            con1.close();
            con2.close();
        }
     }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
     }
    }//GEN-LAST:event_custableMouseClicked

    private void stalltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stalltableMouseClicked
        
    }//GEN-LAST:event_stalltableMouseClicked

    private void signoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutActionPerformed
        int Joption = JOptionPane.showConfirmDialog(null,"This action proceed to exit\n want to Proceed?","prompt",JOptionPane.YES_NO_OPTION);
        if(Joption == JOptionPane.YES_OPTION){
        setVisible(false);
        new Home().setVisible(true);
        }
        else if(Joption == JOptionPane.NO_OPTION){}
    }//GEN-LAST:event_signoutActionPerformed

    private void SignoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignoutActionPerformed
        int Joption = JOptionPane.showConfirmDialog(null,"This action proceed to exit\n want to Proceed?","prompt",JOptionPane.YES_NO_OPTION);
        if(Joption == JOptionPane.YES_OPTION){
        setVisible(false);
        new Home().setVisible(true);
        }
        else if(Joption == JOptionPane.NO_OPTION){
            
        }
    }//GEN-LAST:event_SignoutActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        Lname.setText("By FirstName Or Surname Or MiddleName");
        DefaultTableModel model=(DefaultTableModel)custable.getModel();
        int count =model.getRowCount();
        if (count != 0){
            model.setRowCount(0);
            }
        Picture.setIcon(null);
    }//GEN-LAST:event_clearActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       stallnum.setText("By Stall Number Or Status");
       DefaultTableModel model=(DefaultTableModel)stalltable.getModel();
       int count =model.getRowCount();
       if (count != 0){
       model.setRowCount(0);
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void timeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeKeyReleased
           
    }//GEN-LAST:event_timeKeyReleased

    private void timePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_timePropertyChange
      
    }//GEN-LAST:event_timePropertyChange

    private void timeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeMouseMoved
       
    }//GEN-LAST:event_timeMouseMoved

    private void stallnumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stallnumKeyReleased
      DefaultTableModel model=(DefaultTableModel)stalltable.getModel();
      String empty = stallnum.getText();
      if (model.getRowCount() != 0){
      model.setRowCount(0);
      }
      List<Stall> sList = new ArrayList<Stall>();
      queryStall p =new queryStall();
        
      try {
      sList = p.RetrieveStall(empty, empty);
          
            for (int i=0;i<sList.size();i++){
            model.addRow(new Object[]{});
            stalltable.setValueAt(sList.get(i).getStall_Num(), i, 0);
            stalltable.setValueAt(sList.get(i).getStall_Name(), i, 1);
            stalltable.setValueAt(sList.get(i).getStall_Description(), i, 2);
            stalltable.setValueAt(sList.get(i).getSection_Type(), i, 3);
            stalltable.setValueAt(sList.get(i).getStall_Status(), i, 4);
            stalltable.setValueAt(sList.get(i).getStall_Price(), i, 5);
            
        }
       if(empty.isEmpty()){
       model.setRowCount(0);
       }
       } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_stallnumKeyReleased

    private void LnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LnameKeyReleased
       DefaultTableModel model=(DefaultTableModel)custable.getModel();
       String empty = Lname.getText();
       if (model.getRowCount() != 0){
            model.setRowCount(0);
        }
        List<Customer> sList = new ArrayList<Customer>();   
        queryCustomer p =new queryCustomer();
        
        try {
            sList = p.RetrieveCustomer(empty, empty, empty, empty);
          
            for (int i=0;i<sList.size();i++){
            model.addRow(new Object[]{});
            custable.setValueAt(sList.get(i).getCus_Num(),i,1);
            custable.setValueAt(sList.get(i).getFullname(), i, 1);
            custable.setValueAt(sList.get(i).getCus_Address(), i, 2);
            custable.setValueAt(sList.get(i).getCus_ContactNumber(), i, 3);
            custable.setValueAt(sList.get(i).getCus_Status(), i, 4);
            custable.setValueAt(sList.get(i).getStall_Name(), i, 5);
            custable.setValueAt(sList.get(i).getSRH_Price(), i, 6);
            custable.setValueAt(sList.get(i).getSTH_DueDate(), i, 7);
        }
        if(empty.isEmpty()){
        model.setRowCount(0);
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_LnameKeyReleased

    private void stallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stallActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stallActionPerformed

    private void LnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LnameKeyTyped
       
    }//GEN-LAST:event_LnameKeyTyped

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed
        time.setText(String.format("%tI:%<tM %<Tp", new Date()));
    }//GEN-LAST:event_timeActionPerformed

    private void LnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LnameActionPerformed

    private void UpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateCustomerActionPerformed
        update();    
    }//GEN-LAST:event_UpdateCustomerActionPerformed

    private void sigoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigoutActionPerformed
      int Joption = JOptionPane.showConfirmDialog(null,"This action proceed to exit\n want to Proceed?","prompt",JOptionPane.YES_NO_OPTION);
      if(Joption == JOptionPane.YES_OPTION){
      setVisible(false);
      new Home().setVisible(true);
        }
      else if(Joption == JOptionPane.NO_OPTION){}
    }//GEN-LAST:event_sigoutActionPerformed

    private void UpdateStallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateStallActionPerformed
     UPDATE();
    }//GEN-LAST:event_UpdateStallActionPerformed

    private void CustomerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerMenuActionPerformed

    private void stallnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stallnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stallnumActionPerformed

    private void LnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LnameMouseClicked
        Lname.setText("");
    }//GEN-LAST:event_LnameMouseClicked

    private void stallnumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stallnumMouseClicked
        stallnum.setText("");
    }//GEN-LAST:event_stallnumMouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        Help1 h = new Help1();
        h.setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       Increment();   
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       INCREMENT();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       update();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        UPDATE();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        Help1 h = new Help1();
        h.setVisible(true);
    }//GEN-LAST:event_helpActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Help1 h = new Help1();
        h.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void viewuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewuActionPerformed
       new ViewUser().setVisible(true);
    }//GEN-LAST:event_viewuActionPerformed

    private void viewuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewuserActionPerformed
       new ViewUser().setVisible(true);
    }//GEN-LAST:event_viewuserActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
         new ViewUser().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void deactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deactActionPerformed
       int row = custable.getSelectedRow();
       String TableClick = (custable.getModel().getValueAt(row, 0).toString());
       int r = Integer.parseInt(TableClick);
       addstall update = new addstall();
       updateCustomer up = new updateCustomer();
       try {
       update.updatestallStatus(r);
       up.DeleteCus(r);
       JOptionPane.showMessageDialog(null, "Process Sucessful");
       }    
       catch(Exception e){
       JOptionPane.showMessageDialog(null,e);   
       }
    }//GEN-LAST:event_deactActionPerformed

    private void yearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearItemStateChanged
       DefaultTableModel model=(DefaultTableModel)Year.getModel();
      
      String empty = (String) year.getSelectedItem();
      if (model.getRowCount() != 0){
      model.setRowCount(0);
      }
      List<Collection> sList = new ArrayList<Collection>();   
      queryCollection p =new queryCollection();
      try {
            sList = p.RetrieveTotalCollectionYear(empty);
          
            for (int i=0;i<sList.size();i++){
            model.addRow(new Object[]{});
            Year.setValueAt(sList.get(i).getColl_Date(), i, 0);
            Year.setValueAt(sList.get(i).getUnCollect(), i, 1);
            Year.setValueAt(sList.get(i).getCol_Monthly(), i, 2);
            Year.setValueAt(sList.get(i).getTotalArrears(), i, 3);
        }
      if(empty.isEmpty()){
      model.setRowCount(0);
      }
      } catch (Exception ex) {
      }
    }//GEN-LAST:event_yearItemStateChanged

    private void LnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LnameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_LnameKeyPressed

    private void custableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_custableMouseEntered

    private void CustomerMenuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CustomerMenuItemStateChanged
       DefaultTableModel model=(DefaultTableModel)cusreport.getModel();
      
       String empty = (String) CustomerMenu.getSelectedItem();
       if (model.getRowCount() != 0){
       model.setRowCount(0);
       }
       List<Customer> sList = new ArrayList<Customer>();   
       queryCustomer p =new queryCustomer();
       try {
            sList = p.retrieveCustomerReport(empty);
          
            for (int i=0;i<sList.size();i++){
            model.addRow(new Object[]{});
            cusreport.setValueAt(sList.get(i).getCus_Num(), i, 0);
            cusreport.setValueAt(sList.get(i).getFullname(), i, 1);
            cusreport.setValueAt(sList.get(i).getCus_Status(), i, 2);
            cusreport.setValueAt(sList.get(i).getStall_Name(), i, 3);
            cusreport.setValueAt(sList.get(i).getSTH_Date_OF_Rent(), i, 4);
            cusreport.setValueAt(sList.get(i).getSRH_Price(), i, 5);
            
        }
        if(empty.isEmpty()){
        model.setRowCount(0);
            }
          } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_CustomerMenuItemStateChanged

    private void stallItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_stallItemStateChanged
       DefaultTableModel model=(DefaultTableModel)stallreport.getModel();
      
       String empty = (String) stall.getSelectedItem();
       if (model.getRowCount() != 0){
       model.setRowCount(0);
       }
         List<Stall> sList = new ArrayList<Stall>();   
         queryStall p =new queryStall();
        
       try {
            sList = p.RetrieveStallReport(empty);
          
            for (int i=0;i<sList.size();i++){
            model.addRow(new Object[]{});
            stallreport.setValueAt(sList.get(i).getStall_Num(), i, 0);
            stallreport.setValueAt(sList.get(i).getStall_Name(), i, 1);
            stallreport.setValueAt(sList.get(i).getSection_Type(), i, 2);
            stallreport.setValueAt(sList.get(i).getStall_Description(), i, 3);
            stallreport.setValueAt(sList.get(i).getStall_Status(), i, 4);
            stallreport.setValueAt(sList.get(i).getSTH_Date_Of_Rent(), i, 5);
            stallreport.setValueAt(sList.get(i).getStall_Price(), i, 6);
            
        }
        if(empty.isEmpty()){
        model.setRowCount(0);
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_stallItemStateChanged

    private void mnthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mnthItemStateChanged
       DefaultTableModel model=(DefaultTableModel)Month.getModel();
       DefaultTableModel model1=(DefaultTableModel)totalMN.getModel();
       String empty = (String) mnth.getSelectedItem();
       if (model.getRowCount() != 0){
            model.setRowCount(0);
       }
      if (model1.getRowCount() != 0){
       model1.setRowCount(0);
      }
         List<Collection> sList = new ArrayList<Collection>();
         List<Collection> sList1 = new ArrayList<Collection>(); 
        queryCollection p =new queryCollection();
        
      try {
            sList = p.RetrieveCollection(empty);
             sList1 = p.RetrieveTotalCollection(empty);
          
            for (int i=0;i<sList.size();i++){
            model.addRow(new Object[]{});
            Month.setValueAt(sList.get(i).getEmp_FullName(), i, 0);
            Month.setValueAt(sList.get(i).getColl_Date(), i, 1);
            Month.setValueAt(sList.get(i).getStall_Name(), i, 2);
            Month.setValueAt(sList.get(i).getCol_Monthly(), i, 3);
            
        }
            for (int i=0;i<sList1.size();i++){
             model1.addRow(new Object[]{});
             totalMN.setValueAt(sList1.get(i).getColl_Date(), i, 0);
             totalMN.setValueAt(sList1.get(i).getCol_Monthly(), i, 1);
            }
     if(empty.isEmpty()){
     model.setRowCount(0);
     model1.setRowCount(0);
     }
     } catch (Exception ex) {
     }
    }//GEN-LAST:event_mnthItemStateChanged

    private void filterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterItemStateChanged

        String stal = (String) filter.getSelectedItem();
        if(stal.equals("View All")){
                  DefaultTableModel model=(DefaultTableModel)stalltable.getModel();
                  DefaultTableModel model1=(DefaultTableModel)stalltable1.getModel();
      String empty = "6";
      if (model.getRowCount() != 0 || model1.getRowCount() !=0){
      model.setRowCount(0);
      model1.setRowCount(0);
      }
      List<Stall> sList = new ArrayList<Stall>();
      queryStall p =new queryStall();
      List<Stall> sList1 = new ArrayList<Stall>();
      queryStall p1 =new queryStall();
        
      try {
      sList = p.branch1(empty, empty);
            for (int i=0;i<sList.size();i++){
            model.addRow(new Object[]{});
            stalltable.setValueAt(sList.get(i).getStall_Num(), i, 0);
            stalltable.setValueAt(sList.get(i).getStall_Name(), i, 1);
            stalltable.setValueAt(sList.get(i).getStall_Description(), i, 2);
            stalltable.setValueAt(sList.get(i).getSection_Type(), i, 3);
            stalltable.setValueAt(sList.get(i).getStall_Status(), i, 4);
            stalltable.setValueAt(sList.get(i).getStall_Price(), i, 5);
           
            }
            sList1 = p1.branch2(empty, empty);
            for (int j=0;j<sList1.size();j++){
            model1.addRow(new Object[]{});
            stalltable1.setValueAt(sList1.get(j).getStall_Num(), j, 0);
            stalltable1.setValueAt(sList1.get(j).getStall_Name(), j, 1);
            stalltable1.setValueAt(sList1.get(j).getStall_Description(), j, 2);
            stalltable1.setValueAt(sList1.get(j).getSection_Type(), j, 3);
            stalltable1.setValueAt(sList1.get(j).getStall_Status(), j, 4);
            stalltable1.setValueAt(sList1.get(j).getStall_Price(), j, 5);
           
            }
       if(empty.isEmpty()||empty.isEmpty()){
       model.setRowCount(0);
       model1.setRowCount(0);
       }
       } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        }
        else if(stal.equals("Branch 1")){
            
            DefaultTableModel model=(DefaultTableModel)stalltable.getModel();
            DefaultTableModel model1=(DefaultTableModel)stalltable1.getModel();
            model1.setRowCount(0);
      String empty = "6";
      if (model.getRowCount() != 0){
      model.setRowCount(0);
      }
      List<Stall> sList = new ArrayList<Stall>();
      queryStall p =new queryStall();
        
      try {
          
      sList = p.branch1(empty, empty);
          
            for (int i=0;i<sList.size();i++){
            model.addRow(new Object[]{});
            stalltable.setValueAt(sList.get(i).getStall_Num(), i, 0);
            stalltable.setValueAt(sList.get(i).getStall_Name(), i, 1);
            stalltable.setValueAt(sList.get(i).getStall_Description(), i, 2);
            stalltable.setValueAt(sList.get(i).getSection_Type(), i, 3);
            stalltable.setValueAt(sList.get(i).getStall_Status(), i, 4);
            stalltable.setValueAt(sList.get(i).getStall_Price(), i, 5);
            
        }
       if(empty.isEmpty()){
       model.setRowCount(0);
       }
       } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        }
        else if(stal.equals("Branch 2")){
            DefaultTableModel model=(DefaultTableModel)stalltable1.getModel();
            DefaultTableModel model1=(DefaultTableModel)stalltable.getModel();
            model1.setRowCount(0);
      String empty = "6";
      if (model.getRowCount() != 0){
      model.setRowCount(0);
      }
      List<Stall> sList = new ArrayList<Stall>();
      queryStall p =new queryStall();
        
      try {
      sList = p.branch2(empty, empty);
          
            for (int i=0;i<sList.size();i++){
            model.addRow(new Object[]{});
            stalltable1.setValueAt(sList.get(i).getStall_Num(), i, 0);
            stalltable1.setValueAt(sList.get(i).getStall_Name(), i, 1);
            stalltable1.setValueAt(sList.get(i).getStall_Description(), i, 2);
            stalltable1.setValueAt(sList.get(i).getSection_Type(), i, 3);
            stalltable1.setValueAt(sList.get(i).getStall_Status(), i, 4);
            stalltable1.setValueAt(sList.get(i).getStall_Price(), i, 5);
            
        }
       if(empty.isEmpty()){
       model.setRowCount(0);
       }
       } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        }
        else{
            DefaultTableModel model=(DefaultTableModel)stalltable1.getModel();
            DefaultTableModel model1=(DefaultTableModel)stalltable.getModel();
            model1.setRowCount(0);
            model.setRowCount(0);
        }
    }//GEN-LAST:event_filterItemStateChanged

    private void filterPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_filterPropertyChange
       
    }//GEN-LAST:event_filterPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mangersview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mangersview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mangersview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mangersview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new mangersview().setVisible(true);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        time.setText(String.format("%tI:%<tM:%<tS %<Tp", new Date()));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Customer;
    private javax.swing.JMenuItem CustomerAdd;
    private javax.swing.JComboBox CustomerMenu;
    private javax.swing.JPopupMenu CustomerView;
    private javax.swing.JTextField Lname;
    private javax.swing.JMenu Menu;
    private javax.swing.JTable Month;
    private javax.swing.JLabel Picture;
    private javax.swing.JMenuItem Signout;
    private javax.swing.JMenuItem StallAdd;
    private javax.swing.JPopupMenu StallView;
    private javax.swing.JMenuItem UpdateCustomer;
    private javax.swing.JMenuItem UpdateStall;
    private javax.swing.JTable Year;
    private javax.swing.JButton clear;
    private javax.swing.JTable cusreport;
    private javax.swing.JTable custable;
    public static javax.swing.JTextField date;
    private javax.swing.JMenuItem deact;
    private javax.swing.JComboBox filter;
    private javax.swing.JMenuItem help;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    public static javax.swing.JLabel lablemap;
    private javax.swing.JPanel map;
    private javax.swing.JTextField mapupdate;
    private javax.swing.JComboBox mnth;
    private javax.swing.JButton print;
    private javax.swing.JMenuItem signout;
    private javax.swing.JMenuItem sigout;
    private javax.swing.JComboBox stall;
    private javax.swing.JTextField stallnum;
    private javax.swing.JTable stallreport;
    private javax.swing.JTable stalltable;
    private javax.swing.JTable stalltable1;
    private javax.swing.JTextField time;
    private javax.swing.JTable totalMN;
    private javax.swing.JMenuItem viewu;
    private javax.swing.JMenuItem viewuser;
    private javax.swing.JComboBox year;
    // End of variables declaration//GEN-END:variables
}
