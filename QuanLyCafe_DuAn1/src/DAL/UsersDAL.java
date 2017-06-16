/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.Users;
/**
 *
 * @author LTSNLH5586
 */
public class UsersDAL {
    public static void CauTruyVanThemNhanVien(Users u) {
        String sql = "insert into Users(Username,Pwd,Idroles) "
                + "values ('"+u.getUsername()+"', '"+u.getPwd()+"',1) ";            
        ConnectionDB.ExcuteQueryUpdate(sql);
    }
}
