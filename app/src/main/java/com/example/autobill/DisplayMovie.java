/*package com.example.autobill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DisplayMovie extends AppCompatActivity {
    EditText name_Edit;
    EditText year_Edit;
    EditText director_Edit;
    EditText rate_Edit;
    EditText country_Edit;

    Button saveButton;
    Button updateButton;
    Button deleteButton;

    String _id;
    String _name;
    String _year;
    String _director;
    String _rate;
    String _country;

    dbHelper helper;
    SQLiteDatabase db;
    Intent intent;
    String MODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movie);

        helper = new dbHelper(this);
        db = helper.getWritableDatabase();

        name_Edit = findViewById(R.id.nameEdit);
        year_Edit = findViewById(R.id.yearEdit);
        director_Edit = findViewById(R.id.directorEdit);
        rate_Edit = findViewById(R.id.rateEdit);
        country_Edit = findViewById(R.id.countryEdit);

        saveButton = findViewById(R.id.saveButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        intent = getIntent();
        MODE = intent.getStringExtra("MODE");
        if(MODE.equals("ITEM")){
            _id = intent.getStringExtra("_id");
            _name = intent.getStringExtra("_name");
            _year = intent.getStringExtra("_year");
            _director = intent.getStringExtra("_director");
            _rate = intent.getStringExtra("_rate");
            _country = intent.getStringExtra("_country");
            name_Edit.setText(_name);
            year_Edit.setText(_year);
            director_Edit.setText(_director);
            rate_Edit.setText(_rate);
            country_Edit.setText(_country);
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _name = name_Edit.getText().toString();
                _year = year_Edit.getText().toString();
                _director = director_Edit.getText().toString();
                _rate = rate_Edit.getText().toString();
                _country = country_Edit.getText().toString();
                db.execSQL("INSERT INTO movie VALUES ("+null+", '"+_name+"', '"+ _year+"', '"+_director+"', '"+_rate+"', '"+_country+"');");
                finish();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _name = name_Edit.getText().toString();
                _year = year_Edit.getText().toString();
                _director = director_Edit.getText().toString();
                _rate = rate_Edit.getText().toString();
                _country = country_Edit.getText().toString();
                db.execSQL("UPDATE movie" +
                        " SET " +
                        "_name ='"+ _name +"', " +
                        "_year ='"+ _year +"', " +
                        "_director ='"+ _director+"', " +
                        "_rate = '"+_rate+"', " +
                        "_country ='"+ _country+"'"+
                        " WHERE _id ="+ _id);
                Log.d("UPDATE","_ID is updated : "+_id );
                finish();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("DELETE FROM movie WHERE _id = " + _id);
                Log.d("DELETE", "_ID is deleted: " + _id);
                finish();
            }
        });
    }
}*/