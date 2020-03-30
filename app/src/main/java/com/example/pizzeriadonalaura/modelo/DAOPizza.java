package com.example.pizzeriadonalaura.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.pizzeriadonalaura.pojos.Ingredientes;
import com.example.pizzeriadonalaura.pojos.Pizza;
import java.util.ArrayList;
import java.util.List;


public class DAOPizza extends SQLiteOpenHelper {
    private static DAOPizza pizzaSingleton;
    private static final String DB= "Pizeria";
    private static final int DBVersion = 1;


    //Constructor
    public DAOPizza(Context context){
        super(context, DB, null, DBVersion);
    }

    //SINGLETON DIVIDIDO EN 2 MÉTODOS
    public static void createInstance(Context context){
        pizzaSingleton = new DAOPizza(context);
    }
    public static DAOPizza getInstance(){
        return pizzaSingleton;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Sentencia SQL para crea las tablas de la DB
        String sqlCrearTablaPizza = "CREATE TABLE IF NOT EXISTS Pizzas (nombre_pizza TEXT, tam_pizza TEXT)";
        String sqlCrearTablaIngredientes = "CREATE TABLE IF NOT EXISTS Ingredientes (nombre_ingredientes TEXT, precio DECIMAL)";
        String sqlCrearTablaComun = "CREATE TABLE IF NOT EXISTS PizzaIngredientes (nombre_pizzafk TEXT, nombre_ingredientesfk TEXT)";

        db.execSQL(sqlCrearTablaPizza);
        db.execSQL(sqlCrearTablaIngredientes);
        db.execSQL(sqlCrearTablaComun);

        //Recibirá la respuesta de la DB
        // Que si no encuentra las tuplas nos creará la DB
        Cursor cursorPizza = db.rawQuery("SELECT * FROM Pizzas", null);
        //Sino existen tuplas
        if(!cursorPizza.moveToFirst()){
            //Insertamos Pizzas
            db.execSQL("INSERT INTO Pizzas (nombre_pizza, tam_pizza) VALUES ('Carbonara', 'Mediana')");
            db.execSQL("INSERT INTO Pizzas (nombre_pizza, tam_pizza) VALUES ('Margarita', 'Mediana')");
            db.execSQL("INSERT INTO Pizzas (nombre_pizza, tam_pizza) VALUES ('Tunara', 'Mediana') ");
            db.execSQL("INSERT INTO Pizzas (nombre_pizza, tam_pizza) VALUES ('Mexicana', 'Mediana') ");
            db.execSQL("INSERT INTO Pizzas (nombre_pizza, tam_pizza) VALUES ('Peperonni', 'Mediana') ");
            db.execSQL("INSERT INTO Pizzas (nombre_pizza, tam_pizza) VALUES ('Capricciossa', 'Mediana') ");
            db.execSQL("INSERT INTO Pizzas (nombre_pizza, tam_pizza) VALUES ('Especial', 'Mediana') ");
            db.execSQL("INSERT INTO Pizzas (nombre_pizza, tam_pizza) VALUES ('Carnivora', 'Mediana') ");

            //Insertamos ingredientes
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Huevo', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Nata', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Bacon', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Tomate', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Queso', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Atun', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Oregano', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Chorizo', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Guindilla', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Pepperonni', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Pimiento', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Mimole', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Jamon', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Ternera', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Harvatti', 2.5)");
            db.execSQL("INSERT INTO Ingredientes (nombre_ingredientes, precio) VALUES ('Salsa-bbq', 2.5)");

            //Insertamos Relaciones
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Carbonara', 'Huevo')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Carbonara', 'Nata')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Carbonara', 'Bacon')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Margarita', 'Tomate')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Margarita', 'Queso')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Margarita', 'Oregano')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Tunara', 'Atun')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Tunara', 'Tomate')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Tunara', 'Queso')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Mexicana', 'Chorizo')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Mexicana', 'Tomate')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Mexicana', 'Guindilla')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Capricciossa', 'Huevo')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Capricciossa', 'Mimole')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Capricciossa', 'Jamon')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Especial', 'Ternera')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Especial', 'Bacon')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Especial', 'Harvatti')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Carnivora', 'Bacon')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Carnivora', 'Ternera')");
            db.execSQL("INSERT INTO PizzaIngredientes (nombre_pizzafk, nombre_ingredientesfk) VALUES ('Carnivora', 'Salsa-bbq')");

        }

        cursorPizza.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Aqui eliminaremos la tabla anterior y la crearemos de nuevo vacía dependiento de la version de la DB
    }




    public List<Pizza> getPizzas(){
        List<Pizza> misPizzas = new ArrayList<Pizza>();

        String sqlPizza = "SELECT * FROM Pizzas";
        // Para escribir getWritableDatabase()
        SQLiteDatabase db = getReadableDatabase(); //Para leer
        Cursor cursorPizza = db.rawQuery(sqlPizza, null);

        if(cursorPizza.moveToFirst()){
            do {
                String nombrePizza = cursorPizza.getString(0);
                String sqlIngredientes = "SELECT Ingredientes.nombre_ingredientes, Ingredientes.precio FROM Ingredientes " +
                        "INNER JOIN PizzaIngredientes ON PizzaIngredientes.nombre_ingredientesfk = Ingredientes.nombre_ingredientes " +
                        "INNER JOIN Pizzas ON Pizzas.nombre_pizza = PizzaIngredientes.nombre_pizzafk " +
                        "WHERE PizzaIngredientes.nombre_pizzafk = '" +nombrePizza+ "'";

                List<Ingredientes> lstIngredientes = new ArrayList<>();
                Cursor cursorIngredientes = db.rawQuery(sqlIngredientes, null);
                if(cursorIngredientes.moveToFirst()){
                    do {
                        Ingredientes  ingAux = new Ingredientes(cursorIngredientes.getString(0), cursorIngredientes.getDouble(1));
                        lstIngredientes.add(ingAux);
                    } while(cursorIngredientes.moveToNext());
                }

                cursorIngredientes.close();

               Pizza pizza = new Pizza(nombrePizza, cursorPizza.getString(1), lstIngredientes);
                misPizzas.add(pizza);
            }while (cursorPizza.moveToNext());
        }
        cursorPizza.close();
        return misPizzas;
    }
}
