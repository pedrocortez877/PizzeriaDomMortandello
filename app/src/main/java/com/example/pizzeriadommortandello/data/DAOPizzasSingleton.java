package com.example.pizzeriadommortandello.data;

import com.example.pizzeriadommortandello.model.Pizza;

import java.util.ArrayList;

public class DAOPizzasSingleton {
    private static DAOPizzasSingleton INSTANCE;

    private ArrayList<Pizza> pizzas;

    private DAOPizzasSingleton(){
        this.pizzas = new ArrayList<>();
    }

    public static DAOPizzasSingleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DAOPizzasSingleton();
        }
        return INSTANCE;
    }

    public ArrayList<Pizza> getPizzas(){
        return this.pizzas;
    }

    public void addPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }
}
