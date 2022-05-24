/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author citra
 */
public class connection {
    
   private static java.sql.Connection koneksi;
    public static java.sql.Connection getConnection(){
        if(koneksi == null){
            try{
                String url = "jdbc:mysql://localhost:3306/chat";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url,user,password);
                System.out.println("Connection Successfully");
            } catch (Exception e){
                System.out.println("Error");
            }
        }
        return koneksi;
    }
    
    public static void main(String[] args){
        getConnection();
    }
}
