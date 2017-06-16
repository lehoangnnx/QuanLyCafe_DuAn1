/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author LTSNLH5586
 */
public class Ban {

    private int Id;
    private String Tenban;
    private int Trangthai;

    public Ban() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTenban() {
        return Tenban;
    }

    public void setTenban(String Tenban) {
        this.Tenban = Tenban;
    }

    public int getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(int Trangthai) {
        this.Trangthai = Trangthai;
    }

}
