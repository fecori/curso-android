package com.area51.session20;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.area51.application.ConfigureApplication;
import com.area51.sqlite.Querys;
import com.area51.utils.InitViews;

import org.json.JSONArray;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    public View root;
    EditText txtUsuario, txtCorreo;
    Button btnIngresar;

    Querys querys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root = findViewById(android.R.id.content).getRootView();
        InitViews.whichClass(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        querys = new Querys(MainActivity.this);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!txtUsuario.getText().toString().equals("") && txtCorreo.getText().toString().equals("")) {
                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setMessage("Cargando!!");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                            "http://johannfjs.com/android/ws/validarUsuario.php?correo=" + txtUsuario.getText().toString() + "&contrasenia=" + txtCorreo.getText().toString(),
                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    try {
                                        if (response.length() > 0) {
                                            JSONObject jsonObject = response.getJSONObject(0);
                                            querys.registrarPersona(jsonObject.getString("nombres") + " " + jsonObject.getString("apellidoPaterno") + " " + jsonObject.getString("apellidoMaterno"));
                                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Usuario invalido", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    progressDialog.dismiss();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    progressDialog.dismiss();
                                }
                            }
                    );
                    ConfigureApplication.getInstance().addToRequestQueue(jsonArrayRequest);
                }
            }
        });


    }
}
