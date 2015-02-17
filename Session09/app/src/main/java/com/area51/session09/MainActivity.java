package com.area51.session09;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText txtCorreoElectronico, txtContrasena;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCorreoElectronico = (EditText) findViewById(R.id.txtCorreoElectronico);
        txtContrasena = (EditText) findViewById(R.id.txtContrasena);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtCorreoElectronico.getText().toString().trim().equals("") && txtContrasena.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Ingresa todos los datos requeridos", Toast.LENGTH_SHORT).show();
                } else if (txtCorreoElectronico.getText().toString().trim().equals("abc") && txtContrasena.getText().toString().trim().equals("123")) {
                    Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                    startActivity(intent);
                }
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
