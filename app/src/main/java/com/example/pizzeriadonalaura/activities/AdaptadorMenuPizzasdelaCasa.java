package com.example.pizzeriadonalaura.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.pizzeriadonalaura.R;
import com.example.pizzeriadonalaura.controladores.ControladorMenuPPL;
import com.example.pizzeriadonalaura.pojos.Pizza;

public class AdaptadorMenuPizzasdelaCasa extends ArrayAdapter<Pizza> {

    public AdaptadorMenuPizzasdelaCasa(Context context, Pizza[] lstMenuPizza){
        super(context, R.layout.plantilla_listview, lstMenuPizza);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.plantilla_listview, null);

        Pizza pizza = getItem(position);

        TextView tvNombrePizza = item.findViewById(R.id.lstMenuCasaNombrePizza);
        tvNombrePizza.setText(pizza.getNombrePizza());

        TextView tvIngredientesPizza = item.findViewById(R.id.lstMenuCasaIngredientesPizza);
        tvIngredientesPizza.setText(ControladorMenuPPL.obtenerStringIngredientes(pizza.getListaIngredientesPizza()));

        TextView tvTamPrecioPizza = item.findViewById(R.id.lstMenuCasaTamPizza);
        tvTamPrecioPizza.setText(pizza.getTamPizza());

        return item;
    }
}
