package com.example.amhso.meshope;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);


        final Animation a = AnimationUtils.loadAnimation(this, R.anim.animation_scale);
        a.reset();

        android.support.constraint.ConstraintLayout layout = (android.support.constraint.ConstraintLayout) findViewById(R.id.con_bg);

        layout.startAnimation(a);





        final Animation b = AnimationUtils.loadAnimation(this, R.anim.animation_alpha);
        b.reset();
        final TextView rText = (TextView) findViewById(R.id.des_logo);
        rText.startAnimation(b);



        final Animation c = AnimationUtils.loadAnimation(this, R.anim.animation_translate);
        c.reset();
        final ImageView imgview = (ImageView) findViewById(R.id.imagelogo);
        imgview.startAnimation(c);



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(LogoActivity.this,MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.animation_activity_start,R.anim.animation_activity_end);
                finish();

            }
        },5000);
    }
}
