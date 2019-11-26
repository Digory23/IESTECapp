package com.example.iestecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TicketActivity extends AppCompatActivity {
    TextView nombre, ticket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        nombre = (TextView)findViewById(R.id.nombre_completo);
        ticket = (TextView)findViewById(R.id.tiquete_en);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String apellido = intent.getStringExtra("apellido");
        String ticket_e = intent.getStringExtra("ticket");
        nombre.setText(name+" "+apellido);
        ticket.setText(ticket_e);
    }
}
