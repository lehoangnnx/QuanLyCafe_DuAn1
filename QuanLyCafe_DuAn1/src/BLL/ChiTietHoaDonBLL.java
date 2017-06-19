/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ChiTietHoaDonDAL;
import DAL.ConnectionDB;
import DAL.ThucDonDAL;
import DTO.ChiTietHoaDon;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LTSNLH5586
 */
public class ChiTietHoaDonBLL {
    public static void addChiTietHoaDon(ChiTietHoaDon cthd){
       
           ChiTietHoaDonDAL.addChiTietHoaDon(cthd);
        
    }
    
    public static void updateSoLuongMonChitietHoaDon(int soLuong, int idChiTietHoaDon, BigDecimal gia){
       
           ChiTietHoaDonDAL.updateSoLuongMonChitietHoaDon(soLuong, idChiTietHoaDon, gia);
        
    }
    public static void deleteChiTietHoaDon(int idChiTietHoaDon){
       
           ChiTietHoaDonDAL.dateleChiTietHoaDon(idChiTietHoaDon);
        
    }
    public static ResultSet getChiTietThucDonBySoHoaDon(String soHoaDon){
        ResultSet rs;
        rs = ChiTietHoaDonDAL.getChiTietHoaDonBySoHoaDon(soHoaDon);
        return rs;
    }
    public static int tongTien = 0;
    public static boolean updateSoLuongMon = false;
    public static int idChiTietHoaDon = 0;
    public static int getSoLuong = 0;
    public static ChiTietHoaDon getChiTietHoaDonBySoHoaDonStr(String soHoaDon) {
        ResultSet rs;
        rs = ChiTietHoaDonDAL.getChiTietHoaDonBySoHoaDon(soHoaDon);
        ChiTietHoaDon chiTiethHoaDon = new ChiTietHoaDon();
        try {
            while (rs.next()) {
                tongTien = tongTien + rs.getInt("Gia");
                chiTiethHoaDon.setGia(new BigDecimal(rs.getString("Gia")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chiTiethHoaDon;
    }
    public static ChiTietHoaDon getChiTietHoaDonBySoHoaDonVaIdThucDon(String soHoaDon, int idThucDon) {
        ResultSet rs;
        rs = ChiTietHoaDonDAL.getChiTietHoaDonBySoHoaDonVaIdThucDon(soHoaDon, idThucDon);
        ChiTietHoaDon chiTiethHoaDon = new ChiTietHoaDon();
        try {
            while (rs.next()) {
                updateSoLuongMon = true;
                idChiTietHoaDon = rs.getInt("Id");
                getSoLuong = rs.getInt("Soluong");
                //chiTiethHoaDon.setGia(new BigDecimal(rs.getString("Gia")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chiTiethHoaDon;
    }
    public static void DoDuLieuVaoJTableChiTietHoaDon(ResultSet rs, JTable tableTam){
        Object []objs = new Object[]{"Id","Số Hóa Đơn","Tên Món", "Số Lượng","Giá", "Tổng Giá","Id Thực Đơn"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        tableTam.setModel(tableModel);
        tableTam.getColumnModel().getColumn(0).setMinWidth(0);
        tableTam.getColumnModel().getColumn(0).setMaxWidth(0);
        tableTam.getColumnModel().getColumn(1).setMinWidth(0);
        tableTam.getColumnModel().getColumn(1).setMaxWidth(0);
        tableTam.getColumnModel().getColumn(6).setMinWidth(0);
        tableTam.getColumnModel().getColumn(6).setMaxWidth(0);
        try {
            while(rs.next()){
                Object[] item = new Object[7];
                 item[0] = rs.getInt("Id");
                 item[1] = rs.getString("SoHoaDon");
                item[2] = ThucDonDAL.getThucDonById(rs.getInt("Idthucdon")).getTenMon();
                   
                item[3] = rs.getInt("Soluong");
                 item[4] = rs.getInt("Gia") / rs.getInt("Soluong") ;
                item[5] = rs.getString("Gia");
                item[6] = rs.getInt("Idthucdon");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
}
