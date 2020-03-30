package com.example.pizzeriadonalaura.pojos;

import java.io.Serializable;

public class Ingredientes implements Serializable {
    private String nombreIngrediente;
    private double precioIngrediente;

    //CONSTRUCTOR
    public Ingredientes(String nombreIngrediente, Double precioDefecto){
        this.nombreIngrediente = nombreIngrediente;
        this.precioIngrediente = precioDefecto;
    }

    //CONSTRUCTOR
    public Ingredientes(String nombreIngrediente){
        this.nombreIngrediente = nombreIngrediente;
        this.precioIngrediente = 2.5;
    }

    //Métodos SETTER & GETTER
    public String getNombreIngrediente(){
        return this.nombreIngrediente;
    }
    public double getPrecioIngrediente() {return precioIngrediente;}

    public void setIngredientes(String nombreIngrediente){ this.nombreIngrediente = nombreIngrediente;}
    public void setPrecioIngrediente(String precioIngrediente){ this.precioIngrediente = getPrecioIngrediente();}
}
