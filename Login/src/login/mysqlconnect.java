/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class mysqlconnect {
    Connection conn = null;
    public static Connection ConnectDb() {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/login","root","1234");
       //     JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null; 
        }
   
    }
}
