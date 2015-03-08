/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.model;

/**
 *
 * @author STUDENT
 */
public class Stall_Rate_History {
    private int SRH_Num;
    private double SRH_Price;
    private String SRH_Date_of_Price_Change;
    private int Stall_Num;

    
    public Stall_Rate_History(double Price ,  String Date ,  int StallNum){
        
        this.SRH_Price = Price;
        this.SRH_Date_of_Price_Change = Date;
        this.Stall_Num = StallNum;
    }
    
   
    public int getSRH_Num() {
        return SRH_Num;
    }

    
    public void setSRH_Num(int SRH_Num) {
        this.SRH_Num = SRH_Num;
    }

    
    public double getSRH_Price() {
        return SRH_Price;
    }

    
    public void setSRH_Price(double SRH_Price) {
        this.SRH_Price = SRH_Price;
    }

    
    public String getSRH_Date() {
        return SRH_Date_of_Price_Change;
    }

    
    public void setSRH_Date(String SRH_Date) {
        this.SRH_Date_of_Price_Change = SRH_Date;
    }

    
    public int getStall_Num() {
        return Stall_Num;
    }

    
    public void setStall_Num(int Stall_Num) {
        this.Stall_Num = Stall_Num;
    }
    
    
}
