package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class zhangfenglei extends AppCompatActivity {
    TextView alljin,allchu,allshiping,allfuzhuang,allxuexi,allriyong;
    String M="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhangfenglei);
        alljin=findViewById(R.id.alljin);
        allchu=findViewById(R.id.allchu);
        allshiping=findViewById(R.id.allshiping);
        allfuzhuang=findViewById(R.id.allfuzhuang);
        allxuexi=findViewById(R.id.allxuexi);
        allriyong=findViewById(R.id.allriyong);
        allchu.setText(getChu());
        alljin.setText(getJin());
        allshiping.setText(getFood());
        allfuzhuang.setText(getFuzhuang());
        allxuexi.setText(getXuxi());
        allriyong.setText(getRiyong());
    }
    public String getChu() {
        DBManger dbManager = new DBManger(this);
        List<jizhangitem> Zestlist = dbManager.listAllZ();
        Float C=0.0f;
        for(jizhangitem i:Zestlist){
            if(i.getMtype()==0){
                C=-i.getShuliang()*i.getMprice()+C;
            }
            }
        M=String.valueOf(C);
        return M;}
    public String getJin() {
        DBManger dbManager = new DBManger(this);
        List<jizhangitem> Zestlist = dbManager.listAllZ();
        Float C=0.0f;
        for(jizhangitem i:Zestlist){
            if(i.getMtype()==1){
                C=i.getShuliang()*i.getMprice()+C;
            }
        }
        M=String.valueOf(C);
        return M;}
    public String getFood() {
        DBManger dbManager = new DBManger(this);
        List<jizhangitem> Zestlist = dbManager.listAllZ();
        Float C=0.0f;
        for(jizhangitem i:Zestlist){
            if(i.getMleibie().equals("食品支出")){
                C=i.getShuliang()*i.getMprice()+C;
            }
        }
        M=String.valueOf(C);
        return M;}
    public String getFuzhuang() {
        DBManger dbManager = new DBManger(this);
        List<jizhangitem> Zestlist = dbManager.listAllZ();
        Float C=0.0f;
        for(jizhangitem i:Zestlist){
            if(i.getMleibie().equals("服装支出")){
                C=i.getShuliang()*i.getMprice()+C;
            }
        }
        M=String.valueOf(C);
        return M;}
    public String getXuxi() {
        DBManger dbManager = new DBManger(this);
        List<jizhangitem> Zestlist = dbManager.listAllZ();
        Float C=0.0f;
        for(jizhangitem i:Zestlist){
            if(i.getMleibie().equals("学习支出")){
                C=i.getShuliang()*i.getMprice()+C;
            }
        }
        M=String.valueOf(C);
        return M;}
    public String getRiyong() {
        DBManger dbManager = new DBManger(this);
        List<jizhangitem> Zestlist = dbManager.listAllZ();
        Float C=0.0f;
        for(jizhangitem i:Zestlist){
            if(i.getMleibie().equals("日用支出")){
                C=i.getShuliang()*i.getMprice()+C;
            }
        }
        M=String.valueOf(C);
        return M;}
}
