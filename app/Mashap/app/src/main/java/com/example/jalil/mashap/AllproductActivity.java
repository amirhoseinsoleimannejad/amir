package com.example.jalil.mashap;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.amhso.meshope.adapter.AllproductAdapter;
import com.example.amhso.meshope.Otherclass.G;
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
import java.util.Map;

public class AllproductActivity extends AppCompatActivity {


    private String id_seller;

    private ListView listView;
    Product[] products;
    RecyclerView recyclerView;



    RecyclerView.Adapter recyclerView_Adapter;

    RecyclerView.LayoutManager recyclerViewLayoutManager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_allproduct);

        G.activity=this;


        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){

            id_seller=bundle.getString("id_seller");

        }
        else{
            finish();
        }


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);

        //Change 2 to your choice because here 2 is the number of Grid layout Columns in each row.
        recyclerViewLayoutManager = new GridLayoutManager(G.activity, 2);

        recyclerView.setLayoutManager(recyclerViewLayoutManager);



        HttpPostAsyncTask conn=new HttpPostAsyncTask();
        conn.execute(G.urlserver+"all_product?id_seller="+id_seller);


    }





    public class HttpPostAsyncTask extends AsyncTask<String, String, String> {

        // This is the JSON body of the post
        JSONObject postData;

        // This is a constructor that allows you to pass in the JSON body
//        public HttpPostAsyncTask(Map<String, String> postData) {
//            if (postData != null) {
//                this.postData = new JSONObject(postData);
//            }
//        }



        @Override
        protected void onPostExecute(String result) {

            Log.i("22222222222222222", "22222222222222222222222222" + result);




            try {


                JSONArray contacts;
                JSONObject jsonObj = new JSONObject(result);
                contacts = jsonObj.getJSONArray("products");

                products=new Product[ contacts.length()];


                for (int i = 0; i < contacts.length(); i++) {

                    JSONObject c = contacts.getJSONObject(i);
                    String id = c.getString("id");
                    String title = c.getString("title");
                    String image= c.getString("img");

                    products[i]=new Product(id,title,"2000",image);



                }
//

//                AllproductAdapter adapter=new AllproductAdapter(G.activity, products);
//                listView.setAdapter(adapter);


//                recyclerView_Adapter = new RecyclerViewAdapter(G.activity, products);
//
//                recyclerView.setAdapter(recyclerView_Adapter);

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
