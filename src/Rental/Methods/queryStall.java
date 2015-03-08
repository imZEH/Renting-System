/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.*;
import Rental.model.Stall;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class queryStall {
   private Statement st ;
    private java.sql.Connection con1;
    private proper manager1 = null;
    private java.sql.Connection con2;
    private Connection manager2 = null;
    ResultSet rs = null;
    
    public queryStall(){
        
    }
    
    public queryStall (proper manager1){
        this.manager1 = manager1;
    }
    public queryStall (Connection manager2){
        this.manager2 = manager2;
    }
    
    public List<Stall> RetrieveStall(String ID, String Stall_Status) throws Exception{
        List stallList = new ArrayList();
        con1 =  (java.sql.Connection) proper.getMySqlConnection();
        java.sql.Statement stmt = con1.createStatement();
        con2 =  (java.sql.Connection) Connection.getMySqlConnection();
         stmt = con2.createStatement();
        rs = stmt.executeQuery("Select ST.Stall_Num,ST.Stall_Name,ST.Stall_Status,S.Section_Description, S.Section_Type,RATe.SRH_Price from ZEH.Section S INNER JOIN ZEH.Section SE ON S.Section_Num = SE.Section_Num "
               + " INNER JOIN ZEH.Stall ST ON ST.Section_Num = S.Section_Num "
               + " INNER JOIN ZEH.Stall_Rate_History RATE On RATe.Stall_Num = ST.Stall_Num where ST.Stall_Num LIKE '"+ID+"%' OR ST.Stall_Status LIKE '"+Stall_Status+"%'"
                + "UNION "
                + " Select STA.Stall_Num,STA.Stall_Name,STA.Stall_Status,SE.Section_Description, SE.Section_Type,RATES.SRH_Price from ZEH.Section SE INNER JOIN ZEH.Section S ON SE.Section_Num = S.Section_Num "
               + " INNER JOIN ZEH.Stall STA ON STA.Section_Num = SE.Section_Num "
               + " INNER JOIN ZEH.Stall_Rate_History RATES On RATES.Stall_Num = STA.Stall_Num where STA.Stall_Num LIKE '"+ID+"%' OR STA.Stall_Status LIKE '"+Stall_Status+"%'");
    
        while (rs.next()){
        int num = rs.getInt("Stall_Num");
        String name= rs.getString("Stall_Name");
        String location= rs.getString("Section_Description");
        String section = rs.getString("Section_Type");
        String status= rs.getString("Stall_Status");
        double price= rs.getDouble("SRH_Price");
        
        
        Stall ST = new Stall(num,name,location,status,section,price);
        stallList.add(ST);
        
}
        return stallList;
    }
    
    public List<Stall> RetrieveStallReport(String Status) throws Exception{
        List stallList = new ArrayList();
        con1 =  (java.sql.Connection) proper.getMySqlConnection();
        java.sql.Statement stmt = con1.createStatement();
        con2 =  (java.sql.Connection) Connection.getMySqlConnection();
         stmt = con2.createStatement();
        rs = stmt.executeQuery("SELECT  ST.Stall_Num,ST.Stall_Name,S.Section_Type,S.Section_Description,ST.Stall_Status,"
                + "RATE.SRH_Price,RATE.SRH_Date_Of_Price_Change from ZEH.Section S INNER JOIN ZEH.Stall ST ON ST.Section_Num = S.Section_Num "
                + "INNER JOIN ZEH.Stall_Rate_History RATE ON RATE.Stall_Num = ST.Stall_Num where ST.Stall_Status LIKE '"+Status+"'");
    while (rs.next()){
        int num =rs.getInt("Stall_Num");
        String name= rs.getString("Stall_Name");
        String sec= rs.getString("Section_Type");
        String loc = rs.getString("Section_Description");
        String stn= rs.getString("Stall_Status");
        double price = rs.getDouble("SRH_Price");
        String dt = rs.getString("SRH_Date_Of_Price_Change");
            
           
               Stall ST = new Stall(num,name,sec,loc,stn,dt,price);
               stallList.add(ST);
        }
    return stallList;
    
    
    }
    
    
    
    public List<Stall> branch1(String ID, String Stall_Status) throws Exception{
      
        List stallList = new ArrayList();
        con1 =  (java.sql.Connection) ConnectBranch1_1.getMySqlConnection();
        java.sql.Statement stmt = con1.createStatement();
        con2 =  (java.sql.Connection) ConnectBranch2_1.getMySqlConnection();
         stmt = con2.createStatement();
        rs = stmt.executeQuery("Select ST.Stall_Num,ST.Stall_Name,ST.Stall_Status,S.Section_Description, S.Section_Type,RATe.SRH_Price "
                +"from ZEH.Section S INNER JOIN ZEH.Section SE ON S.Section_Num = SE.Section_Num "
               + "INNER JOIN ZEH.Stall ST ON ST.Section_Num = S.Section_Num "
               + "INNER JOIN ZEH.Stall_Rate_History RATE On RATe.Stall_Num = ST.Stall_Num "
                +"where ST.Stall_Num LIKE '"+ID+"%' OR ST.Stall_Status LIKE '"+Stall_Status+"%'");
    
        while (rs.next()){
        int num = rs.getInt("Stall_Num");
        String name= rs.getString("Stall_Name");
        String location= rs.getString("Section_Description");
        String section = rs.getString("Section_Type");
        String status= rs.getString("Stall_Status");
        double price= rs.getDouble("SRH_Price");
        
        
        Stall ST = new Stall(num,name,location,status,section,price);
        stallList.add(ST);
        
}
        return stallList;
    }
    public List<Stall> branch2(String ID, String Stall_Status) throws Exception{
      
        List stallList = new ArrayList();
        con1 =  (java.sql.Connection) ConnectBranch1_2.getMySqlConnection();
        java.sql.Statement stmt = con1.createStatement();
        con2 =  (java.sql.Connection) ConnectBranch2_2.getMySqlConnection();
         stmt = con2.createStatement();
        rs = stmt.executeQuery("Select ST.Stall_Num,ST.Stall_Name,ST.Stall_Status,S.Section_Description, S.Section_Type,RATe.SRH_Price from ZEH.Section S INNER JOIN ZEH.Section SE ON S.Section_Num = SE.Section_Num "
               + "INNER JOIN ZEH.Stall ST ON ST.Section_Num = S.Section_Num "
               + "INNER JOIN ZEH.Stall_Rate_History RATE On RATe.Stall_Num = ST.Stall_Num where ST.Stall_Num LIKE '"+ID+"%' OR ST.Stall_Status LIKE '"+Stall_Status+"%'");
    
        while (rs.next()){
        int num = rs.getInt("Stall_Num");
        String name= rs.getString("Stall_Name");
        String location= rs.getString("Section_Description");
        String section = rs.getString("Section_Type");
        String status= rs.getString("Stall_Status");
        double price= rs.getDouble("SRH_Price");
        
        
        Stall ST = new Stall(num,name,location,status,section,price);
        stallList.add(ST);
        
}
        return stallList;
    }
    
    public List<Stall> select(String ID, String Stall_Status) throws Exception{
        List stallList = new ArrayList();
        con1 =  (java.sql.Connection) proper.getMySqlConnection();
        java.sql.Statement stmt = con1.createStatement();
        con2 =  (java.sql.Connection) Connection.getMySqlConnection();
         stmt = con2.createStatement();
        rs = stmt.executeQuery("Select * from ZEH.Stall Union all Select * from ZEH.Stall");
    
        while (rs.next()){
        int num = rs.getInt("Stall_Num");
        String name= rs.getString("Stall_Name");
        String location= rs.getString("Stall_Status");
        
        
        Stall ST = new Stall(num,name,location);
        stallList.add(ST);
        
}
        return stallList;
    }
}
