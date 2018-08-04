package com.example.jalil.mashap.fragmant;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amhso.meshope.MainActivity;
import com.example.amhso.meshope.Otherclass.G;
import com.example.amhso.meshope.Otherclass.Product;
import com.example.amhso.meshope.Otherclass.Seller;
import com.example.amhso.meshope.Otherclass.SellerAdapter;
import com.example.amhso.meshope.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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


public class LoginFragment extends Fragment{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final  View view= inflater.inflate(R.layout.fragment_login, container, false);



        Button login=(Button)view.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText email=(EditText) view.findViewById(R.id.email);
                String emailS=email.getText().toString();

                if(emailS.isEmpty()) {
                    email.setError("ایمیل نباید خالی باشد");
                    return;
                }



                EditText password=(EditText) view.findViewById(R.id.password);
                String passwordS=password.getText().toString();

                if(passwordS.isEmpty()) {
                    password.setError("پسورد نباید خالی باشد");
                    return;
                }



                HashMap<String, String> postData = new HashMap<>();
                postData.put("salam", "hello");

                HttpPostAsyncTask task = new HttpPostAsyncTask(postData,emailS,passwordS);
                task.execute(G.urlserver+"auth");

            }
        });



        return view;
    }







    public class HttpPostAsyncTask extends AsyncTask<String, String, String> {

        // This is the JSON body of the post
        JSONObject postData;
        public String username;
        public String password;
        public ProgressDialog progressDialog;

        // This is a constructor that allows you to pass in the JSON body
        public HttpPostAsyncTask(Map<String, String> postData,String username,String password) {

            this.username=username;
            this.password=password;
            if (postData != null) {
                this.postData = new JSONObject(postData);
            }
        }



        @Override
        protected void onPostExecute(String result) {

            Log.i("22222222222222222", "22222222222222222222222222" + result);

            progressDialog.dismiss();

            if(result.equals("1")){

            }
            else{


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(G.activity);
                // Setting Alert Dialog Title
                alertDialogBuilder.setTitle("اطلاعات وارد شده اشتباه می باشد");
                // Icon Of Alert Dialog
//                alertDialogBuilder.setIcon(R.drawable.question);
                // Setting Alert Dialog Message
                alertDialogBuilder.setMessage("آیا دوباره امتحان می کنید؟");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("بله", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
//                        finish();
                    }
                });

                alertDialogBuilder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialogBuilder.setNeutralButton("انصراف", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        G.activity.finish();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();



            }

        }






        @Override
        protected void onPreExecute() {

            Log.i("22222222222222222", "22222222222222222222222222start" );

            progressDialog = new ProgressDialog(G.activity);
            progressDialog.setMessage("چند لحظه صبر کنید...."); // Setting Message
            progressDialog.setTitle("در حال تایید اطلاعات"); // Setting Title
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
            progressDialog.show(); // Display Progress Dialog


            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    progressDialog.dismiss();
                }
            }).start();


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
                urlConnection.setRequestProperty(
                "Authorization",
                        "Basic " + Base64.encodeToString((this.username+":"+this.password).getBytes(), Base64.NO_WRAP));

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
