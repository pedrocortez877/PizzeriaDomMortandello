package com.example.pizzeriadommortandello.ui.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaCodec;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.data.DAOPizzasSingleton;
import com.example.pizzeriadommortandello.model.Pizza;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout lnlvMenuPizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.lnlvMenuPizzas = findViewById(R.id.lnlvMenuPizzas);
        this.buildMenuPizzas();
    }

    public void buildMenuPizzas(){
        for(Pizza pizza : DAOPizzasSingleton.getInstance().getPizzas()) {
            View view = getLayoutInflater().inflate(R.layout.menu_item_view, this.lnlvMenuPizzas, false);
            TextView txtPizzaName = view.findViewById(R.id.txtPizzaName);
            txtPizzaName.setText(pizza.getName());
            TextView txtPizzaPrice = view.findViewById(R.id.txtPizzaPrice);
            Double small = Double.parseDouble(pizza.getPrice()) * 0.75;
            Double base = Double.parseDouble(pizza.getPrice());
            Double big = Double.parseDouble(pizza.getPrice()) * 1.25;
            txtPizzaPrice.setText("P: R$" + small + " " + "M: R$" + base + " " + "G: R$" + big);
            view.setTag(pizza);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Pizza p = (Pizza) view.getTag();
                    showPizzaInfo(p);
                }
            });
            this.lnlvMenuPizzas.addView(view);
        }
    }

     public void showPizzaInfo(Pizza pizza){
         AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
         dialogBuilder.setTitle(R.string.pizza_info);
         View view = getLayoutInflater().inflate(R.layout.show_pizza_info_dialog, null);
         dialogBuilder.setView(view);
         TextView txtPizzaName = view.findViewById(R.id.txtFlavor);
         txtPizzaName.setText(pizza.getName());
         TextView txtPizzaIngredients = view.findViewById(R.id.txtIngredient);
         txtPizzaIngredients.setText(pizza.getIngredients());
         TextView txtPizzaPrice = view.findViewById(R.id.txtPrice);
         Double small = Double.parseDouble(pizza.getPrice()) * 0.75;
         Double base = Double.parseDouble(pizza.getPrice());
         Double big = Double.parseDouble(pizza.getPrice()) * 1.25;
         txtPizzaPrice.setText("P: R$" + small + " " + "M: R$" + base + " " + "G: R$" + big);
         dialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                //do nothing
             }
         });
         dialogBuilder.create().show();
     }


}