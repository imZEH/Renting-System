/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.Connection;
import Connections.proper;
import Rental.model.Employee;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author acer
 */
public class addEmployee {
    
    public void addEmp(Employee employee) throws Exception{
        java.sql.Connection con1 ;
        java.sql.Connection con2 ;
        PreparedStatement ps ;
	ResultSet rs = null;
        String sql = "INSERT into Employee(Emp_IDNum,Emp_Account,Emp_Password,Emp_FName,Emp_MidName,Emp_LName,Emp_Type) VALUES(?,?,?,?,?,?,?)";
        
        proper manager1 = null;
        Connection manager2 = null;
        
        con1 =  (java.sql.Connection) manager1.getMySqlConnection();
        con2 =  (java.sql.Connection) manager2.getMySqlConnection();
	ps= (PreparedStatement) con1.prepareStatement(sql);
        ps= (PreparedStatement) con2.prepareStatement(sql);
        
        ps.setInt(1, employee.getEmp_IDNum());
        ps.setString(2, employee.getEmp_Acount());
        ps.setString(3, employee.getEmp_Password());
        ps.setString(4, employee.getEmp_FName());
        ps.setString(5, employee.getEmp_MidName());
        ps.setString(6, employee.getEmp_LName());
        ps.setString(7, employee.getEmp_Type());
        //ps.setString(8, employee.getEmp_Status());
        ps.executeUpdate();
    }
    
    public void upEmp(int EMPID,String Acc, String Pass, String FName, String MName, String LName, String Type) throws Exception{
                java.sql.Connection con1 ;
                java.sql.Connection con2 ;
		java.sql.PreparedStatement ps;
		
                String sql = "Update ZEH.Employee Emp set Emp.Emp_IDNum = '"+EMPID+"', Emp.Emp_Account = '"+Acc+"', Emp.Emp_Password = '"+Pass+"', Emp.Emp_FName = '"+FName+"',"
                        + "Emp.Emp_MidName = '"+MName+"', Emp.Emp_LName = '"+LName+"',Emp.Emp_Type = '"+Type+"' where Emp.Emp_IDNum = '"+EMPID+"'";
                proper manager1 = null;
                Connection manager2 = null;
               
                
                con1 = (java.sql.Connection) manager1.getMySqlConnection();
                con2 = (java.sql.Connection) manager2.getMySqlConnection();
                ps= (java.sql.PreparedStatement) con1.prepareStatement(sql);
                ps= (java.sql.PreparedStatement) con2.prepareStatement(sql);

		ps.executeUpdate();
    }
    
    public void upEmpStatus(int EMPID) throws Exception{
       
                java.sql.Connection con1 ;
               java.sql.Connection con2 ; 
		java.sql.PreparedStatement ps;
		
                String sql = "Update ZEH.Employee Emp set Emp.Emp_Status = 'Active' where Emp.Emp_IDNum = '"+EMPID+"'";
                proper manager1 = null;
                Connection manager2 = null;
                
                con1 = (java.sql.Connection) manager1.getMySqlConnection();
                 con2 = (java.sql.Connection) manager2.getMySqlConnection();
			ps= (java.sql.PreparedStatement) con1.prepareStatement(sql);
                        ps= (java.sql.PreparedStatement) con2.prepareStatement(sql);

		ps.executeUpdate();
    }
    public void upEmpStatus1(int EMPID) throws Exception{
       
                java.sql.Connection con1;
                java.sql.Connection con2 ;
		java.sql.PreparedStatement ps;
		
                String sql = "Update ZEH.Employee Emp set Emp.Emp_Status = 'InActive' where Emp.Emp_IDNum = '"+EMPID+"'";
                proper manager1 = null;
                Connection manager2 = null;
                
                con1 = (java.sql.Connection) manager1.getMySqlConnection();
                con2 = (java.sql.Connection) manager2.getMySqlConnection();
		ps= (java.sql.PreparedStatement) con1.prepareStatement(sql);
                ps= (java.sql.PreparedStatement) con2.prepareStatement(sql);

		ps.executeUpdate();
    }
    
   
}
