package com.example.pizzeriadommortandello.ui.components;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.model.Pizza;

public class CustomDialog extends Dialog implements View.OnClickListener
{
    public Activity activity;
    public Button btn;
    private Pizza pizza;

    public CustomDialog(Activity parentActivity, Pizza pizza) {
        super(parentActivity);
        this.activity = parentActivity;
        this.pizza = pizza;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.show_pizza_info_dialog);
        btn = (Button) findViewById(R.id.btnClose);
        btn.setOnClickListener(this);
        ((TextView) findViewById(R.id.txtFlavor)).setText(pizza.getName());
        ((TextView) findViewById(R.id.txtIngredient)).setText(pizza.getIngredients());
        Double small = Double.parseDouble(pizza.getPrice()) * 0.75;
        Double base = Double.parseDouble(pizza.getPrice()) * 0.75;
        Double big = Double.parseDouble(pizza.getPrice()) * 1.25;
        ((TextView) findViewById(R.id.txtPriceP)).setText("P: " + "\nR$" + small + "  ");
        ((TextView) findViewById(R.id.txtPriceM)).setText("M: " + "\nR$" + base + "  ");
        ((TextView) findViewById(R.id.txtPriceG)).setText("G: " + "\nR$" + big + "  ");
    }

    @Override
    public void onClick(View view) {
        dismiss();
    }
}
