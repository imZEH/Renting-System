/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental_Gui;

import Rental.Methods.addEmployee;
import Rental.model.Employee;
import com.mysql.jdbc.Connection;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultFocusManager;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author acer
 */
public class AddUser extends javax.swing.JFrame {
java.sql.Connection con1 = null;
java.sql.Connection con2 = null;
PreparedStatement pst = null;
ResultSet rs = null;
    /**
     * Creates new form AddUser
     */
    public AddUser() {
        initComponents();
    }
    
    
    public void increment(){
    try{
    con1 =  (java.sql.Connection) Connections.proper.getMySqlConnection();
    con2 =  (java.sql.Connection) Connections.Connection.getMySqlConnection();
    String sql = "select * from ZEH.Employee Emp";
    pst = (PreparedStatement) con1.prepareStatement(sql);
    pst = (PreparedStatement) con2.prepareStatement(sql);
    rs = pst.executeQuery();
    if (rs.last()) {
    String Emp_Num = rs.getString(1);
    int z = Integer.parseInt(Emp_Num);
    z = z+1;
    Useridnum.setText(Integer.toString(z));
    }
    }catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
    }
    
    public void ADDEMP(){
        int IDNum = Integer.parseInt(Useridnum.getText());
       String Fname = Userfname.getText();
       String Mname = Usermname.getText();
       String Lname = lname.getText();
       String Type = (String) type.getSelectedItem();
       String Username = Usersuname.getText();
       String Password = Userpass.getText();
       String RePassword = Userrepass.getText();
       int length;
       length = Password.length();
        
       Employee Emp = new Employee(IDNum,Username,Password,Fname,Mname,Lname,Type);
       addEmployee addEmp = new addEmployee();
       try {
       if(Password.equals(RePassword) && (length >=5 && (!Username.equals("")))){
       addEmp.addEmp(Emp);
       JOptionPane.showMessageDialog(null,"Information sucessfully added");
        
       Userfname.setText("");Usermname.setText("");lname.setText("");
       Usersuname.setText("");Userpass.setText("");Userrepass.setText("");
       type.setSelectedItem("Manager");
            
       increment();
       }
       else{
       JOptionPane.showMessageDialog(null,"Some fields are ERROR","ERROR",JOptionPane.ERROR_MESSAGE);
       }
       } catch (Exception ex) {
       JOptionPane.showMessageDialog(null,ex);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Useridnum = new javax.swing.JTextField();
        Userfname = new javax.swing.JTextField();
        Usermname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        Usersuname = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        button3 = new java.awt.Button();
        button2 = new java.awt.Button();
        button1 = new java.awt.Button();
        jLabel8 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox();
        pprompt = new javax.swing.JLabel();
        repprompt = new javax.swing.JLabel();
        Userpass = new javax.swing.JPasswordField();
        Userrepass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 120, 0, 0));
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.orange);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Add User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ID Number:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("First Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Middle Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Last Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Username:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Password:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Re-enter Password:");

        Userfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserfnameActionPerformed(evt);
            }
        });
        Userfname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UserfnameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UserfnameKeyTyped(evt);
            }
        });

        Usermname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsermnameActionPerformed(evt);
            }
        });
        Usermname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UsermnameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UsermnameKeyTyped(evt);
            }
        });

        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lnameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lnameKeyTyped(evt);
            }
        });

        Usersuname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UsersunameKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        button3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button3.setLabel("Cancel");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button2.setLabel("Clear All");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button1.setLabel("Save");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Type:");

        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manager", "Cashier" }));

        Userpass.setToolTipText("Your password must be at least 5 characters in length");
        Userpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UserpassKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UserpassKeyReleased(evt);
            }
        });

        Userrepass.setToolTipText("Your password must be at least 5 characters in length");
        Userrepass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UserrepassKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UserrepassKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Usermname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(Userfname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Useridnum, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lname))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Usersuname, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Userpass, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Userrepass, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 4, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pprompt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(repprompt, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Useridnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Userfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Usermname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Usersuname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pprompt)
                    .addComponent(Userpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(repprompt)
                    .addComponent(Userrepass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void UserfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserfnameActionPerformed

    private void UsermnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsermnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsermnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        Userfname.setText("");
        Usermname.setText("");
        lname.setText("");
        Usersuname.setText("");
        Userpass.setText("");
        Userrepass.setText("");
        type.setSelectedItem("Manager");
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
       ADDEMP();
    }//GEN-LAST:event_button1ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
      int dialog =  JOptionPane.showConfirmDialog(null,"This process Back previous window,\nwant to proceed?","Prompt Window",JOptionPane.YES_NO_OPTION);
      if (dialog == JOptionPane.YES_OPTION){
      this.dispose();
      }
      else if(dialog == JOptionPane.NO_OPTION) {}
        
    }//GEN-LAST:event_button3ActionPerformed

    private void UserpassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserpassKeyReleased
      String pass = Userpass.getText();
      int length;
      length = pass.length();
      if(length<=4){
      pprompt.setText("Password too short");
      }
      else 
      pprompt.setText("");
    }//GEN-LAST:event_UserpassKeyReleased

    private void UserrepassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserrepassKeyReleased
       String Password = Userpass.getText();
       String RePassword = Userrepass.getText();
       if(!Password.equals(RePassword)){
       repprompt.setText("Password didn't macth");
       }
       else repprompt.setText("");
    }//GEN-LAST:event_UserrepassKeyReleased

    private void UserfnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserfnameKeyPressed
       int p = evt.getKeyCode();
       JComponent component = (JTextField)evt.getComponent();
       DefaultFocusManager focusManager = new DefaultFocusManager();
       if (p == KeyEvent.VK_ENTER) {
       focusManager.focusNextComponent(component);
       }
    }//GEN-LAST:event_UserfnameKeyPressed

    private void UsermnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsermnameKeyPressed
       int p = evt.getKeyCode();
       JComponent component = (JTextField)evt.getComponent();
       DefaultFocusManager focusManager = new DefaultFocusManager();
       if (p == KeyEvent.VK_ENTER) {
       focusManager.focusNextComponent(component);
       }
    }//GEN-LAST:event_UsermnameKeyPressed

    private void lnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyPressed
       int p = evt.getKeyCode();
       JComponent component = (JTextField)evt.getComponent();
       DefaultFocusManager focusManager = new DefaultFocusManager();
       if (p == KeyEvent.VK_ENTER) {
       focusManager.focusNextComponent(component);
       }
    }//GEN-LAST:event_lnameKeyPressed

    private void UsersunameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsersunameKeyPressed
       int p = evt.getKeyCode();
       JComponent component = (JTextField)evt.getComponent();
       DefaultFocusManager focusManager = new DefaultFocusManager();
       if (p == KeyEvent.VK_ENTER) {
       focusManager.focusNextComponent(component);
       }
    }//GEN-LAST:event_UsersunameKeyPressed

    private void UserpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserpassKeyPressed
       int p = evt.getKeyCode();
       JComponent component = (JTextField)evt.getComponent();
       DefaultFocusManager focusManager = new DefaultFocusManager();
       if (p == KeyEvent.VK_ENTER) {
       focusManager.focusNextComponent(component);
       }
    }//GEN-LAST:event_UserpassKeyPressed

    private void UserrepassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserrepassKeyPressed
       int p = evt.getKeyCode();
       if (p == KeyEvent.VK_ENTER) {
       ADDEMP();
       }
    }//GEN-LAST:event_UserrepassKeyPressed

    private void UserfnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserfnameKeyTyped
        char c = evt.getKeyChar();
        if (((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
        } else {
        }
    }//GEN-LAST:event_UserfnameKeyTyped

    private void UsermnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsermnameKeyTyped
        char c = evt.getKeyChar();
        if (((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
        } else {
        }
    }//GEN-LAST:event_UsermnameKeyTyped

    private void lnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyTyped
        char c = evt.getKeyChar();
        if (((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
        } else {
        }
    }//GEN-LAST:event_lnameKeyTyped

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
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AddUser().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Userfname;
    public static javax.swing.JTextField Useridnum;
    private javax.swing.JTextField Usermname;
    private javax.swing.JPasswordField Userpass;
    private javax.swing.JPasswordField Userrepass;
    private javax.swing.JTextField Usersuname;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lname;
    private javax.swing.JLabel pprompt;
    private javax.swing.JLabel repprompt;
    private javax.swing.JComboBox type;
    // End of variables declaration//GEN-END:variables
}
