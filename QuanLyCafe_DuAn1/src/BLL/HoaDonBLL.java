/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.HoaDonDAL;
import DTO.HoaDon;
import java.math.BigDecimal;

/**
 *
 * @author LTSNLH5586
 */
public class HoaDonBLL {
    public static void addHoaDon(HoaDon hd){
       
           HoaDonDAL.addHoaDon(hd);
        
    }
    public static HoaDon getHoaDonBySoHoaDon(String soHoaDon){
        
       HoaDon hoaDon = HoaDonDAL.getHoaDonBySoHoaDon(soHoaDon);
        return hoaDon;
    }
     public static void updateTongTienHoaDon(String soHoaDon ,BigDecimal tongTien) {
        
            HoaDonDAL.updateTongTienHoaDon(soHoaDon, tongTien);
        
    } 
     public static void deleteHoaDon(String soHoaDon) {
        
            HoaDonDAL.deleteHoaDon(soHoaDon);
        
    } 
}
