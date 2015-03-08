/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.Connection;
import Connections.proper;
import Rental.model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class Query {
    private proper manager1 = null;
    private Connection manager2 = null;
    
     public Query() {
    }
    
     public Query (proper manager1){
        this.manager1 = manager1;
    }
     public Query (Connection manager2){
        this.manager2 = manager2;
    }
     
      public List<Customer> getCustomers() throws Exception {
        List custList = new ArrayList();
        java.sql.Connection con1 = null;
        java.sql.Connection con2 = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
       
        con1 = manager1.getMySqlConnection();
        con2 = manager2.getMySqlConnection();
          
        
	rs = pst.executeQuery("SELECT * FROM ZEH.Customer Cus where Cus.Cus_Num LIKE ? OR Cus.Cus_FName LIKE ? OR Cus.Cus_MidName LIKE ? OR Cus.Cus_LName LIKE ?");
        
        while(rs.next()){
            int Num = rs.getInt("Cus_Num");
            String FName = rs.getString("Cus_FName");
            String MName = rs.getString("Cus_MidName");
            String LName = rs.getString("Cus_LName");
            String Add = rs.getString("Cus_Address");
            String ConNum = rs.getString("Cus_ContactNum");
            String Status = rs.getString("Cus_Status");
            String Image = rs.getString("Cus_Image");
            String PATH = rs.getString("Cus_Path");
            
            Customer cus = new Customer(Num,FName,MName,LName,Add,ConNum,Status,Image,PATH);
            custList.add(cus);
        }
        return custList;
      }  
}
