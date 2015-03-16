package com.area51.utils;

/**
 * Created by macbook on 3/16/15.
 */
public class Constant {

    public static int DB_VERSION = 1;
    public static String DB_NAME = "session21.db";

    public static String TB_PERSONA = "tb_persona";
    public static String C_NOMBRE_APELLIDO = "nombre_apellido";

    public static String CREATE_PERSONA = "CREATE TABLE " + TB_PERSONA + "(" + C_NOMBRE_APELLIDO + " TEXT)";
    public static String DROP_TABLE = "DROP TABLE " + TB_PERSONA;

}
