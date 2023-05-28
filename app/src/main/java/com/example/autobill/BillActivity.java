package com.example.autobill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class BillActivity extends AppCompatActivity {
    ListView buyList;

    Button back;
    Button bill;

    dbHelper helper;
    SQLiteDatabase db;

    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        buyList = findViewById(R.id.List_BuyList);
        back = findViewById(R.id.btn_backCamera);
        bill = findViewById(R.id.btn_goBill);

        helper = new dbHelper(this);
        db = helper.getWritableDatabase();

        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM captured_item",null);
        startManagingCursor(cursor);
        String[] from = {"_img","_name","_value","count"};
        int[] to = new int[]{R.id.img_buyImage,R.id.item_buyName,R.id.item_buyValue,R.id.editTextText};

        adapter = new SimpleCursorAdapter(this, R.layout.activity_bill,cursor,from,to);
        buyList.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(getApplicationContext(), PaymentActivity.class);
                startActivity(paymentIntent);
            }
        });
    }
}