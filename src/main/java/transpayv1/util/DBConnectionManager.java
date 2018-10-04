/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Utility for connection to mysql-database
 * @author jk
 */
public class DBConnectionManager {
    
    public DBConnectionManager() {
        
    }
    
    public static Connection getConnection() {
        
            Connection con = null;

            // Load Driver
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            // Get the main Connection
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moresis?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8", "root", "root");//20VjhtcbC15
//                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moresis?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf-8", "root", "root");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            return con;
    }
}