package com.example.linux.myhalilsoroor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout btn1 = (RelativeLayout) findViewById(R.id.con_bg);
        ImageView btn2 = (ImageView) findViewById(R.id.imageView3);

        Animation anim_m_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.jamal);
        Animation anim_m_left = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.javad);
        btn1.startAnimation(anim_m_right);
        btn2.startAnimation(anim_m_left);

        ImageView imageView2= (ImageView) findViewById(R.id.imageView2);
        Animation ali = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.jafar);
        imageView2.startAnimation(ali);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void Omclickhandler(View view) {
        Intent jalil=new Intent(this,menue.class);
        startActivity(jalil);
    }
}
