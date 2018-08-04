package com.example.jalil.recycllioutasli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView  myRecycler ;
    List<Item> mItem = new ArrayList<>() ;
    ItemAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecycler =(RecyclerView) findViewById(R.id.recycler_view);
         mAdapter = new ItemAdapter(mItem, this);

        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
     //  RecyclerView.LayoutManager gLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false);
       RecyclerView.LayoutManager gLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        myRecycler.setLayoutManager(gLayoutManager);

//        RecyclerView.ItemDecoration iDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        myRecycler.addItemDecoration(iDecoration);

        myRecycler.setItemAnimator(new DefaultItemAnimator());

        myRecycler.setHasFixedSize(true);

        myRecycler.setAdapter(mAdapter);

        setData();


    }
    private void setData() {
        mItem.add(new Item(R.drawable.avatar_1, "SeyedMahdi", "سلام. بریم آبگرم فردوس؟", "12:14"));
        mItem.add(new Item(R.drawable.avatar_2, "Ahmad", "فایلا رو دانلود کردی؟", "11:41"));
        mItem.add(new Item(R.drawable.avatar_3, "Morteza", "شرمنده امروز نمیرسم بیام", "11:38"));
        mItem.add(new Item(R.drawable.avatar_4, "Farhad", "اوکی. ممنون", "11:32"));
        mItem.add(new Item(R.drawable.avatar_1, "SeyedMahdi", "سلام. بریم آبگرم فردوس؟", "12:14"));
        mItem.add(new Item(R.drawable.avatar_2, "Ahmad", "فایلا رو دانلود کردی؟", "11:41"));
        mItem.add(new Item(R.drawable.avatar_3, "Morteza", "شرمنده امروز نمیرسم بیام", "11:38"));
        mItem.add(new Item(R.drawable.avatar_4, "Farhad", "اوکی. ممنون", "11:32"));
        mItem.add(new Item(R.drawable.avatar_1, "SeyedMahdi", "سلام. بریم آبگرم فردوس؟", "12:14"));
        mItem.add(new Item(R.drawable.avatar_2, "Ahmad", "فایلا رو دانلود کردی؟", "11:41"));
        mItem.add(new Item(R.drawable.avatar_3, "Morteza", "شرمنده امروز نمیرسم بیام", "11:38"));
        mItem.add(new Item(R.drawable.avatar_4, "Farhad", "اوکی. ممنون", "11:32"));

        mAdapter.notifyDataSetChanged();
    }

}
