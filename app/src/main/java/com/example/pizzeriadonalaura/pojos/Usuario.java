package com.example.pizzeriadonalaura.pojos;

public class Usuario {
    private String nombreUsuario;
    private String passUsuario;
    private Pizza pizzaFav;

    //Cosntructor sin Pizza
    public Usuario(String nombre, String pass){
        this.nombreUsuario = nombre;
        this.passUsuario = pass;
    }

    //Constructor con pizza
    public Usuario(String nombre, String pass, Pizza pizzaFav){
        this.nombreUsuario = nombre;
        this.passUsuario = pass;
        this.pizzaFav = pizzaFav;
    }

    //METODOS SETTER & GETTER
    public void setNombreUsuario(String nombre){ this.nombreUsuario = nombre;}
    public void  setPassUsuario(String pass){ this.passUsuario = pass;}
    public void setPizzaFav(Pizza pizzaFav){ this.pizzaFav = pizzaFav;}

    public String getNombreUsuario(){ return  this.nombreUsuario;}
    public  String getPassUsuario(){ return  this.passUsuario;}
    public Pizza getPizzaFav(){return this.pizzaFav;}
}
