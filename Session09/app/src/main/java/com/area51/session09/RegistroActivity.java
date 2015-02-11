package com.area51.session09;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.area51.models.Persona;
import com.area51.utils.Constant;

import java.util.ArrayList;

/**
 * Created by elder_vasquez on 2/11/15.
 */
public class RegistroActivity extends ActionBarActivity {

    EditText txtNombre, txtApellidoPaterno, txtApellidoMaterno;
    Spinner spSexo;
    Button btnRegistrar, btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellidoPaterno = (EditText) findViewById(R.id.txtApellidoPaterno);
        txtApellidoMaterno = (EditText) findViewById(R.id.txtApellidoMaterno);
        spSexo = (Spinner) findViewById(R.id.spSexo);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnListar = (Button) findViewById(R.id.btnListar);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Constant.LISTA_PERSONA == null)
            Constant.LISTA_PERSONA = new ArrayList<Persona>();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!txtNombre.getText().toString().trim().equals("") && !txtApellidoPaterno.getText().toString().trim().equals("") && txtApellidoMaterno.getText().toString().trim().equals("")) {
                    Constant.LISTA_PERSONA.add(new Persona(
                            Constant.LISTA_PERSONA.size(),
                            txtNombre.getText().toString(),
                            txtApellidoPaterno.getText().toString(),
                            txtApellidoMaterno.getText().toString(),
                            spSexo.getSelectedItem().toString()
                    ));
                    txtNombre.setText("");
                    txtApellidoPaterno.setText("");
                    txtApellidoMaterno.setText("");
                    txtNombre.requestFocus();
                    spSexo.setSelection(0);
                } else
                    Toast.makeText(getApplicationContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show();

            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, ListadoActivity.class);
                startActivity(intent);
            }
        });

    }
}
