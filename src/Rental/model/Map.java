/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.model;

/**
 *
 * @author acer
 */
public class Map {
    private int Map_Num;
    private String Map_Image;
    private String Date_Update;

    
    public Map(String Image, String Date){
        this.Map_Image = Image;
        this.Date_Update = Date;
    }
    
    public int getMap_Num() {
        return Map_Num;
    }

    
    public void setMap_Num(int Map_Num) {
        this.Map_Num = Map_Num;
    }

    
    public String getMap_Image() {
        return Map_Image;
    }

    
    public void setMap_Image(String Map_Image) {
        this.Map_Image = Map_Image;
    }

    
    public String getDate_Update() {
        return Date_Update;
    }

   
    public void setDate_Update(String Date_Update) {
        this.Date_Update = Date_Update;
    }
    
}
