package com.example.jalil.mashap.fragmant;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import android.app.AlertDialog;
import android.app.Notification;
import android.app.ProgressDialog;
import android.app.TaskStackBuilder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.Fragment;

import com.example.amhso.meshope.MainActivity;
import com.example.amhso.meshope.Otherclass.G;
import com.example.amhso.meshope.R;
import com.example.amhso.meshope.VerifysignupActivity;




import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

public class SignupFragment extends Fragment{



    HttpPost httppost;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpclient;
    List<NameValuePair> nameValuePairs;
    ProgressDialog dialog = null;

    String nameS;
    String emailS;
    String phoneS;
    String meliS;
    String passwordS;

    EditText name,email,password,meli,phone;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_signup, container, false);











        Button signup=(Button)view.findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                name=(EditText) view.findViewById(R.id.name);
                nameS=name.getText().toString();

                if(nameS.isEmpty()) {
                    name.setError("نام و نام خانوادگی نباید خالی باشد");
                    return;
                }



                email=(EditText) view.findViewById(R.id.email);
                emailS=email.getText().toString();

                if(emailS.isEmpty()) {
                    email.setError("ایمیل نباید خالی باشد");
                    return;
                }




                phone=(EditText) view.findViewById(R.id.phone);
                phoneS=phone.getText().toString();

                if(phoneS.isEmpty()) {
                    email.setError("موبایل نباید خالی باشد");
                    return;
                }





                meli=(EditText) view.findViewById(R.id.meli);
                meliS=meli.getText().toString();

                if(meliS.isEmpty()) {
                    meli.setError("کد ملی نباید خالی باشد");
                    return;
                }




                password=(EditText) view.findViewById(R.id.password);
                passwordS=password.getText().toString();

                if(passwordS.isEmpty()) {
                    password.setError("رمز عبور نباید خالی باشد");
                    return;
                }






                HttpPostAsyncTask task = new HttpPostAsyncTask();
                task.execute(G.urlserver+"signup");



            }
        });



        return view;
    }







    public void showAlert(final String Title, final String Text){
        G.activity.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(G.activity);
                builder.setTitle(Title);
                builder.setMessage(Text)
                        .setCancelable(false)
                        .setPositiveButton("باشه", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }







    public class HttpPostAsyncTask extends AsyncTask<String, String, String> {




        @Override
        protected void onPostExecute(String result) {

            Log.i("22222222222222222", "22222222222222222222222222" + result);



            String response[]=result.split(":");

            try {

                if(response[0].equals("1")){

                    dialog.dismiss();


                    Notification("تاییده ثبت نام",response[1]);



                    Intent i = new Intent(G.activity,VerifysignupActivity.class);
                    i.putExtra("id_user",response[2]);
                    i.putExtra("code_sms",response[1]);
                    G.activity.startActivity(i);
                    G.activity.finish();
                    G.activity.overridePendingTransition(R.anim.animation_activity_start,R.anim.animation_activity_end);

                }

                if(response[0].equals("error")){
                    dialog.dismiss();

                    switch (response[1]){
                        case "1":
                            name.setError("نام و نام خانوادگی نامعتبر می باشد");

                        case "2":
                            email.setError("ایمیل موجود یا نامعتبر است");

                        case "3":
                            phone.setError("شماره نامعتبر می باشد");


                        case "4":
                            meli.setError("کدملی نامعتبر است");

                        case "5":
                            email.setError("ایمیل نامعتبر می باشد");

                        case "6":
                            email.setError("ایمیل نامعتبر می باشد");


                        case "7":
                            password.setError("رمز عبور نامعتبر می باشد");


                    }
                }
                if(response[0].equals("-3")){
                    dialog.dismiss();
                    showAlert("خطای سرور","در برقراری ارتباط به مشکل برخورد کرده ایم");

                }


                else{
                    dialog.dismiss();
                }


            }
            catch (Exception e){


                Log.i("eeeeee", "errrrrrrrror: "+e.toString());
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
                nameValuePairs = new ArrayList<NameValuePair>(5);
                // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar,
                nameValuePairs.add(new BasicNameValuePair("name",nameS.trim()));
                nameValuePairs.add(new BasicNameValuePair("email",emailS.trim()));
                nameValuePairs.add(new BasicNameValuePair("phone",phoneS.trim()));
                nameValuePairs.add(new BasicNameValuePair("meli",meliS.trim()));
                nameValuePairs.add(new BasicNameValuePair("password",passwordS.trim()));
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





    public void Notification(String Title,String Text){


        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(G.activity)
                        .setSmallIcon(R.drawable.basket)
                        .setContentTitle(Title)   //this is the title of notification
                        .setColor(101)
                        .setPriority(Notification.PRIORITY_MAX)
                        .setAutoCancel(true)
                        .setContentText(Text);


        Intent intent = new Intent(G.activity, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(G.activity, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.getNotification().flags |= Notification.FLAG_AUTO_CANCEL;
        builder.setContentIntent(contentIntent);
        // Add as notification

        NotificationManager manager = (NotificationManager) G.activity.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());


    }
}
