package com.example.autobill;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Buy.db";
    private static final int DATABASE_VERSION = 2;

    public dbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        Log.d("TAG","Database onCreate");
        db.execSQL("CREATE TABLE captured_item(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "_name TEXT,"
                + "_value TEXT,"
                + "_count TEXT,"
                + "img BLOB)");
        //testing dump
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS captured_item");
        onCreate(db);
    }
}
