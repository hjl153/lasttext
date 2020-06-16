package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.DbManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class user extends AppCompatActivity {
    TextView username;
    String name,today_sdr,todaytime;
    int count=0;
    String tag="未打卡";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        username=findViewById(R.id.username);
        SharedPreferences sp=getSharedPreferences("myname", Activity.MODE_PRIVATE);
        name=sp.getString("name","");
        username.setText(name);
        SharedPreferences Sp=getSharedPreferences("ddda", Activity.MODE_PRIVATE);
        todaytime=Sp.getString("time","");
    }
    public void onClick(View btn){
        if(btn.getId()==R.id.souce){
            Intent config = new Intent(this, source.class);
            startActivity(config);
        }
        else if(btn.getId()==R.id.plan){
            Intent config = new Intent(this, plan.class);
            startActivity(config);
        }
        else if(btn.getId()==R.id.money){
            Intent config = new Intent(this, zichan.class);
            startActivity(config);
        }
        else if(btn.getId()==R.id.back3){
            Intent config = new Intent(this, zhuyeActivity.class);
            startActivity(config);
        }
        else if(btn.getId()==R.id.dd){
            Date today= Calendar.getInstance().getTime();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd");
            today_sdr=sdf.format(today);
            if(!todaytime.equals(today_sdr)&&tag.equals("未打卡")){
                count=count+1;
                DBManger dbManager = new DBManger(this);
                dbManager.update(count,name);
                tag="已打卡";
                Log.i("g", ""+count+todaytime+today_sdr);
                Toast.makeText(this, "打卡成功", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "您已经打过卡了，请明天再来", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
