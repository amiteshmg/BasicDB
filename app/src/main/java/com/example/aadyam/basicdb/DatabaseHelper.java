package com.example.aadyam.basicdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Aadyam on 10/22/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "basicinfo.db";
    public static final String TABLE_NAME = "registration";
    public static final String COL1 = "name";
    public static final String COL2 = "address";
    public static final String COL3 = "contact";
    public static final String COL4 = "email";



    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME + "(Name TEXT,Address TEXT,Contact INTEGER,Email TEXT) ";

//    public DatabaseHelper(Context context) {
//        super(context, TABLE_NAME, null, 1);
//    }




    public DatabaseHelper(Context context) {
       // super(context, DATABASE_NAME, null, DATABASE_VERSION);
     super(context,DATABASE_NAME, null, DATABASE_VERSION);
        //super(context, Environment.getExternalStorageDirectory() + File.separator + DATABASE_NAME, null, DATABASE_VERSION);
    }




    //SQLiteDatabase db =


    @Override
    public void onCreate(SQLiteDatabase db)
    {


            db.openOrCreateDatabase(DATABASE_NAME,null);

            db.execSQL(SQL_CREATE_TABLE);

        //db.execSQL("CREATE DATABASE "+DATABASE_NAME);
        //this.getWritableDatabase();


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
       onCreate(db);
    }


    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

//error
    public boolean addData(String name, String address, String contact, String email) {
//error
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, name);
        contentValues.put(COL2, address);
        contentValues.put(COL3, contact);
        contentValues.put(COL4, email);

        Log.d(TAG, "adding data...." + name + "to db");
        Log.d(TAG, "adding data...." + address + "to db");
        Log.d(TAG, "adding data...." + contact + "to db");
        Log.d(TAG, "adding data...." + email + "to db");

        Long result = database.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public List<User> getDatabaseEntries() {

        List<User> userList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
               //user.setID(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(0));
                user.setAddress(cursor.getString(1));
                user.setContact(Long.parseLong(cursor.getString(2)));
                user.setEmail(cursor.getString(3));
                // Adding contact to list
                userList.add(user);
            } while (cursor.moveToNext());
        }

        // return contact list
        return userList;
    }

}
