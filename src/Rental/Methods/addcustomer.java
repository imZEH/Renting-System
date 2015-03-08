/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.Connection;
import Connections.proper;
import Rental.model.Customer;
import Rental.model.Stall_Rent_History;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;

/**
 *
 * @author acer
 */
public class addcustomer {
    public void addCus(Customer customers) throws Exception{
        java.sql.Connection con1 ;
        java.sql.Connection con2 ;
        PreparedStatement ps ;
        
        
	ResultSet rs = null;
        String sql = "Insert into Customer(Cus_Num,Cus_FName,Cus_MidName,Cus_LName,Cus_Address,Cus_ContactNum,Cus_Status,Cus_Image,Cus_Path) Values(?,?,?,?,?,?,?,?,?)";

        proper manager1 = null;
        Connection manager2 = null;
        
        con1 =  (java.sql.Connection) manager1.getMySqlConnection();
        con2 =  (java.sql.Connection) manager1.getMySqlConnection();
	ps= (PreparedStatement) con1.prepareStatement(sql);
        ps= (PreparedStatement) con2.prepareStatement(sql);
        String picture = customers.getCus_Image();
        File f=new File(picture);
        FileInputStream fis;
        fis = new FileInputStream(f);
        ps.setInt(1,customers.getCus_Num());
        ps.setString(2, customers.getCus_Fname());
        ps.setString(3, customers.getCus_MidName());
        ps.setString(4, customers.getCus_Lname());
        ps.setString(5, customers.getCus_Address());
        ps.setString(6, customers.getCus_ContactNumber());
        ps.setString(7, customers.getCus_Status());
        ps.setBinaryStream(8, (InputStream)fis, (int)(f.length()));
        ps.setString(9, customers.getCus_Path());
        ps.executeUpdate();
	//rs = ps.getGeneratedKeys();
    }
    
    public void addhist(Stall_Rent_History rent)throws Exception{
        java.sql.Connection con1 ;
        java.sql.Connection con2 ;
        PreparedStatement ps;
        ResultSet rs = null;
        String sql = "INSERT into Stall_Rent_History(STH_Date_Of_Rent,Stall_Num,Cus_Num,STH_DueDate,STH_Extension) VALUES(?,?,?,?,?)";
        proper manager1 = null;
        Connection manager2 = null;
        
        con1 =  (java.sql.Connection) manager1.getMySqlConnection();
        con2 =  (java.sql.Connection) manager2.getMySqlConnection();
	ps= (PreparedStatement) con1.prepareStatement(sql);
        ps= (PreparedStatement) con2.prepareStatement(sql);
        
       // ps.setInt(1, rent.getSTH_Num());
        ps.setString(1, rent.getSTH_DateOfRent());
        ps.setInt(2, rent.getStall_Num());
        ps.setInt(3, rent.getCus_Num());
        ps.setString(4, rent.getSTH_DueDate());
        ps.setString(5, rent.getSTH_Extension());
        ps.executeUpdate();
        
        
        
    }
    
    public void updateStall(String Status,int StallNum)throws Exception{
        java.sql.Connection con1 ;
        java.sql.Connection con2 ;
        PreparedStatement ps;
	ResultSet rs = null;
        String sql = "Update Stall  SET Stall_Status = '"+Status+"'where Stall_Num = '"+StallNum+"'";
        proper manager1 = null;
        Connection manager2 = null;
        
        con1 = (java.sql.Connection) manager1.getMySqlConnection();
        con2 = (java.sql.Connection) manager2.getMySqlConnection();
	ps= (PreparedStatement) con1.prepareStatement(sql);
        ps= (PreparedStatement) con2.prepareStatement(sql);
        ps.executeUpdate();
    }
    
    public void updateS(int StallNum, String StallName)throws Exception{
        java.sql.Connection con1;
        java.sql.Connection con2;
        PreparedStatement ps;
	ResultSet rs = null;
        String sql = "UPDATE Stall  SET Stall_Num = '"+StallNum+"' , Stall_Name = '"+StallName+"' where Stall_Num = '"+StallNum+"'";
        proper manager1 = null;
        Connection manager2 = null;
        
        con1 = (java.sql.Connection) manager1.getMySqlConnection();
        con2 = (java.sql.Connection) manager2.getMySqlConnection();
	ps= (PreparedStatement) con1.prepareStatement(sql);
        ps= (PreparedStatement) con2.prepareStatement(sql);
        ps.executeUpdate();
    }
    
}
