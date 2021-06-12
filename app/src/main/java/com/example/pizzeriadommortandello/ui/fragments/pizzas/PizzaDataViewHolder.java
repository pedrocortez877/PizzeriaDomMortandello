package com.example.pizzeriadommortandello.ui.fragments.pizzas;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.model.Pizza;
import com.example.pizzeriadommortandello.ui.components.CustomDialog;
import com.example.pizzeriadommortandello.ui.lists.pizzas.PizzaDataAdapter;

public class PizzaDataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Pizza pizza;
    private final TextView txtPizzaName;
    private final TextView txtPizzaPrice;
    private final TextView txtPizzaIngredients;
    private final PizzaDataAdapter adapter;

    public PizzaDataViewHolder(@NonNull View itemView, PizzaDataAdapter adapter){
        super(itemView);
        this.txtPizzaName = itemView.findViewById(R.id.txtPizzaName);
        this.txtPizzaPrice = itemView.findViewById(R.id.txtPizzaPrice);
        this.txtPizzaIngredients = itemView.findViewById(R.id.txtPizzaIngredient);
        itemView.setOnClickListener(this);
        txtPizzaPrice.setOnClickListener(this);
        this.adapter = adapter;
    }

    public void bind(Pizza pizza){
        this.pizza = pizza;
        this.txtPizzaName.setText(pizza.getName());
        this.txtPizzaPrice.setText(pizza.getPrice());
        this.txtPizzaIngredients.setText(pizza.getIngredients());
        this.updateOpenView();
    }

    private void updateOpenView() {
        boolean isOpen = adapter.getOpenViewCacheFor(this.pizza.getId());
        this.txtPizzaIngredients.setVisibility(isOpen ? View.VISIBLE : View.GONE);
    }

    private void toggleDescription() {
        boolean isVisible = this.txtPizzaIngredients.getVisibility() == View.VISIBLE;
        int visibility;
        if(isVisible) {
            visibility = View.GONE;
            this.adapter.unsetOpenViewCacheFor(this.pizza.getId());
        }
        else {
            visibility = View.VISIBLE;
            this.adapter.setOpenViewCacheFor(this.pizza.getId());
        }
        this.txtPizzaIngredients.setVisibility(visibility);
    }

    public void showPizzaInfo(Pizza pizza) {
        CustomDialog dialog = new CustomDialog(this.adapter.getActivity(), pizza);
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        if (itemView == v) {
            this.toggleDescription();
        }
        else {
            this.showPizzaInfo(this.pizza);
        }

    }
}
