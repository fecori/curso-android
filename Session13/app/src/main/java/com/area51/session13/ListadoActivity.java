package com.area51.session13;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.area51.adapter.ListadoAdapter;
import com.area51.models.Persona;
import com.area51.sqlite.ManageOpenHelper;
import com.area51.utils.Constant;

import java.util.ArrayList;

/**
 * Created by elder_vasquez on 2/23/15.
 */
public class ListadoActivity extends ActionBarActivity {

    ListView lvListado;
    ListadoAdapter adapter;
    ArrayList<Persona> listadoPersona;

    ManageOpenHelper dbConexion;
    SQLiteDatabase dbProcesos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        lvListado = (ListView) findViewById(R.id.lvListado);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listadoPersona = new ArrayList<Persona>();

        dbConexion = new ManageOpenHelper(ListadoActivity.this);
        dbProcesos = dbConexion.getReadableDatabase();

        listadoPersona = new ArrayList<Persona>();
        String sql = "SELECT * FROM " + Constant.TB_PERSONA;
        Cursor cursor = dbProcesos.rawQuery(sql, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    listadoPersona.add(new Persona(listadoPersona.size(),
                            cursor.getString(cursor.getColumnIndex(Constant.C_NOMBRE)),
                            cursor.getString(cursor.getColumnIndex(Constant.C_APELLIDO_PATERNO)),
                            cursor.getString(cursor.getColumnIndex(Constant.C_APELLIDO_MATERNO))
                    ));

                } while (cursor.moveToNext());
            }
        }

        adapter = new ListadoAdapter(getApplicationContext(), listadoPersona);
        lvListado.setAdapter(adapter);

    }
}
