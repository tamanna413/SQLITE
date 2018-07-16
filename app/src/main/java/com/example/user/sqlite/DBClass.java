package com.example.user.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBclass extends SQLiteOpenHelper {

    public  static  final String DATABASE_NAME ="student";
    public  static  final int DATABASE_VERSION= 1;

    public DBclass(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE USER(mail text,password text,Type text)");

    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(db);
    }
    public boolean onAddData(String mail,String password,String types){
        SQLiteDatabase db =getWritableDatabase();

        ContentValues contentValues =new ContentValues();
        contentValues.put("mail",mail);
        contentValues.put("password",password);
//        contentValues.put("number",number);
        contentValues.put("Types",types);

        long status = db.insert("user",null,contentValues);
        contentValues.clear();
        return (status >-1);
    }

    public Cursor getData(){
        SQLiteDatabase db =getReadableDatabase();

        Cursor cursor =db.query("user",null,null,null,null,null,null);
        return cursor;
    }
    //   delete
    public  void onDelete(String mail) {
        SQLiteDatabase db = getWritableDatabase();




        String[] arr = null;
        arr[0] = mail;
        db.delete("user", "mail=", arr);
    }

    //          Update
    void onUpdate (String mail){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("mail",mail);


        String arr[]={"",""};
        arr[0]=mail;
        db.update("user",contentValues,"mail=?",arr);

    }



}