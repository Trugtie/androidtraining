package vn.edu.stu.karaokelist.model;

public class BaiHat {
private String ma;
private String ten;
private String mota;

    public BaiHat(String ma, String ten, String mota) {
        this.ma = ma;
        this.ten = ten;
        this.mota = mota;
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
