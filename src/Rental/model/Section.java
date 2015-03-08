/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.model;

/**
 *
 * @author STUDENT
 */
public class Section {
    private int Section_Num;
    private String Section_Type;
    private String Section_Description;

    
    public Section(int SectionNum,String Type, String Des){
        this.Section_Num = SectionNum;
        this.Section_Type = Type;
        this.Section_Description = Des;
        
    }
     public Section(String Type, String Des){
            this.Section_Type = Type;
            this.Section_Description = Des;
        }

    public Section(int Num) {
        this.Section_Num = Num;
    }
    
    public int getSection_Num() {
        return Section_Num;
    }

   
    public void setSection_Num(int Section_Num) {
        this.Section_Num = Section_Num;
    }

    
    public String getSection_Type() {
        return Section_Type;
    }

    
    public void setSection_Type(String Section_Type) {
        this.Section_Type = Section_Type;
    }

   
    public String getSection_Description() {
        return Section_Description;
    }

   
    public void setSection_Description(String Section_Description) {
        this.Section_Description = Section_Description;
    }
}
