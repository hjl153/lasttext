package com.example.text;

public class jihuaitem {
    private int id;
    private String Jdate;
    private int Jleibie;
    private int Jzhuangtai;
    private String Jcontext;

    public int getJzhuangtai() {
        return Jzhuangtai;
    }
    public jihuaitem() {
        super();
        this.Jzhuangtai=0;
        this.Jdate = "";
        this.Jcontext = "";
    }

    public jihuaitem(String jdate,String jcontext,int jleibie,int jzhuangtai) {
        super();
        this.Jdate = jdate;
        this.Jleibie = jleibie;
        this.Jcontext = jcontext;
        this.Jzhuangtai=jzhuangtai;
    }

    public int getId() {
        return id;
    }

    public String getJdate() {
        return Jdate;
    }

    public int getJleibie() {
        return Jleibie;
    }

    public String getJcontext() {
        return Jcontext;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJdate(String jdate) {
        Jdate = jdate;
    }

    public void setJleibie(int jleibie) {
        Jleibie = jleibie;
    }

    public void setJcontext(String jcontext) {
        Jcontext = jcontext;
    }
    public void setJzhuangtai(int jzhuangtai) {
        Jzhuangtai = jzhuangtai;
    }
}

