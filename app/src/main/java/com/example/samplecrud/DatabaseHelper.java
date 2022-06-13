package com.example.samplecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String APP_TABLE = "APP_TABLE";
    public static final String COLUMN_STUDENT_ID = "STUDENT_ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_ADDRESS = "ADDRESS";

    public DatabaseHelper(@Nullable Context context) {
        super(context,APP_TABLE +".db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + APP_TABLE + "(" + COLUMN_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " STRING," + COLUMN_ADDRESS + " STRING )";
        db.execSQL(query);

    }
public boolean AddOne(DataModel dataModel) {
    SQLiteDatabase db = getWritableDatabase();
    ContentValues cv = new ContentValues();
    cv.put(COLUMN_STUDENT_ID, dataModel.getStudentID());
    cv.put(COLUMN_NAME, dataModel.getName());
    cv.put(COLUMN_ADDRESS, dataModel.getAddress());
    long insert = db.insert(APP_TABLE, null, cv);
    if (insert == -1) {
        return false;
    } else {

        return true;
    }
}
public List<DataModel> Read(){
        List<DataModel> returnList = new ArrayList<>();
        String select = "SELECT * FROM "+APP_TABLE;
        SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.rawQuery(select, null);
    if (cursor.moveToFirst()) {
        do {
            int dataID = cursor.getInt(0);
            String name = cursor.getString(1);
            String address = cursor.getString(2);
            DataModel dataModel = new DataModel(dataID, name, address);
            returnList.add(dataModel);


        } while (cursor.moveToNext());


        }
    else{

        }
    cursor.close();
    db.close();
    return returnList;
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
