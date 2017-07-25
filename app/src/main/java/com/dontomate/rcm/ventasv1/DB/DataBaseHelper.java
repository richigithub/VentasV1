package com.dontomate.rcm.ventasv1.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ricardo on 24/07/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    //Table Name
    public  static  final String TABLE_NAME = "VENTAS";

    //Table Columns
    public static final String COL_ID = "_ID";
    public static final String NOMBRE_CLIENTE = "Cliente";
    public static final String COL_GRUESO = "GRUESO";
    public static final String COL_PAREJO = "PAREJO";
    public static final String COL_RICHI = "RICHI";
    public static final String COL_TOTAL = "TOTAL";
    public static final String COL_GRUESOP = "GRUESOP";
    public static final String COL_CGFORPG = "CG*PG";
    public static final String COL_PAREJOP = "PAREJOP";
    public static final String COL_CPFORPP = "CP*PP";
    public static final String COL_RICHIP = "RICHIP";
    public static final String COL_CRFORPR = "CR*PR";
    public static final String COL_TOTALP = "TOTALP";
    public static final String COL_ABONO = "ABONO";
    public static final String COL_SALDO = "SALDO";
    public static final String COL_DANI = "DANI";
    public static final String COL_RICHARD = "RICHARD";

    //Database information
    static final String DB_NAME = "VentasDB";
    //database version
    static  final int DB_VERSION = 1;

    //Creating table query
    private static final String CREATE_TABLE = "create table "+ TABLE_NAME + "("+ COL_ID
                                                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                + NOMBRE_CLIENTE + " TEXT NOT NULL, "
                                                + COL_GRUESO + " INTEGER, "
                                                + COL_PAREJO + " INTEGER, "
                                                + COL_RICHI  + " INTEGER, "
                                                + COL_TOTAL  + " INTEGER, "
                                                + COL_GRUESOP + " REAL, "
                                                + COL_CGFORPG + " REAL, "
                                                + COL_PAREJOP + " REAL, "
                                                + COL_CPFORPP + " REAL, "
                                                + COL_RICHIP  + " REAL, "
                                                + COL_CRFORPR + " REAL, "
                                                + COL_TOTALP + " REAL, "
                                                +COL_ABONO + " REAL, "
                                                +COL_SALDO + " REAL, "
                                                +COL_DANI +" INTEGER, "
                                                +COL_RICHARD +" INTEGER);";
    public DataBaseHelper(Context context){
        super(context, DB_NAME, null,DB_VERSION);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
}
