package com.example.jalil.myapplication1;



import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import android.app.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;






public class MainActivity extends AppCompatActivity {



    public  String dataServer;
    private DrawerLayout drawer;
    private NavigationView navigat;
    public SharedPreferences shpref;
    private TextView setUserName;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_xml);
//        G.activity = this;


        ImageView menu=(ImageView) findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.RIGHT);

            }
        });

//        startService(new Intent(getBaseContext(), SocketService.class));
//
//
//        BottomNavigationView mBottomNav=(BottomNavigationView) findViewById(R.id.navigation);
//        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()) {
//                    case R.id.menu_home:
//                        Intent u= new Intent(MainActivity.this , MainActivity.class);
//                        startActivity(u);
//                        return true;
//                    case R.id.menu_search:
//                        Intent s= new Intent(MainActivity.this , SearchActivity.class);
//                        startActivity(s);
//                        return true;
//                    case R.id.menu_perecent:
//                        Intent e= new Intent(MainActivity.this , PersentActivity.class);
//                        startActivity(e);
//                        return true;
//
//                    case R.id.menu_signup:
//                        Intent w= new Intent(MainActivity.this , SignupwebActivity.class);
//                        startActivity(w);
//                        return true;
//
////                    case R.id.menu_mokhaberat:
////                        Intent k= new Intent(MainActivity.this , MokhaberatActivity.class);
////                        startActivity(k);
////                        return true;
//
//                }
//                return false;
//
//            }
//        });

//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        //set file sharepreferences
        this.shpref = getSharedPreferences("bano", Context.MODE_PRIVATE);

        //ser drawer
        this.drawer = (DrawerLayout) findViewById(R.id.DL);
        //set click item drawer
        this.navigat = (NavigationView) findViewById(R.id.NA);


//        this.navigat.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
////                return itemClickNavigat(item);
//            }
//        });


        this.navigat.setItemIconTintList(null);

        //set username in heder drawer
//        if(G.checklogin()){
//            View header=this.navigat.getHeaderView(0);
//            this.setUserName = (TextView) header.findViewById(R.id.setUsername);
//            this.setUserName.setText( "با سلام :" + shpref.getString("username" , " ثبت نشده است"));
//
//
//
//
//        }else {
//            // not login go to activity login
//            Toast.makeText(this,"خواهشمندیم وارد شوید",Toast.LENGTH_LONG).show();
//            this.intent = new Intent(MainActivity.this , LoginActivity.class);
//            startActivity(this.intent);
//        }
//
//
//        conn1 = new connect_main(this, "sadaD");
//        conn1.execute();



    }



//
//    private boolean itemClickNavigat(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.exit :
//                SharedPreferences.Editor sh_edit = this.shpref.edit();
//                sh_edit.putString("username", null);
//                sh_edit.putString("pass", null );
//                sh_edit.putBoolean("login", false);
//                sh_edit.apply();
//                SharedPreferences.Editor sh_edit1 = this.shpref.edit();
//                sh_edit1.clear();
//                sh_edit1.apply();
//                this.drawer.closeDrawer(Gravity.RIGHT);
//                finish();
//                Intent i = new Intent(MainActivity.this , ThmeActivity.class);
//                startActivity(i);
//                return true;
//            case R.id.presence1 :
//                this.drawer.closeDrawer(Gravity.RIGHT);
//                finish();
//                Intent j = new Intent(MainActivity.this , PersentActivity.class);
//                startActivity(j);
//                return true;
//
//            case R.id.signup :
//                this.drawer.closeDrawer(Gravity.RIGHT);
//                finish();
//                Intent u= new Intent(MainActivity.this , SignupwebActivity.class);
//                startActivity(u);
//                return true;
//
//
//            case R.id.profile :
//                this.drawer.closeDrawer(Gravity.RIGHT);
//                finish();
//                Intent r= new Intent(MainActivity.this , ProfileActivity.class);
//                startActivity(r);
//                return true;
//
//
//            case R.id.chat:
//                Intent c= new Intent(MainActivity.this , ChatActivity.class);
//                startActivity(c);
//                return true;
//
//
//            case R.id.report:
//                Intent p= new Intent(MainActivity.this , ReportActivity.class);
//                startActivity(p);
//                return true;
//
//
//
//        }
//        return false;
//    }
//

    @Override
    protected void onStop() {
        super.onStop();


    }



    //start class connect to internet

