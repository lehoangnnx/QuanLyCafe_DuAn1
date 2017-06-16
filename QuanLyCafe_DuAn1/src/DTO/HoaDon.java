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

    private int Id;
    private Date Gioden;
    private BigDecimal Tongtien;
    private BigDecimal Giamgia;
    private int IdUser;
    private int Trangthai;
    private int Idban;

    public HoaDon() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getGioden() {
        return Gioden;
    }

    public void setGioden(Date Gioden) {
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
