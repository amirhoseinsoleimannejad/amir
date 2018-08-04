package com.example.jalil.recycleview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<Integer> viewColors = new ArrayList<>();
        viewColors.add(Color.BLUE);
        viewColors.add(Color.YELLOW);
        viewColors.add(Color.MAGENTA);
        viewColors.add(Color.RED);
        viewColors.add(Color.BLACK);

        ArrayList<Item> items = new ArrayList<Item>();

        Item i=new Item(R.drawable.ic_launcher_background,"Name","Massege","jalilsoroor");
//        animalNames.add("Horse");
//        animalNames.add("Cow");
//        animalNames.add("Camel");
//        animalNames.add("Sheep");
//        animalNames.add("Goat");
        // set up the RecyclerView
        items.add(i);
        items.add(i);
        items.add(i);
        items.add(i);
        items.add(i);
        items.add(i);
        items.add(i);
        items.add(i);



        RecyclerView recyclerView = findViewById(R.id.rvAnimals);

        GridLayoutManager recyclerViewLayoutManager = new GridLayoutManager(MainActivity.this, 2);

        recyclerView.setLayoutManager(recyclerViewLayoutManager);
//        LinearLayoutManager horizontalLayoutManagaer
//                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(horizontalLayoutManagaer);



        adapter = new MyRecyclerViewAdapter(this, viewColors, items);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on item position " + position, Toast.LENGTH_SHORT).show();
    }
}