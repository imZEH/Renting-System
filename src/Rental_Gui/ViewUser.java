/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental_Gui;

import Rental.Methods.addEmployee;
import Rental.Methods.queryEmployee;
import Rental.model.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class ViewUser extends javax.swing.JFrame {
java.sql.Connection con1 = null;
java.sql.Connection con2 = null;
PreparedStatement pst = null;
    /**
     * Creates new form ViewUser
     */
    public ViewUser() {
        initComponents();
        
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        deact = new javax.swing.JMenuItem();
        act = new javax.swing.JMenuItem();
        addEmp = new javax.swing.JMenuItem();
        update = new javax.swing.JMenuItem();
        back = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchuser = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        jPopupMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPopupMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPopupMenu1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPopupMenu1MouseEntered(evt);
            }
        });
        jPopupMenu1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jPopupMenu1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
                jPopupMenu1MenuKeyReleased(evt);
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });

        deact.setText("DeActivate");
        deact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deactMouseClicked(evt);
            }
        });
        deact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deactActionPerformed(evt);
            }
        });
        jPopupMenu1.add(deact);

        act.setText("Activate");
        act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actActionPerformed(evt);
            }
        });
        jPopupMenu1.add(act);

        addEmp.setText("Add User");
        addEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmpActionPerformed(evt);
            }
        });
        jPopupMenu1.add(addEmp);

        update.setText("Edit/Update User");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPopupMenu1.add(update);

        back.setText("Back to Main");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPopupMenu1.add(back);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(390, 160, 0, 0));
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.orange);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Number", "Full Name", "Status", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        user.setComponentPopupMenu(jPopupMenu1);
        user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        user.getTableHeader().setReorderingAllowed(false);
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(user);
        user.getColumnModel().getColumn(0).setResizable(false);
        user.getColumnModel().getColumn(1).setResizable(false);
        user.getColumnModel().getColumn(1).setPreferredWidth(200);
        user.getColumnModel().getColumn(2).setResizable(false);
        user.getColumnModel().getColumn(3).setResizable(false);

        jButton1.setText("Add User");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.orange);
        jLabel1.setText("Search By:");

        searchuser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchuser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchuser.setText("ID Number Or Type");
        searchuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchuserMouseClicked(evt);
            }
        });
        searchuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchuserKeyReleased(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Clear Field");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(searchuser, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchuser, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       new AddUser().setVisible(true);
       try{
       con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
       con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
       String sql = "Select * from ZEH.Employee Emp";
       pst = (PreparedStatement) con1.prepareStatement(sql);
      pst = (PreparedStatement) con2.prepareStatement(sql);
       ResultSet rs = pst.executeQuery();
       AddUser.Useridnum.setEditable(false);
       AddUser.Useridnum.setText(Integer.toString(1111));
       if (rs.last()) {
              String Cus_Num = rs.getString("Emp_IDNum");
              int z = Integer.parseInt(Cus_Num);
              z = z+1;
              AddUser.Useridnum.setText(Integer.toString(z));
      }
      }catch(Exception e){
      JOptionPane.showMessageDialog(null,"ERROR","Prompt",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchuserKeyReleased
      DefaultTableModel model=(DefaultTableModel)user.getModel();
      String empty = searchuser.getText();
      if (model.getRowCount() != 0){
      model.setRowCount(0);
      }
      List<Employee> sList = new ArrayList<Employee>();   
      queryEmployee p =new queryEmployee();
      try {
      sList = p.RetrieveEmployee(empty, empty);
          
            for (int i=0;i<sList.size();i++){
            model.addRow(new Object[]{});
            user.setValueAt(sList.get(i).getEmp_IDNum(), i, 0);
            user.setValueAt(sList.get(i).getFullName(), i, 1);
            user.setValueAt(sList.get(i).getEmp_Status(), i, 2);
            user.setValueAt(sList.get(i).getEmp_Type(), i, 3);
            
        }
      if(empty.isEmpty()){
      model.setRowCount(0);
      }
      } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
      }
    }//GEN-LAST:event_searchuserKeyReleased

    private void searchuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchuserMouseClicked
       searchuser.setText("");
    }//GEN-LAST:event_searchuserMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       searchuser.setText("ID Number Or Type");
       DefaultTableModel model=(DefaultTableModel)user.getModel();
       int count =model.getRowCount();
       if (count != 0){
       model.setRowCount(0);
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void deactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deactActionPerformed
       int row = user.getSelectedRow();
       String TableClick = (user.getModel().getValueAt(row, 0).toString());
       int rt = Integer.parseInt(TableClick);
       DefaultTableModel model=(DefaultTableModel)user.getModel();
       int count =model.getRowCount();
       
       addEmployee up = new addEmployee();
       try {
            up.upEmpStatus1(rt);
            JOptionPane.showMessageDialog(null,"Process sucessfully");
       if (count != 0){
            model.setRowCount(0);
            }
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null,"ERROR","Prompt",JOptionPane.ERROR_MESSAGE);
        }
        searchuser.setText("ID Number Or Type");
    }//GEN-LAST:event_deactActionPerformed

    private void actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actActionPerformed
        int row = user.getSelectedRow();
        String TableClick = (user.getModel().getValueAt(row, 0).toString());
        int rt = Integer.parseInt(TableClick);
        DefaultTableModel model=(DefaultTableModel)user.getModel();
       int count =model.getRowCount();
       
       addEmployee up = new addEmployee();
       try {
            up.upEmpStatus(rt);
            JOptionPane.showMessageDialog(null,"Process sucessfully");
       if (count != 0){
            model.setRowCount(0);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"ERROR","Prompt",JOptionPane.ERROR_MESSAGE);
        }
       searchuser.setText("ID Number Or Type");
    }//GEN-LAST:event_actActionPerformed

    private void addEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmpActionPerformed
       new AddUser().setVisible(true);
       try{
        con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
      con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
        String sql = "Select * from ZEH.Employee Emp";
        pst = (PreparedStatement) con1.prepareStatement(sql);
      pst = (PreparedStatement) con2.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        AddUser.Useridnum.setEditable(false);
        AddUser.Useridnum.setText(Integer.toString(1111));
        if (rs.last()) {
              String Cus_Num = rs.getString("Emp_IDNum");
              int z = Integer.parseInt(Cus_Num);
              z = z+1;
              AddUser.Useridnum.setText(Integer.toString(z));
              }
       }catch(Exception e){
       JOptionPane.showMessageDialog(null,"ERROR","Prompt",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_addEmpActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       int row = user.getSelectedRow();
       String TableClick = (user.getModel().getValueAt(row, 0).toString());
       DefaultTableModel model=(DefaultTableModel)user.getModel();
       int count =model.getRowCount();
       try{
            con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
             con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
            
            String Update = "Select * from ZEH.Employee Emp where Emp.Emp_IDNum = '"+TableClick+"'";
            pst = (PreparedStatement) con1.prepareStatement(Update);
      pst = (PreparedStatement) con2.prepareStatement(Update);
            ResultSet rs = pst.executeQuery();
      
       while(rs.next()){
            int Joption = JOptionPane.showConfirmDialog(null,"Do you want to Update User Information?","Prompt",JOptionPane.YES_NO_OPTION);
       if(Joption == JOptionPane.YES_OPTION){
        
       new UpdateAccount().setVisible(true);
       }
       else if(Joption == JOptionPane.NO_OPTION){}
             int Id = (Integer.parseInt(rs.getString("Emp_IDNum")));
             String Acount = rs.getString("Emp_Account");
             String Password = rs.getString("Emp_Password");
             String Fname = rs.getString("Emp_FName");
             String MName = rs.getString("Emp_MidName");
             String LName = rs.getString ("Emp_LName");  
             String ty = rs.getString("Emp_Type");
             UpdateAccount.managersidnum.setEditable(false);
             UpdateAccount.managersidnum.setText(Integer.toString(Id));
             UpdateAccount.managersfname.setText(Fname);
             UpdateAccount.managersmname.setText(MName);
             UpdateAccount.lname.setText(LName);
             UpdateAccount.managersuname.setText(Acount);
             UpdateAccount.managerspass.setText(Password);
             UpdateAccount.type.setSelectedItem(ty);
            }
       }catch(Exception e){
       JOptionPane.showMessageDialog(null,e);
       }
    }//GEN-LAST:event_updateActionPerformed

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
       
    }//GEN-LAST:event_userMouseClicked

    private void jPopupMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPopupMenu1MouseClicked
        
    }//GEN-LAST:event_jPopupMenu1MouseClicked

    private void jPopupMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPopupMenu1MouseEntered
       
    }//GEN-LAST:event_jPopupMenu1MouseEntered

    private void deactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deactMouseClicked
        
    }//GEN-LAST:event_deactMouseClicked

    private void jPopupMenu1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jPopupMenu1MenuKeyPressed
      
    }//GEN-LAST:event_jPopupMenu1MenuKeyPressed

    private void jPopupMenu1MenuKeyReleased(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jPopupMenu1MenuKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPopupMenu1MenuKeyReleased

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
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ViewUser().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem act;
    private javax.swing.JMenuItem addEmp;
    private javax.swing.JMenuItem back;
    private javax.swing.JMenuItem deact;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchuser;
    private javax.swing.JMenuItem update;
    private javax.swing.JTable user;
    // End of variables declaration//GEN-END:variables
}