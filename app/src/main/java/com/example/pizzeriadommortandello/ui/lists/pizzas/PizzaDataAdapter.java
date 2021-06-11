package com.example.pizzeriadommortandello.ui.lists.pizzas;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.model.Pizza;
import com.example.pizzeriadommortandello.ui.fragments.pizzas.PizzaDataViewHolder;

import java.util.ArrayList;

public class PizzaDataAdapter extends RecyclerView.Adapter<PizzaDataViewHolder> {

    private ArrayList<Pizza> pizzas;
    private OnClickEditStatusListener listener;
    private SparseBooleanArray toggleInfo;

    public interface OnClickEditStatusListener{
        void onClickEditPizza(Pizza pizza);
    }

    public PizzaDataAdapter(ArrayList<Pizza> pizzas){
        this.pizzas = pizzas;
        this.toggleInfo = new SparseBooleanArray();
    }

    @NonNull
    @Override
    public PizzaDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.menu_item_view, parent, false);
        return new PizzaDataViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull PizzaDataViewHolder holder, int position) {
        holder.bind(this.pizzas.get(position));
    }

    @Override
    public int getItemCount() {
        return this.pizzas.size();
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
