/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.model;

/**
 *
 * @author STUDENT
 */
public class Customer {
    private int Cus_Num;
    private String Cus_Fname;
    private String Cus_Lname;
    private String Cus_MidName;
    private String Cus_Address;
    private String Cus_ContactNumber;
    private String Cus_Status;
    private String Cus_Type;
    private String Cus_Image;
    private String Cus_Path;
    private double SRH_Price;
    private String STH_DueDate;
    private String Fullname;
    private String Stall_Name;
    private String Cus_Pay_Status;
    private double Cus_Arrears;
    private String STH_Date_OF_Rent;
   
    
  public Customer(int Num,String FName,String MName,String LName,String Add,String ConNum,String Status,String Image , String PATH){
      this.Cus_Num = Num;
      this.Cus_Fname = FName;
      this.Cus_MidName = MName;
      this.Cus_Lname = LName;
      this.Cus_Address = Add;
      this.Cus_ContactNumber = ConNum;
      this.Cus_Status = Status;
      this.Cus_Image = Image;
      this.Cus_Path = PATH;
  }
  
  public Customer(int Num, String FullName, String Add,String ConNum,String Status,String Stall_Purchase,double Price,String duedate){
      this.Cus_Num = Num;
      this.Fullname = FullName;
      this.Cus_Address = Add;
      this.SRH_Price = Price;
      this.Cus_ContactNumber = ConNum;
      this.Cus_Status = Status;
      this.STH_DueDate = duedate;
      this.Stall_Name = Stall_Purchase;
     // this.Cus_Pay_Status = Des;
  }
  public Customer(int Num, String FullName, String ConNum, String Status, String duedate, String Stall_Purchase, double arrears,double Price){
      this.Cus_Num = Num;
      this.Fullname = FullName;
      this.Cus_Arrears = arrears;
      this.SRH_Price = Price;
      this.Cus_ContactNumber = ConNum;
      this.Cus_Status = Status;
      this.STH_DueDate = duedate;
      this.Stall_Name = Stall_Purchase;
      
  }
  
  public Customer (int num, String full, String sta,String stn, String datepur, double stp){
      this.Cus_Num = num;
      this.Fullname = full;
      this.Cus_Status = sta;
      this.Stall_Name = stn;
      this.STH_Date_OF_Rent = datepur;
      this.SRH_Price = stp;
  }
  
  public Customer(int Num){
      this.Cus_Num = Num;
      
  }

   
    public int getCus_Num() {
        return Cus_Num;
    }

   
    public void setCus_Num(int CusNum) {
        this.Cus_Num = CusNum;
    }

   
    public String getCus_Fname() {
        return Cus_Fname;
    }

   void setCus_Fname(String firstName) {
        this.Cus_Fname = firstName;
    }

    public String getCus_Lname() {
        return Cus_Lname;
    }

    
    public void setCus_Lname(String lastName) {
        this.Cus_Lname = lastName;
    }

    
    public String getCus_MidName() {
        return Cus_MidName;
    }

   
    public void setCus_MidName(String middleName) {
        this.Cus_MidName = middleName;
    }

    
    public String getCus_Address() {
        return Cus_Address;
    }

    
    public void setCus_Address(String homeAddress) {
        this.Cus_Address = homeAddress;
    }

    
    public String getCus_ContactNumber() {
        return Cus_ContactNumber;
    }

    
    public void setCus_ContactNumber(String Contact) {
        this.Cus_ContactNumber = Contact;
    }

    
    public String getCus_Status() {
        return Cus_Status;
    }

    
    public void setCus_Status(String status) {
        this.Cus_Status = status;
    }

    
    public String getCus_Type() {
        return Cus_Type;
    }

    
    public void setCus_Type(String type) {
        this.Cus_Type = type;
    }

    
    public String getCus_Image() {
        return Cus_Image;
    }

    
    public void setCus_Image(String Cus_Image) {
        this.Cus_Image = Cus_Image;
    }

    
    public String getCus_Path() {
        return Cus_Path;
    }

    
    public void setCus_Path(String Cus_Path) {
        this.Cus_Path = Cus_Path;
    }

    
    public double getSRH_Price() {
        return SRH_Price;
    }

    
    public void setSRH_Price(double SRH_Price) {
        this.SRH_Price = SRH_Price;
    }

    
    public String getSTH_DueDate() {
        return STH_DueDate;
    }

    
    public void setSTH_DueDate(String STH_DueDate) {
        this.STH_DueDate = STH_DueDate;
    }

    
    public String getFullname() {
        return Fullname;
    }

    
    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    
    public String getStall_Name() {
        return Stall_Name;
    }

    
    public void setStall_Name(String Stall_Name) {
        this.Stall_Name = Stall_Name;
    }

   
    public String getCus_Pay_Status() {
        return Cus_Pay_Status;
    }

    
    public void setCus_Pay_Status(String Cus_Pay_Status) {
        this.Cus_Pay_Status = Cus_Pay_Status;
    }

    
    public double getCus_Arrears() {
        return Cus_Arrears;
    }

    
    public void setCus_Arrears(double Cus_Arrears) {
        this.Cus_Arrears = Cus_Arrears;
    }

    
    public String getSTH_Date_OF_Rent() {
        return STH_Date_OF_Rent;
    }

    
    public void setSTH_Date_OF_Rent(String STH_Date_OF_Rent) {
        this.STH_Date_OF_Rent = STH_Date_OF_Rent;
    }
    
}
