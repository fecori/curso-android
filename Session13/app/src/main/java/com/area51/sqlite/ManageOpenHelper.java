package com.area51.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.area51.utils.Constant;

/**
 * Created by macbook on 2/20/15.
 */
public class ManageOpenHelper extends SQLiteOpenHelper {


    public ManageOpenHelper(Context context) {
        super(context, Constant.DB_NAME, null, Constant.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constant.CREATE_TABLE_PERSONA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Constant.DROP_TABLE_PERSONA);
        onCreate(db);

    }
}
