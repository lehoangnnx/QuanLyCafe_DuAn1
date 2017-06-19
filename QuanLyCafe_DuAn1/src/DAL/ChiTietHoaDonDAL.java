/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ChiTietHoaDon;
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
public class ChiTietHoaDonDAL {
     public  static  void addChiTietHoaDon(ChiTietHoaDon cthd){
    String sql ="insert into ChiTietHoaDon(SoHoaDon,Idthucdon,Soluong,Gia) "
            + "values ('"+cthd.getSoHoaDon()+"', "+cthd.getIdthucdon()+", "+cthd.getSoluong()+", "+cthd.getGia()+") ";
               ConnectionDB.ExcuteQueryUpdate(sql);
        }
     public static void updateSoLuongMonChitietHoaDon(int soLuong, int idChiTietHoaDon, BigDecimal gia) {
        String sql = "update ChiTietHoaDon set SoLuong =" + soLuong + ", Gia = "+gia+" where Id = " + idChiTietHoaDon ;
        ConnectionDB.ExcuteQueryUpdate(sql);
    }
     public static void dateleChiTietHoaDon( int idChiTietHoaDon) {
        String sql = "delete ChiTietHoaDon where Id= " + idChiTietHoaDon;
        ConnectionDB.ExcuteQueryUpdate(sql);
    }
     public static ResultSet getChiTietHoaDonBySoHoaDon(String soHoaDon) {
        ResultSet rs;

        String sql = "select * from  ChiTietHoaDon where SoHoaDon = '" + soHoaDon + "'";
        rs = ConnectionDB.ExcuteQueryGetTable(sql);
        
        return rs;
    }
     
      public static ResultSet getChiTietHoaDonBySoHoaDonVaIdThucDon(String soHoaDon, int idThucDon) {
        ResultSet rs;

        String sql = "select * from  ChiTietHoaDon where SoHoaDon = '" + soHoaDon + "' and Idthucdon = "+idThucDon ;
        rs = ConnectionDB.ExcuteQueryGetTable(sql);
        
        return rs;
    }
     
}
