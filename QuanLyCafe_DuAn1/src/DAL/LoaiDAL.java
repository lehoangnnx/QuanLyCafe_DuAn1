/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.Loai;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LTSNLH5586
 */
public class LoaiDAL {
    public static String getTenLoaibyId(int id){
        String tenLoai = "";
        ResultSet rs;
        String sql = "select * from Loai where Id = "+id;
        rs=ConnectionDB.ExcuteQueryGetTable(sql);
        try {
            
            while(rs.next()){
                tenLoai = rs.getString("TenLoai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenLoai;
    }
    public static ResultSet getAllLoai() {
        ResultSet rs;
        String SQLSelect = "select * from loai";
        rs = ConnectionDB.ExcuteQueryGetTable(SQLSelect);
        return rs;
    }
}
