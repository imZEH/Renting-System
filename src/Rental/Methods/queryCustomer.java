/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.Connection;
import Connections.proper;
import Rental.model.Customer;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class queryCustomer {
    
    private Statement st ;
    private java.sql.Connection con1;
    private proper manager1= null;
    private java.sql.Connection con2;
    private Connection manager2 = null;
    ResultSet rs = null;
    
    public queryCustomer(){
        
    }
    
    public queryCustomer (proper manager1){
        this.manager1 = manager1;
    }
    public queryCustomer (Connection manager2){
        this.manager2 = manager2;
    }
    
    public List<Customer> RetrieveCustomer(String ID, String FName,String MName, String LName) throws Exception{
        List custList = new ArrayList();
        con1 =  (java.sql.Connection) proper.getMySqlConnection();
        java.sql.Statement stmt = con1.createStatement();
        con2 =  (java.sql.Connection) Connection.getMySqlConnection();
        stmt = con1.createStatement();
         stmt = con2.createStatement();
        rs = stmt.executeQuery("SELECT CONCAT(UPPER(Cus.Cus_LName),',',UPPER(Cus.Cus_FName),' ',UPPER(Cus.Cus_MidName)) fullname ,Cus.Cus_Num,Cus.Cus_Address,Cus.Cus_ContactNum,Cus.Cus_Status,Cus.Cus_Pay_Status,ST.Stall_Name,RATE.SRH_Price, SRH.STH_DueDate from ZEH.Stall_Rent_History SRH"
               + " INNER JOIN ZEH.Customer Cus ON SRH.Cus_Num = Cus.Cus_Num "
               + " INNER JOIN ZEH.Stall ST ON ST.Stall_Num = SRH.Stall_Num "
               + " INNER JOIN ZEH.Stall_Rate_History RATE ON RATE.Stall_Num = ST.Stall_Num where Cus.Cus_Lname  LIKE '"+LName+"%' OR Cus.Cus_FName LIKE '"+FName+"%' OR Cus.Cus_Num LIKE '"+ID+"%' OR Cus.Cus_MidName LIKE '"+MName+"%'");
     
     
        while (rs.next()){
        int num = rs.getInt("Cus_Num");
        String name = rs.getString("fullname");
        String Add = rs.getString("Cus_Address");
        String Contact = rs.getString("Cus_ContactNum");
        String Status = rs.getString("Cus_Status");
        String StallN = rs.getString("Stall_Name");
        double Price = rs.getDouble("SRH_Price");
        String Duedte = rs.getString("STH_DueDate");
        
        Customer stud = new Customer( num,  name,  Add,  Contact,  Status,  StallN,  Price, Duedte);
        custList.add(stud);
    }
    
        return custList;
    }
    
    public List<Customer> retrievetoCashier(String ID, String FName,String MName, String LName) throws Exception{
    List custList = new ArrayList();
    con1 =  (java.sql.Connection) proper.getMySqlConnection();
    PreparedStatement pst ;
    con2 =  (java.sql.Connection) Connection.getMySqlConnection();
     
    String sql = "SELECT Cus.Cus_Arrears,CONCAT(UPPER(Cus.Cus_LName),',',UPPER(Cus.Cus_FName),' ',UPPER(Cus.Cus_MidName)) fullname ,Cus.Cus_Num,Cus.Cus_Address,Cus.Cus_ContactNum,Cus.Cus_Status,Cus.Cus_Pay_Status,ST.Stall_Name,RATE.SRH_Price, SRH.STH_DueDate from ZEH.Stall_Rent_History SRH"
               + " INNER JOIN ZEH.Customer Cus ON SRH.Cus_Num = Cus.Cus_Num "
               + " INNER JOIN ZEH.Stall ST ON ST.Stall_Num = SRH.Stall_Num "
               + " INNER JOIN ZEH.Stall_Rate_History RATE ON RATE.Stall_Num = ST.Stall_Num where Cus.Cus_Lname  LIKE '"+LName+"%' OR Cus.Cus_FName LIKE '"+FName+"%' OR Cus.Cus_Num LIKE '"+ID+"%' OR Cus.Cus_MidName LIKE '"+MName+"%'";
    pst = (PreparedStatement) con1.prepareStatement(sql);
      pst = (PreparedStatement) con2.prepareStatement(sql);
      rs = pst.executeQuery();
    while (rs.next()){
        
        int num= rs.getInt("Cus_Num");
        String full = rs.getString ("fullname");
        String contact = rs.getString("Cus_ContactNum");
        String sta= rs.getString("Cus_Status");
        String date = rs.getString("STH_DueDate");
        String stn= rs.getString("Stall_Name");
        double arr = rs.getDouble("Cus_Arrears");
        double stp = rs.getDouble("SRH_Price");
        
    
        Customer stud = new Customer(num,full,contact,sta,date,stn,arr,stp);
        custList.add(stud);
    }
    return custList;
}
    
    public List<Customer> retrieveCustomerReport(String Status)throws Exception{
    List custList = new ArrayList();
    con1 =  (java.sql.Connection) proper.getMySqlConnection();
    java.sql.Statement stmt = con1.createStatement();
    con2 =  (java.sql.Connection) Connection.getMySqlConnection();
     stmt = con1.createStatement();
     stmt = con2.createStatement();
    rs = stmt.executeQuery("SELECT CONCAT(Cus.Cus_LName,',', Cus.Cus_FName,' ',  Cus.Cus_MidName) fullname,Cus.Cus_Num,Cus.Cus_Status,ST.Stall_Name,SRH.STH_Date_Of_Rent,RATE.SRH_Price FROM ZEH.Stall_Rent_History SRH "
                + "INNER JOIN ZEH.Customer Cus ON Cus.Cus_Num=SRH.Cus_Num "
                + "INNER JOIN ZEH.Stall ST ON ST.Stall_Num = SRH.Stall_Num "
                + "INNER JOIN ZEH.Stall_Rate_History RATE ON RATE.Stall_Num = ST.Stall_Num where Cus.Cus_Status  = '"+Status+"'");
    while (rs.next()){
        int num = rs.getInt("Cus_Num");
        String full= rs.getString("fullname");
        String sta= rs.getString("Cus_Status");
        String stn= rs.getString("Stall_Name");
        String datepur = rs.getString("STH_Date_Of_Rent");
        double stp = rs.getDouble("SRH_Price");
        
        Customer stud = new Customer(num,full,sta,stn,datepur,stp);
        custList.add(stud);
        }
        return custList;
    }
}


