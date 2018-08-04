package com.example.jalil.mashap.Otherclass;



import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;





public class G extends Application {

    public static Context context;
    public static Activity activity;

    public static String urlserver="http://afrapartition.ir/meshop/android/";
    public static final String urlimage = "http://afrapartition.ir/meshop/uploads/";


    public static Boolean firstlunch=true;











    @Override
    public void onCreate() {

        context = getApplicationContext();
        super.onCreate();


    }









}