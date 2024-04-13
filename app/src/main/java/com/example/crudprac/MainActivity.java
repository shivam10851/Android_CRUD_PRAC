package com.example.crudprac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.crudprac.adapter.RecyclerViewAdapter;
import com.example.crudprac.data.MyDbHandler;
import com.example.crudprac.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDbHandler db= new MyDbHandler(MainActivity.this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Contact shivam=new Contact();
        shivam.setName("Shivam");
        shivam.setPhoneNumber("9999988888");
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        db.addContact(shivam);
        contactArrayList=new ArrayList<>();

        List<Contact> allContacts=db.fetchContacts();
        for(Contact i:allContacts){
            Log.d("dbTable","id =" + i.getId()+"\n"+ "name ="+i.getName()+"\n"+"phoneNumber ="+i.getPhoneNumber());
            contactArrayList.add(i);
        }
        Log.d("dbTable", "you got "+db.getCount()+ " queries in records!!");
        recyclerViewAdapter=new RecyclerViewAdapter(MainActivity.this,contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}