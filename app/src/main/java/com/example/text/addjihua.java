package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

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
    String today_sdr,Learn=null,Life=null;
    int type=0;
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
        if(btn.getId()==R.id.tijiao) {
            if (Beizhu.length() <= 0) {
                Toast.makeText(this, "请输入计划内容", Toast.LENGTH_SHORT).show();
            }
            else {
                plan1 = (RadioGroup) findViewById(R.id.plan1);

                plan1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int id = group.getCheckedRadioButtonId();
                        RadioButton choise = (RadioButton) findViewById(id);
                        String output = choise.getText().toString();
                        if (output.equals("lifeplan")) {
                            type = 0;
                            Log.i("tag", "写入据完毕");

                        } else if(output.equals("learnplan")){
                            type = 1;
                            Log.i("tag", "写入数完毕");

                        }
                        }		});
                DBManger dbManager = new DBManger(addjihua.this);
                jihuaitem jhua=new jihuaitem(today_sdr,Beizhu,type);
                dbManager.addJ(jhua);
                Toast.makeText(this, "提交完成", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
