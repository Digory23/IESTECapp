package com.example.iestecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItinerarioGralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String[] mobileArray = {"Industry 4.0, development opportunities for Latin America","IPhone 20: The Future","WindowsMobile: Why did it die?",
                "La UTP y los semilleros de Investigación JIC",
                "WebOS: Su fracaso e influencia","Sistema de medición para el análisis de la innovación social en proyectos.","Windows vs Linux en el mundo modenos","Creación de plásticos a base de desechos de pescados"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerario_gral);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.actividadeslist, mobileArray);

        ListView listView = (ListView) findViewById(R.id.listaActividadesG);
        listView.setAdapter(adapter);
    }
}
