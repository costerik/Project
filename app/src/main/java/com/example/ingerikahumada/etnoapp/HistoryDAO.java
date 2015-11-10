package com.example.ingerikahumada.etnoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Ing. Erik Ahumada on 10/11/2015.
 */
public class HistoryDAO {
    private static final String TAG="AndroidDatabase";
    private SQLiteDatabase mDatabase;
    private TraduccionDbHelper mDbHelper;

    public HistoryDAO(Context context){
        mDbHelper=new TraduccionDbHelper(context);
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on opening database" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException{
        mDatabase=mDbHelper.getWritableDatabase();
    }

    public void close(){
        mDbHelper.close();
    }

    public long addEntry(String español, String wayuunaiki){
        long index;
        ContentValues data=new ContentValues();
        data.put(Traduccion.HistoryEntry.COLUMN_NAME_ESPAÑOL,español);
        data.put(Traduccion.HistoryEntry.COLUMN_NAME_WAYUUNAIKI,wayuunaiki);

        index=mDatabase.insert(Traduccion.HistoryEntry.TABLE_NAME,null,data);

        Log.d(TAG, "add data entry returned index " + index);
        return index;
    }

    public ArrayList<String> getData(){
        //mDatabase=mDbHelper.getReadableDatabase();
        ArrayList<String> list=new ArrayList();
        String query="SELECT * FROM "+Traduccion.HistoryEntry.TABLE_NAME;
        Cursor cursor=mDatabase.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Log.d(TAG, "obtaining data... ");
                //String data=" id :"+cursor.getString(1)+ " Name: "+cursor.getString(2)+" LastName: "+cursor.getString(3);
                String data="  Español: "+cursor.getString(1)+ " Wayuunaiki: "+cursor.getString(2);
                list.add(data);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public boolean deleteTitle(String id)
    {
        return mDatabase.delete(Traduccion.HistoryEntry.TABLE_NAME, Traduccion.HistoryEntry._ID + "=" + id, null) > 0;
    }

    public boolean updateElement(String id,String español,String wayuunaiki){
        ContentValues cv=new ContentValues();
        cv.put(Traduccion.HistoryEntry.COLUMN_NAME_ESPAÑOL, español);
        cv.put(Traduccion.HistoryEntry.COLUMN_NAME_WAYUUNAIKI, wayuunaiki);
        return mDatabase.update(Traduccion.HistoryEntry.TABLE_NAME, cv, Traduccion.HistoryEntry._ID + "=" + id, null)>0;
    }
}
