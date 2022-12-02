/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apotek;

import static apotek.Apotek.res;
import static apotek.Apotek.stm;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yodha
 */
public class TesterApotek {
    public static void main(String[] args) {
        try {
            Apotek a = new Apotek();
            int b = a.getstock("1");
            System.out.println(b);
            System.out.println(a.getHarga("3"));
            a.setStock("2", "75");
            a.setHarga("3", "15000");
            int c = Integer.parseInt("10");
            System.out.println(c);
            
            int total = 0;
            res = stm.executeQuery("select stock from stockobat");
            while (res.next()){
                total += res.getInt("stock");
            }
            System.out.println(total);
        } catch (SQLException ex) {
            Logger.getLogger(TesterApotek.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
