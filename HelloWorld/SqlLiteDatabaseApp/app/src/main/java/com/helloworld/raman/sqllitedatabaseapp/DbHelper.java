package com.helloworld.raman.sqllitedatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by raman on 1/11/15.
 */
public class DbHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "StudentsDb";

    private static final int DB_VERSION = 3;

    private static final String TABLE_NAME = "StudentsInfo";

    private static String studentName = "StudentsName";

    private static final String rollNo = "Roll_No";

    private static final String query = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"( "+rollNo+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+studentName+" TEXT)";


    private static final String dropQuery = " DROP TABLE " +TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    public void addData() {

        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        String[] names = {"RAMAN","LAKSHMAN","LAVA","KUSHA","SITA","HANUMAN"};

        for (int i = 0; i < names.length; i++) {
            ContentValues values = new ContentValues();
            values.put(studentName, names[i]);
            writableDatabase.insert(TABLE_NAME, null, values);

        }
        writableDatabase.close();
    }

    public ArrayList<String> retrieveData(){
        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = readableDatabase.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        ArrayList<String> list = new ArrayList<String>();

        while(!cursor.isAfterLast()){
            String name = cursor.getString(cursor.getColumnIndex(studentName));

            list.add(name);

            cursor.moveToNext();
        }
        cursor.close();
        readableDatabase.close();

        return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropQuery);
        onCreate(db);
    }
}
