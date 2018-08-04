package com.example.amhso.meshope;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amhso.meshope.Otherclass.G;
import com.example.amhso.meshope.adapter.MyPagerAdapter;
import com.example.amhso.meshope.Otherclass.PagerContainer;
import com.example.amhso.meshope.Otherclass.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DetailproductActivity extends AppCompatActivity {

    TextView nameproduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailproduct);

        G.activity=this;
        String id_product="";




        TextView textView= (TextView) findViewById(R.id.textView110);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        Typeface yekan_font3 = Typeface.createFromAsset(getAssets(), "BTrafcBd_0.ttf");
        TextView b3= (TextView) findViewById(R.id.textView112);
        b3.setTypeface(yekan_font3);

        Typeface yekan_font6 = Typeface.createFromAsset(getAssets(),"BYekan.ttf");
        TextView b6= (TextView) findViewById(R.id.textView1113);
        b6.setTypeface(yekan_font6);

        Typeface yekan_font1 = Typeface.createFromAsset(getAssets(),"BYekan.ttf");
        TextView b1= (TextView) findViewById(R.id.textView110);
        b1.setTypeface(yekan_font1);

        Typeface yekan_font2 = Typeface.createFromAsset(getAssets(), "BYekan.ttf");
        TextView b2= (TextView) findViewById(R.id.textView111);
        b2.setTypeface(yekan_font2);

        Typeface yekan_font5 = Typeface.createFromAsset(getAssets(), "BYekan.ttf");
        Button b5= (Button) findViewById(R.id.button115);
        b5.setTypeface(yekan_font5);


//        nameproduct=(TextView) findViewById(R.id.name_product);

        Bundle bundle = getIntent().getExtras();

        if(true){
//            id_product=bundle.getString("id_product");

            id_product="1";
            HashMap<String, String> postData = new HashMap<>();
            postData.put("salam", "hello");

            HttpPostAsyncTask task = new HttpPostAsyncTask(postData);
            task.execute(G.urlserver+"detail_product?id_product="+id_product);




            PagerContainer mContainer = (PagerContainer) findViewById(R.id.pager_container);


            ViewPager pager = mContainer.getViewPager();

            Product pro []=new Product[5];

            String idp = "1";
            String nameproduct = "محصول 2";
            String image="";
            String price="26900";
            pro[0]=new Product(idp,nameproduct,price,image);

             idp = "1";
             nameproduct = "محصول 2";
             image="";
             price="26900";
            pro[1]=new Product(idp,nameproduct,price,image);

            idp = "1";
            nameproduct = "محصول 2";
            image="";
            price="26900";
            pro[2]=new Product(idp,nameproduct,price,image);

            idp = "1";
            nameproduct = "محصول 2";
            image="";
            price="26900";
            pro[3]=new Product(idp,nameproduct,price,image);


            idp = "1";
            nameproduct = "محصول 2";
            image="";
            price="26900";
            pro[4]=new Product(idp,nameproduct,price,image);





            PagerAdapter adapter = new MyPagerAdapter(pro);
            pager.setAdapter(adapter);

            pager.setOffscreenPageLimit(adapter.getCount());
        }
    }





    public void jalil1(View view) {
        String imagName="a2";
        int res=getResources().getIdentifier(imagName,"drawable",getPackageName());
        ImageView iv = (ImageView) findViewById(R.id.imageView6);
        iv.setImageResource(res);

    }

    public void jalil2(View view) {
        String imagName="a3";
        int res1=getResources().getIdentifier(imagName,"drawable",getPackageName());
        ImageView iv1 = (ImageView) findViewById(R.id.imageView6);
        iv1.setImageResource(res1);
    }

    public void jalil3(View view) {
        String imagName="a4";
        int res4=getResources().getIdentifier(imagName,"drawable",getPackageName());
        ImageView iv4 = (ImageView) findViewById(R.id.imageView6);
        iv4.setImageResource(res4);
    }








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
                contacts = jsonObj.getJSONArray("product");



                for (int i = 0; i < contacts.length(); i++) {

                    JSONObject c = contacts.getJSONObject(i);
                    String id = c.getString("id");
                    String title = c.getString("title");

//                    nameproduct.setText(title);

                }
//
//                SellerAdapter = new SellerAdapter(G.activity,listnameseller);
//                listView.setAdapter(SellerAdapter);

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
