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
public class HoaDon {

    
    private String SoHoaDon;
    private String Gioden;
    private BigDecimal Tongtien;
    private BigDecimal Giamgia;
    private int IdUser;
    private int Trangthai;
    private int Idban;

    public HoaDon(String SoHoaDon, String Gioden, BigDecimal Tongtien, BigDecimal Giamgia, int IdUser, int Trangthai, int Idban) {
        this.SoHoaDon = SoHoaDon;
        this.Gioden = Gioden;
        this.Tongtien = Tongtien;
        this.Giamgia = Giamgia;
        this.IdUser = IdUser;
        this.Trangthai = Trangthai;
        this.Idban = Idban;
    }

    public String getSoHoaDon() {
        return SoHoaDon;
    }

    public void setSoHoaDon(String SoHoaDon) {
        this.SoHoaDon = SoHoaDon;
    }

    
    
    public HoaDon() {
    }

   

    public String getGioden() {
        return Gioden;
    }

    public void setGioden(String Gioden) {
        this.Gioden = Gioden;
    }

    public BigDecimal getTongtien() {
        return Tongtien;
    }

    public void setTongtien(BigDecimal Tongtien) {
        this.Tongtien = Tongtien;
    }

    public BigDecimal getGiamgia() {
        return Giamgia;
    }

    public void setGiamgia(BigDecimal Giamgia) {
        this.Giamgia = Giamgia;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public int getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(int Trangthai) {
        this.Trangthai = Trangthai;
    }

    public int getIdban() {
        return Idban;
    }

    public void setIdban(int Idban) {
        this.Idban = Idban;
    }

}
