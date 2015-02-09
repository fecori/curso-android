package com.area51.session08;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.area51.models.Persons;
import com.area51.utils.Constant;

import java.util.ArrayList;

/**
 * Created by elder_vasquez on 2/9/15.
 */
public class RegistroActivity extends ActionBarActivity {

    EditText txtNombres, txtApellidoPaterno, txtApellidoMaterno;
    Button btnRegistro, btnListado;
    Spinner spSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombres = (EditText) findViewById(R.id.txtNombres);
        txtApellidoPaterno = (EditText) findViewById(R.id.txtApellidoPaterno);
        txtApellidoMaterno = (EditText) findViewById(R.id.txtApellidoMaterno);
        spSexo = (Spinner) findViewById(R.id.spSexo);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        btnListado = (Button) findViewById(R.id.btnListado);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Constant.listaPersona == null)
            Constant.listaPersona = new ArrayList<Persons>();

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (txtNombres.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "No se ingreso nombre", Toast.LENGTH_SHORT).show();
                    txtNombres.requestFocus();
                    txtNombres.setText("");
                } else if (txtApellidoPaterno.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "No se ingreso apellido paterno", Toast.LENGTH_SHORT).show();
                    txtApellidoPaterno.requestFocus();
                    txtApellidoPaterno.setText("");
                } else if (txtApellidoMaterno.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "No se ingreso apellido materno", Toast.LENGTH_SHORT).show();
                    txtApellidoMaterno.requestFocus();
                    txtApellidoMaterno.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario Registrado...", Toast.LENGTH_SHORT).show();
                    Constant.listaPersona.add(new Persons(
                            Constant.listaPersona.size(),
                            txtNombres.getText().toString(),
                            txtApellidoPaterno.getText().toString(),
                            txtApellidoMaterno.getText().toString(),
                            (int) spSexo.getSelectedItemId()
                    ));
                    txtNombres.setText("");
                    txtApellidoPaterno.setText("");
                    txtApellidoMaterno.setText("");
                    txtNombres.requestFocus();
                    spSexo.setSelection(0);
                }
            }
        });

        btnListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, ListadoActivity.class);
                startActivity(intent);
            }
        });

    }
}
