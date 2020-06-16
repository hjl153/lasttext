package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class plan extends AppCompatActivity {
    TextView plan,daka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        plan=findViewById(R.id.plan);
        daka=findViewById(R.id.daka);
        SharedPreferences sp=getSharedPreferences("myname", Activity.MODE_PRIVATE);
        String name=sp.getString("name","");
        DBManger dbManager = new DBManger(this);
        int count=dbManager.findCount(name);
        daka.setText(String.valueOf(count));
        plan.setText(getcount()+"%");
    }
    public String getcount() {
        DBManger dbManager = new DBManger(this);
        List<jihuaitem> Jestlist = dbManager.listAllJ();
        Float x=0.0f,y=0.0f;
        for(jihuaitem i:Jestlist){
            if(i.getJzhuangtai()==1){
                x=x+1;
            }
            y=y+1;
        }
        float m=x/y*100;
        String xm=String.valueOf(m);
        Log.i("tag",""+m);
        return xm;}
}