//    public class connect_main extends AsyncTask<String, String, String> {
//
//
//        HttpURLConnection conn;
//        URL url = null;
//        public static final int CONNECTION_TIMEOUT = 10000;
//        public static final int READ_TIMEOUT = 15000;
//        public String dataa = null;
//        public String error = null;
//        public int check = 0;
//        public Context context = G.context;
//        public boolean check_internet = false;
//        public boolean check_network = false;
//        public ProgressDialog progress;
//        public Activity activity = G.activity;
//        private Activity setactivity = null;
//        public String check1 = "na";
//        public String query;
//        private SharedPreferences shpref;
//
//        public connect_main(Activity mainActivity, String send_data) {
//            this.setactivity = mainActivity;
//            connect.check = 0;
//            connect.dataa = null;
//            this.progress = new ProgressDialog(this.setactivity);
//            this.query = send_data;
//            this.shpref = G.activity.getSharedPreferences("bano", Context.MODE_PRIVATE);
//
//        }
//
//
//        /**
//         * Before starting background thread Show Progress Dialog
//         */
//        @Override
//        protected void onCancelled() {
//            super.onCancelled();
//
//        }
//
//        @Override
//        protected void onPreExecute() {
//            if (!connect.checknet()) {
//                progress.setMessage("خواهشا اینترنت خود را وصل کنید");
//                progress.setIndeterminate(true);
//                progress.setCancelable(false);
//                progress.setButton(DialogInterface.BUTTON_NEGATIVE, "باشه", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//                progress.show();
//
//
//            } else {
//
//            }
//
//        }
//
//        protected void onPostExecute(String file_url) {
//
//            String title_news="";
//            String title_messday="";
//            String title_service="";
//            String image_news="";
//            String image_messday="";
//             String image_service="";
//
//
//            Log.i("eeeeeeeeeeeeeeeeeeee", "onPostExecute: "+file_url);
//
//            try {
//                JSONObject jsonObj = new JSONObject(file_url);
//
//                // Getting JSON Array node
//                JSONArray contacts = jsonObj.getJSONArray("contacts");
//
//                // looping through All Contacts
//
//                for (int i = 0; i < contacts.length(); i++) {
//
//
//                     JSONObject c = contacts.getJSONObject(i);
//                     title_news=c.getString("title_news");
//                     title_messday = c.getString("title_messday");
//                     title_service = c.getString("title_service");
//                     image_news= c.getString("image_news");
//                     image_messday= c.getString("image_messday");
//                     image_service= c.getString("image_service");
//
//
//                }
//
//
//                TextView news=(TextView) findViewById(R.id.news_text);
//                news.setText(title_news);
//
//                TextView mess=(TextView) findViewById(R.id.messday_text);
//                mess.setText(title_messday);
//
//                TextView service=(TextView) findViewById(R.id.service_text);
//                service.setText(title_service);
//
//
//                ImageView imageView = (ImageView) findViewById(R.id.news);
//
//
//                Picasso.with(this.activity)
//                        .load(G.ServerImg+image_news)
//                        .resize(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels / 3 )
//
//                        .into(imageView);
//
//                imageView = (ImageView) findViewById(R.id.messday);
//
//                Picasso.with(this.activity)
//                        .load(G.ServerImg+image_messday)
//                        .resize(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels / 3 )
//
//                        .into(imageView);
//
//                imageView = (ImageView) findViewById(R.id.service);
//
//                Picasso.with(this.activity)
//                        .load(G.ServerImg+image_service)
//                        .resize(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels / 3 )
//
//                        .into(imageView);
//            } catch (final JSONException e) {
//
//                Log.i("ttttttttttttttttttt", "fffffffffffff: "+e.toString());
//
//            }
//
//        }
//
//        /**
//         * getting All products from url
//         */
//        protected String doInBackground(String... args) {
//            // Enter URL address where your php file resides
//            if (connect.checknet()) {
//                try {
//                    url = new URL(G.ServerUrl + "fetch_content?category="+this.shpref.getString("category", null));
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                    dataa = "url";
//                    return "url";
//                }
//                try {
//                    // Setup HttpURLConnection class to send and receive data from php and mysql
//                    conn = (HttpURLConnection) url.openConnection();
//                    conn.setReadTimeout(READ_TIMEOUT);
//                    conn.setConnectTimeout(CONNECTION_TIMEOUT);
//                    try {
//                        conn.setRequestMethod("POST");
//                    } catch (ProtocolException e) {
//                        e.printStackTrace();
//                        dataa = "post";
//                        return "post";
//
//                    }
//
//
//                    if (this.shpref.contains("login")) {
//                        String credentials = this.shpref.getString("username", null) + ":" + this.shpref.getString("pass", null);
//                        final String basic =
//                                "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
//                        conn.setRequestProperty("Authorization", basic);
//                    }
//                    // setDoInput and setDoOutput method depict handling of both send and receive
//                    conn.setDoInput(true);
//                    conn.setDoOutput(true);
//                    // Append parameters to URL
////            Uri.Builder builder = new Uri.Builder()
////                    .appendQueryParameter("username", "fsfsf")
////                    .appendQueryParameter("password", "sfsfsf");
////            String query = builder.build().getEncodedQuery();
//
//                    // Open connection for sending data
//                    OutputStream os = conn.getOutputStream();
//                    BufferedWriter writer = new BufferedWriter(
//                            new OutputStreamWriter(os, "UTF-8"));
//                    writer.write(this.query);
//                    writer.flush();
//                    writer.close();
//                    os.close();
//                    conn.connect();
//
//                } catch (IOException e1) {
//                    // TODO Auto-generated catch block
//                    e1.printStackTrace();
//                    dataa = "write";
//                    return "write";
//
//                }
//
//                try {
//                    int response_code = conn.getResponseCode();
//                    // Check if successful connection made
//                    if (response_code == HttpURLConnection.HTTP_OK) {
//                        // Read data sent from server
//                        InputStream input = conn.getInputStream();
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//                        StringBuilder result = new StringBuilder();
//                        String line;
//
//                        while ((line = reader.readLine()) != null) {
//                            result.append(line);
//                        }
//
//                        // Pass data to onPostExecute method
//                        dataa = result.toString();
//                        return (result.toString());
//
//                    } else {
//                        dataa = "no_connect";
//                        return "no_connect";
//
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    dataa = "connect";
//                    return "connect";
//
//                } finally {
//                    conn.disconnect();
//                }
//            }
//            dataa = "no_net";
//            return "no_net";
//
//        }
//
//    }
//
//




    private void getserver(String dataa) throws JSONException {
        this.dataServer = dataa;

    }


    @Override
    public void onBackPressed() {
        if(this.drawer.isDrawerOpen(Gravity.RIGHT)){
            this.drawer.closeDrawer(Gravity.RIGHT);
        }else {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("آیا می خواهید از برنامه خارج شوید");
            String positiveText = "بله";
            builder.setPositiveButton(positiveText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            MainActivity.super.onBackPressed();
                            finish();
                        }
                    });

            String negativeText ="خیر";
            builder.setNegativeButton(negativeText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // negative button logic
                        }
                    });

            AlertDialog dialog = builder.create();
            // display dialog
            dialog.show();


        }

    }





}