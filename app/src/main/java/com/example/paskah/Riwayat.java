package com.example.paskah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class Riwayat extends AppCompatActivity {
    private String[] rwyt = {"Riwayat Bacaan","Riwayat Peristiwa","Riwayat Lagu"};

    private ArrayList<String> data;

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

        lv = (ListView) findViewById(R.id.list);

        data = new ArrayList<>();

        Collections.addAll(data, rwyt);

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, R.layout.support_simple_spinner_dropdown_item, data);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String getRwyt = data.get(position);

                //Berpindah Activity dan Mempassing data Nama pada Activity Selanjutnya
                Intent sendData = new Intent(Riwayat.this, Detail.class);
                sendData.putExtra("MyRwyt", getRwyt);
                startActivity(sendData);
            }
        });
    }
}