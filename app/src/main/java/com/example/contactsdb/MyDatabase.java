package com.example.contactsdb;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "contact";
    public static final String Contact_TB_NAME = "contacts";
    public static final String Contact_CLN_NAME = "Name";
    public static final String Contact_CLN_PHONE = "Phone";
    public static final String Contact_CLN_Type = "Type";
    public static final int DB_VERSION = 1 ;

    public MyDatabase(Context context){
          super(context,DB_NAME,null,DB_VERSION);
      }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Contact_TB_NAME + "( " + Contact_CLN_NAME + " TEXT , " + Contact_CLN_PHONE
        + " TEXT , " + Contact_CLN_Type + " TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS " + Contact_TB_NAME);
        onCreate(db);
    }
    public boolean insertContact(Contact c){
      SQLiteDatabase db = getWritableDatabase();
      ContentValues values = new ContentValues();
      values.put(Contact_CLN_NAME,c.getName());
      values.put(Contact_CLN_PHONE,c.getPhone());
      values.put(Contact_CLN_Type,c.getType());
     long result =  db.insert(Contact_TB_NAME,null,values);
        return result != -1 ;
    }
    public ArrayList<Contact> getContacts(){
        ArrayList<Contact> contacts = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
      Cursor cursor = db.rawQuery(" SELECT * FROM " + Contact_TB_NAME , null);
      if(cursor.moveToFirst()){
          do {
              String name = cursor.getString(cursor.getColumnIndex(Contact_CLN_NAME));
              String phone = cursor.getString(cursor.getColumnIndex(Contact_CLN_PHONE));
              String type = cursor.getString(cursor.getColumnIndex(Contact_CLN_Type));
              Contact c = new Contact(type,name,phone);
              contacts.add(c);
          }while (cursor.moveToNext());
          cursor.close();
          }
        return contacts;
    }
    }
