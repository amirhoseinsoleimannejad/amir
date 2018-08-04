package com.example.amhso.meshope;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PointF;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amhso.meshope.Otherclass.G;
import com.example.amhso.meshope.Otherclass.Product;
import com.example.amhso.meshope.Otherclass.Seller;
import com.example.amhso.meshope.Otherclass.SellerAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.takusemba.spotlight.OnSpotlightEndedListener;
import com.takusemba.spotlight.OnSpotlightStartedListener;
import com.takusemba.spotlight.OnTargetStateChangedListener;
import com.takusemba.spotlight.SimpleTarget;
import com.takusemba.spotlight.Spotlight;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    ListView listView ;
    ArrayList<Seller> listnameseller;
    com.example.amhso.meshope.Otherclass.SellerAdapter SellerAdapter;
    ImageView two;
    ImageView one;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        G.activity=this;








        BottomNavigationView mBottomNav=(BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_home:
                        Intent u= new Intent(G.activity , MainActivity.class);
                        startActivity(u);
                        return true;
                    case R.id.action_favoride:
                        Intent s= new Intent(G.activity , FavoriteActivity.class);
                        startActivity(s);
                        return true;
                    case R.id.action_search:
                        Intent e= new Intent(G.activity , AllproductjalilActivity.class);
                        startActivity(e);
                        return true;

                    case R.id.action_sharge:
                        Intent w= new Intent(G.activity , ChargeActivity.class);
                        startActivity(w);
                        return true;

                    case R.id.action_exit:
                        finish();
                        return true;
                }
                return false;

            }
        });





        ImageView basket=(ImageView) findViewById(R.id.basket);
        basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basket();
            }
        });




        ImageView profile=(ImageView) findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                profile();
            }
        });



//        ActionBar actionBar= getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeButtonEnabled(true);
//
//
//        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.colorAccent));
//
//        DrawerLayout drawerLayout;
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
//
//
//        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
//        drawerToggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.menuitem1:
////                        Toast.makeText(MainActivity.this, "صفحه اصلی کلیک شده است", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.menuitem2:
////                        Toast.makeText(MainActivity.this, "خروج کلیک شده است", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return true;
//            }
//        });


        listView=(ListView) findViewById(R.id.listviewseller);


        listnameseller = new ArrayList<>();

        SellerAdapter = new SellerAdapter(this,listnameseller);
        listView.setAdapter(SellerAdapter);


        HashMap<String, String> postData = new HashMap<>();
        postData.put("salam", "hello");

        HttpPostAsyncTask task = new HttpPostAsyncTask(postData);
        task.execute(G.urlserver+"fetch_seller");

    }




    @Override
    public void onWindowFocusChanged (boolean hasFocus) {

        if(G.firstlunch){

            G.firstlunch=false;
            one = (ImageView) findViewById(R.id.basket);
            int[] oneLocation = new int[2];
            one.getLocationOnScreen(oneLocation);
            float oneX = oneLocation[0] + one.getWidth() / 2f  ;
            float oneY = oneLocation[1] + one.getWidth() / 2f  ;
            // make an target
            SimpleTarget firstTarget = new SimpleTarget.Builder(MainActivity.this).setPoint(oneX, oneY)
                    .setRadius(100f)
                    .setTitle("سبد خرید")
                    .setDescription("با کلیک کردن می توانید سبد خرید خود را ببینید.")
                    .build();



            two = (ImageView) findViewById(R.id.profile);

            int[] twoLocation = new int[2];
            two.getLocationOnScreen(twoLocation);
            float oneXp = twoLocation[0] + two.getWidth() / 2f  ;
            float oneYp = twoLocation[1] + two.getWidth() / 2f  ;

            Log.i("111111111111", "onCreate: "+oneX+oneY+"gggg"+oneXp+oneYp);
            // make an target
            SimpleTarget secondTarget = new SimpleTarget.Builder(MainActivity.this).setPoint(oneXp,oneYp)
                    .setRadius(100f)
                    .setTitle("حساب کاربری")
                    .setDescription("می توانید اطلاعات حساب خود را دیده و آن را ویرایش کنید.")
                    .build();
//
//        SimpleTarget thirdTarget =
//                new SimpleTarget.Builder(MainActivity.this).setPoint(findViewById(R.id.basket))
//                        .setRadius(200f)
//                        .setTitle("third title")
//                        .setDescription("third description")
//                        .build();

            Spotlight.with(MainActivity.this)
                    .setOverlayColor(ContextCompat.getColor(MainActivity.this, R.color.background))
                    .setDuration(1000L)
                    .setAnimation(new DecelerateInterpolator(2f))
                    .setTargets(firstTarget,secondTarget)
                    .setClosedOnTouchedOutside(true)
                    .start();
        }

    }










    public  void basket(){

        SharedPreferences shpref = G.activity.getSharedPreferences("Meshopper", Context.MODE_PRIVATE);

        if(shpref.getString("id_user","-1").equals("-1")){

            Intent i=new Intent(G.activity,SignupActivity.class);
            G.activity.startActivity(i);
            overridePendingTransition(R.anim.animation_activity_start,R.anim.animation_activity_end);

        }
        else{

            Intent i=new Intent(G.activity,ShopingbagActivity.class);
            G.activity.startActivity(i);
            overridePendingTransition(R.anim.animation_activity_start,R.anim.animation_activity_end);

        }

    }








    public  void profile(){

        SharedPreferences shpref = G.activity.getSharedPreferences("Meshopper", Context.MODE_PRIVATE);

        if(shpref.getString("id_user","-1").equals("-1")){

            Intent i=new Intent(G.activity,SignupActivity.class);
            G.activity.startActivity(i);
            overridePendingTransition(R.anim.animation_activity_start,R.anim.animation_activity_end);

        }
        else{

            Intent i=new Intent(G.activity,ProfileActivity.class);
            G.activity.startActivity(i);
            overridePendingTransition(R.anim.animation_activity_start,R.anim.animation_activity_end);

        }

    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.bottom_navigation_items, menu);
