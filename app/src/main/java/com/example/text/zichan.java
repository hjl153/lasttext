package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class zichan extends AppCompatActivity {
    TextView username,amoney,mmoney,lmoney;
    EditText amont;
    String name,Ni="0.0f",M="0.0f";
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
        SharedPreferences spp=getSharedPreferences("all", Activity.MODE_PRIVATE);
        M=spp.getString("M","");
        amoney.setText(M);
        SharedPreferences sp=getSharedPreferences("mymoney", Activity.MODE_PRIVATE);
        Ni=sp.getString("money","");
        Log.i("mmm", Ni);
        mmoney.setText(Ni);
        if(M.length()>0&&Ni.length()>0){
        Float x=Float.parseFloat(Ni)+Float.parseFloat(M);
        lmoney.setText(String.valueOf(x));}
        amont.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                SharedPreferences sp=getSharedPreferences("mymoney", Activity.MODE_PRIVATE);
                Ni=sp.getString("money","");
                Log.i("mmm", Ni);
                mmoney.setText(Ni);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mmoney.setText(amont.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
    }
    public void onClick(View btn){
        String money=amont.getText().toString();
        if(btn.getId()==R.id.button4){
            SharedPreferences sp=getSharedPreferences("mymoney", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("money",money);
            Log.i("g", money);
            editor.commit();
            Float a=Float.parseFloat(amont.getText().toString());
            lmoney.setText(String.valueOf(a+Float.parseFloat(M)));
        }
    }

}
