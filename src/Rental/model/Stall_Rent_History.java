/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.model;

/**
 *
 * @author STUDENT
 */
public class Stall_Rent_History {
    private int STH_Num;
    private int Stall_Num;
    private int Cus_Num;
    private String STH_DateOfRent;
    private String STH_DueDate;
    private String STH_Extension;
    
    
    public Stall_Rent_History(String daterent,int stallnum, int cusnum,String dueDate, String Extension){
        this.Stall_Num = stallnum;
        this.Cus_Num = cusnum;
        this.STH_DateOfRent = daterent;
        this.STH_DueDate = dueDate;
        this.STH_Extension = Extension;
    }

    
    public int getSTH_Num() {
        return STH_Num;
    }

    
    public void setSTH_Num(int STH_Num) {
        this.STH_Num = STH_Num;
    }

    
    public int getStall_Num() {
        return Stall_Num;
    }

    
    public void setStall_Num(int Stall_Num) {
        this.Stall_Num = Stall_Num;
    }

    
    public int getCus_Num() {
        return Cus_Num;
    }

    
    public void setCus_Num(int Cus_Num) {
        this.Cus_Num = Cus_Num;
    }

    
    public String getSTH_DateOfRent() {
        return STH_DateOfRent;
    }

   
    public void setSTH_DateOfRent(String STH_DateOfRent) {
        this.STH_DateOfRent = STH_DateOfRent;
    }

    
    public String getSTH_DueDate() {
        return STH_DueDate;
    }

    
    public void setSTH_DueDate(String STH_DueDate) {
        this.STH_DueDate = STH_DueDate;
    }

    
    public String getSTH_Extension() {
        return STH_Extension;
    }

    
    public void setSTH_Extension(String STH_Extension) {
        this.STH_Extension = STH_Extension;
    }

    
   

    
}
