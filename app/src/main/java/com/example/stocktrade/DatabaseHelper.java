package com.example.stocktrade;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_name = "stocktrade.db";
    public static final String Table_name = "stocklist_table";
    public static final String col1 = "Id";
    public static final String col2 = "Name";
    public static final String col3="Details";
    public static final String col4 = "Ltp";
    public static final String col5 = "Changeper";
    public static final String col6 = "Changeprice";
    public static final String col7 = "Qty";
    public static final String col8 = "Price";

    public DatabaseHelper(@Nullable Context context) {
        super(context, Database_name, null, 1);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+Table_name+"(Id INTEGER PRIMARY KEY AUTOINCREMENT ,Name TEXT,Details Text,Ltp TEXT,Changeper TEXT,Changeprice TEXT,Qty TEXT,Price TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+Table_name);
        onCreate(db);
    }
    public boolean insertData(String Name,String Details,String Ltp,String Changeper,String Changeprice,String Qty,String Price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,Name);
        contentValues.put(col3,Details);
        contentValues.put(col4,Ltp);
        contentValues.put(col5,Changeper);
        contentValues.put(col6,Changeprice);
        contentValues.put(col7,Qty);
        contentValues.put(col8,Price);

        long result=db.insert(Table_name,null,contentValues);
        if (result==-1){
            return false;
        }
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("Select * from "+Table_name,null);
        return res;
    }
}
