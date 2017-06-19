/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.LoaiDAL;
import DAL.ThucDonDAL;
import DTO.ThucDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LTSNLH5586
 */
public class ThucDonBLL {
    public static ResultSet getAllThucDon(){
        ResultSet rs;
        rs = ThucDonDAL.getAllThucDon();
        return rs;
    }
    
    public static ResultSet getThucDonByIdLoai(int idLoai){
        ResultSet rs;
        rs = ThucDonDAL.getThucDonByIdLoai(idLoai);
        return rs;
    }
    public static ThucDon getThucDonById(int id){
        
       ThucDon thucDon = ThucDonDAL.getThucDonById(id);
        return thucDon;
    }
    
    public static void doDuLieuVaoBang(ResultSet rs, JTable tableTam){
        Object []objs = new Object[]{"Loại Món", "Tên Loại", "Giá","Đơn Vị Tính"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        tableTam.setModel(tableModel);
        
        try {
            while(rs.next()){
                Object[] item = new Object[11];
                item[0] = LoaiDAL.getTenLoaibyId(rs.getInt("IdLoai"));
                
                item[1] = rs.getString("TenMon");
                item[2] = rs.getString("DonGia");
                item[3]= rs.getString("DonViTinh");
                
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
