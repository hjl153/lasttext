package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class addbeiwanglu extends AppCompatActivity {

    EditText beizhu2, year, month, day;
    int type = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbeiwanglu);
        beizhu2 = findViewById(R.id.beizhu1);
        year = findViewById(R.id.year);
        month = findViewById(R.id.month);
        day = findViewById(R.id.day);
    }

    public void onClick(View btn) {
        String Beizhu = beizhu2.getText().toString();
        String Year = year.getText().toString();
        String Month = month.getText().toString();
        String Day = day.getText().toString();
        if (btn.getId() == R.id.back5) {
            Intent intent=new Intent(addbeiwanglu.this,zhuyeActivity.class);
            intent.putExtra("id",2);
            startActivityForResult(intent,0);
            finish();
        }
        if (btn.getId() == R.id.tijiao) {
            if (Beizhu.length() <= 0) {
                Toast.makeText(this, "请输入计划内容", Toast.LENGTH_SHORT).show();
            } else if (Year.length() <= 0 && Month.length() <= 0 && Day.length() <= 0) {
                Toast.makeText(this, "请输入日期", Toast.LENGTH_SHORT).show();
            }
            else{
            DBManger dbManager = new DBManger(addbeiwanglu.this);
            if(Integer.parseInt(Month)<10){
                Month="0"+Month;
            }
                if(Integer.parseInt(Day)<10){
                    Day="0"+Day;
                }

            beiwangluitem Bhua = new beiwangluitem(Year+"_"+Month+"_"+Day,Beizhu);
            dbManager.addB(Bhua);
            Toast.makeText(this, "提交完成", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(addbeiwanglu.this,zhuyeActivity.class);
                intent.putExtra("id",2);
                startActivityForResult(intent,0);
            finish();}
        }

    }
}


