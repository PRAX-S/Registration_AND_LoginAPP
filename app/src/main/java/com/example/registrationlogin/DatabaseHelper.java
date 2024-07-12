package com.example.registrationlogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "LoginApp.db";
     public static final int DATABASE_VERSION = 1;
     public static final String TABLE_NAME = "users";
     public static final String COLUMN_ID = "id";
     public static final String COLUMN_USERNAME="username";
     public static final String COLUMN_EMAIL ="email";
     public static final String COLUMN_PASSWORD = "password";


     private static final String TABLE_CREATE =
             "CREATE TABLE " + TABLE_NAME + " (" +
                     COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     COLUMN_USERNAME + " TEXT, " +
                     COLUMN_EMAIL + " TEXT,"+
                     COLUMN_PASSWORD + " TEXT); " ;

     DatabaseHelper(Context context){
         super(context,DATABASE_NAME,null,DATABASE_VERSION);
     }


     @Override
     public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE);
     }

     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME );
         onCreate(db);

     }
 }
