package com.example.text;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String  DB_NAME="user.db";
    public static final String  JTB_NAME="jihua_name";
    public static final String TB_NAME="tb_name";
    public static final String  BTB_NAME="beiwanglu_name";
    public static final String MTB_NAME="jizhang_name";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }
    public DBHelper(Context context){
        super(context,DB_NAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TB_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT,PASSWORD TEXT)");
        db.execSQL("CREATE TABLE "+JTB_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,JDATE TEXT,JCONTEXT TEXT,JLEIBIE INTEGER)");
        db.execSQL("CREATE TABLE "+BTB_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,BDATE TEXT,BCONTEXT TEXT)");
        db.execSQL("CREATE TABLE "+MTB_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,MNAME TEXT,MDATE TEXT,MPRICE FLOAT,SHULIANG INTEGER,MLEIBIE TEXT,ZHUSHI,TEXT,MTYPE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
