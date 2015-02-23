package com.area51.session13;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.area51.adapter.ListadoAdapter;
import com.area51.sqlite.ManageOpenHelper;
import com.area51.utils.Constant;


public class MainActivity extends ActionBarActivity {

    EditText txtNombre, txtApellidoPaterno, txtApellidoMaterno;
    Button btnRegistrar, btnListado;

    ManageOpenHelper dbConexion;
    SQLiteDatabase dbProcesos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellidoPaterno = (EditText) findViewById(R.id.txtApellidoPaterno);
        txtApellidoMaterno = (EditText) findViewById(R.id.txtApellidoMaterno);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnListado = (Button) findViewById(R.id.btnListado);

    }

    @Override
    protected void onResume() {
        super.onResume();

        dbConexion = new ManageOpenHelper(MainActivity.this);
        dbProcesos = dbConexion.getReadableDatabase();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!txtNombre.toString().trim().equals("") &&
                        !txtApellidoPaterno.toString().trim().equals("") &&
                        !txtApellidoMaterno.toString().trim().equals("")) {

                    String sql = "INSERT INTO " + Constant.TB_PERSONA + "(" +
                            Constant.C_NOMBRE + "," +
                            Constant.C_APELLIDO_PATERNO + "," +
                            Constant.C_APELLIDO_MATERNO + ") VALUES('" +
                            txtNombre.getText().toString() + "','" +
                            txtApellidoPaterno.getText().toString() + "','" +
                            txtApellidoMaterno.getText().toString() + "')";

                    dbProcesos.execSQL(sql);
                    Log.d("TAG", sql);

                }

            }
        });

        btnListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
