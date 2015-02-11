package com.area51.session09;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.area51.adapters.ListadoAdapter;
import com.area51.utils.Constant;

/**
 * Created by elder_vasquez on 2/11/15.
 */
public class ListadoActivity extends ActionBarActivity {

    ListadoAdapter adapter;
    ListView lvListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lvListado = (ListView) findViewById(R.id.lvListado);

        adapter = new ListadoAdapter(getApplicationContext(), Constant.LISTA_PERSONA);
        lvListado.setAdapter(adapter);

    }
}
