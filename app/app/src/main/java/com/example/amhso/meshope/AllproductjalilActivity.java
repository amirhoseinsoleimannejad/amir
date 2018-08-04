package com.example.amhso.meshope;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AllproductjalilActivity extends AppCompatActivity {


    private DrawerLayout drawer;
    private NavigationView navigat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allproductjalil);



        this.drawer = (DrawerLayout) findViewById(R.id.DL);



        this.navigat = (NavigationView) findViewById(R.id.NA);
        this.navigat.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return itemClickNavigat(item);
            }
        });
        this.navigat.setItemIconTintList(null);


        ImageView menu=(ImageView) findViewById(R.id.imageView);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawer.openDrawer(Gravity.RIGHT);

            }
        });


        TextView menuT=(TextView) findViewById(R.id.textView112);
        menuT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawer.openDrawer(Gravity.RIGHT);

            }
        });


        Typeface yekan_font22 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b22= (TextView) findViewById(R.id.textView112);
        b22.setTypeface(yekan_font22);



        Typeface yekan_font3 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b3= (TextView) findViewById(R.id.textView301);
        b3.setTypeface(yekan_font3);

        Typeface yekan_font2 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b2= (TextView) findViewById(R.id.textView302);
        b2.setTypeface(yekan_font2);
        Typeface yekan_font4 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b4= (TextView) findViewById(R.id.textView311);
        b4.setTypeface(yekan_font4);
        Typeface yekan_font5 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b5= (TextView) findViewById(R.id.textView312);
        b5.setTypeface(yekan_font5);
        Typeface yekan_font6 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b6= (TextView) findViewById(R.id.textView310);
        b6.setTypeface(yekan_font6);
        Typeface yekan_font7 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b7= (TextView) findViewById(R.id.textView309);
        b7.setTypeface(yekan_font7);
        Typeface yekan_font8 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b8= (TextView) findViewById(R.id.textView308);
        b8.setTypeface(yekan_font8);
        Typeface yekan_font9 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b9= (TextView) findViewById(R.id.textView307);
        b9.setTypeface(yekan_font9);
        Typeface yekan_font10 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b10= (TextView) findViewById(R.id.textView306);
        b10.setTypeface(yekan_font10);
        Typeface yekan_font11 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b11= (TextView) findViewById(R.id.textView305);
        b11.setTypeface(yekan_font11);
        Typeface yekan_font12 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b12= (TextView) findViewById(R.id.textView304);
        b12.setTypeface(yekan_font12);
        Typeface yekan_font13 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b13= (TextView) findViewById(R.id.textView303);
        b13.setTypeface(yekan_font13);
//        Button f= (Button) findViewById(R.id.button115);
//        Typeface yekan_font21 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
//        f.setTypeface(yekan_font21);
        TextView textView= (TextView) findViewById(R.id.textView302);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        TextView textView1= (TextView) findViewById(R.id.textView305);
        textView1.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        TextView textView2= (TextView) findViewById(R.id.textView308);
        textView2.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        TextView textView3= (TextView) findViewById(R.id.textView311);
        textView3.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }





    private boolean itemClickNavigat(MenuItem item){
        switch (item.getItemId()){


            case R.id.category1 :
                this.drawer.closeDrawer(Gravity.RIGHT);
                return true;

            case R.id.category2 :
                this.drawer.closeDrawer(Gravity.RIGHT);
                return true;

            case R.id.category3 :
                this.drawer.closeDrawer(Gravity.RIGHT);
                return true;

            case R.id.category4 :
                this.drawer.closeDrawer(Gravity.RIGHT);
                return true;

        }
        return false;
    }
}
