package com.area51.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.area51.models.Persona;
import com.area51.utils.Constant;

import java.util.ArrayList;

/**
 * Created by macbook on 2/27/15.
 */
public class Querys {

    private ManageOpenHelper dbConexion;
    Querys querys;

    public Querys(Context context) {
        dbConexion = new ManageOpenHelper(context);
    }

    public void insertarPersona(String nombre, String apellidos, String genero) {

        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        String sql = "INSERT INTO " + Constant.TB_PERSONA + "(" +
                Constant.C_NOMBRE + "," +
                Constant.C_APELLIDOS + "," +
                Constant.C_GENERO + ") VALUES('" +
                nombre + "','" +
                apellidos + "','" +
                genero + "')";
        dbProcesos.execSQL(sql);

    }

    public void eliminarPersona(int id) {
        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        String sql = "DELETE FROM " + Constant.TB_PERSONA +
                "WHERE " + Constant.C_ID + "=" + id;
        dbProcesos.execSQL(sql);
    }

    public void actualizarPersona(int id, String nombre, String apellidos, String genero) {
        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        String sql = "UPDATE " + Constant.TB_PERSONA + "SET " +
                Constant.C_NOMBRE + "=" + nombre + "," +
                Constant.C_APELLIDOS + "=" + apellidos + "," +
                Constant.C_GENERO + "=" + genero + "," +
                "WHERE " + Constant.C_ID + "=" + id + ";";
        dbProcesos.execSQL(sql);
    }

    public ArrayList<Persona> listarTodos() {
        ArrayList<Persona> listaPersona = new ArrayList<Persona>();
        SQLiteDatabase dbProcesos = dbConexion.getReadableDatabase();
        String sql = "SELECT * FROM " + Constant.TB_PERSONA;
        Cursor cursor = dbProcesos.rawQuery(sql, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    listaPersona.add(new Persona(listaPersona.size(),
                            cursor.getString(cursor.getColumnIndex(Constant.C_NOMBRE)),
                            cursor.getString(cursor.getColumnIndex(Constant.C_APELLIDOS)),
                            cursor.getString(cursor.getColumnIndex(Constant.C_GENERO))
                    ));

                } while (cursor.moveToNext());
            }
        }

        return listaPersona;
    }

}
