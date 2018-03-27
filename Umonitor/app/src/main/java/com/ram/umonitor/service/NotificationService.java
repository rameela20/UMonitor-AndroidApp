package com.ram.umonitor.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ram.umonitor.model.Notification;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationService extends Service {

    DatabaseReference myRef;
    int count=0;
    public NotificationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myRef= FirebaseDatabase.getInstance().getReference("notifications");
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        new RequestTask().execute();

                    }
                });
            }
        };
        timer.schedule(task, 0, 30000); //it executes this every 1000ms
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("service","dis");
    }

    class RequestTask extends AsyncTask<Void,Void,JSONObject> {

        @Override
        protected JSONObject doInBackground(Void... params) {

            //https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=6.9351353,79.8609322&radius=50&key=%20AIzaSyATUMNVGi6cVgfdBcpoWSHxm0h8r6L9BW0
            String url = "https://umonitor-b1291.firebaseio.com/periodAssess.json?orderBy=\"$key\"&limitToLast=1&auth=iJeQqe3VH3BC0qiUG9kKXTbG1baklajlfbr6bcpw";
            getPlaceJSON(url);
            return  getPlaceJSON(url);
        }

        protected void onPostExecute(JSONObject jsonObject){
            //Toast.makeText(getApplicationContext(),jsonObject.toString(),Toast.LENGTH_LONG).show();

            //try {
                String[] temp=jsonObject.toString().split(":");
                String [] t=temp[4].split(",");
                double t1=Double.parseDouble(t[0].replaceAll("^\"|\"$", ""));
                if((t1>20)){
                    Notification notification=new Notification();
                    notification.setDesc("Temperature is : "+t1+" celcius");
                    Date date=new Date();
                    notification.setTitle("Temperature High at "+date.toString());

                    myRef.push().setValue(notification);
                    count++;
                }
            String [] s=temp[3].split(",");
            double s1=Double.parseDouble(s[0].replaceAll("^\"|\"$", ""));
            if((s1<70)){
                Notification notification=new Notification();
                notification.setDesc("Saturation is : "+s1+"%");
                Date date=new Date();
                notification.setTitle("Saturation Low at "+date.toString());

                myRef.push().setValue(notification);
                count++;
            }


            Log.d("Temp:",t[0].replaceAll("^\"|\"$", ""));






        }


        public JSONObject getPlaceJSON(String urlString){
            InputStream inputStream;
            String result="";
            JSONObject jsonObject = null;
            HttpURLConnection httpURLConnection;
            try{
                URL url = new URL(urlString);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                inputStream = httpURLConnection.getInputStream();

                if(inputStream!=null){
                    result = convertInputStreamToString(inputStream);
                    return new JSONObject(result);
                }
            }catch(MalformedURLException ex){
                Log.w("Error",ex.getMessage());
            }catch (IOException ex){
                Log.w("Error",ex.getMessage());
            }catch (JSONException ex){
                Log.w("Error",ex.getMessage());
            }

            return jsonObject;
        }


        private String convertInputStreamToString(InputStream inputStream) throws IOException{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String result = "";
            while ((line = bufferedReader.readLine())!= null){
                result += line;
            }
            inputStream.close();
            return result;
        }


    }
}
