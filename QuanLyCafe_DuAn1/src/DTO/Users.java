/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author LTSNLH5586
 */
public class Users {

    private int Id;
    private String Username;
    private String Pwd;
    private String Ten;
    private String Diachi;
    private String Sdt;
    private String Cmnd;
    private Date Ngayvaolam;
    private int Idroles;

    public Users() {
    }

    public Users(int Id, String Username, String Pwd, String Ten, String Diachi, String Sdt, String Cmnd, Date Ngayvaolam, int Idroles) {
        this.Id = Id;
        this.Username = Username;
        this.Pwd = Pwd;
        this.Ten = Ten;
        this.Diachi = Diachi;
        this.Sdt = Sdt;
        this.Cmnd = Cmnd;
        this.Ngayvaolam = Ngayvaolam;
        this.Idroles = Idroles;
    }

    public Users(String Username, String Pwd, int Idroles) {
        this.Username = Username;
        this.Pwd = Pwd;
        this.Idroles = Idroles;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String Pwd) {
        this.Pwd = Pwd;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getCmnd() {
        return Cmnd;
    }

    public void setCmnd(String Cmnd) {
        this.Cmnd = Cmnd;
    }

    public Date getNgayvaolam() {
        return Ngayvaolam;
    }

    public void setNgayvaolam(Date Ngayvaolam) {
        this.Ngayvaolam = Ngayvaolam;
    }

    public int getIdroles() {
        return Idroles;
    }

    public void setIdroles(int Idroles) {
        this.Idroles = Idroles;
    }

}
