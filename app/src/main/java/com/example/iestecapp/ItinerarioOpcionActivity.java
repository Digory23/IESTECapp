package com.example.iestecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItinerarioOpcionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerario_opcion);

        ItinerarioHoy();
        ItinerarioGral();
    }

    private void ItinerarioHoy(){
        Button btnOpcion1 = (Button) findViewById(R.id.btnHoy);
        btnOpcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItinerarioOpcionActivity.this, ItinerarioHoyActivity.class));
            }
        });
    }

    private void ItinerarioGral(){
        Button btnOpcion2 = (Button) findViewById(R.id.btnGral);
        btnOpcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItinerarioOpcionActivity.this, ItinerarioGralActivity.class));
            }
        });
    }
}
