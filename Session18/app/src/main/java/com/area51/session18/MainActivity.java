package com.area51.session18;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.area51.application.ConfigureApplication;
import com.area51.utils.InitViews;

import org.json.JSONArray;


public class MainActivity extends ActionBarActivity {

    public View root;
    Button btnTraer;
    TextView txtJson;

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
        btnTraer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Cargando datos...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://johannfjs.com/android/ws/index.php", new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        txtJson.setText(response.toString());
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                ConfigureApplication.getInstance().addToRequestQueue(jsonArrayRequest, "json_array_req");

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
