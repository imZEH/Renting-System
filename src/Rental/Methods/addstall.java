/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.Connection;
import Connections.proper;
import Rental.model.*;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author acer
 */
public class addstall {
    
    public void addSta(Stall stall) throws Exception{
         java.sql.Connection con1;
         java.sql.Connection con2;
        PreparedStatement ps;
	ResultSet rs = null;
        String sql = "INSERT into Stall(Stall_Num,Stall_Name,Stall_Status,Section_Num) VALUES(?,?,?,?)";
        
        proper manager1 = null;
        Connection manager2 = null;
        
        con1 =  (java.sql.Connection) manager1.getMySqlConnection();
        con2 =  (java.sql.Connection) manager2.getMySqlConnection();
	ps= (PreparedStatement) con1.prepareStatement(sql);
        ps= (PreparedStatement) con2.prepareStatement(sql);
        
        ps.setInt(1, stall.getStall_Num());
        ps.setString(2, stall.getStall_Name());
        ps.setString(3, stall.getStall_Status());
        ps.setInt(4, stall.getSection_Num());
        ps.executeUpdate();
        
    }
    public void addSec(Section section) throws Exception{
        java.sql.Connection con1 ;
        java.sql.Connection con2 ;
        PreparedStatement ps;
	ResultSet rs = null;
        String sql = "INSERT into Section(Section_Num,Section_Type,Section_Description) VALUES(?,?,?)";
        proper manager1 = null;
        Connection manager2 = null;
        
        con1 =  (java.sql.Connection) manager1.getMySqlConnection();
	
        con2=  (java.sql.Connection) manager2.getMySqlConnection();
	ps= (PreparedStatement) con1.prepareStatement(sql);
        ps= (PreparedStatement) con2.prepareStatement(sql);
        
        ps.setInt(1, section.getSection_Num());
        ps.setString(2, section.getSection_Type());
        ps.setString(3, section.getSection_Description());
        ps.executeUpdate();
    }
    
    public void addrate(Stall_Rate_History Rate) throws Exception{
        java.sql.Connection con1;
        java.sql.Connection con2;
        PreparedStatement ps;
	ResultSet rs = null;
        String sql = "INSERT into Stall_Rate_History(SRH_Price,SRH_Date_of_Price_Change,Stall_Num) VALUES(?,?,?)";
        
        proper manager1 = null;
        Connection manager2 = null;
        
        con1 =  (java.sql.Connection) manager1.getMySqlConnection();
	
         con2 =  (java.sql.Connection) manager2.getMySqlConnection();
	ps= (PreparedStatement) con1.prepareStatement(sql);
        ps= (PreparedStatement) con2.prepareStatement(sql);
        
        
        ps.setDouble(1, Rate.getSRH_Price());
        ps.setString(2, Rate.getSRH_Date());
        ps.setInt(3, Rate.getStall_Num());
        ps.executeUpdate();
    }
    
    public void upStall(int StallNum, String SName, String Status, int SNum) throws Exception{
        java.sql.Connection con1;
        java.sql.Connection con2;
		java.sql.PreparedStatement ps;
        String sql = "UPDATE ZEH.Stall ST set ST.Stall_num = '"+StallNum+"',ST.Stall_Name = '"+SName+"', ST.Stall_Status = '"+Status+"', ST.Section_Num = '"+SNum+"'"
                + "where ST.Stall_Num = '"+StallNum+"' ";
        proper manager1 = null;
        Connection manager2 = null;
        
        con1 = (java.sql.Connection) manager1.getMySqlConnection();
			ps= (java.sql.PreparedStatement) con1.prepareStatement(sql);
                        con2 = (java.sql.Connection) manager2.getMySqlConnection();
			ps= (java.sql.PreparedStatement) con2.prepareStatement(sql);

		ps.executeUpdate();
    }
    
    public void upSec(int SecNum, String SecType, String SecDes) throws Exception{
        java.sql.Connection con1 ;
        java.sql.Connection con2 ;
		java.sql.PreparedStatement ps ;
        String sql = "UPDATE ZEH.Section S set S.Section_Num = '"+SecNum+"', S.Section_Type = '"+SecType+"', S.Section_Description = '"+SecDes+"'  where S.Section_Num = '"+SecNum+"'";
     proper manager1 = null;
      Connection manager2 = null;
        
        con1 = (java.sql.Connection) manager1.getMySqlConnection();
			ps= (java.sql.PreparedStatement) con1.prepareStatement(sql);
                        con2 = (java.sql.Connection) manager2.getMySqlConnection();
			ps= (java.sql.PreparedStatement) con2.prepareStatement(sql);

		ps.executeUpdate();
    }
    
    
    public void upStallRate(double SPrice, String DateChange, int StallNum) throws Exception{
        java.sql.Connection con1;
        java.sql.Connection con2;
	java.sql.PreparedStatement ps;
        
        String sql = "UPDATE ZEH.Stall_Rate_History RATE set RATE.SRH_Price = '"+SPrice+"' , RATE.SRH_Date_of_Price_Change = '"+DateChange+"' , RATE.Stall_Num = '"+StallNum+"' where RATE.Stall_Num = '"+StallNum+"'";
        proper manager1 = null;
        proper manager2 = null;
        
        con1 = (java.sql.Connection) manager1.getMySqlConnection();
	ps= (java.sql.PreparedStatement) con1.prepareStatement(sql);
        con2 = (java.sql.Connection) manager2.getMySqlConnection();
	ps= (java.sql.PreparedStatement) con2.prepareStatement(sql);

	ps.executeUpdate();
    }
   
    public void updatestallStatus(int cusNum)throws Exception{
        java.sql.Connection con2;
        java.sql.Connection con1;
        
	java.sql.PreparedStatement ps;
        
        String sql = "UPDATE ZEH.Stall ST INNER JOIN ZEH.Stall_Rent_HIstory SRH set ST.Stall_Status = 'Available' where SRH.Cus_Num = '"+cusNum+"'";
        proper manager1 = null;
        Connection manager2 = null;
        
        
        con1 = (java.sql.Connection) manager1.getMySqlConnection();
	ps= (java.sql.PreparedStatement) con1.prepareStatement(sql);
        con2 = (java.sql.Connection) manager2.getMySqlConnection();
	ps= (java.sql.PreparedStatement) con2.prepareStatement(sql);

	ps.executeUpdate();
    }
    
}