//        return true;
//    }






    public class HttpPostAsyncTask extends AsyncTask<String, String, String> {

        // This is the JSON body of the post
        JSONObject postData;

        // This is a constructor that allows you to pass in the JSON body
        public HttpPostAsyncTask(Map<String, String> postData) {
            if (postData != null) {
                this.postData = new JSONObject(postData);
            }
        }



        @Override
        protected void onPostExecute(String result) {

            Log.i("22222222222222222", "22222222222222222222222222" + result);




            try {


                JSONArray contacts;
                JSONObject jsonObj = new JSONObject(result);
                contacts = jsonObj.getJSONArray("seller");



                for (int i = 0; i < contacts.length(); i++) {

                    JSONObject c = contacts.getJSONObject(i);
                    String id = c.getString("id");
                    String name = c.getString("name_store");


//                    listnameseller.add(name);



                    try {
                        JSONArray product;
                        JSONObject jsonObjp = new JSONObject(result);
                        product = jsonObjp.getJSONArray(""+id);
                        Log.i("lelelelelelelelelelele", "array: "+product.length());

                        Product pro[]=new Product[product.length()];
                        for (int j = 0; j < product.length(); j++) {

                            JSONObject p = product.getJSONObject(j);
                            String idp = p.getString("id");
                            String nameproduct = p.getString("title");
                            String image=p.getString("img");
                            String price=p.getString("price");
                            pro[j]=new Product(idp,nameproduct,price,image);
                        }

                        Seller s=new Seller(id,name,pro);
                        listnameseller.add(s);

                        Log.i("lelelelelelelelelelele", "onPostExecute: "+s.getP().length);

                    }
                    catch (Exception e){

                        Log.i("eeeeee", "productttttttttttt: "+e.toString());
                    }
                }

                SellerAdapter = new SellerAdapter(G.activity,listnameseller);
                listView.setAdapter(SellerAdapter);

            }
            catch (Exception e){


                Log.i("eeeeee", "errrrrrrrror: "+e.toString());
            }


        }






        @Override
        protected void onPreExecute() {

            Log.i("22222222222222222", "22222222222222222222222222start" );
        }



        // This is a function that we are overriding from AsyncTask. It takes Strings as parameters because that is what we defined for the parameters of our async task
        @Override
        protected String doInBackground(String... params) {

            try {
                // This is getting the url from the string we passed in
                URL url = new URL(params[0]);


                Log.i("uuuuuuuu", "uuuuuuuuuuuuuuuu: "+url.toString());


                // Create the urlConnection
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);

                urlConnection.setRequestProperty("Content-Type", "application/json");

                urlConnection.setRequestMethod("POST");


                // OPTIONAL - Sets an authorization header
                urlConnection.setRequestProperty("Authorization", "someAuthString");

                // Send the post body
                if (this.postData != null) {
                    OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
                    writer.write(postData.toString());
                    writer.flush();
                }

                int statusCode = urlConnection.getResponseCode();

                if (statusCode ==  200) {

                    InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

//                    String response = convertInputStreamToString(inputStream);

                    // From here you can convert the string to JSON with whatever JSON parser you like to use

                    BufferedReader reader = null;

                    reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response

                    while ((line = reader.readLine()) != null) {
                        // Append server response in string
                        sb.append(line);

                    }


                   return sb.toString();

                    // After converting the string to JSON, I call my custom callback. You can follow this process too, or you can implement the onPostExecute(Result) method

                } else {
                    return "dont connect";
                }

            } catch (Exception e) {
                Log.i("error rrrrrrr", e.getLocalizedMessage());
            }
            return null;
        }
    }





}
