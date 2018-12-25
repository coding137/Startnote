package com.devStereo.owls.diary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

/**
 * Created by Cloud on 2017-03-12.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sql) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void queryDate(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

    }

    public void insertData(String topic, String contents){
        SQLiteDatabase database =getWritableDatabase();
        String sql= "INSERT INTO MEMO VALUES(NULL, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, topic);
        statement.bindString(2, contents);


        statement.executeInsert();
    }

    public void editData(String topic, String contents, String id){
        String sql= "UPDATE MEMO set topic= ? , contents = ? where Tid = ?";
        Log.d("Edit Data : "," Topic : "+topic+" contents : "+contents+ " id : "+id);

        SQLiteDatabase database =getWritableDatabase();
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, topic);
        statement.bindString(2, contents);
        statement.bindString(3, id);

        statement.executeInsert();
    }
    public void deleteData(String id){
        String sql= "DELETE FROM MEMO where Tid = ?";
        SQLiteDatabase database =getWritableDatabase();
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, id);

        statement.executeInsert();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);

    }
}
