package com.example.linux.myhalilsoroor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class menue extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menue);
        ImageView imageView2= (ImageView) findViewById(R.id.imageView5);
        Animation anim_m_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.jafar);
        imageView2.startAnimation(anim_m_right);

        ImageView imageView3= (ImageView) findViewById(R.id.imageView11);
        Animation qqq = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.jafar);
        imageView3.startAnimation(qqq);

        ImageView imageView4= (ImageView) findViewById(R.id.imageView12);
        Animation www = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.jafar);
        imageView4.startAnimation(www);

        ImageView btn2 = (ImageView) findViewById(R.id.imageView6);

        Animation zzz = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.javad);
        btn2.startAnimation(zzz);
        ImageView btn3 = (ImageView) findViewById(R.id.imageView7);

        Animation wwww = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.javad);
        btn3.startAnimation(wwww);
        ImageView btn4 = (ImageView) findViewById(R.id.imageView8);

        Animation xxx = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.javad);
        btn4.startAnimation(xxx);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on1clickhandler(View view) {
        Intent jalil=new Intent(this,pizaa.class);
        startActivity(jalil);
    }


    public void on2clickhandler(View view) {
        Intent jalil1=new Intent(this,hamberger.class);
        startActivity(jalil1);
    }
    public void on3clickhandler(View view) {
        Intent jalil11=new Intent(this,sosis.class);
        startActivity(jalil11);
    }
}
