package com.example.paskah;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBControl extends SQLiteOpenHelper {
    static abstract class MyColumns implements BaseColumns {
        static final String NamaTabel = "riwayat";
        static final String id = "id";
        static final String bacaan = "bacaan";
        static final String peristiwa = "peristiwa";
        static final String lagu = "lagu";
    }

    private static final String db_name ="paskah.db";
    private static final int db_version=1;

    private static final String db_create = "CREATE TABLE "
            +MyColumns.NamaTabel+ "("
            +MyColumns.id+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +MyColumns.bacaan+ " TEXT NOT NULL, "
            +MyColumns.peristiwa+ " TEXT NOT NULL, "
            +MyColumns.lagu+ " TEXT NOT NULL );";

    private static final String db_delete = "DROP TABLE IF EXISTS "+MyColumns.NamaTabel;

    public DBControl(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(db_delete);
        onCreate(db);
    }
}
