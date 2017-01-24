package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import  com.example.android.pets.data.PetContract.PetEntry;
/**
 * Created by Ning on 1/17/2017.
 */

// DB Help class needs to:
    // 1. extends from SQLiteOpenHelper
    // 2. Proivde a constructor
    // 3. Override OnCreate method
    // 4. Override OnUpgrade method


public class PetDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pets.db"; // a string represents db name
    private static final int DATABASE_VERSION = 1;

    public  PetDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    // String used to create the database
    private static final String CREATE_DATABASE = "CREATE TABLE " + PetEntry.TABLE_NAME  + " (" +
            PetEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, " +
            PetEntry.COLUMN_PET_BREED + " TEXT, " +
            PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL DEFAULT 0, " +
            PetEntry.COLUMN_PET_WEIGHT + " INTEGER);";

    private static final String DELETE_DATABASE = "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_DATABASE);
        onCreate(db);
    }
}
