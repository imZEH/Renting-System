/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental_Gui;


import Rental.Methods.queryCustomer;
import Rental.model.Customer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author acer
 */
public final class Colview extends javax.swing.JFrame implements ActionListener {
Timer clockTimer;
java.sql.Connection con1 = null;
java.sql.Connection con2 = null;
PreparedStatement pst = null;
PreparedStatement psmt = null;
PreparedStatement psmt1 = null;
PreparedStatement psmt2 = null;
    

    public Colview() {
        initComponents();
        clockTimer = new Timer(1000, this);
        clockTimer.start();
        day.setVisible(false);
        month.setVisible(false);
        year.setVisible(false);
        day.setText(getFutureDate());
        DuetDate1();
        time.setEditable(false);
        date.setEditable(false);
        date.setText(getDate());
        DuetDate();
        duedate();
        EmployeeNum.setVisible(false);
        EmployeeNum1.setVisible(false);
        setResizable(false);
        totalamount.setEditable(false);
        balance.setEditable(false);
        duedate.setVisible(false);
       }
   
   
   public String getDate()
   {
      DateFormat dateFormat = new SimpleDateFormat( "MMMMMMMMM d, yyyy" );
      Calendar calendar = Calendar.getInstance();
      return dateFormat.format( calendar.getTime() );
   }
   public String getFutureDate()
   {
      DateFormat dateFormat = new SimpleDateFormat( "d" );
      Calendar calendar = Calendar.getInstance();
      calendar.add( Calendar.DATE,8 );
      return dateFormat.format( calendar.getTime() );
      
   }
    public void DuetDate1(){
        Calendar cal = new GregorianCalendar();
        int Month = cal.get(Calendar.MONTH);
        int Year = cal.get(Calendar.YEAR);
        int text = Month+1+1;
        year.setText(Integer.toString(Year));
        int k  = text;
        switch(k){
        case 1: month.setText("Janauary");
        break;
        case 2: month.setText("February");
        break;
        case 3: month.setText("March");
        break;
        case 4: month.setText("April");
        break;
        case 5: month.setText("May");
        break;
        case 6: month.setText("June");
        break;
        case 7: month.setText("July");
        break;
        case 8: month.setText("August");
        break;
        case 9: month.setText("September");
        break;
        case 10: month.setText("October");
        break;
        case 11: month.setText("November");
        break;
        case 12: month.setText("December");
        break;
        case 13: month.setText("January");
        break;
        case 14: month.setText("February");
        break;
        }
    }
    public void DuetDate(){
       Calendar cal = new GregorianCalendar();
        int MONTH = cal.get(Calendar.MONTH);
        int YEAR = cal.get(Calendar.YEAR);
        int DAY = cal.get(Calendar.DAY_OF_MONTH);
        int text = MONTH+1+1;
        
        int k  = text;
        switch(k){
        case 1: duedate.setText("Janauary " +DAY+", "+YEAR);
        break;
        case 2: duedate.setText("February " +DAY+", "+YEAR);
        break;
        case 3: duedate.setText("March " +DAY+", "+YEAR);
        break;
        case 4: duedate.setText("April " +DAY+", "+YEAR);
        break;
        case 5: duedate.setText("May " +DAY+", "+YEAR);
        break;
        case 6: duedate.setText("June " +DAY+", "+YEAR);
        break;
        case 7: duedate.setText("July " +DAY+", "+YEAR);
        break;
        case 8: duedate.setText("August " +DAY+", "+YEAR);
        break;
        case 9: duedate.setText("September " +DAY+", "+YEAR);
        break;
        case 10: duedate.setText("October " +DAY+", "+YEAR);
        break;
        case 11: duedate.setText("November " +DAY+", "+YEAR);
        break;
        case 12: duedate.setText("December " +DAY+", "+YEAR);
        break;
        case 13: duedate.setText("January " +DAY+", "+YEAR);
        break;
    }
    }
    
