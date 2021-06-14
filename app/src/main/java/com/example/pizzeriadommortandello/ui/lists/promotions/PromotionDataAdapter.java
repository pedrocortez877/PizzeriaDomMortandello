package com.example.pizzeriadommortandello.ui.lists.promotions;

import android.app.Activity;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.model.Promotion;
import com.example.pizzeriadommortandello.ui.fragments.pizzas.PizzaDataViewHolder;
import com.example.pizzeriadommortandello.ui.fragments.promotions.PromotionsDataViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PromotionDataAdapter extends RecyclerView.Adapter<PromotionsDataViewHolder> {
    private ArrayList<Promotion> promotions;
    private SparseBooleanArray toggleInfo;
    private Activity activity;

    public PromotionDataAdapter(ArrayList<Promotion> promotions, Activity activity){
        this.promotions = promotions;
        this.promotions.sort((pr1, pr2) -> pr1.getNome().compareTo(pr2.getNome()));
        this.activity = activity;
        this.toggleInfo = new SparseBooleanArray();
    }

    public Activity getActivity(){
        return this.activity;
    }

    @NonNull
    @Override
    public PromotionsDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.promotion_item_view, parent, false);
        return new PromotionsDataViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionsDataViewHolder holder, int position) {
        holder.Bind(this.promotions.get(position));
    }

    @Override
    public int getItemCount() {
        return this.promotions.size();
    }

    public void setOpenViewCacheFor(int id) {
        this.toggleInfo.put(id, true);
    }

    public void unsetOpenViewCacheFor(int id) {
        this.toggleInfo.delete(id);
    }

    public boolean getOpenViewCacheFor(int id) {
        return this.toggleInfo.get(id, false);
    }
}
