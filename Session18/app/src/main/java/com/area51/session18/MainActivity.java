package com.area51.session18;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.area51.application.ConfigureApplication;
import com.area51.utils.InitViews;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    public View root;
    Button btnTraer;
    EditText txtJson;
    TextView txtbattleTagName, txtbattleTagNumber, txtMonstruosEliminados, txtElitesEliminados, txtParagonLevel;

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

                /*JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("https://us.api.battle.net/d3/profile/FECORI-1637/?locale=es_MX&apikey=wmzs37hgs52vfc8kwg56jwumy3sa97kc", new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        txtJson.setText(response.toString());
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        txtJson.setText("Error ===> " + error.toString());
                        progressDialog.dismiss();
                    }
                });*/

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://us.api.battle.net/d3/profile/FECORI-1637/?locale=es_MX&apikey=wmzs37hgs52vfc8kwg56jwumy3sa97kc", null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                txtJson.setText("onResponse ===> " + response.toString());

                                try {

                                    String[] battleTag = response.getString("battleTag").split("#");

                                    txtbattleTagName.setText(battleTag[0]);
                                    txtbattleTagNumber.setText("#" + battleTag[1]);
                                    txtMonstruosEliminados.setText(response.getJSONObject("kills").getString("monsters"));
                                    txtElitesEliminados.setText(response.getJSONObject("kills").getString("elites"));
                                    txtParagonLevel.setText(response.getString("paragonLevel"));

                                    Toast.makeText(getApplicationContext(), response.getString("progression"), Toast.LENGTH_LONG).show();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                progressDialog.dismiss();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                txtJson.setText("onErrorResponse ===> " + error.toString());
                                progressDialog.dismiss();
                            }
                        });

                ConfigureApplication.getInstance().addToRequestQueue(jsonObjectRequest, "json_array_req");

            }
        });
    }

}
