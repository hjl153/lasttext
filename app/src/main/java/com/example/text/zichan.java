package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class zichan extends AppCompatActivity {
    TextView username,amoney,mmoney,lmoney;
    EditText amont;
    String name,Ni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zichan);
        username=findViewById(R.id.username);
        amoney=findViewById(R.id.allmoney);
        mmoney=findViewById(R.id.monthmoney);
        lmoney=findViewById(R.id.lastmoney);
        amont=findViewById(R.id.amont);
        SharedPreferences SP=getSharedPreferences("myname", Activity.MODE_PRIVATE);
        name=SP.getString("name","");
        username.setText(name);
        SharedPreferences sp=getSharedPreferences("mymoney", Activity.MODE_PRIVATE);
        Ni=sp.getString("money","");
        Log.i("mmm", Ni);
        mmoney.setText(Ni);
    }
    public void onClick(View btn){
        String money=amont.getText().toString();
        if(btn.getId()==R.id.button4){
            SharedPreferences sp=getSharedPreferences("mymoney", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("money",money+"元");
            Log.i("g", money);
            editor.commit();
        }
    }

}
