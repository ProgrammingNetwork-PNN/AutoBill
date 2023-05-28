package com.example.autobill;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {
    ManagerDBHelper helper;
    SQLiteDatabase db;
    Button btn_back;
    SimpleCursorAdapter adapter;

    ListView history;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        btn_back = findViewById(R.id.btn_backTitle);
        history = findViewById(R.id.listView_History);
        helper = new ManagerDBHelper(this);
        db = helper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM manager_item",null);
        startManagingCursor(cursor);
        String[] from = {"_name","_price","_count"};
        int[] to = new int[]{R.id.tv_historyId,R.id.tv_historyValue,R.id.tv_historyCount};
        adapter = new SimpleCursorAdapter(this, R.layout.activity_history_item,cursor,from,to);
        history.setAdapter(adapter);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}