/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.model;




public class Employee {
    private int Emp_IDNum;
    private String Emp_Acount;
    private String Emp_Password;
    private String Emp_FName;
    private String Emp_LName;
    private String Emp_MidName;
    private String Emp_Type;
    private String Emp_Status;
    private String FullName;
    
    public Employee(int ID, String Account, String Password, String FName, String MName, String LName, String Type){
        this.Emp_IDNum = ID;
        this.Emp_Acount = Account;
        this.Emp_Password = Password;
        this.Emp_FName = FName;
        this.Emp_MidName = MName;
        this.Emp_LName = LName;
        this.Emp_Type = Type;
    }
    
    public Employee(int ID, String Name, String Type, String sta){
        this.Emp_IDNum = ID;
        this.FullName = Name;
        this.Emp_Type = Type;
        this.Emp_Status = sta;
    }
    
    public Employee(String mao1,String name, String St, int EmpNum){
    this.Emp_Type = mao1;
    this.FullName = name;
    this.Emp_Status = St;
    this.Emp_IDNum = EmpNum;
        
    }
   

   
    public int getEmp_IDNum() {
        return Emp_IDNum;
    }

   
    public void setEmp_IDNum(int Emp_IDNum) {
        this.Emp_IDNum = Emp_IDNum;
    }

    
    public String getEmp_Acount() {
        return Emp_Acount;
    }

    
    public void setEmp_Acount(String Emp_Acount) {
        this.Emp_Acount = Emp_Acount;
    }

   
    public String getEmp_Password() {
        return Emp_Password;
    }

    
    public void setEmp_Password(String Emp_Password) {
        this.Emp_Password = Emp_Password;
    }

    
    public String getEmp_FName() {
        return Emp_FName;
    }

   
    
    public void setEmp_FName(String Emp_FName) {
        this.Emp_FName = Emp_FName;
    }

    
    public String getEmp_LName() {
        return Emp_LName;
    }

    
    public void setEmp_LName(String Emp_LName) {
        this.Emp_LName = Emp_LName;
    }

    
    
    public String getEmp_MidName() {
        return Emp_MidName;
    }

    
    public void setEmp_MidName(String Emp_MidName) {
        this.Emp_MidName = Emp_MidName;
    }

   
    public String getEmp_Type() {
        return Emp_Type;
    }

    
    public void setEmp_Type(String Emp_Type) {
        this.Emp_Type = Emp_Type;
    }

    
    public String getEmp_Status() {
        return Emp_Status;
    }

    public void setEmp_Status(String Emp_Status) {
        this.Emp_Status = Emp_Status;
    }

    
    public String getFullName() {
        return FullName;
    }

    
    public void setFullName(String FullName) {
        this.FullName = FullName;
    }
    
}
