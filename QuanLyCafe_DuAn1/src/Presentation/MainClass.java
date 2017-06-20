/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import BLL.HoaDonBLL;
import DAL.ChiTietHoaDonDAL;
import DAL.ConnectionDB;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Random;
import java.util.Vector;
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
        //ChiTietHoaDonDAL.getChiTietHoaDonBySoHoaDon("20170618152215");
        frmdn.show();
      
    }
   
}
 
