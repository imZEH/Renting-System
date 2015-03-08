/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.Connection;
import Rental_Gui.Colview;
import Rental_Gui.Home;
import Rental_Gui.mangersview;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Neil
 */
public class loginclass {
    private Statement st ;
    private java.sql.Connection con1;
    private java.sql.Connection con2;
    private Connection manager = null;
    ResultSet rs = null;
    
PreparedStatement pst = null;
    
    
    
    public void log(String username, String password) {
        try{ 
        String insert = "select CONCAT(Emp.Emp_Type,' = ',Emp.Emp_Lname,', ',Emp.Emp_FName,' ',Emp.Emp_MidName) fullname,Emp.Emp_Type,Emp.Emp_Status,Emp.Emp_IDNum from ZEH.employee Emp INNER JOIN ZEH.employee epl ON Emp.Emp_IDNum = epl.Emp_IDNum where Emp.Emp_Account = '"+username+"' OR epl.Emp_Account = '"+username+"' and epl.Emp_Password = '"+password+"' OR  Emp.Emp_Password = '"+password+"'";
      
      pst = (PreparedStatement) con1.prepareStatement(insert);
      pst = (PreparedStatement) con2.prepareStatement(insert); 
      rs = pst.executeQuery();
           
      String usr = "Cashier";
      String usr1 = "Manager";
        
            
      if(rs.next()){
                 String mao1 = rs.getString("Emp_Type");
                 String name = rs.getString("fullname");
                 String St = rs.getString("Emp_Status");
                 String num = rs.getString("Emp_IDNum");
      if(mao1.equals(usr1)&&(St.equals("Active"))){
                new Home().setVisible(false);
                new mangersview().setVisible(true);
           
             }
      else if(mao1.equals(usr)&&(St.equals("Active"))){
               new Home().setVisible(false);
                new Colview().setVisible(true);
                Colview.EmployeeNum.setText(name);
               Colview.EmployeeNum1.setText(num);
             
     }else{
               JOptionPane.showMessageDialog(null,"Check your Username and Password","Error",JOptionPane.ERROR_MESSAGE);}
            
     }else{
               JOptionPane.showMessageDialog(null,"Check your Username and Password","Error",JOptionPane.ERROR_MESSAGE);}
                con1.close();con2.close();
     }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    
}
}

