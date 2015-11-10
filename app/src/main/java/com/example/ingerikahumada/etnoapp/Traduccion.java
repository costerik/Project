package com.example.ingerikahumada.etnoapp;

import android.provider.BaseColumns;

/**
 * Created by Ing. Erik Ahumada on 10/11/2015.
 */
public class Traduccion{
    public Traduccion(){}

    public static abstract class HistoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "History";
        //public static final String COLUMN_NAME_ENTRY_ID = "traduccionId";
        public static final String COLUMN_NAME_ESPAÑOL = "español";
        public static final String COLUMN_NAME_WAYUUNAIKI = "wayuunaiki";
    }
}
