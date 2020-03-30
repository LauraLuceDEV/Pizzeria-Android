package com.example.pizzeriadonalaura.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.pizzeriadonalaura.R;
import com.example.pizzeriadonalaura.controladores.ControladorMenuPPL;
import com.example.pizzeriadonalaura.pojos.Ingredientes;
import com.example.pizzeriadonalaura.pojos.Pizza;

import java.util.ArrayList;
import java.util.List;

public class MenuPedidoPizzaPersonalizada extends AppCompatActivity {
    private RadioGroup rgTamPizzas;
    private RadioButton rbPizzaMediana, rbPizzaFamiliar;

    private CheckBox cbBacon, cbChampi, cbJamon, cbQueso,
        cbBbq, cbTernera, cbMozarella, cbNata,
    cbHuevo, cbPimiento, cbSalchichas, cbCebolla, cbMarcarFavorita;

    private Button btnAtras, btnConfirPedido;
    private Pizza miPizzaAlGusto;
    String TamPizza;
    private List<Ingredientes> lstIngredientes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pizza_personalizada);
        //Bindeamos
        //Primero los RADIO - BUTTON
        rgTamPizzas = findViewById(R.id.rgTamPizza);
        rbPizzaMediana = findViewById(R.id.rbMediana);
        rbPizzaFamiliar = findViewById(R.id.rbFamiliar);
        //LOS Check-Box Ingredientes
        cbBacon = findViewById(R.id.cbBacon);
        cbChampi = findViewById(R.id.cbChampi);
        cbJamon = findViewById(R.id.cbjamon);
        cbQueso = findViewById(R.id.cbqueso);
        cbBbq = findViewById(R.id.salsaBbq);
        cbTernera = findViewById(R.id.cbTernera);
        cbMozarella = findViewById(R.id.cbmozarella);
        cbNata = findViewById(R.id.cbNata);
        cbHuevo = findViewById(R.id.cbHuevo);
        cbPimiento = findViewById(R.id.cbPimiento);
        cbSalchichas = findViewById(R.id.cbSalchichas);
        cbCebolla = findViewById(R.id.cbCebolla);
        cbMarcarFavorita = findViewById(R.id.pizzaPersoFav);
        //Botones
        btnAtras = findViewById(R.id.btnAtrasPizzaPerso);
        btnConfirPedido = findViewById(R.id.btnConfirmPersonalizada);
        //Lista Ingredientes
        lstIngredientes = new ArrayList<>();

        //Primero comprobamos el tamaño de la pizza
        rgTamPizzas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rbPizzaMediana.isChecked()){
                    TamPizza = "Mediana";
                }else if(rbPizzaFamiliar.isChecked()){
                    TamPizza = "Familiar";
                }else {
                    Context context = getApplicationContext();
                    CharSequence text = "Seleccione un tamaño para su Pizza";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        //Añadimos los ingredientes a una lista de ingredientes
        //BACON
        cbBacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbBacon.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbBacon.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbBacon);}
            }
        });
        //CHAMPIÑONES
        cbChampi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbChampi.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbChampi.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbChampi);}
            }
        });
        //JAMÓN
        cbJamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbJamon.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbJamon.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbJamon);}
            }
        });
        //QUESO
        cbQueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbQueso.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbQueso.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbQueso);}
            }
        });
        //BBQ
        cbBbq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbBbq.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbBbq.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbBbq);}
            }
        });
        //TERNERA
        cbTernera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbTernera.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbTernera.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbTernera);}
            }
        });
        //MOZARELLA
        cbMozarella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbMozarella.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbMozarella.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbMozarella);}
            }
        });
        //NATA
        cbNata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbNata.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbNata.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbNata);}
            }
        });
        //HUEVO
        cbHuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbHuevo.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbHuevo.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbHuevo);}
            }
        });
        //PIMIENTO
        cbPimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbPimiento.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbPimiento.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbPimiento);}
            }
        });
        //SALCHICHAS
        cbSalchichas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbSalchichas.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbSalchichas.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbSalchichas);}
            }
        });
        //CEBOLLA
        cbCebolla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbCebolla.isChecked()){
                    Ingredientes i1 = new Ingredientes(cbCebolla.getText().toString());
                    lstIngredientes.add(i1);

                }else{lstIngredientes.remove(cbCebolla);}
            }
        });


        //PIZZA - FAVORITA
        cbMarcarFavorita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbMarcarFavorita.isChecked()){
                    if( (rbPizzaFamiliar.isChecked() || rbPizzaMediana.isChecked()) && !lstIngredientes.isEmpty()){

                        Pizza pizzaFav = new Pizza("Personalizada", TamPizza, lstIngredientes);
                        ControladorMenuPPL.guardarPizzaFavorita(pizzaFav);
                    }else {
                        Toast toastmsj = Toast.makeText(getApplicationContext(),"Compruebe el tamaño e ingredientes de su Pizza ", Toast.LENGTH_LONG);
                        toastmsj.show();
                    }

                }
            }
        });


        //Botón de confirmar Pedido
        btnConfirPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( (rbPizzaFamiliar.isChecked() || rbPizzaMediana.isChecked()) && !lstIngredientes.isEmpty()) {
                    Pizza pizzaPedido = new Pizza("Personalizada", TamPizza, lstIngredientes);

                    Intent actFinPedido = new Intent(MenuPedidoPizzaPersonalizada.this, MenuConfirmacionPedido.class);
                    Bundle bundPizza = new Bundle();
                    bundPizza.putSerializable("pedidoPizza", pizzaPedido);;
                    actFinPedido.putExtras(bundPizza);
                    startActivity(actFinPedido);

                }else {
                    Toast toastmsj = Toast.makeText(getApplicationContext(),"Compruebe el tamaño e ingredientes de su Pizza ", Toast.LENGTH_LONG);
                    toastmsj.show();
                }

            }
        });


        //Botón de volver a atrás
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actPedido = new Intent(MenuPedidoPizzaPersonalizada.this, MenuPedido.class);
                startActivity(actPedido);
            }
        });





    }
}
