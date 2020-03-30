package com.example.pizzeriadonalaura.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pizzeriadonalaura.R;
import com.example.pizzeriadonalaura.pojos.Ingredientes;
import com.example.pizzeriadonalaura.pojos.Pizza;

public class MenuConfirmacionPedido extends AppCompatActivity {
    private TextView nombrePizza, precioPizza, ingredientesPizza;
    private Pizza pedidoPizza;

    //TODO Plasmar los datos de la pizza del bundle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_confirmacion_pedido);

        nombrePizza = findViewById(R.id.tvNombrePizza);
        precioPizza = findViewById(R.id.tvPrecioPizza);
        ingredientesPizza = findViewById(R.id.tvIngredientesPizza);

        //Obtenemos el Bundle
        pedidoPizza = (Pizza) getIntent().getSerializableExtra("pedidoPizza");  // NO (Pizza) savedInstanceState.getSerializable("pedidoPizza");
        String nombrePedidoPizza = pedidoPizza.getNombrePizza();
        double precioPedidoPizza = pedidoPizza.getPrecioPizza();

        //Convertimos la lista de nuestros ingredientes en 'String'
        String ingredientesPedidoPizza = "";
        for (Ingredientes ing : pedidoPizza.getListaIngredientesPizza())
            ingredientesPedidoPizza += ing.getNombreIngrediente() + " ";

        //Mostramos los datos en nuestros Text-View
        nombrePizza.setText("Su Pizza " + nombrePedidoPizza + ", son:");
        precioPizza.setText(String.valueOf(precioPedidoPizza) + "€ en total");
        ingredientesPizza.setText("Ingredientes: " +ingredientesPedidoPizza);

    }

    @Override
    public void onBackPressed() {
        Intent volverMenuPrincipal = new Intent(this, MenuPrincipal.class);
        volverMenuPrincipal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(volverMenuPrincipal);
        finish();
    }
}
