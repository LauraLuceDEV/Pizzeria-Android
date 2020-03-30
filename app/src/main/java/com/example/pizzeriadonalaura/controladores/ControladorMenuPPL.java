package com.example.pizzeriadonalaura.controladores;

import com.example.pizzeriadonalaura.modelo.DAOPizza;
import com.example.pizzeriadonalaura.modelo.DAOPreferenceLogin;
import com.example.pizzeriadonalaura.pojos.Ingredientes;
import com.example.pizzeriadonalaura.pojos.Pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ControladorMenuPPL {

    public static void modificarColorFondo(int idColor){
        DAOPreferenceLogin.getInstanceLoggin().guardarColorFondo(idColor);
    }

    public static int getColorBck(){
        return DAOPreferenceLogin.getInstanceLoggin().obtenerColorFondo();
    }

    //OPCION QUE LLAMA AL DAO
    public static void opcionPizzaFavorita(boolean checkFavorita) {
       DAOPreferenceLogin.getInstanceLoggin().guardarOpcionFavorita(checkFavorita);
    }

    public static boolean obtenerOpcionPizzaFavorita() {
       return DAOPreferenceLogin.getInstanceLoggin().obtenerOpcionPizzaFavorita();
    }

    //Método que llama al DAOPreferences y nos coimprueba si existe una Pizza Favorita
    public static String comprobacionExisteFavorita() {
        return  DAOPreferenceLogin.getInstanceLoggin().obtenerPizzaFavorita();
    }

    //GUARDAR en la SHARED-PREFERENCES LA PIZZA FAVORITA
    public static void guardarPizzaFavorita(Pizza pizzaFav){
        //Guardar la lista de ingredientes
        List<String> lstIngredientes = new ArrayList<>();
        for (int i=0; i < pizzaFav.getListaIngredientesPizza().size(); i++){
            lstIngredientes.add(pizzaFav.getListaIngredientesPizza().get(i).getNombreIngrediente());
        }

        DAOPreferenceLogin.getInstanceLoggin().guardarPizzaFavorita(pizzaFav.getNombrePizza());
        DAOPreferenceLogin.getInstanceLoggin().guardarIngredientesFavoritos(lstIngredientes);
        DAOPreferenceLogin.getInstanceLoggin().guardarTamPizzaFavorita(pizzaFav.getTamPizza());
    }

    //OBTENER DE LA SHARED-PREFERENCE LA PIZZA FAVORITA
    public static Pizza obtenerPizzaFavorita(){

        String nombrePizzaFav = DAOPreferenceLogin.getInstanceLoggin().obtenerPizzaFavorita();
        String tamPizzaFav = DAOPreferenceLogin.getInstanceLoggin().obtenerPizzaFavoritaTam();

        List<Ingredientes> lstIngredientes = new ArrayList<>();
        Set<String> ingredientesPizzaFav = DAOPreferenceLogin.getInstanceLoggin().obtenerPizzaFavoritaIngredientes();
        //Rellenar Lista
        for(String ingrediente : ingredientesPizzaFav){
            Ingredientes ing1 = new Ingredientes(ingrediente);
            lstIngredientes.add(ing1);
        }

        Pizza pizzaFav = new Pizza(nombrePizzaFav, tamPizzaFav,lstIngredientes);
        return pizzaFav;
    }

    //Combierte la Lista de ingredientes en un 'String/Cadena Texto
    public static String obtenerStringIngredientes(List<Ingredientes> lstIngredietnes) {
        String ingredientes = "";
        for(int i=0; i < lstIngredietnes.size(); i++){
            ingredientes += lstIngredietnes.get(i).getNombreIngrediente() + " ";
        }
        return ingredientes;
    }

    //Obtener Listado de Pizzas por defecto
    public static Pizza[] obtenerListadoPizzasMenuCasa() {
        List<Pizza> pizzaList =  DAOPizza.getInstance().getPizzas();

        Pizza[] misPizzas = new Pizza[pizzaList.size()];

        for(int i=0; i < pizzaList.size(); i++){
            misPizzas[i] = pizzaList.get(i);
        }

        return misPizzas;
    }
}
