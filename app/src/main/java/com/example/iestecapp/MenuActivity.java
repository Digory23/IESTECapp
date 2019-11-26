package com.example.iestecapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private TextView nombre;
    private String name, apellido, ticket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        nombre = findViewById(R.id.bienvenido1);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        apellido = intent.getStringExtra("apellido");
        ticket = intent.getStringExtra("ticket");
        nombre.setText("Bienvenido, "+name);
        VerPase();
        VerItinerario();
        VerInfo();
    }

    private void VerPase(){
        CardView paseEntrada = (CardView) findViewById(R.id.btnPaseEntrada);
        paseEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MenuActivity.this, TicketActivity.class));
                Intent intent = new Intent(MenuActivity.this, TicketActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("apellido", apellido);
                intent.putExtra("ticket", ticket);

                MenuActivity.this.startActivity(intent);
            }
        });
    }

    private void VerItinerario(){
        CardView itinerario = (CardView) findViewById(R.id.itinerario);
        itinerario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ItinerarioOpcionActivity.class));
            }
        });
    }

    private void VerInfo(){
        CardView informacion = (CardView) findViewById(R.id.info);
        informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, InfoActivity.class));
            }
        });
    }
}
