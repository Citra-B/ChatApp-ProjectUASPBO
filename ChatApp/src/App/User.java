/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import connection.connection;
import java.sql.*;
/**
 *
 * @author citra
 */
public class User {
    int id;
    String name,username,password;
    
    public int cekLogin(){
        int nilaiBalik = 0;
        try{
            Connection c = connection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM users WHERE username='" + this.username +
                    "' AND password='" + this.password + "'";
            ResultSet r = s.executeQuery(sql);
            
            if(r.next()){
                if(this.username.equals("admin")){
                    nilaiBalik = 2;
                } else { 
                    nilaiBalik = 1;
                }
                
                this.id = r.getInt("id");
                this.name = r.getString("name");
            }
        } catch(SQLException e){
            System.out.println("Error");
        }
        return nilaiBalik;
    }
    
    public int cekDaftar(){
        int nilaiBalik = 0;
        try{
            Connection c = connection.getConnection();
            
            Statement s = c.createStatement();
          
            String sql = "SELECT * FROM users WHERE username='" + this.username + "'";
            ResultSet r = s.executeQuery(sql);
            if(!r.next()){
                sql = "INSERT INTO users VALUES (?,?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);               
                p.setString(1, this.name);
                p.setString(2, this.username);
                p.setString(3, this.password);
                p.setString(4, null);

                p.executeUpdate();
                p.close();
                
                nilaiBalik = 1;
            } 
          
        }catch(SQLException e){
            System.out.println("Error");
        }
        return nilaiBalik;
    }
    
    public int kirimPesan(String pengirim, String isiPesan){
        try{
            Connection c = connection.getConnection();
            
            String sql = "INSERT INTO pesan VALUES (?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, null);
            p.setString(2, this.username);
            p.setString(3, pengirim);
            p.setString(4, isiPesan);
            
            
            p.executeUpdate();
            p.close();
        } catch (SQLException e){
            System.out.println("Error");
        }
        return 1;
    }
}
