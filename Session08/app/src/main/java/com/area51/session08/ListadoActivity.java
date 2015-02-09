package com.area51.session08;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.area51.adapters.ListaAdapter;
import com.area51.models.Persons;
import com.area51.utils.Constant;

import java.util.ArrayList;

/**
 * Created by elder_vasquez on 2/9/15.
 */
public class ListadoActivity extends ActionBarActivity {

    ListaAdapter adapter;
    ListView lstItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        lstItem = (ListView) findViewById(R.id.lstItem);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Constant.listaPersona == null)
            Constant.listaPersona = new ArrayList<Persons>();

        adapter = new ListaAdapter(getApplicationContext());
        lstItem.setAdapter(adapter);

    }
}
