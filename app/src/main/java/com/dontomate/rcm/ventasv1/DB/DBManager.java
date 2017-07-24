package com.dontomate.rcm.ventasv1.DB;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by Ricardo on 24/07/2017.
 */

public class DBManager {

    private DataBaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager (Context c){
        context = c;
    }
    public DBManager open() throws SQLException {
        dbHelper = new DataBaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public  void close() {
        dbHelper.close();
    }
    public void insert(String name, String desc){
        ContentValues contentValue = new ContentValues();
        
    }
}
