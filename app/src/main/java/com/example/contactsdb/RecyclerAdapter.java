package com.example.contactsdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ContactViewHolder> {

    ArrayList<Contact> contacts ;
    public RecyclerAdapter(ArrayList<Contact> contacts){
        this.contacts = contacts ;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contact,null,false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact c = contacts.get(position);
    holder.tv_name.setText(c.getName());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public  class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name ;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }}
