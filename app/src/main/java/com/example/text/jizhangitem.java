package com.example.text;

public class jizhangitem {
    private int id;
    private String Mname;
    private String Mdate;
    private float Mprice;
    private int Shuliang;
    private String Mleibie;
    private String Zhushui;
    private int Mtype;
    public jizhangitem() {
        super();
        this.Mname = "";
        this.Mdate = "";
        this.Mprice = 0.0f;
        this.Shuliang = 0;
        this.Mleibie = "";
        this.Zhushui = "";
        this.Mtype = 0;
    }
    public jizhangitem(int id, String mname, String mdate, float mprice, int shuliang, String mleibie, String zhushui, int mtype) {
        this.id = id;
        Mname = mname;
        Mdate = mdate;
        Mprice = mprice;
        Shuliang = shuliang;
        Mleibie = mleibie;
        Zhushui = zhushui;
        Mtype = mtype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getMdate() {
        return Mdate;
    }

    public void setMdate(String mdate) {
        Mdate = mdate;
    }

    public float getMprice() {
        return Mprice;
    }

    public void setMprice(float mprice) {
        Mprice = mprice;
    }

    public int getShuliang() {
        return Shuliang;
    }

    public void setShuliang(int shuliang) {
        Shuliang = shuliang;
    }

    public String getMleibie() {
        return Mleibie;
    }

    public void setMleibie(String mleibie) {
        Mleibie = mleibie;
    }

    public String getZhushui() {
        return Zhushui;
    }

    public void setZhushui(String zhushui) {
        Zhushui = zhushui;
    }

    public int getMtype() {
        return Mtype;
    }

    public void setMtype(int mtype) {
        Mtype = mtype;
    }
}
