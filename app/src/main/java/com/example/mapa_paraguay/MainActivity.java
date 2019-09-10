package com.example.mapa_paraguay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    Button btntipos,btnsitios,btnubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsitios = (Button) findViewById(R.id.btnsitios);
        btntipos  = (Button) findViewById(R.id.btntipos);
        btnubicacion = (Button) findViewById(R.id.btnubicacion);

        btnsitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //utilizamos el onclick para enviar el mapa en el boton de sitios
                Intent intent = new Intent(getApplicationContext(),MapsActivity1.class);
                startActivity(intent);
            }
        });

    }

    public void  MapasSitios(View view){
        Intent intent = new Intent(getApplicationContext(),MapsActivityTipos.class);
        startActivity(intent);
    }

    public void  Ubicacion(View view){
        Intent intent = new Intent(getApplicationContext(),MapsActivityUbicacion.class);
        startActivity(intent);
    }

}
