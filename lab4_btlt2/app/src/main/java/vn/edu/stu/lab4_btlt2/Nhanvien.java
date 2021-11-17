package vn.edu.stu.lab4_btlt2;

import java.io.Serializable;

public class Nhanvien implements Serializable {
    private String ma;
    private String ten;
    private String sdt;

    public Nhanvien() {
    }

    public Nhanvien(String ma, String ten, String sdt) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return
                "Mã: " + ma + '\n' +
                        "Tên: " + ten + '\n' +
                        "SĐT: " + sdt;
    }
}
