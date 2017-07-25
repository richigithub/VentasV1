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
    public void insert(int _id, String nombre_cliente, int grueso, int parejo, int richi,
                            int total, double gruesoPrecio, double parejoPrecio, double richiPrecio
                            , double cgPorPg, double cpPorPp, double crPorPr, double totalPrecio
                            , double abono, double saldo, int cantidad_dani, int cantidad_richard){
        ContentValues contentValue = new ContentValues();
        contentValue.put("_ID", _id);
        contentValue.put("CLIENTE", nombre_cliente);
        contentValue.put("GRUESO", grueso);
        contentValue.put("PAREJO",parejo);
        contentValue.put("RICHI", richi);
        contentValue.put("TOTAL",total);
        contentValue.put("GRUESOP", gruesoPrecio);
        contentValue.put("CG*PG", cgPorPg);
        contentValue.put("PAREJOP",parejoPrecio);
        contentValue.put("CP*PP",cpPorPp);
        contentValue.put("RICHIP",richiPrecio);
        contentValue.put("CR*PR",crPorPr);
        contentValue.put("TOTALP",totalPrecio);
        contentValue.put("ABONO",abono);
        contentValue.put("SALDO",saldo);
        contentValue.put("DANI",cantidad_dani);
        contentValue.put("RICHARD",cantidad_richard);
        database.insert(DataBaseHelper.TABLE_NAME, null, contentValue);
    }
    public Cursor fetch(){
        String [] columns = new String[]{DataBaseHelper.COL_ID,DataBaseHelper.COL_GRUESO,
                DataBaseHelper.COL_PAREJO, DataBaseHelper.COL_RICHI, DataBaseHelper.COL_TOTAL
                , DataBaseHelper.COL_GRUESOP,DataBaseHelper.COL_CGFORPG, DataBaseHelper.COL_PAREJOP
                , DataBaseHelper.COL_CPFORPP, DataBaseHelper.COL_RICHIP, DataBaseHelper.COL_CRFORPR
                , DataBaseHelper.COL_TOTALP, DataBaseHelper.COL_ABONO, DataBaseHelper.COL_SALDO
                , DataBaseHelper.COL_DANI, DataBaseHelper.COL_RICHARD};
        Cursor cursor = database.query(DataBaseHelper.TABLE_NAME, columns, null,
                null, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update (long _id, String nombre_cliente, int grueso, int parejo, int richi,
                       int total, double gruesoPrecio, double parejoPrecio, double richiPrecio
            , double cgPorPg, double cpPorPp, double crPorPr, double totalPrecio
            , double abono, double saldo, int cantidad_dani, int cantidad_richard){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.NOMBRE_CLIENTE, nombre_cliente);
        contentValues.put(DataBaseHelper.COL_GRUESO, grueso);
        contentValues.put(DataBaseHelper.COL_PAREJO, parejo);
        contentValues.put(DataBaseHelper.COL_RICHI, richi);
        contentValues.put(DataBaseHelper.COL_GRUESOP, gruesoPrecio);
        contentValues.put(DataBaseHelper.COL_CGFORPG, cgPorPg);
        contentValues.put(DataBaseHelper.COL_PAREJOP, parejoPrecio);
        contentValues.put(DataBaseHelper.COL_CPFORPP, cpPorPp);
        contentValues.put(DataBaseHelper.COL_RICHIP, richiPrecio);
        contentValues.put(DataBaseHelper.COL_CRFORPR, crPorPr);
        contentValues.put(DataBaseHelper.COL_TOTALP, totalPrecio);
        contentValues.put(DataBaseHelper.COL_ABONO, abono);
        contentValues.put(DataBaseHelper.COL_SALDO, saldo);
        contentValues.put(DataBaseHelper.COL_DANI, cantidad_dani);
        contentValues.put(DataBaseHelper.COL_RICHARD, cantidad_richard);
        int i = database.update(DataBaseHelper.TABLE_NAME, contentValues,
                            DataBaseHelper.COL_ID + "="+ _id, null);
        return  i;
    }
    public void delete (long _id){
        database.delete(DataBaseHelper.TABLE_NAME, DataBaseHelper.COL_ID +"="
                        +_id, null);
    }
}
