package com.example.pizzeriadonalaura.modelo;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.pizzeriadonalaura.PizzeriaApplication;
import com.example.pizzeriadonalaura.R;
import com.example.pizzeriadonalaura.pojos.Usuario;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DAOPreferenceLogin {
    private static DAOPreferenceLogin logginUsuarioSingleton;
    private SharedPreferences sharedPreferences;


    //CONSTRUCTOR
    public DAOPreferenceLogin(){
        sharedPreferences = PizzeriaApplication.getContext().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        if(!sharedPreferences.contains("usuario")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("usuario", "laura");
            editor.putString("contrasenna", "lucena");
            editor.apply();
        }
    }

    //MÉTODOS
    //GETTER
    public Usuario getUsuario(){
        String usuarioString = sharedPreferences.getString("usuario", "");
        String contrasennaString = sharedPreferences.getString("contrasenna", "");
        return new Usuario(usuarioString, contrasennaString);
    }


    //Singleton que llama al constructor
    public static DAOPreferenceLogin getInstanceLoggin(){
        if (logginUsuarioSingleton == null) {  logginUsuarioSingleton = new DAOPreferenceLogin(); }
        return logginUsuarioSingleton;
    }

    //COLOR DE FONDO
    public void guardarColorFondo(int idColor){
        SharedPreferences.Editor editpreference = sharedPreferences.edit();
        editpreference.putInt("colorBck", idColor);
        editpreference.apply();
    }
    public int obtenerColorFondo(){
        return sharedPreferences.getInt("colorBck", R.color.grisBck);
    }


    //USUARIO DATOS SESION
    public void guardarCheckLoggin(boolean cbPulsado){
        SharedPreferences.Editor editBool = sharedPreferences.edit();
        editBool.putBoolean("sesionLoginn", cbPulsado);
        editBool.apply();
    }
    public boolean obtenerEstadoSesion() {
        return sharedPreferences.getBoolean("sesionLoginn", false);
    }


    //OPCIÓN DESHABILITAR MENÚ PIZZA FAVORITA
    public void guardarOpcionFavorita(boolean cbFavorita){
        SharedPreferences.Editor editBool = sharedPreferences.edit();
        editBool.putBoolean("opcionFavorita", cbFavorita);
        editBool.apply();
    }
    public boolean obtenerOpcionPizzaFavorita(){
        return sharedPreferences.getBoolean("opcionFavorita", false);
    }

    //GUARDAR/COMPROBAR PIZZA FAVORITA SI EXISTE EN SHARED PREFERENCES
    public void guardarPizzaFavorita(String pizzaFav){
        SharedPreferences.Editor editPizzaFav = sharedPreferences.edit();
        editPizzaFav.putString("miPizzaFavorita", pizzaFav);
        editPizzaFav.apply();
    }
    public String obtenerPizzaFavorita() {
        return  sharedPreferences.getString("miPizzaFavorita", "");
    }

    //Guarda/comprueba los ingredientes de la pizza-FAV
    public void guardarIngredientesFavoritos(List<String> ingredientesList){
        /*for(String ingrediente : ingredientesList){
            ingredientesSet.add(ingrediente);
        }*/
        Set<String> ingredientesSet = new HashSet<>(ingredientesList);
        SharedPreferences.Editor editSet = sharedPreferences.edit();
        editSet.putStringSet("miPizzaFavoritaIngredientes", ingredientesSet);
        editSet.apply();
    }
    public Set<String> obtenerPizzaFavoritaIngredientes() {
        return  sharedPreferences.getStringSet("miPizzaFavoritaIngredientes", new HashSet<String>());
    }


    //Guarda/Comprueba el tamaño de la pizza-FAV
    public void guardarTamPizzaFavorita(String tamPizza) {
        SharedPreferences.Editor editPizzaFav = sharedPreferences.edit();
        editPizzaFav.putString("miPizzaFavoritaTam", tamPizza);
        editPizzaFav.apply();
    }
    public String obtenerPizzaFavoritaTam() {
        return  sharedPreferences.getString("miPizzaFavoritaTam", "");
    }
}
