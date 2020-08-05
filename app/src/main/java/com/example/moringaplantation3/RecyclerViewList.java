package com.example.moringaplantation3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewList extends AppCompatActivity {
   public static Activity ListAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_list);
        ListAct = RecyclerViewList.this;
        RecyclerView rv = findViewById(R.id.recView);
        rv.setLayoutManager(new LinearLayoutManager(RecyclerViewList.this));
       DatabaseSQLite db = new DatabaseSQLite(RecyclerViewList.this);
        ArrayList<GetterSetter>persons = db.select1();
        rv.setAdapter(new RecyclerViewAdapter(RecyclerViewList.this,persons));
    }
}