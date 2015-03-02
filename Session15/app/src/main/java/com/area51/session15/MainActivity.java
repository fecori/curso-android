package com.area51.session15;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.area51.adapters.ListaAdapter;
import com.area51.models.Persona;
import com.area51.sqlite.ManageOpenHelper;
import com.area51.sqlite.Querys;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    EditText txtNombre, txtApellidos;
    Spinner spGenero;
    Button btnRegistrar, btnActualizar;
    ListView lvLista;

    Querys querys;

    ManageOpenHelper dbConexion;
    SQLiteDatabase dbProcesos;
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
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        lvLista = (ListView) findViewById(R.id.lvLista);

    }

    @Override
    protected void onResume() {
        super.onResume();

        querys = new Querys(MainActivity.this);
        listaPersona = new ArrayList<Persona>();
        listaPersona = querys.listarTodos();
        adapter = new ListaAdapter(getApplicationContext(), listaPersona);
        lvLista.setAdapter(adapter);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtNombre.getText().toString().trim().equals("") && txtApellidos.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Campos vacios.", Toast.LENGTH_SHORT).show();
                } else {

                    querys.insertarPersona(txtNombre.getText().toString(), txtApellidos.getText().toString(), spGenero.getSelectedItem().toString());
                    listaPersona = querys.listarTodos();
                    adapter.notifyDataSetChanged();

                    txtNombre.setText("");
                    txtApellidos.setText("");
                    txtNombre.requestFocus();
                    spGenero.setSelection(0);

                }

            }
        });

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Opciones").setItems(R.array.opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(), "Click!", Toast.LENGTH_SHORT).show();

                        switch (which) {
                            case 0:
                                Toast.makeText(getApplicationContext(), "Opcion1!", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(getApplicationContext(), "Opcion2!", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        //listaPersona = querys.listarTodos();
                        //adapter.notifyDataSetChanged();

                    }
                });

            }
        });

    }

}
