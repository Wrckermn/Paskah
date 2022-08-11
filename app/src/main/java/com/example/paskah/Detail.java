package com.example.paskah;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    private ListView lv;

    private TextView tv;

    private DBControl MyDatabase;

    private ArrayList<String> ListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        lv = (ListView) findViewById(R.id.list);
        tv = (TextView) findViewById(R.id.textView);

        String getRwyt = getIntent().getStringExtra("MyRwyt");

        tv.setText(getRwyt);

        switch (getRwyt){
            case "Riwayat Bacaan":
                ListData = new ArrayList<>();
                MyDatabase = new DBControl(getBaseContext());
                //Mengambil Repository dengan Mode Membaca
                SQLiteDatabase ReadData = MyDatabase.getReadableDatabase();
                Cursor cursor = ReadData.rawQuery("SELECT * FROM "+ DBControl.MyColumns.NamaTabel,null);

                cursor.moveToFirst();//Memulai Cursor pada Posisi Awal

                //Melooping Sesuai Dengan Jumlan Data (Count) pada cursor
                for(int count=0; count < cursor.getCount(); count++){

                    cursor.moveToPosition(count);//Berpindah Posisi dari no index 0 hingga no index terakhir

                    ListData.add(cursor.getString(1));//Menambil Data Dari Kolom 1 (Nama)
                    //Lalu Memasukan Semua Datanya kedalam ArrayList
                }

                lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListData));
                break;
            case "Riwayat Pencarian":
                ListData = new ArrayList<>();
                MyDatabase = new DBControl(getBaseContext());
                //Mengambil Repository dengan Mode Membaca
                SQLiteDatabase ReadDataa = MyDatabase.getReadableDatabase();
                Cursor cursorr = ReadDataa.rawQuery("SELECT "+DBControl.MyColumns.peristiwa+" FROM "+ DBControl.MyColumns.NamaTabel,null);

                cursorr.moveToFirst();//Memulai Cursor pada Posisi Awal

                //Melooping Sesuai Dengan Jumlan Data (Count) pada cursor
                for(int count=0; count < cursorr.getCount(); count++){

                    cursorr.moveToPosition(count);//Berpindah Posisi dari no index 0 hingga no index terakhir

                    ListData.add(cursorr.getString(1));//Menambil Data Dari Kolom 1 (Nama)
                    //Lalu Memasukan Semua Datanya kedalam ArrayList
                }
                lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListData));
                break;
        }
    }
}