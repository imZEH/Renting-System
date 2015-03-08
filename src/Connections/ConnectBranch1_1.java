/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Neil
 */
public class ConnectBranch1_1 {
     public static java.sql.Connection getMySqlConnection() throws Exception {
String driver = "com.mysql.jdbc.Driver";
Properties info = new Properties();
info.load(new FileInputStream("config1.properties"));
String address2 = info.getProperty("address2");
String user = info.getProperty("username");
String pass = info.getProperty("password");
String url ="jdbc:mysql://"+address2+":3306/ZEH";

Class.forName(driver); 
java.sql.Connection conn = DriverManager.getConnection(url, user,pass);
return conn;
}
}
