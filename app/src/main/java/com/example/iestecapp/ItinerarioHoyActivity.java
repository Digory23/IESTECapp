package com.example.iestecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItinerarioHoyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String[] mobileArray = {"Industry 4.0, development opportunities for Latin America","IPhone 20: The Future","WindowsMobile: Why did it die?",
                "Cómo mejorar la educación de ciencias naturales",
                "WebOS: Su fracaso e influencia","Ingeniería 2.0: ¿qué hay de nuevo?"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerario_hoy);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.actividadeslist, mobileArray);

        ListView listView = (ListView) findViewById(R.id.listaActividades);
        listView.setAdapter(adapter);
    }
}
