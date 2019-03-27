package com.example.beszedkepes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper  extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Login.db";
    public static final String TABLE_NAME = "user";

    public static final String DATA_1 = "ID";
    public static final String DATA_2 = "name";
    public static final String DATA_3 = "username";
    public static final String DATA_4 = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID integer primary key AUTOINCREMENT, name text, username text , password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TABLE_NAME);
    }


    public boolean insertUser(String name, String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATA_2,name);
        contentValues.put(DATA_3,username);
        contentValues.put(DATA_4,password);
        long ins = db.insert(TABLE_NAME,null,contentValues);
        if(ins==-1)
        {
            return false;
        }
        else
            return true;
    }

    public Cursor chkuser(String username)
    {
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select username, password from " + TABLE_NAME + " where username=" + "'" + username + "'" , null);
        return cursor;
    }
}
