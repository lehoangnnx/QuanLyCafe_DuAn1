/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DAL.ConnectionDB;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nhung
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static frmDangNhap frmdn = new frmDangNhap();
    public static ConnectionDB Connection = new ConnectionDB();
    public static void main(String[] args) {
        // TODO code application logic here
        frmdn.show();
    }
   
}
 
