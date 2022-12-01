/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apotek;

/**
 *
 * @author yodha
 */
public class TesterApotek {
    public static void main(String[] args) {
        Apotek a = new Apotek();
        int b = a.getstock("1");
        System.out.println(b);
        System.out.println(a.getHarga("3"));
        a.setStock("2", "75");
        a.setHarga("3", "15000");
        int c = 100;
        System.out.println(Integer.toString(c));
        
    }
}
