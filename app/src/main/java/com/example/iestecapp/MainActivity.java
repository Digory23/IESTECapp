package com.example.iestecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText ticket_e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ticket_e = (EditText)findViewById(R.id.tiquete);
        EntrarSistema();
        RegistrarSistema();
    }

    private void EntrarSistema(){
        Button btnEntrar = (Button) findViewById(R.id.btnIngresar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String ticket = ticket_e.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(MainActivity.this,"FUNCIONA", Toast.LENGTH_SHORT).show();
                        try {

                            JSONObject jsonResponse = new JSONObject(response);//response del query JSON
                            boolean success = jsonResponse.getBoolean("success");//obtiene el valor booleano de la BD
                            if(success){
                                //obtiene los datos del usuario
                                String nombre = jsonResponse.getString("name");
                                String apellido = jsonResponse.getString("last_name");
                                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                                intent.putExtra("name", nombre);
                                intent.putExtra("apellido", apellido);
                                intent.putExtra("ticket", ticket);

                                MainActivity.this.startActivity(intent);//se realiza el login y se envia a la siguiente activity

                            }else{

                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("error de Login").setNegativeButton("Retry",null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest= new LoginRequest(ticket,responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
            }
        });
    }

    private void RegistrarSistema(){
        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        String url = "http://www.congreso1.ds507.online";
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://congreso1.ds507.online/PROTOTIPO/")));
            }
        });
    }
}
