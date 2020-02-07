package com.example.contactsdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   FloatingActionButton btn_floating ;
    ArrayList<Contact> contacts  ;
    RecyclerView rv_contacts ;
 MyDatabase db ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_floating = (FloatingActionButton) findViewById(R.id.btn_floating);
        rv_contacts = (RecyclerView)findViewById(R.id.rv_contacts);
        contacts = new ArrayList<>();
        db = new MyDatabase(this);
        contacts = db.getContacts();
        btn_floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this ,SaveContact.class);
                startActivity(i);
            }
        });
     RecyclerAdapter adapter = new RecyclerAdapter(contacts);
       rv_contacts.setAdapter(adapter);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv_contacts.setLayoutManager(lm);
    }
    }
