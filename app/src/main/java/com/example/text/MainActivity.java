package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.name);
        password=findViewById(R.id.zpassword);

    }
    public void onClick(View btn){
        String Name=username.getText().toString();
        String Password=password.getText().toString();
        SharedPreferences sp=getSharedPreferences("myname", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("name",Name);
        editor.commit();
        Log.i("TAG",Name+Password);
        if(btn.getId()==R.id.enter) {
            if (Name.length() <= 0) {
                Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            } else if (Password.length() <= 0) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            } else {
                DBManger dbManager = new DBManger(MainActivity.this);
                if (dbManager.findById(Name, Password)) {
                    Intent config = new Intent(this, zhuyeActivity.class);
                    startActivity(config);
                    finish();
                } else {
                    Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(btn.getId()==R.id.Login){
            Intent config = new Intent(this,login.class);
            startActivity(config);
        }
    }
}
