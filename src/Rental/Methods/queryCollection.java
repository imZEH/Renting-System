/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.Connection;
import Connections.proper;
import Rental.model.Collection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class queryCollection {
    private Statement st ;
    private java.sql.Connection con1;
    private java.sql.Connection con2;
    private proper manager1 = null;
    private Connection manager2 = null;
    ResultSet rs = null;
    
    public queryCollection(){
        
    }
    
    public queryCollection (proper manager1){
        this.manager1 = manager1;
    }
    public queryCollection (Connection manager2){
        this.manager2 = manager2;
    }
    
    public List<Collection> RetrieveCollection(String ID) throws Exception{
        List CollList = new ArrayList();
        con1 =  (java.sql.Connection) proper.getMySqlConnection();
        java.sql.Statement stmt = con1.createStatement();
        con2 =  (java.sql.Connection) Connection.getMySqlConnection();
        stmt = con2.createStatement();
        rs = stmt.executeQuery("Select CONCAT(Emp.Emp_LName,', ',Emp.Emp_FName,' ',Emp.Emp_MidName) Fullname,"
                + "Col.Col_Date, ST.Stall_Name,Col.Col_Monthly From ZEH.Collection Col INNER JOIN ZEH.Employee Emp ON Emp.Emp_IDNum = Col.Emp_IDNum "
                + "INNER JOIN ZEH.Stall ST ON ST.Stall_Num = Col.Stall_Num Where Col.Col_Date LIKE '%"+ID+"%'");

        while(rs.next()){
        String FulName = rs.getString("Fullname");
        String ColDate = rs.getString("Col_Date");
        String SName = rs.getString("Stall_Name");
        int Amount = rs.getInt("Col_Monthly");
        
        Collection Col = new Collection(FulName,ColDate,SName,Amount);
        CollList.add(Col);
    }
        return CollList;
    }
    
    public List<Collection> RetrieveTotalCollection(String ID) throws Exception{
        List CollList = new ArrayList();
        con1 =  (java.sql.Connection) proper.getMySqlConnection();
        java.sql.Statement stmt = con1.createStatement();
        con2 =  (java.sql.Connection) Connection.getMySqlConnection();
         stmt = con2.createStatement();
        rs = stmt.executeQuery("Select Col.Col_Date,Sum(Col.Col_Monthly) total From ZEH.Employee Emp INNER JOIN ZEH.Collection Col ON Col.Emp_IDNum = Emp.Emp_IDNum Where Col.Col_Date LIKE '%"+ID+"%'");

       while(rs.next()){
        String ColDate = rs.getString("Col_Date");
        double SName = rs.getDouble("total");
        String Date = "";
            Date = ColDate;
            String a[] = Date.split(" ");
            Date = a[0];
        
        Collection Coll = new Collection(Date,SName);
        CollList.add(Coll);
    }
        return CollList;
    }
    
    public List<Collection> RetrieveTotalCollectionYear(String ID) throws Exception{
        List CollList = new ArrayList();
        con1 =  (java.sql.Connection) proper.getMySqlConnection();
        java.sql.Statement stmt = con1.createStatement();
        con2 =  (java.sql.Connection) Connection.getMySqlConnection();
        stmt = con2.createStatement();
        rs = stmt.executeQuery("Select Col.UnCollect,Sum(Col.Col_Monthly) total,Sum(Col.Total_Arrears) arrears,Col.Col_Date from ZEH.Collection Col where Col.Col_Date LIKE '%"+ID+"%'");

        while(rs.next()){
        double total = rs.getDouble("total");
        double uncolect = rs.getDouble("UnCollect");
        double arr = rs.getDouble("arrears");
        String date = rs.getString("Col_Date");
        double unco = uncolect*12;
        double untotal = unco - total;
        String Date = "";
            Date = date;
            String a[] = Date.split(" ");
            Date = a[2];
         
        Collection Coll = new Collection(Date,untotal,total,arr);
        CollList.add(Coll); 
    }
        return CollList;
    }
    }
    
    
    
    
