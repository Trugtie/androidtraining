package vn.edu.stu.buoi4;

import java.io.Serializable;

public class User implements Serializable {
    private String hoTen;
    private String CMND;
    private boolean nam;
    private boolean nu;
    private boolean khac;
    private boolean anNgon;
    private boolean macDep;
    private boolean choiGame;
    private String moTa;


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

    public boolean isNam() {
        return nam;
    }

    public void setNam(boolean nam) {
        this.nam = nam;
    }

    public boolean isNu() {
        return nu;
    }

    public void setNu(boolean nu) {
        this.nu = nu;
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

    public boolean isKhac() {
        return khac;
    }

    public void setKhac(boolean khac) {
        this.khac = khac;
    }
}
