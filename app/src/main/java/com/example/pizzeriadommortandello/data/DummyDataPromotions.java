package com.example.pizzeriadommortandello.data;

import com.example.pizzeriadommortandello.model.Pizza;
import com.example.pizzeriadommortandello.model.Promotion;

import java.util.ArrayList;

public class DummyDataPromotions {
    private int numPromos = 5;
    private int numMaxPizzas = 3;
    private int minPCT = 5;
    private int maxPCT = 20;
    private int numPizzas;
    private double pctDesc;
    private Promotion promocao;
    private int id = 1;
    private int indice = 0;
    public ArrayList<Pizza> pizzas = DAOPizzasSingleton.getInstance().getPizzas();

    public DummyDataPromotions(){
        for(int i=0; i<numPromos; i++){
            if(!pizzas.isEmpty()){
                ArrayList<Pizza> pizzasPromotion = new ArrayList<>();
                numPizzas = (int) Math.ceil(Math.random() * (numMaxPizzas - 1) + 1);
                pctDesc = Math.random() * (maxPCT - minPCT) + minPCT;
                promocao = new Promotion();
                promocao.setId(id);
                promocao.setNome("Promoção" + id);
                promocao.setDesconto(pctDesc);
                id++;
                for(int j=0; j<numPizzas; j++){
                    indice = (int) Math.ceil(Math.random() * (pizzas.size() - 0));
                    if(pizzas.get(indice-1) != null){
                        pizzasPromotion.add(pizzas.get(indice-1));
                    }
                }
                promocao.setPizzas(pizzasPromotion);
                DAOPromotionsSingleton.getINSTANCE().addPromotion(promocao);
            }
        }
    }


}
