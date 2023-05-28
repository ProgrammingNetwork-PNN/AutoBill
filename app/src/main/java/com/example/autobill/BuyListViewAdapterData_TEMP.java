package com.example.autobill;

import java.sql.Blob;

public class BuyListViewAdapterData_TEMP {
    private int _id;
    private int _count;
    private String _name;
    private String _value;
    private Blob img;

    public void set_id(int _id){this._id = _id;}
    public void set_count(int _count){this._count = _count;}
    public void set_name(String _name){this._name = _name;}
    public void set_value(String _value){this._value = _value;}
    public void set_img(Blob img){this.img = img;}

    public int get_id(){return this._id;}
    public int get_count(){return this._count;}
    public String get_name(){return this._name;}
    public String get_value(){return this._value;}
    public Blob getImg(){return this.img;}
}
