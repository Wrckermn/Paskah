package com.example.paskah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Yohanes extends AppCompatActivity {
    private String TAG = Yohanes.class.getSimpleName();

    private ProgressDialog pDialog;

    private ListView lv;

    private TextView tv;

    // URL to get contacts JSON
    private static String url = "https://api-alkitab.herokuapp.com/v2/passage/Yoh/18?ver=tb";

    private static String url1 = "https://api-alkitab.herokuapp.com/v2/passage/Yoh/19?ver=tb";

    private static String url2 = "https://api-alkitab.herokuapp.com/v2/passage/Yoh/20?ver=tb";

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yohanes);

        contactList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);
        tv = (TextView) findViewById(R.id.textView);

        new GetContacts().execute();
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Yohanes.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            HttpHandler sh1 = new HttpHandler();
            HttpHandler sh2 = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            String jsonStr1 = sh1.makeServiceCall(url1);
            String jsonStr2 = sh2.makeServiceCall(url2);

            String getYoh = getIntent().getStringExtra("MyYoh");

            tv.setText(getYoh);

            Log.e(TAG, "Response from url: " + jsonStr);
            Log.e(TAG, "Response from url: " + jsonStr1);
            Log.e(TAG, "Response from url: " + jsonStr2);

            if (jsonStr != null) {
                try {
                    switch (getYoh){
                        case "Penangkapan":
                            JSONObject jsonObj = new JSONObject(jsonStr);

                            // Getting JSON Array node
                            JSONArray provinsis = jsonObj.getJSONArray("verses");


                            // looping through All Contacts
                            for (int i = 0; i < 12; i++) {
                                JSONObject c = provinsis.getJSONObject(i);

                                String content = c.getString("content");

                                // tmp hash map for single contact
                                HashMap<String, String> data = new HashMap<>();

                                // adding each child node to HashMap key => value
                                data.put("content", content);

                                // adding contact to contact list
                                contactList.add(data);
                            }
                            break;
                        case "Pengadilan Yahudi":
                            JSONObject jsonObj1 = new JSONObject(jsonStr);

                            // Getting JSON Array node
                            JSONArray provinsis1 = jsonObj1.getJSONArray("verses");

                            HashMap<String, String> data1;

                            // looping through All Contacts
                            for (int i = 12; i < 27; i++) {
                                JSONObject c = provinsis1.getJSONObject(i);

                                String contentt = c.getString("content");

                                // tmp hash map for single contact
                                data1 = new HashMap<>();

                                // adding each child node to HashMap key => value
                                data1.put("content", contentt);

                                // adding contact to contact list
                                contactList.add(data1);
                            }
                            break;
                        case "Pengadilan Romawi":
                            JSONObject jsonObj2 = new JSONObject(jsonStr);
                            JSONObject jsonObjj = new JSONObject(jsonStr1);

                            // Getting JSON Array node
                            JSONArray provinsis2 = jsonObj2.getJSONArray("verses");
                            JSONArray provinsiss = jsonObjj.getJSONArray("verses");

                            HashMap<String, String> data;

                            // looping through All Contacts
                            for (int i = 27; i < provinsis2.length(); i++) {
                                JSONObject c = provinsis2.getJSONObject(i);

                                String content = c.getString("content");

                                // tmp hash map for single contact
                                data = new HashMap<>();

                                // adding each child node to HashMap key => value
                                data.put("content", content);

                                // adding contact to contact list
                                contactList.add(data);
                            }
                            for (int i=0; i < 16; i++){
                                JSONObject d = provinsiss.getJSONObject(i);

                                String content = d.getString("content");

                                // tmp hash map for single contact
                                data = new HashMap<>();

                                // adding each child node to HashMap key => value
                                data.put("content", content);

                                // adding contact to contact list
                                contactList.add(data);
                            }
                            break;
                        case "Penyaliban":
                            JSONObject jsonObj3 = new JSONObject(jsonStr1);

                            // Getting JSON Array node
                            JSONArray provinsis3 = jsonObj3.getJSONArray("verses");

                            // looping through All Contacts
                            for (int i = 16; i < 37; i++) {
                                JSONObject c = provinsis3.getJSONObject(i);

                                String content = c.getString("content");

                                // tmp hash map for single contact
                                HashMap<String, String> dataa = new HashMap<>();

                                // adding each child node to HashMap key => value
                                dataa.put("content", content);

                                // adding contact to contact list
                                contactList.add(dataa);
                            }
                            break;
                        case "Penguburan":
                            JSONObject jsonObj4 = new JSONObject(jsonStr1);

                            // Getting JSON Array node
                            JSONArray provinsis4 = jsonObj4.getJSONArray("verses");

                            // looping through All Contacts
                            for (int i = 37; i < provinsis4.length(); i++) {
                                JSONObject c = provinsis4.getJSONObject(i);

                                String content = c.getString("content");

                                // tmp hash map for single contact
                                HashMap<String, String> dataa = new HashMap<>();

                                // adding each child node to HashMap key => value
                                dataa.put("content", content);

                                // adding contact to contact list
                                contactList.add(dataa);
                            }
                            break;
                        case "Tuhan Yang Bangkit":
                            JSONObject jsonObj5 = new JSONObject(jsonStr2);

                            // Getting JSON Array node
                            JSONArray provinsis5 = jsonObj5.getJSONArray("verses");

                            // looping through All Contacts
                            for (int i = 0; i < 29; i++) {
                                JSONObject c = provinsis5.getJSONObject(i);

                                String content = c.getString("content");

                                // tmp hash map for single contact
                                HashMap<String, String> dataa = new HashMap<>();

                                // adding each child node to HashMap key => value
                                dataa.put("content", content);

                                // adding contact to contact list
                                contactList.add(dataa);
                            }
                            break;
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    Yohanes.this, contactList,
                    R.layout.list_yohanes, new String[]{"content"}, new int[]{R.id.conten});

            lv.setAdapter(adapter);
        }

    }
}