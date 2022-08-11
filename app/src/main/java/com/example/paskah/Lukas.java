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

public class Lukas extends AppCompatActivity {
    private String TAG = Lukas.class.getSimpleName();

    private ProgressDialog pDialog;

    private ListView lv;

    private TextView tv;

    // URL to get contacts JSON
    private static String url = "https://api-alkitab.herokuapp.com/v2/passage/Luk/22?ver=tb";

    private static String url1 = "https://api-alkitab.herokuapp.com/v2/passage/Luk/23?ver=tb";

    private static String url2 = "https://api-alkitab.herokuapp.com/v2/passage/Luk/24?ver=tb";

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lukas);

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
            pDialog = new ProgressDialog(Lukas.this);
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

            String getLuk = getIntent().getStringExtra("MyLuk");

            tv.setText(getLuk);

            Log.e(TAG, "Response from url: " + jsonStr);
            Log.e(TAG, "Response from url: " + jsonStr1);
            Log.e(TAG, "Response from url: " + jsonStr2);

            if (jsonStr != null) {
                try {
                    switch (getLuk){
                        case "Getsemani dan Pengkhianatan":
                            JSONObject jsonObj = new JSONObject(jsonStr);

                            // Getting JSON Array node
                            JSONArray provinsis = jsonObj.getJSONArray("verses");


                            // looping through All Contacts
                            for (int i = 38; i < 53; i++) {
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
                            for (int i = 53; i < provinsis1.length(); i++) {
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
                            JSONObject jsonObj2 = new JSONObject(jsonStr1);

                            // Getting JSON Array node
                            JSONArray provinsis2 = jsonObj2.getJSONArray("verses");

                            // looping through All Contacts
                            for (int i = 0; i < 25; i++) {
                                JSONObject c = provinsis2.getJSONObject(i);

                                String content = c.getString("content");

                                // tmp hash map for single contact
                                HashMap<String, String> data = new HashMap<>();

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
                            for (int i = 25; i < 49; i++) {
                                JSONObject c = provinsis3.getJSONObject(i);

                                String content = c.getString("content");

                                // tmp hash map for single contact
                                HashMap<String, String> data = new HashMap<>();

                                // adding each child node to HashMap key => value
                                data.put("content", content);

                                // adding contact to contact list
                                contactList.add(data);
                            }
                            break;
                        case "Penguburan":
                            JSONObject jsonObj4 = new JSONObject(jsonStr1);

                            // Getting JSON Array node
                            JSONArray provinsis4 = jsonObj4.getJSONArray("verses");

                            // looping through All Contacts
                            for (int i = 49; i < provinsis4.length(); i++) {
                                JSONObject c = provinsis4.getJSONObject(i);

                                String content = c.getString("content");

                                // tmp hash map for single contact
                                HashMap<String, String> data = new HashMap<>();

                                // adding each child node to HashMap key => value
                                data.put("content", content);

                                // adding contact to contact list
                                contactList.add(data);
                            }
                            break;
                        case "Pagi Kebangkitan":
                            JSONObject jsonObj5 = new JSONObject(jsonStr2);

                            // Getting JSON Array node
                            JSONArray provinsis5 = jsonObj5.getJSONArray("verses");

                            // looping through All Contacts
                            for (int i = 0; i < 12; i++) {
                                JSONObject c = provinsis5.getJSONObject(i);

                                String content = c.getString("content");

                                // tmp hash map for single contact
                                HashMap<String, String> data = new HashMap<>();

                                // adding each child node to HashMap key => value
                                data.put("content", content);

                                // adding contact to contact list
                                contactList.add(data);
                            }
                            break;
                        case "Penampakan Diri Tuhan":
                            JSONObject jsonObj6 = new JSONObject(jsonStr2);

                            // Getting JSON Array node
                            JSONArray provinsis6 = jsonObj6.getJSONArray("verses");

                            // looping through All Contacts
                            for (int i = 12; i < 43; i++) {
                                JSONObject c = provinsis6.getJSONObject(i);

                                String content = c.getString("content");

                                // tmp hash map for single contact
                                HashMap<String, String> data = new HashMap<>();

                                // adding each child node to HashMap key => value
                                data.put("content", content);

                                // adding contact to contact list
                                contactList.add(data);
                            }
                            break;
                        case "Pesan-Pesan Perpisahan":
                            JSONObject jsonObj7 = new JSONObject(jsonStr2);

                            // Getting JSON Array node
                            JSONArray provinsis7 = jsonObj7.getJSONArray("verses");

                            // looping through All Contacts
                            for (int i = 43; i < 53; i++) {
                                JSONObject c = provinsis7.getJSONObject(i);

                                String content = c.getString("content");

                                // tmp hash map for single contact
                                HashMap<String, String> data = new HashMap<>();

                                // adding each child node to HashMap key => value
                                data.put("content", content);

                                // adding contact to contact list
                                contactList.add(data);
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
                    Lukas.this, contactList,
                    R.layout.list_lukas, new String[]{"content"}, new int[]{R.id.conten});

            lv.setAdapter(adapter);
        }

    }
}