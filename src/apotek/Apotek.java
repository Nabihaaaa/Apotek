/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package apotek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author yodha
 */
public final class Apotek implements SQL{
    
    public static Connection con;
    public static Statement stm;
    public static ResultSet res;

    public Apotek() {
        connectsql();
    }
    
    @Override
    public void connectsql() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/database_apotek","root","");
            stm = con.createStatement();
        } catch (Exception ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getstock(String ID){
        try {    
            res = stm.executeQuery("SELECT * from stockobat where ID="+ID);
            int s = 0;
            while (res.next()){
                s = res.getInt("Stock");
            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int getstock(int ID){
        try {
            String id = Integer.toString(ID);
            res = stm.executeQuery("SELECT * from stockobat where ID="+id);
            int s = 0;
            while (res.next()){
                s = res.getInt("Stock");
            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public void setStock(String ID, String Total){
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE StockObat set stock="+Total+" WHERE ID="+ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setStock(int ID, int Total){
        String id = Integer.toString(ID);
        String total = Integer.toString(Total);
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE StockObat set stock="+total+" WHERE ID="+id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getHarga(String ID){
        try {
            res = stm.executeQuery("SELECT * from stockobat where ID="+ID);
            int s = 0;
            while (res.next()){
                s = res.getInt("Harga");
            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;    
    }
    
    public int getHarga(int ID){
        try {
            String id = Integer.toString(ID);
            res = stm.executeQuery("SELECT * from stockobat where ID="+id);
            int s = 0;
            while (res.next()){
                s = res.getInt("Harga");
            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }
    
    public void setHarga(String ID, String Harga){
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE StockObat set Harga="+Harga+" WHERE ID="+ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setHarga(int ID, int Harga){
        String id = Integer.toString(ID);
        String harga = Integer.toString(Harga);
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE StockObat set Harga="+harga+" WHERE ID="+id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getNama(String ID){
        try {
            res = stm.executeQuery("SELECT * from stockobat where ID="+ID);
            int s = 0;
            while (res.next()){
                s = res.getInt("Nama");
            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;    
    }
    
    public void setNama(String ID, String Nama){
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE stockobat set Nama=(?) WHERE ID=(?)");
            ps.setString(1,Nama);
            ps.setString(2, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setKaryawan(String Kolom, String ID, String data){
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Karyawan set "+Kolom+"=(?) WHERE ID=(?)");
            ps.setString(1,data);
            ps.setString(2, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Apotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void tableDisplay() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
