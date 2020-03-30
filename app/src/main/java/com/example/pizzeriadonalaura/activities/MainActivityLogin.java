package com.example.pizzeriadonalaura.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pizzeriadonalaura.R;
import com.example.pizzeriadonalaura.controladores.ControladorLogin;

public class MainActivityLogin extends AppCompatActivity {
    //VAR
    private Button btnAcceder;
    private EditText usuarioNombre, usuarioPass;
    private CheckBox cbRecordarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ControladorLogin.inicializarDAO(getApplicationContext());

        btnAcceder      =   findViewById(R.id.btnAcceder);
        usuarioNombre   =   findViewById(R.id.txtNombreUsusario);
        usuarioPass     =   findViewById(R.id.txtPassUsuario);
        cbRecordarSesion=   findViewById(R.id.cbLogin);

        //Acceder Al Sistema
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean existeUsuario = ControladorLogin.existeUsuarioLoggin(usuarioNombre.getText().toString(), usuarioPass.getText().toString());

                String msjToast = ControladorLogin.respuestaAccesoUsuarios(existeUsuario, usuarioNombre.getText().toString());

                Toast toastMsj = Toast.makeText(MainActivityLogin.this, msjToast, Toast.LENGTH_LONG);
                toastMsj.show();

                if(existeUsuario){
                    Intent intMenuPPL = new Intent(MainActivityLogin.this, MenuPrincipal.class);
                    startActivity(intMenuPPL);
                    finish();
                }
            }
        });


        //Check-Box - Precargar Datos de las Shared Preferences
        cbRecordarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean cbPulsado = cbRecordarSesion.isChecked();
                ControladorLogin.checkBoxRecordarInicioSesion(cbPulsado);
            }
        });

        boolean sesionRecordar = ControladorLogin.obtenerSesion();
        cbRecordarSesion.setChecked(sesionRecordar);

        if(sesionRecordar){
            String userName = ControladorLogin.getUsername();
            String userPass = ControladorLogin.getUserPass();

            usuarioNombre.setText(userName);
            usuarioPass.setText(userPass);
        }
    }
}
