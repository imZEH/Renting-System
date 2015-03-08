/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.Connection;
import Connections.proper;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author acer
 */
public class updateCustomer {
    
    public void updateCus(int CusNum, String FName, String MidName, String LName, String Address, String Contact, String Image,String Path) throws Exception{
        java.sql.Connection con1;
        java.sql.Connection con2;
	java.sql.PreparedStatement ps;
        String picture = Path;
        File f=new File(picture);
        FileInputStream fis;
        fis = new FileInputStream(f);
        String sql = "UPDATE ZEH.Customer Cus set Cus.Cus_Num = '"+CusNum+"', Cus.Cus_FName = '"+FName+"', Cus.Cus_MidName = '"+MidName+"', Cus.Cus_LName = '"+LName+"', Cus.Cus_Address = '"+Address+"',"
                + "Cus.Cus_ContactNum = '"+Contact+"', Cus.Cus_Image = (?),Cus.Cus_Path = '"+Path+"' where Cus.Cus_Num = '"+CusNum+"'";
    
        proper manager1 = null;
        Connection manager2 = null;
               
        con1 = (java.sql.Connection) manager1.getMySqlConnection();
        con2 = (java.sql.Connection) manager2.getMySqlConnection();
        
	ps= (java.sql.PreparedStatement) con1.prepareStatement(sql);
        
        ps= (java.sql.PreparedStatement) con2.prepareStatement(sql);
        ps.setBinaryStream(1, (InputStream)fis, (int)(f.length()));
        ps.executeUpdate();
    
    }
    
    public void DeleteCus(int cus) throws Exception{
        java.sql.Connection con1;
        java.sql.Connection con2;
	java.sql.PreparedStatement ps;
        
        String sql = "UPDATE ZEH.Customer Cus set Cus.Cus_Status = 'InActive' where Cus.Cus_Num = '"+cus+"'";
        
        proper manager1 = null;
         Connection manager2 = null;
               
        con1 = (java.sql.Connection) manager1.getMySqlConnection();
        ps= (java.sql.PreparedStatement) con1.prepareStatement(sql);
        con2 = (java.sql.Connection) manager2.getMySqlConnection();
        ps= (java.sql.PreparedStatement) con2.prepareStatement(sql);
        ps.executeUpdate();
        
    }
    
  
}
