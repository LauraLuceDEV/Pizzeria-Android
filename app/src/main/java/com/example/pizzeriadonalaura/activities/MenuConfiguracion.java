package com.example.pizzeriadonalaura.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.example.pizzeriadonalaura.R;
import com.example.pizzeriadonalaura.controladores.ControladorMenuPPL;

public class MenuConfiguracion extends AppCompatActivity {
    private Switch switchWifi;
    private RadioButton rbVerde, rbBeige, rbGris;
    private RadioGroup radioGroup;
    private ConstraintLayout vistaRaiz;
    private CheckBox cbFavorita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_configuracion);

        switchWifi = findViewById(R.id.switchWifi);
        rbVerde = findViewById(R.id.rbOpcionVerde);
        rbBeige = findViewById(R.id.rbOpcionBeige);
        rbGris = findViewById(R.id.rbOpcionGris);
        radioGroup = findViewById(R.id.rGBackground);
        vistaRaiz = findViewById(R.id.menuConfig);
        cbFavorita = findViewById(R.id.cbFavorita);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int idColor;
                if(rbBeige.isChecked()){
                    idColor = R.color.beigeBck;
                }else if(rbGris.isChecked()){
                    idColor = R.color.grisBck;
                }else{
                    idColor = R.color.verdeBck;
                }

                ControladorMenuPPL.modificarColorFondo(idColor);
                vistaRaiz.setBackgroundColor(ContextCompat.getColor(MenuConfiguracion.this, idColor));
            }
        });

        //Check-Box Pizza Favorita
        cbFavorita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checkFavorita = cbFavorita.isChecked();

                ControladorMenuPPL.opcionPizzaFavorita(checkFavorita);
            }
        });
    }

    //Se ejecuta cada vez que la vista es visible para el usuario
    @Override
    protected void onResume(){
        super.onResume();
        int idColor = ControladorMenuPPL.getColorBck();
        vistaRaiz.setBackgroundColor(ContextCompat.getColor(this, idColor));
    }
}
