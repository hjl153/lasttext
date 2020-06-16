package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class zhangdetail extends AppCompatActivity {
     TextView zname,date,m,z,l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhangdetail);
        String Title=getIntent().getStringExtra("title");
        String Date=getIntent().getStringExtra("date");
        String M=getIntent().getStringExtra("m");
        String Z=getIntent().getStringExtra("z");
        String L=getIntent().getStringExtra("l");
        zname=findViewById(R.id.zname);
        date=findViewById(R.id.date);
        m=findViewById(R.id.m);
        z=findViewById(R.id.z);
        l=findViewById(R.id.l);
        zname.setText(Title);
        date.setText("时间:"+Date);
        m.setText("金额:"+M);
        z.setText("备注:"+Z);
        l.setText("类别:"+L);
    }
}
