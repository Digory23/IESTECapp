package com.example.iestecapp;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import net.glxn.qrgen.android.QRCode;

public class TicketActivity extends AppCompatActivity {
    TextView nombre, ticket;
    String name, apellido, ticket_e;
    ImageView imagenCodigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        imagenCodigo = findViewById(R.id.QRCode);
        nombre = (TextView)findViewById(R.id.nombre_completo);
        ticket = (TextView)findViewById(R.id.tiquete_en);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        apellido = intent.getStringExtra("apellido");
        ticket_e = intent.getStringExtra("ticket");
        nombre.setText(name+" "+apellido);
        ticket.setText(ticket_e);
        GenerarQR();
    }


    public void GenerarQR()
    {

        Bitmap bitmap = QRCode.from("Ticket: "+ ticket_e + " Nombre completo: "+ name + " "+ apellido).bitmap();
        imagenCodigo.setImageBitmap(bitmap);
    }
}
