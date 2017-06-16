/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigDecimal;

/**
 *
 * @author LTSNLH5586
 */
public class ChiTietHoaDon {

    private int Id;
    private int Idhoadon;
    private int Idthucdon;
    private int Soluong;
    private BigDecimal Gia;

    public ChiTietHoaDon() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdhoadon() {
        return Idhoadon;
    }

    public void setIdhoadon(int Idhoadon) {
        this.Idhoadon = Idhoadon;
    }

    public int getIdthucdon() {
        return Idthucdon;
    }

    public void setIdthucdon(int Idthucdon) {
        this.Idthucdon = Idthucdon;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public BigDecimal getGia() {
        return Gia;
    }

    public void setGia(BigDecimal Gia) {
        this.Gia = Gia;
    }

}
