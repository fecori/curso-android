package pe.friki.session17;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import pe.friki.adapters.ListadoPersona;
import pe.friki.asyntask.ManageAsyntask;
import pe.friki.models.Persona;
import pe.friki.utils.Constant;


public class MainActivity extends ActionBarActivity {

    Button btnTraer;
    ListView lvUsuarios;

    ManageAsyntask manage;
    ListadoPersona adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTraer = (Button) findViewById(R.id.btnTraer);
        lvUsuarios = (ListView) findViewById(R.id.lvUsuarios);

    }

    @Override
    protected void onResume() {
        super.onResume();
        manage = new ManageAsyntask(MainActivity.this);
        btnTraer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manage.listar("http://johannfjs.com/android/ws/index.php");
            }
        });
    }

    public void resultadoListarTodo(String s) {

        Constant.LISTA_PERSONA = new ArrayList<Persona>();

        try {
            JSONArray jsonArray = new JSONArray(s);
            if (jsonArray.length() > 0) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Log.d("TAG", "nombre: " + jsonObject.getString("nombres"));
                    Log.d("TAG", "apellidoPaterno: " + jsonObject.getString("apellidoPaterno"));
                    Log.d("TAG", "apellidoMaterno: " + jsonObject.getString("apellidoMaterno"));
                    Log.d("TAG", "genero: " + jsonObject.getString("genero"));
                    Log.d("TAG", "correo: " + jsonObject.getString("correo"));
                    Log.d("TAG", "contrasenia: " + jsonObject.getString("contrasenia"));

                    Constant.LISTA_PERSONA.add(new Persona(
                            jsonObject.getInt("id"),
                            jsonObject.getString("nombres"),
                            jsonObject.getString("apellidoPaterno"),
                            jsonObject.getString("apellidoMaterno"),
                            jsonObject.getString("genero")
                    ));
                }
                adapter = new ListadoPersona(getApplicationContext(), Constant.LISTA_PERSONA);
                lvUsuarios.setAdapter(adapter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
