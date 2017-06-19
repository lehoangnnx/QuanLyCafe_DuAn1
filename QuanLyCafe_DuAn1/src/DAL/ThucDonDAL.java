/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ThucDon;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LTSNLH5586
 */
public class ThucDonDAL {

    public static ResultSet getAllThucDon() {
        ResultSet rs;
        String sql = "select * from  ThucDon  ";
        rs = ConnectionDB.ExcuteQueryGetTable(sql);
        return rs;
    }

    public static ResultSet getThucDonByIdLoai(int idLoai) {
        ResultSet rs;
        String sql = "select * from  ThucDon where IdLoai = " + idLoai;
        rs = ConnectionDB.ExcuteQueryGetTable(sql);
        return rs;
    }
    public static ThucDon getThucDonById(int id) {
        ResultSet rs;
        
        String sql = "select * from  ThucDon where Id = " + id;
        rs = ConnectionDB.ExcuteQueryGetTable(sql);
        ThucDon thucDon = new ThucDon();
        try {
            while(rs.next()){
                thucDon.setTenMon(rs.getString("TenMon"));
                thucDon.setDonViTinh(rs.getString("DonViTinh"));
                thucDon.setDonGia(new BigDecimal(rs.getString("DonGia")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thucDon;
    }
}
