/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.Connection;
import Connections.proper;
import Rental.model.Employee;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class queryEmployee {
    private Statement st ;
    private java.sql.Connection con1;
    private proper manager1= null;
    ResultSet rs = null;
    private java.sql.Connection con2;
    private Connection manager2 = null;
    
    public queryEmployee(){
        
    }
    
    public queryEmployee (proper manager1){
        this.manager1 = manager1;
    }
    public queryEmployee (Connection manager2){
        this.manager2 = manager2;
    }
    
     public List<Employee> RetrieveEmployee(String ID, String Type) throws Exception{
        List EmpList = new ArrayList();
        con1 =  (java.sql.Connection) proper.getMySqlConnection();
        java.sql.Statement stmt = con1.createStatement();
        con2 =  (java.sql.Connection) Connection.getMySqlConnection();
         stmt = con2.createStatement();
        rs = stmt.executeQuery("select CONCAT(Emp.Emp_Lname,', ',Emp.Emp_FName,' ',Emp.Emp_MidName) fullname,Emp.Emp_Type,Emp.Emp_Status,Emp.Emp_IDNum from ZEH.employee Emp where Emp.Emp_IDNum LIKE '"+ID+"%' OR Emp.Emp_Type LIKE '"+Type+"%' ");
        
        while(rs.next()){
            int num = rs.getInt("Emp_IDNum");
            String name = rs.getString("fullname");
            String Empt = rs.getString("Emp_Type");
            String sta = rs.getString("Emp_Status");
            
            Employee Emp = new Employee(num,name,Empt,sta);
           EmpList.add(Emp);
        }
       return EmpList;
}
     
}
