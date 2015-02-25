package com.area51.utils;

/**
 * Created by macbook on 2/20/15.
 */
public class Constant {

    public static int DB_VERSION = 1;
    public static String DB_NAME = "sesion15.db";
    public static String TB_PERSONA = "tb_persona";
    public static String C_ID = "id";
    public static String C_NOMBRE = "nombre";
    public static String C_APELLIDOS = "apellidos";
    public static String C_GENERO = "genero";

    public static String CREATE_TABLE_PERSONA = "CREATE TABLE " + TB_PERSONA +
            "(" + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            C_NOMBRE + " TEXT," +
            C_APELLIDOS + " TEXT," +
            C_GENERO + " TEXT)";

    public static String DROP_TABLE_PERSONA = "DROP TABLE" + TB_PERSONA;


}
