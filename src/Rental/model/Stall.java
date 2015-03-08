/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.model;

/**
 *
 * @author STUDENT
 */
public class Stall {
    private int Stall_Num;
    private String Stall_Name;
    private String Stall_Description;
    private String Stall_Status;
    private int Section_Num;
    private double Stall_Price;
    private String Section_Type;
    private String STH_Date_Of_Rent;

   public Stall(int StallNum, String SName,String Location, String Status,String SecType,double Price){
       this.Stall_Num = StallNum;
       this.Stall_Name = SName;
       this.Stall_Status = Status;
       this.Stall_Description = Location;
       this.Section_Type = SecType;
       this.Stall_Price = Price;
   }
   
   public Stall(int StallNum,String StallName,String STATUS, int sect){
       this.Stall_Num = StallNum;
       this.Stall_Name = StallName;
       this.Stall_Status = STATUS;
       this.Section_Num = sect;
       
   }
    public Stall(int StallNum,String StallName,String STATUS){
       this.Stall_Num = StallNum;
       this.Stall_Name = StallName;
       this.Stall_Status = STATUS;
       
   }
   
   public Stall(int Snum,String Sname,String secT,String loc,String status,String datePriceChange,double price){
       this.Stall_Num = Snum;
       this.Stall_Name = Sname;
       this.Section_Type = secT;
       this.Stall_Description = loc;
       this.Stall_Status = status;
       this.STH_Date_Of_Rent = datePriceChange;
       this.Stall_Price = price;
       
   }
    public int getStall_Num() {
        return Stall_Num;
    }

    
    public void setStall_Num(int Stall_Num) {
        this.Stall_Num = Stall_Num;
    }

   
    public String getStall_Name() {
        return Stall_Name;
    }

    
    public void setStall_Name(String Stall_Name) {
        this.Stall_Name = Stall_Name;
    }

   
    public String getStall_Description() {
        return Stall_Description;
    }

    public void setStall_Description(String Stall_Description) {
        this.Stall_Description = Stall_Description;
    }

   
    public String getStall_Status() {
        return Stall_Status;
    }

    
    public void setStall_Status(String Stall_Status) {
        this.Stall_Status = Stall_Status;
    }

    
    public int getSection_Num() {
        return Section_Num;
    }

    
    public void setSection_Num(int Section_Num) {
        this.Section_Num = Section_Num;
    }

    
    public double getStall_Price() {
        return Stall_Price;
    }

   
    public void setStall_Price(double Stall_Price) {
        this.Stall_Price = Stall_Price;
    }

    
    public String getSection_Type() {
        return Section_Type;
    }

   
    public void setSection_Type(String Section_Type) {
        this.Section_Type = Section_Type;
    }

   
    public String getSTH_Date_Of_Rent() {
        return STH_Date_Of_Rent;
    }

    
    public void setSTH_Date_Of_Rent(String STH_Date_Of_Rent) {
        this.STH_Date_Of_Rent = STH_Date_Of_Rent;
    }

}
