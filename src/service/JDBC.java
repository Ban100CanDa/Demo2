/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*;
/**
 *
 * @author acer
 */
public class JDBC {
    static String url ="jdbc:sqlserver://DESKTOP-2KQ9KFJ\\SQLEXPRESS:1433;encrypt=false;databaseName=FINALASS_FPOLY_NET_JAVA_SM22_BL2";
    static String user = "sa";
    static String pass = "123456789";
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
