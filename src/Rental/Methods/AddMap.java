/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental.Methods;

import Connections.Connection;
import Connections.proper;
import Rental.model.Map;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author acer
 */
public class AddMap {
    
    public void Add(Map map) throws Exception{
        java.sql.Connection con1 ;
        java.sql.Connection con2 ;
        PreparedStatement ps ;
        
        String sql = "INSERT into Map(Map_Image,Date_Update) VALUES(?,?)";
        
        proper manager1 = null;
        Connection manager2 = null;
        
        con1 =  (java.sql.Connection) manager1.getMySqlConnection();
        con2 =  (java.sql.Connection) manager2.getMySqlConnection();
	ps= (PreparedStatement) con1.prepareStatement(sql);
        ps= (PreparedStatement) con2.prepareStatement(sql);
        
        String image = map.getMap_Image();
        File f=new File(image);
        FileInputStream fis = null;
        fis = new FileInputStream(f);
        
        ps.setBinaryStream(1, (InputStream)fis, (int)(f.length()));
        ps.setString(2, map.getDate_Update());
        ps.executeUpdate();
    }
    
}
