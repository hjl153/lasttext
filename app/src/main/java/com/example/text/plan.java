package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class plan extends AppCompatActivity {
    TextView plan,daka;
    String count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        plan=findViewById(R.id.plan);
        daka=findViewById(R.id.daka);
        SharedPreferences sp=getSharedPreferences("ddda", Activity.MODE_PRIVATE);
        count= String.valueOf(sp.getInt("count",0));
        daka.setText("共打卡"+count+"天");
    }
}
