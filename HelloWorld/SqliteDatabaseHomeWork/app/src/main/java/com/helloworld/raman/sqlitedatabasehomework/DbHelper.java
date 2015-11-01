package com.helloworld.raman.sqlitedatabasehomework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by raman on 1/11/15.
 */
public class DbHelper extends SQLiteOpenHelper {

    //DB name
    private static final String dB_Name="studentDatabase";

    //DB version
    private static final int dB_Version=1;

    //table name
    private static final String table_Name = "STUDENT_TABLE";

    //student's name
    private static final String students_Name = "STUDENTS_NAME";

    //Roll Nummber
    private static final String roll_No = "ROLL_NO";

    //Query for creating a table
    private static final String query = "CREATE TABLE IF NOT EXISTS "+table_Name+"( "+roll_No+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+students_Name+" TEXT)";

    //drop query
    private static final String dropQuery = "DROP TABLE "+table_Name;

    public DbHelper(Context context) {
        super(context, dB_Name, null, dB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    public void addData(String students){
        SQLiteDatabase writableDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(students_Name,students);
        writableDatabase.insert(table_Name, null, values);
        writableDatabase.close();
    }

    public ArrayList<String> retrieve(){
        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM "+table_Name;

        Cursor cursor = readableDatabase.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        ArrayList<String> studentList = new ArrayList<String>();

        while(!cursor.isAfterLast()){
            String studentName = cursor.getString(cursor.getColumnIndex(students_Name));

            studentList.add(studentName);

            cursor.moveToNext();
        }
        cursor.close();
        readableDatabase.close();

        return studentList;

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropQuery);
        onCreate(db);
    }
}
