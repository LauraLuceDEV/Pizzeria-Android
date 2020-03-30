package com.example.pizzeriadonalaura.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzeriadonalaura.R;
import com.example.pizzeriadonalaura.controladores.ControladorMenuPPL;
import com.example.pizzeriadonalaura.pojos.Ingredientes;
import com.example.pizzeriadonalaura.pojos.Pizza;

import java.util.List;

public class MenuPedidoFavorita extends AppCompatActivity {
    private TextView tvNombrePizzaFAV, tvIngredientesPizzaFAV, tvPrecioPizzaFAV;
    private Button btnAtras, btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pedido_favorita);
        //Bindeamos
        tvNombrePizzaFAV = findViewById(R.id.tvNombredetuFavorita);
        tvIngredientesPizzaFAV = findViewById(R.id.tvIndredientesdetuFavorita);
        tvPrecioPizzaFAV = findViewById(R.id.tvPreciodetuFavorita);
        btnAtras = findViewById(R.id.btnAtrasMenuPPL);
        btnConfirmar = findViewById(R.id.btnConfirmarPedidoFav);

        //Obtenemos Pizza
        Pizza pizzaFav = ControladorMenuPPL.obtenerPizzaFavorita();
        if(pizzaFav != null){
            //Plasmamos los datos
            tvNombrePizzaFAV.setText(pizzaFav.getNombrePizza());
            //Obtener de la Lista-Ingredientes un String de Ingredientes
            List<Ingredientes> lstIngredietnes = pizzaFav.getListaIngredientesPizza();
            String ingredientes = ControladorMenuPPL.obtenerStringIngredientes(lstIngredietnes);
            tvIngredientesPizzaFAV.setText(ingredientes);
            //Combertimos double en string
            tvPrecioPizzaFAV.setText(String.valueOf(pizzaFav.getPrecioPizza()));
        }else{
            Toast toastPizzaFav = Toast.makeText(getApplicationContext(), "No se ha encontrado ninguna Favorita, inserte una.", Toast.LENGTH_SHORT);
            toastPizzaFav.show();
        }

        //Botones Confrimar y atras (Volvemos al Menu Principal)
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverMenuPrincipal = new Intent(MenuPedidoFavorita.this, MenuPrincipal.class);
                volverMenuPrincipal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(volverMenuPrincipal);
                finish();
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pizza pizzaFAV = ControladorMenuPPL.obtenerPizzaFavorita();

                Intent actFinPedido = new Intent(MenuPedidoFavorita.this, MenuConfirmacionPedido.class);
                Bundle bundPizza = new Bundle();
                bundPizza.putSerializable("pedidoPizza", pizzaFAV);;
                actFinPedido.putExtras(bundPizza);
                startActivity(actFinPedido);
            }
        });
    }
}
