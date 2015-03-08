/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.Connection;
import Connections.proper;
import Rental.model.Collection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author acer
 */
public class CollectionCust {
    java.sql.Connection con1 = null;
    java.sql.Connection con2 = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void addCus(Collection collection) throws Exception{
        String sql = "INSERT INTO Collection (Col_Monthly,Col_Date,Stall_Num,Emp_IDNum,UnCollect,Total_Arrears) VALUES(?,?,?,?,?,?,?)";
        proper manager1 = null;
        Connection manager2 = null;
        
        con1 =  (java.sql.Connection) manager1.getMySqlConnection();
        con2 =  (java.sql.Connection) manager2.getMySqlConnection();
	ps= (PreparedStatement) con1.prepareStatement(sql);
        ps= (PreparedStatement) con2.prepareStatement(sql);
        
        ps.setDouble(1, collection.getCol_Monthly());
        ps.setString(2,collection.getColl_Date());
        ps.setDouble(3, collection.getUnCollect());
        ps.setDouble(4, collection.getTotalArrears());
        ps.executeUpdate();
        
}
    
    public void Uppdte(String DueDate,String Extension,int Cusnum) throws Exception{
        String sql = "Update ZEH.Customer Cus "
                + " INNER JOIN ZEH.Stall_Rent_History SRH set Cus.Cus_Status = 'Active',Cus.Cus_Arrears = '0',SRH.STH_DueDate = '"+DueDate+"',SRH.STH_Extension = '"+Extension+"' where Cus.Cus_Num = '"+Cusnum+"'";
        proper manager1 = null;
        Connection manager2 = null;
        
        con1 = (java.sql.Connection) manager1.getMySqlConnection();
         con2 = (java.sql.Connection) manager2.getMySqlConnection();
	ps= (PreparedStatement) con1.prepareStatement(sql);
        ps= (PreparedStatement) con2.prepareStatement(sql);
        ps.executeUpdate();
    }
}
