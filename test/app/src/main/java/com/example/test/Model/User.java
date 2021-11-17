package com.example.test.Model;

import java.io.Serializable;

public class User implements Serializable {
    private String hoTen;
    private String CMND;
    private String gioiTinh;
    private boolean anNgon;
    private boolean macDep;
    private boolean choiGame;
    private String moTa;


    public User() {
    }

    public User(String hoTen, String CMND, String gioiTinh, boolean anNgon, boolean macDep, boolean choiGame, String moTa) {
        this.hoTen = hoTen;
        this.CMND = CMND;
        this.gioiTinh = gioiTinh;
        this.anNgon = anNgon;
        this.macDep = macDep;
        this.choiGame = choiGame;
        this.moTa = moTa;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public boolean isAnNgon() {
        return anNgon;
    }

    public void setAnNgon(boolean anNgon) {
        this.anNgon = anNgon;
    }

    public boolean isMacDep() {
        return macDep;
    }

    public void setMacDep(boolean macDep) {
        this.macDep = macDep;
    }

    public boolean isChoiGame() {
        return choiGame;
    }

    public void setChoiGame(boolean choiGame) {
        this.choiGame = choiGame;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    @Override
    public String toString() {
        return "Ho ten: " + hoTen + ' ' +
                "CMND: " +    CMND + ' ' +
                "Gioi tinh: " + gioiTinh + ' ';

    }
}
