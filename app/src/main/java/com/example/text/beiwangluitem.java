package com.example.text;

public class beiwangluitem {
    private int id;
    private String Bdate;
    private String Bcontext;
    public beiwangluitem() {
        super();
        this.Bdate = "";
        this.Bcontext = "";
    }
    public beiwangluitem( String bdate, String bcontext) {
        Bdate = bdate;
        Bcontext = bcontext;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBdate() {
        return Bdate;
    }

    public void setBdate(String bdate) {
        Bdate = bdate;
    }

    public String getBcontext() {
        return Bcontext;
    }

    public void setBcontext(String bcontext) {
        Bcontext = bcontext;
    }
}
