package com.dontomate.rcm.ventasv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //obteniendo una instancia del boton btnVentas
        btnVentas = (Button)findViewById(R.id.btn_ver_ventas);
        //Registrando la escucha sobre la actividad Main
        btnVentas.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVentas =  new Intent(MainActivity.this, AgregarVenta.class);
                startActivity(intentVentas);
            }
        });
    }

}
