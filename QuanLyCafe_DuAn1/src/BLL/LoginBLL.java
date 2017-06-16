/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.LoginDAL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LTSNLH5586
 */
public class LoginBLL {
    public static boolean KiemTra(String tdn) {    
        boolean kq = false;
        ResultSet rs;
        rs = LoginDAL.getUserByUsername(tdn);
        try {
            if(rs.next()){
                kq=true;
                quyen = rs.getInt("Idroles");
                manv = rs.getInt("Id");
                matkhau=rs.getString("Pwd");
            }    
        } catch (SQLException ex) {
            System.out.println("lỗi đăng nhập");
        }
        
       
        return kq;
    }
    public static int quyen = 0;
    public static  int manv = 0;
    public static  String matkhau = "";
    
}
