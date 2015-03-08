/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.model;

/**
 *
 * @author STUDENT
 */
public class Collection {
    private int Coll_num;
    private double totalArrears;
    private String Coll_Date;
    private String Stall_Name;
    private String Emp_FullName;
    private String Coll_CusType;
    private double Col_Monthly;
    private double UnCollect;
    private double Stall_Price;

    public Collection(String FulName, String ColDate, String Name, double Amount){
        this.Col_Monthly = Amount;
        this.Coll_Date = ColDate;
        this.Stall_Name = Name;
        this.Emp_FullName = FulName;
      }
    
    public Collection(String Date, double Amount){
        this.Coll_Date = Date;
        this.Col_Monthly = Amount;
         
    }
    
    public Collection(String Date,double untotal,double total, double arr){
        this.Coll_Date = Date;
        this.UnCollect = untotal;
        this.Col_Monthly = total;
        this.totalArrears = arr;
        
    }
    public int getColl_num() {
        return Coll_num;
    }

    
    public void setColl_num(int Coll_num) {
        this.Coll_num = Coll_num;
    }

    
    public String getColl_Date() {
        return Coll_Date;
    }

    
    public void setColl_Date(String Coll_Date) {
        this.Coll_Date = Coll_Date;
    }

    
    public String getStall_Name() {
        return Stall_Name;
    }

    
    public void setStall_Name(String Stall_Name) {
        this.Stall_Name = Stall_Name;
    }

    
    public String getEmp_FullName() {
        return Emp_FullName;
    }

    
    public void setEmp_FullName(String Emp_FullName) {
        this.Emp_FullName = Emp_FullName;
    }

    
    public String getColl_CusType() {
        return Coll_CusType;
    }

    
    public void setColl_CusType(String Coll_CusType) {
        this.Coll_CusType = Coll_CusType;
    }

    
    public double getCol_Monthly() {
        return Col_Monthly;
    }

    
    public void setCol_Monthly(double Col_Monthly) {
        this.Col_Monthly = Col_Monthly;
    }

    
    public double getUnCollect() {
        return UnCollect;
    }

    
    public void setUnCollect(double UnCollect) {
        this.UnCollect = UnCollect;
    }

    
    public double getTotalArrears() {
        return totalArrears;
    }

    
    public void setTotalArrears(double totalArrears) {
        this.totalArrears = totalArrears;
    }

    
    public double getStall_Price() {
        return Stall_Price;
    }

    
    public void setStall_Price(double Stall_Price) {
        this.Stall_Price = Stall_Price;
    }
}
