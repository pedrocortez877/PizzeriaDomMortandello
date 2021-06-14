package com.example.pizzeriadommortandello.data;

import com.example.pizzeriadommortandello.model.Promotion;

import java.util.ArrayList;

public class DAOPromotionsSingleton {
    private static DAOPromotionsSingleton INSTANCE;

    private ArrayList<Promotion> promotions;

    private DAOPromotionsSingleton() { this.promotions = new ArrayList<>(); }

    public static DAOPromotionsSingleton getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new DAOPromotionsSingleton();
        }
        return INSTANCE;
    }

    public ArrayList<Promotion> getPromotions(){ return this.promotions; }

    public void addPromotion(Promotion promotion){ this.promotions.add(promotion); }
}
