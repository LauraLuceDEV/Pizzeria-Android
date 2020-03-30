package com.example.pizzeriadonalaura.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pizzeriadonalaura.R;
import com.example.pizzeriadonalaura.controladores.ControladorLogin;
import com.example.pizzeriadonalaura.controladores.ControladorMenuPPL;
import com.example.pizzeriadonalaura.pojos.Pizza;

public class MenuPedidoCarta extends AppCompatActivity {
    private ListView menuCasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pedido_carta);

        //Bindeamos
        menuCasa = findViewById(R.id.lvMenuPizzas);

        //nos creamso el array de las Pizzas
        Pizza[] menuMisPizzas = ControladorMenuPPL.obtenerListadoPizzasMenuCasa();
        //Creamos instancia del Adaptador
        AdaptadorMenuPizzasdelaCasa adaptador = new AdaptadorMenuPizzasdelaCasa(this, menuMisPizzas);
        //Vinculamos el adaptador al ListView
        menuCasa.setAdapter(adaptador);

        menuCasa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pizza pizza = (Pizza)parent.getItemAtPosition(position);

                if(pizza != null){
                    Intent actFinPedido = new Intent(MenuPedidoCarta.this, MenuConfirmacionPedido.class);
                    Bundle bundPizza = new Bundle();
                    bundPizza.putSerializable("pedidoPizza", pizza);;
                    actFinPedido.putExtras(bundPizza);
                    startActivity(actFinPedido);
                }else {
                    Toast toastmsj = Toast.makeText(getApplicationContext(),"ERROR INESPERADO", Toast.LENGTH_LONG);
                    toastmsj.show();
                }

            }
        });

    }
}
