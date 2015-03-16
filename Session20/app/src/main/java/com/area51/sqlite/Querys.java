package com.area51.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.area51.utils.Constant;

/**
 * Created by macbook on 3/16/15.
 */
public class Querys {

    Context context;
    ManageOpenHelper dbConexion;

    public Querys(Context context) {
        dbConexion = new ManageOpenHelper(context);
    }

    public void registrarPersona(String nombreCompleto) {
        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        String sql = "INSERT INTO " + Constant.TB_PERSONA + "(" + Constant.C_NOMBRE_APELLIDO + ") VALUES (" + nombreCompleto + ")";
        dbProcesos.execSQL(sql);
    }

    public boolean existeRegistro() {
        SQLiteDatabase dbProcesos = dbConexion.getReadableDatabase();
        String sql = "SELECT * FROM " + Constant.TB_PERSONA;
        Cursor cursor = dbProcesos.rawQuery(sql, null);
        return cursor.getCount() > 0 ? true : false;
    }

}
