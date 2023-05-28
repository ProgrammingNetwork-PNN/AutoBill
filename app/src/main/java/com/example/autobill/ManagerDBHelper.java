package com.example.autobill;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ManagerDBHelper extends SQLiteOpenHelper {

    String[] _name = {"가글","가위","라이터","믹스 커피","캔음료","치약","머그컵","키보드","헤드폰","공","페트병","우산"};
    String[] _price = {"2500","1200","800","10000","1200","2000","3500","28000","30000","10000","3000","5000"};

    private static final String DATABASE_NAME = "Manager.db";
    private static final int DATABASE_VERSION = 2;

    public ManagerDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("TAG","ManagerDBHelper onCreate");
        db.execSQL("CREATE TABLE manager_item(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "_name TEXT,"
                + "_price TEXT,"
                + "_count TEXT)");

        for (int i = 0; i < _name.length; i++) {
            ContentValues values = new ContentValues();
            values.put("_id",i);
            values.put("_name", _name[i]);
            values.put("_price", _price[i]);
            values.put("_count",0);

            db.insert("manager_item", null, values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS captured_item");
        onCreate(db);
    }
}
