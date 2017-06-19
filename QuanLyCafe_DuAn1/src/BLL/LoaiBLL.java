/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.LoaiDAL;
import java.sql.ResultSet;

/**
 *
 * @author LTSNLH5586
 */
public class LoaiBLL {
    public static ResultSet getAllLoai(){
        ResultSet rs;
        rs = LoaiDAL.getAllLoai();
        return rs;
    }
}
