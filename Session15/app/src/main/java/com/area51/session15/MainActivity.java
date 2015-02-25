package com.area51.session15;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.area51.adapters.ListaAdapter;
import com.area51.models.Persona;
import com.area51.sqlite.ManageOpenHelper;
import com.area51.utils.Constant;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    EditText txtNombre, txtApellidos;
    Spinner spGenero;
    Button btnRegistrar;

    ManageOpenHelper dbConexion;
    SQLiteDatabase dbProcesos;

    ListView lvLista;
    ListaAdapter adapter;
    ArrayList<Persona> listaPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellidos = (EditText) findViewById(R.id.txtApellidos);
        spGenero = (Spinner) findViewById(R.id.spGenero);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        lvLista = (ListView) findViewById(R.id.lvLista);

    }

    @Override
    protected void onResume() {
        super.onResume();

        dbConexion = new ManageOpenHelper(MainActivity.this);
        dbProcesos = dbConexion.getReadableDatabase();

        listarPersonas();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtNombre.getText().toString().trim().equals("") && txtApellidos.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Campos vacios.", Toast.LENGTH_SHORT).show();
                } else {

                    String sql = "INSERT INTO " + Constant.TB_PERSONA + "(" +
                            Constant.C_NOMBRE + "," +
                            Constant.C_APELLIDOS + "," +
                            Constant.C_GENERO + ") VALUES('" +
                            txtNombre.getText().toString() + "','" +
                            txtApellidos.getText().toString() + "','" +
                            spGenero.getSelectedItem().toString() + "')";

                    dbProcesos.execSQL(sql);
                    listarPersonas();

                    txtNombre.setText("");
                    txtApellidos.setText("");
                    txtNombre.requestFocus();
                    spGenero.setSelection(0);

                    Log.d("TAG", sql);

                }

            }
        });

    }

    public void listarPersonas(){
        listaPersona = new ArrayList<Persona>();

        dbConexion = new ManageOpenHelper(MainActivity.this);
        dbProcesos = dbConexion.getReadableDatabase();

        listaPersona = new ArrayList<Persona>();
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

        adapter = new ListaAdapter(getApplicationContext(), listaPersona);
        lvLista.setAdapter(adapter);
    }

}
