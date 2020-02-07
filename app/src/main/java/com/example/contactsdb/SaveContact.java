package com.example.contactsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SaveContact extends AppCompatActivity {
  // TextView tv_addContact ;
   EditText et_name , et_saving_to ,et_phone;
   ImageView img_arrow,img_check ;
   Context context ;
   MyDatabase db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_contact);
       // tv_addContact = (TextView)findViewById(R.id.et_savingTo);
        et_name = (EditText)findViewById(R.id.et_name);
        et_phone =(EditText)findViewById(R.id.et_phone);
        et_saving_to = (EditText)findViewById(R.id.et_savingTo);
        img_arrow = (ImageView)findViewById(R.id.img_arrow);
        img_check = (ImageView)findViewById(R.id.img_check);
        db = new MyDatabase(this);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SaveContact.this,MainActivity.class);
                startActivity(i);
            }
        });
        img_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String phone = et_phone.getText().toString();
                String type = et_saving_to.getText().toString();
                Contact c = new Contact(type, name,phone);
                db.insertContact(c);
                startActivity(new Intent(SaveContact.this,MainActivity.class));
            } }); }}

//    ArrayList<Contact> contacts = new ArrayList<>();
// contacts.add(c);