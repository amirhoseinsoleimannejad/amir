package com.example.jalil.mashap;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        Typeface yekan_font3 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b3= (TextView) findViewById(R.id.name);
        b3.setTypeface(yekan_font3);



        b3= (TextView) findViewById(R.id.email);
        b3.setTypeface(yekan_font3);


        b3= (TextView) findViewById(R.id.address);
        b3.setTypeface(yekan_font3);



        b3= (TextView) findViewById(R.id.charge);
        b3.setTypeface(yekan_font3);



    }
}
