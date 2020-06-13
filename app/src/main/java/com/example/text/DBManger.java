package com.example.text;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManger {

    private DBHelper dbHelper;
    private  String TBNAME;
    public   String  JTB_NAME;
    public   String  BTB_NAME;
    public   String MTB_NAME;

    public DBManger(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME;
        JTB_NAME = DBHelper.JTB_NAME;
        BTB_NAME = DBHelper.BTB_NAME;
        MTB_NAME = DBHelper.MTB_NAME;
    }

    public void add(Useritem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("UserName", item.getUserName());
        values.put("Password", item.getPassword());
        db.insert(TBNAME, null, values);
        db.close();
    }
    public void addJ(jihuaitem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("JDATE", item.getJdate());
        values.put("JCONTEXT", item.getJcontext());
        values.put("JLEIBIE", item.getJleibie());
        db.insert(JTB_NAME, null, values);
        db.close();
    }
    public void addB(beiwangluitem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("BDATE", item.getBdate());
        values.put("BCONTEXT", item.getBcontext());
        db.insert(BTB_NAME, null, values);
        db.close();
    }
    public void addC(jizhangitem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MNAME", item.getMname());
        values.put("MDATE", item.getMdate());
        values.put("MPRICE", item.getMprice());
        values.put("SHULIANG", item.getShuliang());
        values.put("MLEIBIE", item.getMleibie());
        values.put("ZHUSHI", item.getZhushui());
        values.put("MTYPE", item.getMtype());
        db.insert(MTB_NAME, null, values);
        db.close();
    }
    public void addAll(List<Useritem> list){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        for (Useritem item : list) {
            ContentValues values = new ContentValues();
            values.put("UserName", item.getUserName());
            values.put("Password", item.getPassword());
            db.insert(TBNAME, null, values);
        }
        db.close();
    }

    public void deleteAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME, "ID=?", new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteB(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(BTB_NAME, "id=?", new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteJ(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(JTB_NAME, "id=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void update(Useritem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("UserName", item.getUserName());
        values.put("Passsword", item.getPassword());
        db.update(TBNAME, values, "ID=?", new String[]{String.valueOf(item.getId())});
        db.close();
    }

    public List<Useritem> listAll(){
        List<Useritem> rateList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        if(cursor!=null){
            rateList = new ArrayList<Useritem>();
            while(cursor.moveToNext()){
                Useritem item = new Useritem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setUserName(cursor.getString(cursor.getColumnIndex("USERNAME")));
                item.setPassword(cursor.getString(cursor.getColumnIndex("PASSWORD")));

                rateList.add(item);
            }
            cursor.close();
        }
        db.close();
        return rateList;

    }
    public List<beiwangluitem> listAllB(){
        List<beiwangluitem> BList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(BTB_NAME, null, null, null, null, null, null);
        if(cursor!=null){
            BList = new ArrayList<beiwangluitem>();
            while(cursor.moveToNext()){
                beiwangluitem item = new beiwangluitem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setBcontext(cursor.getString(cursor.getColumnIndex("BCONTEXT")));
                item.setBdate(cursor.getString(cursor.getColumnIndex("BDATE")));
                BList.add(item);
            }
            cursor.close();
        }
        db.close();
        return BList;

    }
    public List<jihuaitem> listAllJ(){
        List<jihuaitem> JList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(JTB_NAME, null, null, null, null, null, null);
        if(cursor!=null){
            JList = new ArrayList<jihuaitem>();
            while(cursor.moveToNext()){
                jihuaitem item = new jihuaitem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setJdate(cursor.getString(cursor.getColumnIndex("JDATE")));
                item.setJcontext(cursor.getString(cursor.getColumnIndex("JCONTEXT")));
                item.setJleibie(cursor.getInt(cursor.getColumnIndex("JLEIBIE")));
                JList.add(item);
            }
            cursor.close();
        }
        db.close();
        return JList;

    }
    public List<jihuaitem> listAllJSear(int i,String date){
        List<jihuaitem> JList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(JTB_NAME,null, "JLEIBIE=? and JDATE=?", new String[]{String.valueOf(i),String.valueOf(date)}, null, null, null, null);
        if(cursor!=null){
            JList = new ArrayList<jihuaitem>();
            while(cursor.moveToNext()){
                jihuaitem item = new jihuaitem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setJcontext(cursor.getString(cursor.getColumnIndex("JCONTEXT")));
                JList.add(item);
            }
            cursor.close();
        }
        db.close();
        return JList;

    }
    public Boolean findById(String name,String password){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, "username=?", new String[]{String.valueOf(name)}, null, null, null);
        String X1="";
        if(cursor!=null && cursor.moveToFirst()){
            X1=cursor.getString(cursor.getColumnIndex("PASSWORD"));
            cursor.close();
        }
        db.close();
        if(X1.equals(password)){
            return true;}
        return false;
    }
}

