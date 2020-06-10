package com.example.text;

public class jihuaitem {
    private int id;
    private String Jdate;
    private int Jleibie;
    private String Jcontext;


    public jihuaitem() {
        super();
        this.Jdate = "";
        this.Jleibie=0;
        this.Jcontext = "";
    }

    public jihuaitem(String Jdate, int Jleibie,String Jcontext) {
        super();
        this.Jdate = Jdate;
        this.Jleibie = Jleibie;
        this.Jcontext = Jcontext;
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
}

