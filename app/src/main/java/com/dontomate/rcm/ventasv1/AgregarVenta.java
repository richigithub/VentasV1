package com.dontomate.rcm.ventasv1;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Ricardo on 28/07/2017.
 */

public class AgregarVenta extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sale);
        FloatingActionButton fabguardar = (FloatingActionButton) findViewById(R.id.fab_guardar);
        fabguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Agregado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
