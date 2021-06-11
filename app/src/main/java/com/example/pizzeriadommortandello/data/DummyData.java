package com.example.pizzeriadommortandello.data;

import com.example.pizzeriadommortandello.model.Pizza;

public class DummyData {
    public DummyData() {
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(1, "Calabresa", "Muçarela, Orégano, Azeitona, Cebola, Calabresa e Tomate", 45.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(2, "Prestígio", "Creme de Coco, Chocolate ao Leite e Cereja", 53.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(3, "Muçarela", "Muçarela, Orégano, Azeitona e Tomate", 45.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(4, "Presunto", "Muçarela, Orégano, Azeitona, Cebola, Presunto e Tomate", 45.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(5, "Creme de Milho", "Muçarela, Orégano, Azeitona, Creme de Milho, Milho Cozido, Parmesão e Tomate", 45.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(6, "Atum", "Muçarela, Orégano, Azeitona, Cebola, Atum, Palmito e Tomate", 51.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(7, "Aliche (Peixe)", "Muçarela, Orégano, Azeitona, Aliche e Tomate", 51.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(8, "Palmito", "Muçarela, Orégano, Azeitona, Cebola, Palmito e Tomate", 52.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(9, "Quatro Queijos", "Muçarela, Orégano, Azeitona, Parmesão, Gorgonzola, Catupiry e Tomate", 53.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(10, "Frango com Catupiry", "Muçarela, Orégano, Azeitona, Filé de Peito de Frango, Catupiry e Molho ao Sugo", 52.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(11, "Portuguesa", "Muçarela, Orégano, Azeitona, Cebola, Presunto, Ervilha, Palmito, Calabresa, Ovo e Tomate", 53.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(12,"Parmegiana", "Muçarela, Orégano, Azeitona, Presunto, Parmesão, Tomate, Bacon e Molho ao Sugo", 51.0));
        DAOPizzasSingleton.getInstance().addPizza(new Pizza(13, "Calabresa com Catupiry", "Muçarela, Orégano, Azeitona, Cebola, Calabresa, Catupiry e Tomate", 49.0));
    }
}

