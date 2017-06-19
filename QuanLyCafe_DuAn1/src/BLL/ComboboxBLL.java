/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DinhNghiaComboBox;
import Presentation.MainClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Ridotoji Pham
 */
public class ComboboxBLL {
    public static void LoadDuLieuCombobox(ResultSet rs, JComboBox Combobox, String TenCotHienThi, String TenCotMa) {
        DefaultComboBoxModel Combo = new DefaultComboBoxModel();
        try {
            while (rs.next()) {
                DinhNghiaComboBox item = new DinhNghiaComboBox(rs.getString(TenCotHienThi), rs.getInt(TenCotMa));
                Combo.addElement(item);
                Combobox.setModel(Combo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
   
    public  void setSelectedCombobox(JComboBox cbb, String cbbValue) {
        //Vòng lặp lấy tất cả item trong combobox
        for (int i = 0; i < cbb.getItemCount(); i++) {
            //Lấy từng giá Element trong combobox và gán vào 1 biến Object
            Object obj = cbb.getItemAt(i);
            //Nếu obj khác null
            if (obj != null) {
                //Ép kiểu obj về kiểu DisplayValueModel nhưng mình đã định nghĩa
                DinhNghiaComboBox m = (DinhNghiaComboBox) obj;
                //Nếu nội dung bằng với DisplayMember của obj thì chọn lại combobox
                if (cbbValue.equals(m.DisplayMmber)) {
                    cbb.setSelectedItem(m);   //chọn lại combobox theo Element
                }
            }
        }
    }
    // Hàm định nghĩa số thiws tự trong bảng 
    public static String getSelectedItemID(JComboBox cbb) {
        String result;
        Object[] obj = cbb.getSelectedObjects();
        DinhNghiaComboBox item = (DinhNghiaComboBox) obj[0];
        result = item.DisplayValue.toString();
        return result;
    }
      
}
