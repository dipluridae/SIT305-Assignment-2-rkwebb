package com.example.lprecordlibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;



public class DatabaseHelper extends SQLiteOpenHelper
{

    // Database name
    public static final String DATABASE_NAME = "lp.db";
    public static final int DATABASE_VERSION = 1;

    // user table
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "user_id";
    public static final String COLUMN_USER = "username";
    public static final String COLUMN_PWD = "password";

    // record table
    public static final String TABLE1_NAME = "album";
    public static final String COLUMN1_ID = "record_id";
    public static final String COLUMN1_ALBUM = "albumName";
    public static final String COLUMN1_ARTIST = "artistName";
    public static final String COLUMN1_LABEL = "labelName";
    public static final String COLUMN1_YEAR = "albumYear";
    public static final String COLUMN1_OWNER = "ownerName";

    // owner table
    public static final String TABLE2_NAME = "owners";
    public static final String COLUMN2_ID = "owner_id";
    public static final String COLUMN2_OWNER = "owner2Name";
    public static final String COLUMN2_STREET = "ownerStreet";
    public static final String COLUMN2_SUBURB = "ownerSuburb";
    public static final String COLUMN2_POSTCODE = "ownerPostCode";
    public static final String COLUMN2_STATE = "ownerState";
    public static final String COLUMN2_PHONE = "ownerPhone";
    public static final String COLUMN2_C_DAYS = "ownerDays";
    public static final String COLUMN2_C_TIME = "ownerTimes";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE users (user_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
        db.execSQL("CREATE TABLE album (record_id INTEGER PRIMARY KEY AUTOINCREMENT, albumName TEXT, artistName TEXT, labelName TEXT, albumYear Text, ownerName TEXT)");
        db.execSQL("CREATE TABLE owners (owner_id INTEGER PRIMARY KEY AUTOINCREMENT, owner2Name TEXT, ownerStreet TEXT, ownerSuburb TEXT, ownerPostCode TEXT, ownerState TEXT, ownerPhone TEXT, ownerDays TEXT, ownerTimes TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);

        onCreate(db);
    }

    // insert username and password
    public long insert1 (String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long newRowId = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return newRowId;
    }

    // insert Record data
    public long insert2(String albumName, String artistName, String recordLabel, String year, String owner)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("albumName", albumName);
        contentValues.put("artistName", artistName);
        contentValues.put("labelName", recordLabel);
        contentValues.put("albumYear", year);
        contentValues.put("ownerName", owner);

        long newRowId = db.insert(TABLE1_NAME, null, contentValues);
        db.close();
        return newRowId;
    }

    // insert owner data
    public long insert3(String owner2Name, String ownerStreet, String ownerSuburb, String ownerPostCode, String ownerState, String ownerPhone, String ownerDays, String ownerTimes)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("owner2Name", owner2Name);
        contentValues.put("ownerStreet", ownerStreet);
        contentValues.put("ownerSuburb", ownerSuburb);
        contentValues.put("ownerPostCode", ownerPostCode);
        contentValues.put("ownerState", ownerState);
        contentValues.put("ownerPhone", ownerPhone);
        contentValues.put("ownerDays", ownerDays);
        contentValues.put("ownerTimes", ownerTimes);

        long newRowId = db.insert(TABLE2_NAME, null, contentValues);
        db.close();
        return newRowId;
    }

    // Determine if user is registered
    public boolean fetchUser (String username, String password)
    {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"user_id"};
        String selection = COLUMN_USER + "= ? and " + COLUMN_PWD + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        int numberOfRows = cursor.getCount();
        cursor.close();
        db.close();

        if (numberOfRows > 0)
            return true;
        else
            return false;
    }

    // Determine if Album is in database
    public boolean  fetchAlbum (String albumName, String artistName)
    {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"record_id"};
        String selection = COLUMN1_ALBUM + "= ? and " + COLUMN1_ARTIST + "=?";
        String[] selectionArgs = {albumName, artistName};
        Cursor cursor = db.query(TABLE1_NAME, columns, selection, selectionArgs, null, null, null);

        int numberOfRows = cursor.getCount();
        cursor.close();
        db.close();
        // indicates Album name is found
        if (numberOfRows > 0)
            return true;
        else
            return false;
    }
    // Determine if Owner is in database
    public boolean  fetchOwner (String ownerName)
    {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"owner_id"};
        String selection = COLUMN2_OWNER + "= ?";
        String[] selectionArgs = {ownerName};
        Cursor cursor = db.query(TABLE2_NAME, columns, selection, selectionArgs, null, null, null);
        int numberOfRows = cursor.getCount();
        cursor.close();
        db.close();
        // indicates Owner name found
        if (numberOfRows > 0)
            return true;
        else
            return false;
    }

    }


