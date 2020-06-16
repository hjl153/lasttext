package com.example.text;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class seezhangdan extends AppCompatActivity implements AdapterView.OnItemClickListener{
    TextView zhangdan;
    ListView plan4;
    private List<Map<String ,Object>> listItems;
    zadapter zadapter;
    String allmoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seezhangdan);
        zhangdan=findViewById(R.id.zhangdan);
        plan4=findViewById(R.id.planz);
        listItems= new ArrayList<Map<String, Object>>();
        listItems=getData();
        zadapter=new zadapter(this,R.layout.activity_seezhangdan,listItems);
        plan4.setAdapter(zadapter);
        plan4.setEmptyView(findViewById(R.id.nodata3));
        allmoney=getALLData();
        zhangdan.setText(allmoney);
        plan4.setOnItemClickListener(this);
    }
    public List<Map<String, Object>> getData() {
        DBManger dbManager = new DBManger(this);
        List<jizhangitem> Zestlist = dbManager.listAllZ();
        for(jizhangitem i:Zestlist){
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("id",i.getId());
            map.put("ItemDetail",i.getMname());
            map.put("ItemTime",i.getMdate());
            map.put("Itemleibie",i.getMleibie());
            map.put("Itemzhushi",i.getZhushi());
            if(i.getMtype()==0){
            map.put("ItemMoney",-i.getShuliang()*i.getMprice());}
            else if(i.getMtype()==1){
                map.put("ItemMoney",i.getShuliang()*i.getMprice());}
            listItems.add(map);}
        return listItems;}
    public String getALLData() {
        DBManger dbManager = new DBManger(this);
        List<jizhangitem> Zestlist = dbManager.listAllZ();
        Float J=0.0f,C=0.0f;
        for(jizhangitem i:Zestlist){
            if(i.getMtype()==0){
               C=i.getShuliang()*i.getMprice()+C;
            }
            else if(i.getMtype()==1){
                J=i.getShuliang()*i.getMprice()+J;
            }
            }
        String M=String.valueOf(J-C);
        SharedPreferences sp=getSharedPreferences("all", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("M",M);
        editor.commit();
        return M;}

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                Log.i("click","对话框处理");
                Map<String ,String> map= (Map<String, String>) plan4.getItemAtPosition(position);
                String titlestr=map.get("ItemDetail");
                String date=map.get("ItemTime");
                String m=String.valueOf(map.get("ItemMoney"));
                String z=map.get("Itemzhushi");
                String l=map.get("Itemleibie");
        Log.i("g", ""+m+z+l);
                Intent ratecal=new Intent(this,zhangdetail.class);
                ratecal.putExtra("title",titlestr);
                ratecal.putExtra("date",date);
                ratecal.putExtra("m",m);
                ratecal.putExtra("z",z);
                ratecal.putExtra("l",l);
                startActivity(ratecal);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fenglei,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.xm) {
            Intent config = new Intent(this, zhangfenglei.class);
            startActivityForResult(config,1);
        }
        return true;
    }


}
