package com.example.ingerikahumada.etnoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ing. Erik Ahumada on 10/11/2015.
 */
public class TraduccionDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATA_BASE_NAME="Traduccion.db";
    private static final String TEXT_TYPE=" TEXT";
    public static final String COMMA_SEP=",";
    private static final String SQL_CREATE_ENTRIES=
            "CREATE TABLE " + Traduccion.HistoryEntry.TABLE_NAME+" ( "+
                    Traduccion.HistoryEntry._ID + " INTEGER PRIMARY KEY, " +
                    Traduccion.HistoryEntry.COLUMN_NAME_ESPAÑOL+TEXT_TYPE+COMMA_SEP+
                    Traduccion.HistoryEntry.COLUMN_NAME_WAYUUNAIKI+TEXT_TYPE+")";

    private static final String SQL_DELETE_ENTRIES=
            "DROP TABLE IF EXISTS "+ Traduccion.HistoryEntry.TABLE_NAME;

    public TraduccionDbHelper(Context context){
        super(context,DATA_BASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
