package com.example.iestecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ItinerarioGralActivity extends AppCompatActivity {

    String ticket;
    ArrayList<String> eventos = new ArrayList<String>();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerario_gral);

        Intent intent = getIntent();
        ticket = intent.getStringExtra("ticket");
        EntrarSistema();

        adapter = new ArrayAdapter<String>(this,
                R.layout.actividadeslist, eventos);


    }

    private void EntrarSistema(){

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {

                    JSONArray respJSON = new JSONArray(response);

                    for(int i = 0; i < respJSON.length(); i++)
                    {

                        JSONObject obj = respJSON.getJSONObject(i);
                        String evento = obj.getString("Nombre_Evento");
                        String sala = obj.getString("Sala");
                        eventos.add("Evento: "+ evento + " - " + " Sala:"+sala);
                        //menu[i] = tit;
                    }

                    ListView listView = (ListView) findViewById(R.id.listaActividadesG);
                    listView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                catch (Exception e) {
                    Log.e("ERROR2", e.getMessage(), e);

                }

            }
        };
        ItinerarioRequest itiRequest= new ItinerarioRequest(ticket,responseListener);
        RequestQueue queue = Volley.newRequestQueue(ItinerarioGralActivity.this);
        queue.add(itiRequest);

    }
}