    public void duedate(){
    PreparedStatement pst;
    ResultSet rs;
    String Date = date.getText();
    String d = duedate.getText();
    String wew = (month.getText()+" "+day.getText()+", "+year.getText());
    try{
    con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
      con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
    String Select = "Select Cus.Cus_Num,SRH.STH_DueDate,RATE.SRH_Price,Cus.Cus_Arrears from ZEH.Stall_Rent_History SRH INNER JOIN ZEH.Customer Cus ON Cus.Cus_Num=SRH.Cus_Num "
                + " INNER JOIN ZEH.Stall ST ON ST.Stall_Num = SRH.Stall_Num "
                + "INNER JOIN ZEH.Stall_Rate_History RATE ON RATE.Stall_Num = ST.Stall_Num where SRH.STH_Extension = '"+Date+"'";
     pst = (PreparedStatement) con1.prepareStatement(Select);
      pst = (PreparedStatement) con2.prepareStatement(Select);
    rs = pst.executeQuery();
    while(rs.next()){
    String num = rs.getString("Cus_Num");
    String ddate = rs.getString("STH_DueDate");
    String price = rs.getString("SRH_Price");
    String arrears = rs.getString("Cus_Arrears");
       
    double total1 = Double.parseDouble(price);
    double total2 = Double.parseDouble(arrears);
    double total5 = (total1 * 0.10) + total1;
    double total4 = total5 + total2;
    double amounttotal = total4;
    NumberFormat formatter = new DecimalFormat("#0.000");
    String am = formatter.format(amounttotal);
       
    String query = "Update ZEH.Customer Cus INNER JOIN ZEH.Stall_Rent_History SRH ON"
                   + " Cus.Cus_Num = SRH.Cus_Num set SRH.STH_DueDate = '"+d+"',Cus.Cus_Arrears = '"+am+"',Cus.Cus_Status = 'InActive',SRH.STH_Extension = '"+wew+"' where Cus.Cus_Num = '"+num+"'";
    pst = (PreparedStatement) con1.prepareStatement(query);
     pst = (PreparedStatement) con2.prepareStatement(query);
    pst.executeUpdate();
    }
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
    }
    
    public void Payment(){
    PreparedStatement pst ;
    ResultSet rs ;
    PreparedStatement st ;
    ResultSet sr ;
    double TENDERED1 = Double.parseDouble(tendered.getText());
    double BILL1 = Double.parseDouble(totalamount.getText());
    String Date = "";
    Date = date.getText();
    String a[] = Date.split(" ");
    Date = a[2];
    String Datemnth = "";
    Datemnth = date.getText();
    String b[] = Datemnth.split(" ");
    Datemnth = b[0];
    String num = ID.getText();
    String DueDate = duedate.getText();
    String date1 = date.getText();
    String extension = (month.getText()+" "+day.getText()+", "+year.getText());
    try{
    con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
      con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
    String Select = "Select CONCAT(Cus.Cus_Lname,',',Cus.Cus_FName,' ',Cus.Cus_MidName) fullname,Cus.Cus_Arrears,ST.Stall_Num,RATe.SRH_Price from ZEH.Stall_Rent_History SRH INNER JOIN ZEH.Customer Cus ON Cus.Cus_Num=SRH.Cus_Num "
                    + "INNER JOIN ZEH.Stall ST ON ST.Stall_Num = SRH.Stall_Num "
                    + "INNER JOIN ZEH.Stall_Rate_History RATE ON RATE.Stall_Num = ST.Stall_Num where Cus.Cus_Num = '"+num+"'";
    String stall = "Select Sum(RATE.SRH_Price) total from ZEH.Stall_Rate_History RATE";
    pst = (PreparedStatement) con1.prepareStatement(Select);
      pst = (PreparedStatement) con2.prepareStatement(Select);
      psmt = (PreparedStatement) con1.prepareStatement(stall);
      psmt = (PreparedStatement) con2.prepareStatement(stall);
    rs = pst.executeQuery();
    sr = psmt.executeQuery();
    
    while(sr.next()){
    String TOTAL = sr.getString("total");
    while(rs.next()){
    String arr = rs.getString("Cus_Arrears");
    String Name = rs.getString("fullname");
    String Num = rs.getString("Stall_Num");
    String price = rs.getString("SRH_Price");
    double arrea = Double.parseDouble(arr) * 0.10;
    NumberFormat formatter = new DecimalFormat("#0.000");
    String ar = formatter.format(arrea);
    
    if((TENDERED1 == 0) ||(TENDERED1 ==0) ||(BILL1 == 0)||(BILL1 == 0)||(TENDERED1<BILL1)){
    JOptionPane.showMessageDialog(null, "Transaction Failed","Error",JOptionPane.ERROR_MESSAGE);
    }else{JOptionPane.showMessageDialog(null, "Transaction Complete");
    String sql = "Update ZEH.Customer Cus INNER JOIN ZEH.Stall_Rent_History SRH set Cus.Cus_Status = 'Active',Cus.Cus_Arrears = '0',SRH.STH_DueDate = '"+DueDate+"',SRH.STH_Extension = '"+extension+"' where Cus.Cus_Num = '"+num+"'";
    psmt1 = (PreparedStatement) con1.prepareStatement(sql);
      psmt1= (PreparedStatement) con2.prepareStatement(sql);
    psmt1.executeUpdate();
    String sql1 = "insert into Collection(Col_Monthly,Col_Date,Stall_Num,Emp_IDNum,UnCollect,Total_Arrears) Values('"+BILL1+"','"+date1+"','"+Num+"','"+EmployeeNum1.getText()+"','"+TOTAL+"','"+ar+"')";
    psmt2 = (PreparedStatement) con1.prepareStatement(sql1);
      psmt2 = (PreparedStatement) con2.prepareStatement(sql1);
    psmt2.executeUpdate();
          /*if(print.isSelected()){
       
	JasperDesign jasperDesign = JRXmlLoader.load("report1.jrxml");
    String sql = "Select  * from Receipt where Cus_Num = '"+num+"'";
    JRDesignQuery newQuery = new JRDesignQuery();
    newQuery.setText(sql);
    jasperDesign.setQuery(newQuery);
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign );
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
    JasperViewer.viewReport(jasperPrint);
       }
    }*/
    }
    totalamount.setText("0.00");
    tendered.setText("0.00");
    balance.setText("0.00");
    name.setText("By Number Or FirstName Or Surname Or Middle Name");
    DefaultTableModel model=(DefaultTableModel)customertable.getModel();
    int count =model.getRowCount();
    if (count != 0){
    model.setRowCount(0);
    ID.setText("");
    }}
    }}
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        date = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        time = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tendered = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        print = new javax.swing.JCheckBox();
        balance = new javax.swing.JTextField();
        totalamount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        customertable = new javax.swing.JTable();
        duedate = new javax.swing.JLabel();
        EmployeeNum = new javax.swing.JLabel();
        EmployeeNum1 = new javax.swing.JLabel();
        month = new javax.swing.JLabel();
        day = new javax.swing.JLabel();
        year = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(java.awt.Color.orange);

        date.setBackground(new java.awt.Color(0, 0, 0));
        date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clear.setText("Clear Field");
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        time.setBackground(new java.awt.Color(0, 0, 0));
        time.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Search");

        name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.setText("By Number Or FirstName Or Surname Or Middle Name");
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Date:");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Time:");

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cash Entry", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Billed Amount for ");

