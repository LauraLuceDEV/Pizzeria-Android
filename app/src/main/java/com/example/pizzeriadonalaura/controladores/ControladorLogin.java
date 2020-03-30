package com.example.pizzeriadonalaura.controladores;

import android.content.Context;
import com.example.pizzeriadonalaura.modelo.DAOPizza;
import com.example.pizzeriadonalaura.modelo.DAOPreferenceLogin;
import com.example.pizzeriadonalaura.pojos.Usuario;

public class ControladorLogin {

    //Metodo que nos comprueba si un usuario existe
    public static boolean existeUsuarioLoggin(String userName, String userPass){

        if(!userName.isEmpty() && userPass.length() > 0){
            Usuario usuario = DAOPreferenceLogin.getInstanceLoggin().getUsuario();

            if(usuario.getNombreUsuario().equalsIgnoreCase(userName) && usuario.getPassUsuario().equalsIgnoreCase(userPass)){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    //Método que nos dará una respuesta en función si el usuario se ha insertado correctamente o no
    public static String respuestaAccesoUsuarios(boolean userOK, String userName){
        String msj;
        if(userOK){
            msj = "Bienvenido " + userName;

        }else{ msj = "Error,\r\nCompruebe que están todos los campos correctamente escritos. \r\nSino regístrese";}
        return msj;
    }

    public static void checkBoxRecordarInicioSesion(boolean cbPulsado){
        DAOPreferenceLogin.getInstanceLoggin().guardarCheckLoggin(cbPulsado);
    }

    public static boolean obtenerSesion(){
        return DAOPreferenceLogin.getInstanceLoggin().obtenerEstadoSesion();
    }

    public static String getUsername() {
        return DAOPreferenceLogin.getInstanceLoggin().getUsuario().getNombreUsuario();
    }

    public static String getUserPass() {
        return DAOPreferenceLogin.getInstanceLoggin().getUsuario().getPassUsuario();
    }

    public static void inicializarDAO(Context context) {
        DAOPizza.createInstance(context);
    }
}
