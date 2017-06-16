/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author LTSNLH5586
 */
public class TinhLuong {

    private int Id;
    private int IdUser;
    private BigDecimal Luong;
    private BigDecimal Tong;
    private Date Ngay;

    public TinhLuong() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public BigDecimal getLuong() {
        return Luong;
    }

    public void setLuong(BigDecimal Luong) {
        this.Luong = Luong;
    }

    public BigDecimal getTong() {
        return Tong;
    }

    public void setTong(BigDecimal Tong) {
        this.Tong = Tong;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

}
