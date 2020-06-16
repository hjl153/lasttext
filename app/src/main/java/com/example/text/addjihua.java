package com.example.text;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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

public class addjihua extends AppCompatActivity {
    EditText beizhu;
    RadioGroup plan1;
    String today_sdr;
    int type,zhuangtai=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addjihua);
        beizhu=findViewById(R.id.beizhu2);
        Date today= Calendar.getInstance().getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd");
        today_sdr=sdf.format(today);
    }

    public void onClick(View btn){
        String Beizhu=beizhu.getText().toString();
        if(btn.getId()==R.id.back4) {
            Intent intent=new Intent(addjihua.this,zhuyeActivity.class);
            intent.putExtra("id",1);
            startActivityForResult(intent,0);
            finish();
        }
        if(btn.getId()==R.id.tijiao) {
            if (Beizhu.length() <= 0) {
                Toast.makeText(this, "请输入计划内容", Toast.LENGTH_SHORT).show();
            }
            else {
                plan1 = (RadioGroup) findViewById(R.id.plan1);
                Log.i("tag", "写入据完毕");
                for(int i = 0 ;i < plan1.getChildCount();i++){
                    Log.i("tag", "完毕");
                    RadioButton rb = (RadioButton)plan1.getChildAt(i);
                    String output;
                    if(rb.isChecked()){
                        output = rb.getText().toString();
                        Log.i("tag", output);
                        if (output.equals("生活计划")) {
                            type = 1;
                            Log.i("tag", +type+"写入据完毕");
                        } else if(output.equals("学习计划")){
                            type = 0;
                            Log.i("tag", +type+"写入数完毕");
                        }

                DBManger dbManager = new DBManger(addjihua.this);
                jihuaitem jhua=new jihuaitem(today_sdr,Beizhu,type,zhuangtai);
                dbManager.addJ(jhua);
                Log.i("tag", today_sdr);
                        Log.i("tag", ""+zhuangtai);
                Log.i("tag", Beizhu);
                    Log.i("tag", +type+"");
                Toast.makeText(this, "提交完成", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(addjihua.this,zhuyeActivity.class);
                        intent.putExtra("id",1);
                        startActivityForResult(intent,0);
                    finish();}
            }

        }
    }}}

