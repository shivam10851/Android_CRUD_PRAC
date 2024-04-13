package com.example.crudprac.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.tv.interactive.TvInteractiveAppView;
import android.util.Log;

import com.example.crudprac.model.Contact;
import com.example.crudprac.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context) {
        //null=> default configuration
         super(context, Params.DB_NAME, null, Params.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="CREATE TABLE " + Params.TABLE_NAME  +
                "(" + Params.KEY_ID + " INTEGER PRIMARY KEY," +
                Params.KEY_NAME + " TEXT," +
                Params.KEY_PHONE + " TEXT" + ")";
        Log.d("dbTable",  "table is created");
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public void addContact(Contact contact){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.KEY_NAME,contact.getName());
        values.put(Params.KEY_PHONE,contact.getPhoneNumber());
        db.insert(Params.TABLE_NAME,null,values);
        Log.d("dbTable", contact.getName()+" named Contact added");
        db.close();
    }
    public List<Contact> fetchContacts(){
        List<Contact> allContacts= new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String simpleQuery="SELECT * FROM "+ Params.TABLE_NAME;
        Cursor cursor=db.rawQuery(simpleQuery,null);
        if(cursor.moveToFirst()){
            do{
                Contact contact=new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                allContacts.add(contact);
            }while(cursor.moveToNext());
        }
        return allContacts;
    }
    public int updateContact(Contact contact){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Params.KEY_NAME,contact.getName());
        values.put(Params.KEY_PHONE,contact.getPhoneNumber());
        return db.update(Params.TABLE_NAME,values,Params.KEY_ID+"=?",new String[]{String.valueOf(contact.getId())});
    }
    public void deleteContact(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Params.TABLE_NAME,Params.KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public int getCount(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM " +Params.TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        return cursor.getCount(); 
    }
}
