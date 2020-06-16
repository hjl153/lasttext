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

public class source extends AppCompatActivity {
    TextView yonghu,nicheng;
    EditText chni;
    String name,Ni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source);
        yonghu=findViewById(R.id.username);
        nicheng=findViewById(R.id.nichg);
        chni=findViewById(R.id.chni);
        SharedPreferences Sp=getSharedPreferences("myname", Activity.MODE_PRIVATE);
        name=Sp.getString("name","");
        yonghu.setText(name);
        SharedPreferences sp=getSharedPreferences("nichen", Activity.MODE_PRIVATE);
        Ni=sp.getString("niChen","");
        nicheng.setText(Ni);
        chni.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                SharedPreferences sp=getSharedPreferences("nichen", Activity.MODE_PRIVATE);
                Ni=sp.getString("niChen","");
                nicheng.setText(Ni);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                nicheng.setText(chni.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    public void onClick(View btn){
        String NI=chni.getText().toString();
        if(btn.getId()==R.id.button4){
            SharedPreferences sp=getSharedPreferences("nichen", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("niChen",NI);
            editor.commit();

        }
    }

}
