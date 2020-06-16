package com.example.text;

public class Useritem {
    private int id;
    private String UserName;
    private String Password;
    private int Count;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Useritem() {
        super();
        this.UserName = "";
        this.Password = "";
        this.Count=0;
    }

    public Useritem(String UserName, String Password,int count) {
        super();
        this.UserName = UserName;
        this.Password = Password;
        this.Count=count;
    }
}
