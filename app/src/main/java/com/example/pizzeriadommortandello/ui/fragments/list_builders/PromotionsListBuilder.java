package com.example.pizzeriadommortandello.ui.fragments.list_builders;

import android.app.Activity;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeriadommortandello.model.Promotion;
import com.example.pizzeriadommortandello.ui.lists.promotions.PromotionDataAdapter;

import java.util.ArrayList;

public class PromotionsListBuilder {
    private RecyclerView rvPromotions;
    private LinearLayoutManager layoutManager;
    private PromotionDataAdapter adapter;

    public PromotionsListBuilder(Activity activity, @IdRes int resRV){
        this.rvPromotions = activity.findViewById(resRV);
        this.layoutManager = new LinearLayoutManager(activity);
        this.rvPromotions.setLayoutManager(this.layoutManager);
        this.adapter = null;
    }

    public PromotionsListBuilder load(ArrayList<Promotion> promotions, Activity activity){
        this.adapter = new PromotionDataAdapter(promotions, activity);
        this.rvPromotions.setAdapter(this.adapter);
        return this;
    }
}