        jLabel8.setBackground(java.awt.Color.orange);
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 200, 0));
        jLabel8.setText("P");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cash Tendered");

        tendered.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        tendered.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tendered.setText("0.00");
        tendered.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tenderedMouseClicked(evt);
            }
        });
        tendered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenderedActionPerformed(evt);
            }
        });
        tendered.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tenderedPropertyChange(evt);
            }
        });
        tendered.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tenderedKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tenderedKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tenderedKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Change");

        jLabel12.setBackground(java.awt.Color.orange);
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 200, 0));
        jLabel12.setText("P");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Ok");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Clear");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        print.setBackground(java.awt.Color.orange);
        print.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        print.setText("Print Receipt");
        print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        balance.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        balance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        balance.setText("0.00");

        totalamount.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        totalamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalamount.setText("0.00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel14.setForeground(java.awt.Color.orange);
        jLabel14.setText("P");

        ID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ID.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(totalamount))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(tendered))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(print)
                                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tendered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        customertable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Number", "Full Name", "Contact Number", "Status", "Due Date", "Stall Purchase", "Arrears", "Monthly Bill"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customertable.setToolTipText("<html><img src=\"+image.png+\"></html>"); // NOI18N
        customertable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customertable.getTableHeader().setReorderingAllowed(false);
        customertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customertableMouseClicked(evt);
            }
        });
        customertable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                customertableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(customertable);
        customertable.getColumnModel().getColumn(0).setResizable(false);
        customertable.getColumnModel().getColumn(0).setPreferredWidth(150);
        customertable.getColumnModel().getColumn(1).setResizable(false);
        customertable.getColumnModel().getColumn(1).setPreferredWidth(220);
        customertable.getColumnModel().getColumn(2).setResizable(false);
        customertable.getColumnModel().getColumn(2).setPreferredWidth(100);
        customertable.getColumnModel().getColumn(3).setResizable(false);
        customertable.getColumnModel().getColumn(4).setResizable(false);
        customertable.getColumnModel().getColumn(4).setPreferredWidth(200);
        customertable.getColumnModel().getColumn(5).setResizable(false);
        customertable.getColumnModel().getColumn(5).setPreferredWidth(100);
        customertable.getColumnModel().getColumn(6).setResizable(false);
        customertable.getColumnModel().getColumn(7).setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EmployeeNum1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(duedate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EmployeeNum, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(month)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(day)
                .addGap(18, 18, 18)
                .addComponent(year)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmployeeNum1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(duedate)
                                .addGap(0, 26, Short.MAX_VALUE))
                            .addComponent(EmployeeNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(month)
                            .addComponent(day)
                            .addComponent(year))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar1.setForeground(java.awt.Color.orange);

        jMenu2.setText("|Log out|");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Log out");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        int Joption = JOptionPane.showConfirmDialog(null, "This action proceed to exit\n want to Proceed?", "prompt", JOptionPane.YES_NO_OPTION);
        if (Joption == JOptionPane.YES_OPTION) {
        setVisible(false);
        new Home().setVisible(true);
        } else if (Joption == JOptionPane.NO_OPTION) {
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    private void customertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customertableMouseClicked
        try{
        con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
        con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
        
        int row = customertable.getSelectedRow();
        String TableClick = (customertable.getModel().getValueAt(row, 0).toString());
        String sql = "select Cus.Cus_Num,RATE.SRH_Price,Cus.Cus_Arrears FROM ZEH.Stall_Rent_History SRH INNER JOIN ZEH.Stall ST ON ST.Stall_Num = SRH.Stall_Num"
                    + " INNER JOIN ZEH.Stall_Rate_History RATE On RATE.Stall_Num = ST.Stall_Num "
                    + "INNER JOIN ZEH.Customer Cus ON Cus.Cus_Num = SRH.Cus_Num where Cus.Cus_Num ='"+TableClick+"'";
        pst = (PreparedStatement) con1.prepareStatement(sql);
      pst = (PreparedStatement) con2.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
        if(rs.next()){
        String Num = rs.getString("Cus_Num");
        double Saleprice = (Double.parseDouble(rs.getString("SRH_Price")));
        double arr = (Double.parseDouble(rs.getString("Cus_Arrears")));
        double amount = Saleprice + arr;
        String price = Double.toString(amount);
        totalamount.setText(price);
        ID.setText(Num);
        }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_customertableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Payment();    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        totalamount.setText("0.00");
        tendered.setText("0.00");
        balance.setText("0.00");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
      
    }//GEN-LAST:event_nameKeyTyped

    private void tenderedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tenderedKeyReleased
        NumberFormat formatter = new DecimalFormat("#0.000");
        String cash1 = totalamount.getText();
        String cash2 = tendered.getText();
        double money1 = Double.parseDouble(cash2);
        double money2 = Double.parseDouble(cash1);
        double amount = money1 - money2;
        String ar = formatter.format(amount);
        balance.setText((ar));
    }//GEN-LAST:event_tenderedKeyReleased

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
      DefaultTableModel model=(DefaultTableModel)customertable.getModel();
      String empty = name.getText();
      if (model.getRowCount() != 0){
      model.setRowCount(0);
      }
      List<Customer> sList = new ArrayList<Customer>();   
      queryCustomer p =new queryCustomer();
      try {
      sList = p.retrievetoCashier(empty, empty, empty, empty);
      for (int i=0;i<sList.size();i++){
            model.addRow(new Object[]{});
            customertable.setValueAt(sList.get(i).getCus_Num(), i, 0);
            customertable.setValueAt(sList.get(i).getFullname(), i, 1);
            customertable.setValueAt(sList.get(i).getCus_ContactNumber(), i, 2);
            customertable.setValueAt(sList.get(i).getCus_Status(), i, 3);
            customertable.setValueAt(sList.get(i).getSTH_DueDate(), i, 4);
            customertable.setValueAt(sList.get(i).getStall_Name(), i, 5);
            customertable.setValueAt(sList.get(i).getCus_Arrears(), i, 6);
            customertable.setValueAt(sList.get(i).getSRH_Price(), i, 7);
       }
       if(empty.isEmpty()){
       model.setRowCount(0);
       }
       } catch (Exception ex) {
       JOptionPane.showMessageDialog(null,ex);
       }
    }//GEN-LAST:event_nameKeyReleased

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        name.setText("By Number OR FirstName Or Surname Or Middle Name");
        DefaultTableModel model=(DefaultTableModel)customertable.getModel();
        int count =model.getRowCount();
        if (count != 0){
        model.setRowCount(0);
        ID.setText("");
        }
    }//GEN-LAST:event_clearActionPerformed

    private void tenderedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tenderedKeyTyped
       char c = evt.getKeyChar();
       if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)||(c == KeyEvent.VK_PERIOD))) {
       getToolkit().beep();
       evt.consume();
       } else {
       }
    }//GEN-LAST:event_tenderedKeyTyped

    private void customertableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_customertableAncestorAdded
      
    }//GEN-LAST:event_customertableAncestorAdded

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int Joption = JOptionPane.showConfirmDialog(null, "This action proceed to exit\n want to Proceed?", "prompt", JOptionPane.YES_NO_OPTION);
        if (Joption == JOptionPane.YES_OPTION) {
        setVisible(false);
        new Home().setVisible(true);
        } else if (Joption == JOptionPane.NO_OPTION) {
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        name.setText("");
    }//GEN-LAST:event_nameMouseClicked

    private void tenderedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tenderedMouseClicked
        tendered.setText("");
    }//GEN-LAST:event_tenderedMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void tenderedPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tenderedPropertyChange
       
    }//GEN-LAST:event_tenderedPropertyChange

    private void tenderedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tenderedKeyPressed
         int s = evt.getKeyCode();
        if (s == KeyEvent.VK_ENTER) {
            Payment();
        }
    }//GEN-LAST:event_tenderedKeyPressed

    private void tenderedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenderedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenderedActionPerformed

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameKeyPressed

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
            java.util.logging.Logger.getLogger(Colview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Colview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Colview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Colview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Colview().setVisible(true);
            }
        });
    }
    @Override
     public void actionPerformed(ActionEvent e) {
        time.setText(String.format("%tI:%<tM:%<tS %<Tp", new Date()));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel EmployeeNum;
    public static javax.swing.JLabel EmployeeNum1;
    private javax.swing.JLabel ID;
    private javax.swing.JTextField balance;
    private javax.swing.JButton clear;
    private javax.swing.JTable customertable;
    private javax.swing.JTextField date;
    private javax.swing.JLabel day;
    private javax.swing.JLabel duedate;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel month;
    private javax.swing.JTextField name;
    private javax.swing.JCheckBox print;
    private javax.swing.JTextField tendered;
    private javax.swing.JTextField time;
    private javax.swing.JTextField totalamount;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables

  
}