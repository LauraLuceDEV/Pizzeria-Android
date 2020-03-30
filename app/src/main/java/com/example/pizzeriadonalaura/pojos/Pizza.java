package com.example.pizzeriadonalaura.pojos;

import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;

/**
 * Nuestra clase Pizza tendrá instancias/Objetos Pizza
 */
public class Pizza implements Serializable {
    private String nombrePizza;
    private String tamPizza;
    private List<Ingredientes> ingredientesPizza;


    //Constructor
    public Pizza(String nombrePizza, String tamPizza, List<Ingredientes> ingredientesPizza){
        this.nombrePizza = nombrePizza;
        this.tamPizza = tamPizza;
        this.ingredientesPizza = ingredientesPizza;
    }
    //MÉTODOS

    //Métodos SETTER & GETTER
    //Set
    public void setNombrePizza(String nombrePizza){this.nombrePizza = nombrePizza;}
    public void setTamPizza(String tam){this.tamPizza = tam;}
    public void setListaIngredientesPizza(List<Ingredientes> ingredientesPizza){ this.ingredientesPizza = ingredientesPizza;}
    //Get
    public String getNombrePizza(){  return this.nombrePizza;}
    public  String getTamPizza(){return this.tamPizza;}
    public List<Ingredientes> getListaIngredientesPizza(){ return this.ingredientesPizza;}


    //Metodo que devuelve el precio de una pizza
    public double getPrecioPizza(){
        double precioPizza = 0;

        if(this.tamPizza.equals("Mediana")){
            precioPizza = 2;
        }else { precioPizza = 3.5; }

        for(int i=0; i < ingredientesPizza.size(); i++){
            precioPizza += ingredientesPizza.get(i).getPrecioIngrediente();
        }
        return precioPizza;
    }


    //Metodo toString -- Por el momento no lo encuentro necesario
    //public String toString(){return this.nombrePizza;}
}