package com.area51.session09;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.area51.adapters.GrillaAdapter;
import com.area51.models.Imagen;
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
    GridView gvGrilla;
    ArrayList<Imagen> listaImagen;
    GrillaAdapter adapter;
    String rutaImagen;
    LinearLayout llModificar;
    Button btnActualizar, btnCancelar;
    int id_lista = 0;

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
        gvGrilla = (GridView) findViewById(R.id.gvGrilla);
        llModificar = (LinearLayout) findViewById(R.id.llModificar);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        if (getIntent().getExtras() != null) {
            id_lista = getIntent().getExtras().getInt("KEY");
            if (id_lista > 0) {
                btnRegistrar.setVisibility(View.GONE);
                llModificar.setVisibility(View.VISIBLE);
                id_lista = id_lista - 1;
                txtNombre.setText(Constant.LISTA_PERSONA.get(id_lista).getNombre());
                txtApellidoPaterno.setText(Constant.LISTA_PERSONA.get(id_lista).getApellidoPaterno());
                txtApellidoMaterno.setText(Constant.LISTA_PERSONA.get(id_lista).getApellidoMaterno());
                spSexo.setSelection(Integer.parseInt(Constant.LISTA_PERSONA.get(id_lista).getSexo()));

            } else {
                btnRegistrar.setVisibility(View.VISIBLE);
                llModificar.setVisibility(View.GONE);
            }
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (listaImagen == null) {
            listaImagen = new ArrayList<Imagen>();
            for (int i = 100; i < 103; i++) {
                listaImagen.add(new Imagen(listaImagen.size(), "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_" + i + ".jpg"));
            }
        }

        adapter = new GrillaAdapter(getApplicationContext(), R.layout.grid_item, listaImagen);
        gvGrilla.setAdapter(adapter);

        if (Constant.LISTA_PERSONA == null)
            Constant.LISTA_PERSONA = new ArrayList<Persona>();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!txtNombre.getText().toString().trim().equals("")
                        && !txtApellidoPaterno.getText().toString().trim().equals("")
                        && !txtApellidoMaterno.getText().toString().trim().equals("")) {
                    Constant.LISTA_PERSONA.add(new Persona(
                            Constant.LISTA_PERSONA.size(),
                            txtNombre.getText().toString(),
                            txtApellidoPaterno.getText().toString(),
                            txtApellidoMaterno.getText().toString(),
                            (spSexo.getSelectedItemId() + ""),
                            rutaImagen
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

        gvGrilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                rutaImagen = listaImagen.get(position).getRutaImage();
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constant.LISTA_PERSONA.get(id_lista).setNombre(txtNombre.getText().toString());
                Constant.LISTA_PERSONA.get(id_lista).setApellidoPaterno(txtApellidoPaterno.getText().toString());
                Constant.LISTA_PERSONA.get(id_lista).setApellidoMaterno(txtApellidoMaterno.getText().toString());
                Constant.LISTA_PERSONA.get(id_lista).setSexo(spSexo.getSelectedItemId() + "");
                Constant.LISTA_PERSONA.get(id_lista).setRutaImagen(rutaImagen);
                Intent intent = new Intent(RegistroActivity.this, ListadoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
