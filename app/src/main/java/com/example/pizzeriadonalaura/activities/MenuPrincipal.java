package com.example.pizzeriadonalaura.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;

import com.example.pizzeriadonalaura.R;
import com.example.pizzeriadonalaura.controladores.ControladorMenuPPL;

public class MenuPrincipal extends AppCompatActivity {
    private ImageButton btnWeb, btnPedido, btnConfig;
    private ScrollView scrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnWeb      = findViewById(R.id.btnWeb);
        btnPedido   = findViewById(R.id.btnPedido);
        btnConfig   = findViewById(R.id.btnConfiguracion);
        scrollview  = findViewById(R.id.scrollview);

        //Botón ir a la páginaWeb
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.just-eat.es/restaurants-pizzairinamadrid"));
                startActivity(paginaWeb);
            }
        });

        //Botón Pedido
        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actMenuPedido = new Intent(MenuPrincipal.this, MenuPedido.class);
                startActivity(actMenuPedido);
            }
        });

        //Botón Config
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actConfig = new Intent(MenuPrincipal.this, MenuConfiguracion.class);
                startActivity(actConfig);
            }
        });
    }

    protected void onResume(){
        super.onResume();
        int idColor = ControladorMenuPPL.getColorBck();
        scrollview.setBackgroundColor(ContextCompat.getColor(this, idColor));
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder aletamsj = new AlertDialog.Builder(this);

        aletamsj.setMessage("¿Desea salir de la app?")
                .setTitle("SALIR")
                .setPositiveButton("SALIR", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        MenuPrincipal.super.onBackPressed();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        aletamsj.create().show();
    }
}
