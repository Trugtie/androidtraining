package vn.edu.stu.studentinfoproject;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String mssv;
    private String hoTen;
    private int namSinh;

    public SinhVien(String mssv, String hoTen, int namSinh) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }

    @Override
    public String toString() {
        return
                "Mã sinh viên: '" + mssv +
                "\nHọ và tên: " + hoTen +
                "\nNăm sinh: " + namSinh;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
}
