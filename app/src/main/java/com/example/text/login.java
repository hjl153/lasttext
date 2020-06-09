package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText zhucename;
    EditText zpassword;
    EditText agpassword;
    String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        zhucename=findViewById(R.id.name);
        zpassword=findViewById(R.id.zpassword);
        agpassword=findViewById(R.id.agpassword);
    }
    public void onClick(View btn){
        String Name=zhucename.getText().toString();
        String Password=zpassword.getText().toString();
        String agPassword=agpassword.getText().toString();
        Log.i("TAG",Name+Password);
        if(btn.getId()==R.id.Login) {
            if (Name.length() <= 0) {
                Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            } else if (Password.length() <= 0) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            } else if(agPassword.length() <= 0){
                Toast.makeText(this, "请确认密码", Toast.LENGTH_SHORT).show();
            }
            else {
                DBManger dbManager = new DBManger(login.this);
                if (dbManager.findById(Name, Password)) {
                    Toast.makeText(this, "用户名被占用", Toast.LENGTH_SHORT).show();
                }
                else if(!Password.equals(agPassword)){
                    Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
                }
                else{
                    dbManager.add(new Useritem(Name,Password));
                    Log.i(TAG, "写入数据完毕" );
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
