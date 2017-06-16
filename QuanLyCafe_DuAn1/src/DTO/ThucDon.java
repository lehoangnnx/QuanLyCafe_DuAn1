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
public class ThucDon {

    private int Id;
    private String TenMon;
    private int IdLoai;
    private BigDecimal DonGia;
    private String DonViTinh;

    public ThucDon() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public int getIdLoai() {
        return IdLoai;
    }

    public void setIdLoai(int IdLoai) {
        this.IdLoai = IdLoai;
    }

    public BigDecimal getDonGia() {
        return DonGia;
    }

    public void setDonGia(BigDecimal DonGia) {
        this.DonGia = DonGia;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

}
