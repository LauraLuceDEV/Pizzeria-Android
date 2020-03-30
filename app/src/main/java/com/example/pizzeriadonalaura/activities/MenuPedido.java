package com.example.pizzeriadonalaura.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pizzeriadonalaura.R;
import com.example.pizzeriadonalaura.controladores.ControladorMenuPPL;

public class MenuPedido extends AppCompatActivity {
    private Button btnFav, btnMenu, btnPersonalizada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pedido);

        btnFav = findViewById(R.id.btnFav);
        btnMenu = findViewById(R.id.btnPredeter);
        btnPersonalizada = findViewById(R.id.btnPersonalizada);

        //Botón favorita
        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pizzaFavorita = ControladorMenuPPL.comprobacionExisteFavorita();

                if(pizzaFavorita.isEmpty()){
                    AlertDialog.Builder aletamsj = new AlertDialog.Builder(MenuPedido.this);

                    aletamsj.setMessage("No tiene ninguna Pizza guardada como favorita. \n" +
                                            "¿Que desea realizar?")
                            .setTitle("ERROR")
                            .setPositiveButton("Pizza al gusto", new DialogInterface.OnClickListener()  {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent actPersonalizada = new Intent(MenuPedido.this, MenuPedidoPizzaPersonalizada.class);
                                    startActivity(actPersonalizada);
                                }
                            })
                            .setNegativeButton("Carta", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent actCarta = new Intent(MenuPedido.this, MenuPedidoCarta.class);
                                    startActivity(actCarta);
                                }
                            });
                    aletamsj.create().show();

                }else{
                    Intent actFavorita = new Intent(MenuPedido.this, MenuPedidoFavorita.class);
                    startActivity(actFavorita);
                }
            }
        });

        //Botón IPersonalizada: Ir a la Activity de pizzas al gusto
        btnPersonalizada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actPersonalizada = new Intent(MenuPedido.this, MenuPedidoPizzaPersonalizada.class);
                startActivity(actPersonalizada);
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actCarta = new Intent(MenuPedido.this, MenuPedidoCarta.class);
                startActivity(actCarta);
            }
        });
    }
}
