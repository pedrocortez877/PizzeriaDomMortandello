package com.example.pizzeriadommortandello.ui.fragments.list_builders;

import android.app.Activity;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeriadommortandello.model.Pizza;
import com.example.pizzeriadommortandello.ui.lists.pizzas.PizzaDataAdapter;

import java.util.ArrayList;

public class PizzaListBuilder{
    private RecyclerView rvPizzas;
    private LinearLayoutManager layoutManager;
    private PizzaDataAdapter adapter;

    public PizzaListBuilder(Activity activity, @IdRes int resRV){
        this.rvPizzas = activity.findViewById(resRV);
        this.layoutManager = new LinearLayoutManager(activity);
        this.rvPizzas.setLayoutManager(this.layoutManager);
        this.adapter = null;
    }

    public PizzaListBuilder load(ArrayList<Pizza> pizzas, Activity activity){
        this.adapter = new PizzaDataAdapter(pizzas, activity);
        this.rvPizzas.setAdapter(this.adapter);
        return this;
    }
}
