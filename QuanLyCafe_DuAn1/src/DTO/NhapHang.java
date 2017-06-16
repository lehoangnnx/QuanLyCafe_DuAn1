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
public class NhapHang {

    private int Id;
    private String Ten;
    private Date NgayNhap;
    private int IdNCC;
    private int IdUser;
    private int IdHangHoa;
    private BigDecimal Tongtien;

    public NhapHang() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public int getIdNCC() {
        return IdNCC;
    }

    public void setIdNCC(int IdNCC) {
        this.IdNCC = IdNCC;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public int getIdHangHoa() {
        return IdHangHoa;
    }

    public void setIdHangHoa(int IdHangHoa) {
        this.IdHangHoa = IdHangHoa;
    }

    public BigDecimal getTongtien() {
        return Tongtien;
    }

    public void setTongtien(BigDecimal Tongtien) {
        this.Tongtien = Tongtien;
    }

}
