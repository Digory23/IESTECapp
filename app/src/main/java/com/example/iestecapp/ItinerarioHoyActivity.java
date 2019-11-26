package com.example.iestecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItinerarioHoyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String[] mobileArray = {"Industry 4.0, development opportunities for Latin America","IPhone 20: The Future","WindowsMobile: Why did it die?",
                "La UTP y los semilleros de Investigación JIC",
                "WebOS","Sistema de medición para el análisis de la innovación social en proyectos.","Windows7","Max OS X"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerario_hoy);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.actividadeslist, mobileArray);

        ListView listView = (ListView) findViewById(R.id.listaActividades);
        listView.setAdapter(adapter);
    }
}
