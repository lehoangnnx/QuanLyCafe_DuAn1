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
public class Phat {

    private int Id;
    private int IdUser;
    private String LyDo;
    private Date Ngay;
    private BigDecimal TienThuong;
    private BigDecimal TienPhat;

    public Phat() {
    }

    public Phat(int Id, int IdUser, String LyDo, Date Ngay, BigDecimal TienThuong, BigDecimal TienPhat) {
        this.Id = Id;
        this.IdUser = IdUser;
        this.LyDo = LyDo;
        this.Ngay = Ngay;
        this.TienThuong = TienThuong;
        this.TienPhat = TienPhat;
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

    public String getLyDo() {
        return LyDo;
    }

    public void setLyDo(String LyDo) {
        this.LyDo = LyDo;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

    public BigDecimal getTienThuong() {
        return TienThuong;
    }

    public void setTienThuong(BigDecimal TienThuong) {
        this.TienThuong = TienThuong;
    }

    public BigDecimal getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(BigDecimal TienPhat) {
        this.TienPhat = TienPhat;
    }

}
