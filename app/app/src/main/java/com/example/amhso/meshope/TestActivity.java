package com.example.amhso.meshope;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.amhso.meshope.adapter.CustomListAdapter;
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
import java.util.HashMap;
import java.util.Map;


public class TestActivity extends Activity{

    ListView list;
    Product[] products;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        G.activity=this;
//        products[0]=new Product("1","title","2000","image");
//
//        products[1]=new Product("1","title","2000","image");
//        products[2]=new Product("1","title","2000","image");


        list=(ListView)findViewById(R.id.list);

//        CustomListAdapter adapter=new CustomListAdapter(this, products);
//        list.setAdapter(adapter);


        HashMap<String, String> postData = new HashMap<>();
        postData.put("salam", "hello");

       HttpPostAsyncTask task = new HttpPostAsyncTask(postData);
        task.execute(G.urlserver+"all_product?id_seller=1");


//        list.setOnItemClickListener(new OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                // TODO Auto-generated method stub
//                String Slecteditem= itemname[+position];
//                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
//
//            }
//        });
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

            CustomListAdapter adapter=new CustomListAdapter(G.activity, products);
            list.setAdapter(adapter);

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