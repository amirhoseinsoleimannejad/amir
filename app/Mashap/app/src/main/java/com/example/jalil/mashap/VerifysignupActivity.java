package com.example.jalil.mashap;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amhso.meshope.Otherclass.G;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerifysignupActivity extends AppCompatActivity {

    public TextView time;
    public int counter=120;
    public  EditText one,two,three,four;
    public String sms_valid;
    public String id_user;
    public String code_sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifysignup);

        G.activity=this;


        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){

            id_user=bundle.getString("id_user");
            code_sms=bundle.getString("code_sms");

        }
        else{
            finish();
        }



        one=(EditText)findViewById(R.id.one);
        two=(EditText)findViewById(R.id.two);
        three=(EditText)findViewById(R.id.three);
        four=(EditText)findViewById(R.id.four);

        one.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before,int count) {
                two.requestFocus();
            }
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }
            public void afterTextChanged(Editable s) {
            }
        });




        two.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before,int count) {
                three.requestFocus();
            }
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }
            public void afterTextChanged(Editable s) {
            }
        });



        three.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before,int count) {
                four.requestFocus();
            }
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }
            public void afterTextChanged(Editable s) {
            }
        });





        new CountDownTimer(122000, 1000) {

            public void onTick(long millisUntilFinished) {

                try{
                    time=(TextView)G.activity.findViewById(R.id.time);
                    time.setText(String.valueOf(counter));
                    counter--;
                }
                catch (Exception e){
                    Log.i("eeeee", "onTick: "+e.toString());
                }


            }

            public void onFinish() {

            }

        }.start();





        Button signup=(Button) findViewById(R.id.verify);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                sms_valid = one.getText().toString();
                sms_valid += two.getText().toString();
                sms_valid += three.getText().toString();
                sms_valid += four.getText().toString();


                if(sms_valid.length() == 4 && sms_valid.equals(code_sms)) {


                    HttpPostAsyncTask task = new HttpPostAsyncTask();
                    task.execute(G.urlserver+"valid_sign");


                }
                else{
                    Toast.makeText(G.activity, "کد اشتباه است",Toast.LENGTH_LONG).show();
                }




            }
        });

    }









    public class HttpPostAsyncTask extends AsyncTask<String, String, String> {


        HttpPost httppost;


        HttpClient httpclient;
        List<NameValuePair> nameValuePairs;
        ProgressDialog dialog = null;





        @Override
        protected void onPostExecute(String result) {

            Log.i("22222222222222222", "22222222222222222222222222" + result);



            if(result.equals("1")){

                SharedPreferences shpref_login1 = G.activity.getSharedPreferences("Meshopper", Context.MODE_PRIVATE);
                SharedPreferences.Editor sh_edit = shpref_login1.edit();
                sh_edit.putString("id_user", id_user);
                sh_edit.apply();

                dialog.dismiss();
                Intent i = new Intent(G.activity,MainActivity.class);
                startActivity(i);
                finish();
            }
            else{
                Toast.makeText(G.activity, "کد اشتباه است",Toast.LENGTH_LONG).show();
            }


        }






        @Override
        protected void onPreExecute() {


            dialog = ProgressDialog.show(G.activity, "",
                    "در حال تایید اطلاعات چند لحظه صبر کنید.", true);


        }



        // This is a function that we are overriding from AsyncTask. It takes Strings as parameters because that is what we defined for the parameters of our async task
        @Override
        protected String doInBackground(String... params) {

            try {


                httpclient=new DefaultHttpClient();
                httppost= new HttpPost(params[0]); // make sure the url is correct.
                //add your data
                Log.i("uuuuuu", "urluuuuuuuuuuuu "+params[0]);
                nameValuePairs = new ArrayList<NameValuePair>(2);
                // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar,
                nameValuePairs.add(new BasicNameValuePair("valid_sms",sms_valid.trim()));
                nameValuePairs.add(new BasicNameValuePair("id_user",id_user.trim()));

                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                //Execute HTTP Post Request
//                response=httpclient.execute(httppost);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                String response = httpclient.execute(httppost, responseHandler);
//                System.out.println("Response : " + response);
                return response;



            } catch (Exception e) {
                Log.i("error rrrrrrr", e.toString());
            }

            return null;
        }
    }



}
