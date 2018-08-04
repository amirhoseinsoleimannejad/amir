package com.example.jalil.meshop_asli;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jalil.meshop_asli.Otherclass.G;
import com.takusemba.spotlight.OnSpotlightStateChangedListener;
import com.takusemba.spotlight.OnTargetStateChangedListener;
import com.takusemba.spotlight.Spotlight;
import com.takusemba.spotlight.shape.Circle;
import com.takusemba.spotlight.target.SimpleTarget;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView ;
    ImageView two;
    ImageView one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        G.activity=this;
    }
    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
        if(G.firstlunch){
            G.firstlunch=false;
            TextView textView =(TextView) findViewById(R.id.basket);
            int[] location = new int[2];
            textView.getLocationOnScreen(location);
            float x = (location[0] + textView.getWidth()) / 2f;
            float y = (location[1] + textView.getHeight()) / 2f;

            SimpleTarget simpleTarget = new SimpleTarget.Builder(this)
                    .setPoint(x, y)
                    .setShape(new Circle(50f))
                    .setTitle("تست")
                    .setDescription("توضیحات")
                    .setOnSpotlightStartedListener(new OnTargetStateChangedListener<SimpleTarget>() {
                        @Override
                        public void onStarted(SimpleTarget target) {
                            // do something
                        }
                        @Override
                        public void onEnded(SimpleTarget target) {
                            // do something
                        }
                    })
                    .build();




            Spotlight.with(this)
                    .setDuration(1000L)
                    .setAnimation(new DecelerateInterpolator(2f))
                    .setTargets(simpleTarget)
                    .setClosedOnTouchedOutside(true)
                                .setOnSpotlightStateListener(new OnSpotlightStateChangedListener() {
                                    @Override
                                    public void onStarted() {

                                    }

                                    @Override
                                    public void onEnded() {

                                    }
                                })
                    .start();
        }

    }



}
