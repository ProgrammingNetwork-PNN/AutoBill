/*package com.example.autobill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MovieDatabase_CONFIRM extends AppCompatActivity {

   ListView listView;
    Button addMovieButton;

    dbHelper helper;
    SQLiteDatabase db;

    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.ListView);
        addMovieButton = findViewById(R.id.addMovieButton);

        helper = new dbHelper(this);
        db = helper.getReadableDatabase();

        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM movie",null);
        startManagingCursor(cursor);
        String[] from = {"_name"};
        int[] to = new int[]{R.id.item_name};

        adapter = new SimpleCursorAdapter(this, R.layout.name_list,cursor,from,to);
        listView.setAdapter(adapter);
        
        addMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DisplayMovie.class);
                intent.putExtra("MODE","Add");
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String _id;
                String _name;
                String _year;
                String _director;
                String _rate;
                String _country;
                Intent intent;

                if(position > 1){
                    for(int i=0;i<=position;i++){
                        cursor.moveToNext();
                    }
                }
                _id = cursor.getString(0);
                Log.d("TAG",_id+"");

                _name = cursor.getString(1);
                _year = cursor.getString(2);
                _director = cursor.getString(3);
                _rate = cursor.getString(4);
                _country = cursor.getString(5);

                intent = new Intent(getApplicationContext(),DisplayMovie.class);
                intent.putExtra("MODE","ITEM");
                intent.putExtra("_id",_id+"");
                intent.putExtra("_name",_name);
                intent.putExtra("_year",_year);
                intent.putExtra("_director",_director);
                intent.putExtra("_rate",_rate);
                intent.putExtra("_country",_country);

                startActivity(intent);
            }
        });
    }
}*/