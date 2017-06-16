/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ridotoji Pham
 */
public class ConnectionDB {
    String SQLConnection = "jdbc:sqlserver://localhost"
            + ";databaseName=QLCafe;user=sa;password=123456;";
     static Connection conn;
     public  ConnectionDB(){
         try {
             DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
             conn = DriverManager.getConnection(SQLConnection);
              if (conn != null) {
                System.out.println("Kết nối CSDL thành công!");
            }else{
                System.out.println("Kết nối CSDL thất bại!");    
            }
         } catch (SQLException e) {
             System.out.println(e.toString());
         }
     }
     /**
     * Hàm thực thi câu lệnh Select
     * Đầu vào: @CauTruyVanSQL - Câu truy vấn Select cần thực thi
     * Đầu ra: ResultSet - Bảng dữ liệu, vì câu Select trả về bảng dữ liệu
     * @param cauTruyVan
     * @return 
     */
    public static ResultSet ExcuteQueryGetTable(String cauTruyVan){
        try {
            ResultSet rs;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(cauTruyVan);
            return rs;
        }
        catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return null;    
    }
    /**
     * Hàm thực thi câu lệnh update, delete, insert
     * Đầu vào: @CauTruyvan 
     * Đầu ra: Thực thi và cập nhập vào CSDL
     * @param cauTruyVan
     */
    public static void ExcuteQueryUpdate(String cauTruyVan){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cauTruyVan);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
