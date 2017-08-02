package com.dontomate.rcm.ventasv1.Modulos.CRUD_Ventas;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.dontomate.rcm.ventasv1.ClasesAuxiliares.Formulas;
import com.dontomate.rcm.ventasv1.R;

/**
 * Created by Ricardo on 28/07/2017.
 */

public class AgregarVenta extends AppCompatActivity {

    private Toolbar toolbar ;
    public EditText etCantidadGrueso;
    public EditText etCantidadParejo;
    public EditText etCantidadRiche;
    public EditText etPrecioGrueso;
    public EditText etPrecioParejo;
    public EditText etPrecioRiche;
    public EditText etPGforCG;
    public EditText etPPforCP;
    public EditText etPRforCR;
    public EditText etTotal;
    public EditText etAbono;
    public EditText etSaldo;

    int cantidadGrueso;
    int cantidadParejo;
    int  cantidadRiche;
    double precioDeGrueso;
    double precioDeParejo;
    double precioDeRiche;
    double precio;
    double abono;
    double total;
    double saldo;

    double subtotalGrueso;
    double subtotalParejo;
    double subtotalRiche;

    public Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sale);

        toolbar = (Toolbar)findViewById(R.id.toolbar_venta_agregar);
        //Casting editText Cantidad layout
        etCantidadGrueso = (EditText)findViewById(R.id.cantidad_grueso_et);
        etCantidadParejo = (EditText)findViewById(R.id.cantidad_parejo_et);
        etCantidadRiche = (EditText)findViewById(R.id.cantidad_riche_et);
        //Casting editText Precio layout
        etPrecioGrueso = (EditText)findViewById(R.id.precio_grueso_et);
       // etPrecioGrueso.setVisibility(View.INVISIBLE);
        etPrecioParejo = (EditText)findViewById(R.id.precio_parejo_et);
        //etPrecioParejo.setVisibility(View.INVISIBLE);
        etPrecioRiche = (EditText)findViewById(R.id.precio_Riche_et);
        //etPrecioRiche.setVisibility(View.INVISIBLE);
        //Casting Button Calcular
        btn_calcular = (Button)findViewById(R.id.btn_calcular);
        //Casting editText Abono, saldo, Total
        etTotal = (EditText)findViewById(R.id.total_et);
        etAbono = (EditText)findViewById(R.id.Abono_et);
        etSaldo = (EditText) findViewById(R.id.Saldo_et);
        //OnClick para calcular Campos SUMA, ABONO, SALDO
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Obtener datos
                cantidadGrueso = obtenerCantidadGrueso();
                cantidadParejo = obtenerCantidadParejo();
                cantidadRiche = obtenerCantidadRiche();
                precioDeGrueso = obtenerPrecioGrueso();
                precioDeParejo = obtenerPrecioParejo();
                precioDeRiche = obtenerPrecioRiche();
                //Pasar parametros y calcular subtotales
               subtotalGrueso = subtotal(cantidadGrueso, precioDeGrueso);
               subtotalParejo = subtotal(cantidadParejo, precioDeParejo);
               subtotalRiche =  subtotal(cantidadRiche, precioDeRiche);
                //Obtener Abono
                abono = obtenerAbono();
                //Imprimir Total, y saldo
               total = CalcularTotalVenta(subtotalGrueso,subtotalParejo, subtotalRiche);
                etTotal.setText(""+total);
               saldo = CalcularSaldo(abono, total);
               etSaldo.setText(""+ saldo);
            }
        });

    }

    double CalcularSaldo(double abono, double total) {
        return total - abono;
    }

     double CalcularTotalVenta(double sumaGrueso, double sumaParejo, double sumaRiche) {
        return  sumaGrueso + sumaParejo + sumaRiche;
    }

    double subtotal (int cantidad , double precio){
        return cantidad * precio;
    }
    double obtenerAbono(){
        if (etAbono.getText().toString().isEmpty()){
            return 0;
        }else {
        return Double.parseDouble(etAbono.getText().toString().trim());
        }
    }
    //Metódos para obtener valores grueso
    int obtenerCantidadGrueso(){
        if (etCantidadGrueso.getText().toString().isEmpty()){
            return 0;
        }
        else {
            return Integer.parseInt(etCantidadGrueso.getText().toString().trim());
        }
    }
    double obtenerPrecioGrueso() {
        if (etPrecioGrueso.getText().toString().isEmpty()) {
            return 0;
        } else {
            return Double.parseDouble(etPrecioGrueso.getText().toString().trim());
        }
    }
    //Metódos para obtener valores parejos
    int obtenerCantidadParejo(){
        if (etCantidadParejo.getText().toString().isEmpty()){
            return 0;
        }
        else {
            return Integer.parseInt(etCantidadParejo.getText().toString().trim());
        }
    }
    double obtenerPrecioParejo() {
        if (etPrecioParejo.getText().toString().isEmpty()) {
            return 0;
        } else {
            return Double.parseDouble(etPrecioParejo.getText().toString().trim());
        }
    }
    //Metódos para obtener valores grueso
    int obtenerCantidadRiche(){
        if (etCantidadRiche.getText().toString().isEmpty()){
            return 0;
        }
        else {
            return Integer.parseInt(etCantidadRiche.getText().toString().trim());
        }
    }
    double obtenerPrecioRiche() {
        if (etPrecioRiche.getText().toString().isEmpty()) {
            return 0;
        } else {
            return Double.parseDouble(etPrecioRiche.getText().toString().trim());
        }
    }
}
