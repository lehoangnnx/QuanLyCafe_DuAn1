/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.HoaDon;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LTSNLH5586
 */
public class HoaDonDAL {

    public static void addHoaDon(HoaDon hd) {
        String sql = "insert into HoaDon(SoHoaDon,GioDen,NgayTao,TongTien,GiamGia,IdUser,TrangThai,Idban) "
                + "values('" + hd.getSoHoaDon() + "','" + hd.getGioden() + "','" + hd.getNgayTao()+ "'," + hd.getTongtien() + "," + hd.getGiamgia() + "," + hd.getIdUser() + "," + hd.getTrangthai() + "," + hd.getIdban() + ")";
        ConnectionDB.ExcuteQueryUpdate(sql);
    }

    public static void deleteHoaDon(String soHoaDon) {
        String sql = "delete HoaDon where SoHoaDon= " + soHoaDon ;
        ConnectionDB.ExcuteQueryUpdate(sql);
    }
 public static void updateTongTienHoaDon(String soHoaDon ,BigDecimal tongTien) {
        String sql = "update HoaDon set Tongtien =" + tongTien + " where SoHoaDon = '" + soHoaDon + "'";
        ConnectionDB.ExcuteQueryUpdate(sql);
    }
 public static void updateTrangThaiHoaDon(String soHoaDon ,int trangThai) {
        String sql = "update HoaDon set Trangthai =" + trangThai + " where SoHoaDon = '" + soHoaDon + "'";
        ConnectionDB.ExcuteQueryUpdate(sql);
    }
    public static HoaDon getHoaDonBySoHoaDon(String soHoaDon) {
        ResultSet rs;

        String sql = "select * from  HoaDon where SoHoaDon = '" + soHoaDon + "'";
        rs = ConnectionDB.ExcuteQueryGetTable(sql);
        HoaDon hoaDon = new HoaDon();
        try {
            while (rs.next()) {
                hoaDon.setSoHoaDon(rs.getString("SoHoaDon"));
                hoaDon.setGioden(rs.getString("Gioden"));
                hoaDon.setTongtien(new BigDecimal(rs.getString("Tongtien")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDon;
    }
}
