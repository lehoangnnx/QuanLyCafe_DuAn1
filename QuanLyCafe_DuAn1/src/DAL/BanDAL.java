/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LTSNLH5586
 */
public class BanDAL {

    public static ArrayList<Ban> getAllBan() {
        ResultSet rs;
        ArrayList<Ban> ban = null;
        String sql = "select * from Ban";
        rs = ConnectionDB.ExcuteQueryGetTable(sql);
        ban = new ArrayList<Ban>();
        try {
            while (rs.next()) {
                Ban b = new Ban(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4));
                ban.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ban;
    }

    public static void updateTrangThaiVaSoHoaDon(int idBan, String soHoaDon ,int trangThai) {
        String cautruyvan = "update Ban set Trangthai =" + trangThai + ", SoHoaDon = '"+soHoaDon+"' where Id = " + idBan + "";
        ConnectionDB.ExcuteQueryUpdate(cautruyvan);
    }
}
