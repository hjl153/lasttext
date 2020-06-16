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
        values.put("COUNT", item.getCount());
        db.insert(TBNAME, null, values);
        db.close();
    }
    public void addJ(jihuaitem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("JDATE", item.getJdate());
        values.put("JCONTEXT", item.getJcontext());
        values.put("JLEIBIE", item.getJleibie());
        values.put("JZHUANGTAI", item.getJzhuangtai());
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
        values.put("ZHUSHI", item.getZhushi());
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

    public void update(int item,String name){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Count", item);
        db.update(TBNAME, values, "Username=?", new String[]{String.valueOf(name)});
        db.close();
    }
    public void updateJ(int ite,String name){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Jzhuangtai", ite);
        db.update(JTB_NAME, values, "Jcontext=?", new String[]{String.valueOf(name)});
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
                item.setJzhuangtai(cursor.getInt(cursor.getColumnIndex("JZHUANGTAI")));
                JList.add(item);
            }
            cursor.close();
        }
        db.close();
        return JList;

    }
    public List<jihuaitem> listAllJSear(int i){
        List<jihuaitem> JList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(JTB_NAME,null, "JLEIBIE=?", new String[]{String.valueOf(i)}, null, null, null, null);
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
    public List<jizhangitem> listAllZ(){
        List<jizhangitem> ZList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(MTB_NAME, null, null, null, null, null, null);
        if(cursor!=null){
            ZList = new ArrayList<jizhangitem>();
            while(cursor.moveToNext()){
                jizhangitem item = new jizhangitem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setMname(cursor.getString(cursor.getColumnIndex("MNAME")));
                item.setMdate(cursor.getString(cursor.getColumnIndex("MDATE")));
                item.setMleibie(cursor.getString(cursor.getColumnIndex("MLEIBIE")));
                item.setZhushi(cursor.getString(cursor.getColumnIndex("ZHUSHI")));
                item.setMtype(cursor.getInt(cursor.getColumnIndex("MTYPE")));
                item.setShuliang(cursor.getInt(cursor.getColumnIndex("SHULIANG")));
                item.setMprice(cursor.getFloat(cursor.getColumnIndex("MPRICE")));
                ZList.add(item);
            }
            cursor.close();
        }
        db.close();
        return ZList;

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
    public int findCount(String name){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, "username=?", new String[]{String.valueOf(name)}, null, null, null);
        int X1=0;
        if(cursor!=null && cursor.moveToFirst()){
            X1=cursor.getInt(cursor.getColumnIndex("COUNT"));
            cursor.close();
        }
        db.close();
        return X1;
    }
}

