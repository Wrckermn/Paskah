package com.example.paskah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity3 extends AppCompatActivity {
    private String[] mat = {"Yesus ditangkap","Yesus diadili","Yesus disalibkan","Yesus dikubur","Penemuan Luar Biasa Wanita",
            "Saksi-Saksi Palsu","Amanat Tuhan yang Bangkit"};

    private String[] mar = {"Yesus di Taman Getsemani","Pengadilan Yahudi","Pengadilan Romawi","Penyaliban dan Penguburan","Penemuan Kebangkitan",
            "Penampilan Pasca Kebangkitan","Kenaikan dan Penugasan Para Rasul"};

    private String[] luk = {"Getsemani dan Pengkhianatan","Pengadilan Yahudi","Pengadilan Romawi","Penyaliban","Penguburan",
            "Pagi Kebangkitan","Penampakan Diri Tuhan","Pesan-Pesan Perpisahan"};

    private String[] yoh = {"Penangkapan","Pengadilan Yahudi","Pengadilan Romawi","Penyaliban","Penguburan",
            "Tuhan Yang Bangkit"};

    private ArrayList<String> data, data2, data3, data4;

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lv = (ListView) findViewById(R.id.list);

        data = new ArrayList<>();
        data2 = new ArrayList<>();
        data3 = new ArrayList<>();
        data4 = new ArrayList<>();

        String book_name = getIntent().getStringExtra("book_name");

        switch (book_name){
            case "Matius":
                Collections.addAll(data, mat);
                ArrayAdapter<String> adapter = new ArrayAdapter<>
                        (this, R.layout.support_simple_spinner_dropdown_item, data);
                lv.setAdapter(adapter);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String getMat = data.get(position);

                        DBControl dbControl = new DBControl(getBaseContext());
                        SQLiteDatabase create = dbControl.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put(DBControl.MyColumns.peristiwa, getMat);
                        create.insert(DBControl.MyColumns.NamaTabel, null, values);

                        //Berpindah Activity dan Mempassing data Nama pada Activity Selanjutnya
                        Intent sendData = new Intent(MainActivity3.this, Matius.class);
                        sendData.putExtra("MyMat", getMat);
                        startActivity(sendData);
                    }
                });
                break;

            case "Markus":
                Collections.addAll(data, mar);
                ArrayAdapter<String> adapterr = new ArrayAdapter<>
                        (this, R.layout.support_simple_spinner_dropdown_item, data);
                lv.setAdapter(adapterr);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String getMar = data.get(position);

                        DBControl dbControl = new DBControl(getBaseContext());
                        SQLiteDatabase create = dbControl.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put(DBControl.MyColumns.peristiwa, getMar);
                        create.insert(DBControl.MyColumns.NamaTabel, null, values);

                        //Berpindah Activity dan Mempassing data Nama pada Activity Selanjutnya
                        Intent sendData = new Intent(MainActivity3.this, Markus.class);
                        sendData.putExtra("MyMar", getMar);
                        startActivity(sendData);
                    }
                });
                break;

            case "Lukas":
                Collections.addAll(data, luk);
                ArrayAdapter<String> adapterrr = new ArrayAdapter<>
                        (this, R.layout.support_simple_spinner_dropdown_item, data);
                lv.setAdapter(adapterrr);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String getLuk = data.get(position);

                        DBControl dbControl = new DBControl(getBaseContext());
                        SQLiteDatabase create = dbControl.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put(DBControl.MyColumns.peristiwa, getLuk);
                        create.insert(DBControl.MyColumns.NamaTabel, null, values);

                        //Berpindah Activity dan Mempassing data Nama pada Activity Selanjutnya
                        Intent sendData = new Intent(MainActivity3.this, Lukas.class);
                        sendData.putExtra("MyLuk", getLuk);
                        startActivity(sendData);
                    }
                });
                break;

            case "Yohanes":
                Collections.addAll(data, yoh);
                ArrayAdapter<String> adapterrrr = new ArrayAdapter<>
                        (this, R.layout.support_simple_spinner_dropdown_item, data);
                lv.setAdapter(adapterrrr);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String getYoh = data.get(position);

                        DBControl dbControl = new DBControl(getBaseContext());
                        SQLiteDatabase create = dbControl.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put(DBControl.MyColumns.peristiwa, getYoh);
                        create.insert(DBControl.MyColumns.NamaTabel, null, values);

                        //Berpindah Activity dan Mempassing data Nama pada Activity Selanjutnya
                        Intent sendData = new Intent(MainActivity3.this, Yohanes.class);
                        sendData.putExtra("MyYoh", getYoh);
                        startActivity(sendData);
                    }
                });
                break;
        }
    }
}