/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.*;
import java.sql.ResultSet;


/**
 *
 * @author LTSNLH5586
 */
public class LoginDAL {
    
     public static ResultSet getUserByUsername(String userName){
        ResultSet rs;
        String cautruyvan = "select * from Users where UserName= '" + userName + "'";
       
        rs = ConnectionDB.ExcuteQueryGetTable(cautruyvan);
        
        return rs;
    }
}
