package com.example.jalil.mashap;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShopingbagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingbage);





        TextView textView= (TextView) findViewById(R.id.textView110);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        Typeface yekan_font3 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b3= (TextView) findViewById(R.id.textView112);
        b3.setTypeface(yekan_font3);
        Typeface yekan_font4 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b4= (TextView) findViewById(R.id.textView113);
        b4.setTypeface(yekan_font4);
        Typeface yekan_font5 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b5= (TextView) findViewById(R.id.textView114);
        b5.setTypeface(yekan_font5);
        Typeface yekan_font6 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b6= (TextView) findViewById(R.id.textView116);
        b6.setTypeface(yekan_font6);
        Typeface yekan_font7 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b7= (TextView) findViewById(R.id.textView117);
        b7.setTypeface(yekan_font7);

        Typeface yekan_font8 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b8= (TextView) findViewById(R.id.textView110);
        b8.setTypeface(yekan_font8);
        Typeface yekan_font9 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b9= (TextView) findViewById(R.id.textView111);
        b9.setTypeface(yekan_font9);

        Typeface yekan_font10 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b10= (TextView) findViewById(R.id.textView118);
        b10.setTypeface(yekan_font10);
        Typeface yekan_font11 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b11= (TextView) findViewById(R.id.textView119);
        b11.setTypeface(yekan_font11);
        Typeface yekan_font20 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b20= (TextView) findViewById(R.id.textView200);
        b20.setTypeface(yekan_font20);

        Typeface yekan_font21 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b21= (TextView) findViewById(R.id.textView1);
        b21.setTypeface(yekan_font21);
        Typeface yekan_font22 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b22= (TextView) findViewById(R.id.textView2);
        b22.setTypeface(yekan_font22);
        Typeface yekan_font23 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b23= (TextView) findViewById(R.id.textView3);
        b23.setTypeface(yekan_font23);

        Typeface yekan_font300 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        Button b300= (Button) findViewById(R.id.button300);
        b300.setTypeface(yekan_font300);
    }








    public void manfi(View view) {


    }

    public void mosbat(View view) {

    }
}
