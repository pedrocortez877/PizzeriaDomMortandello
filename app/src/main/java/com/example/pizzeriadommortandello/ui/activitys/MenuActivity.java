package com.example.pizzeriadommortandello.ui.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaCodec;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pizzeriadommortandello.R;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout lnlvMenuPizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lnlvMenuPizzas = findViewById(R.id.lnlvMenuPizzas);
        this.buildMenuPizzas();
    }

    public void buildMenuPizzas(){
        View view = getLayoutInflater().inflate(R.layout.menu_item_view, this.lnlvMenuPizzas, false);
        TextView txtPizzaName = findViewById(R.id.txtPizzaName);
        txtPizzaName.setText("Pizza de Calabresa");
        TextView txtPizzaPrice = findViewById(R.id.txtPizzaPrice);
        txtPizzaPrice.setText("P: "+ "R$20,00" + "M: " + "R$30,00" + "G: " + "R$40,00");
        this.lnlvMenuPizzas.addView(view);
    }

     public void showPizzaInfo(){
         AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
         dialogBuilder.setTitle("Pizza de Calabreza");
         View view = getLayoutInflater().inflate(R.layout.show_pizza_info_dialog, null);
         dialogBuilder.setView(view);
         TextView txtPizzaIngredients = view.findViewById(R.id.txtIngredient);
         txtPizzaIngredients.setText("Molho de tomate, presunto, mussarela e calabresa");
         TextView txtPizzaPrice = view.findViewById(R.id.txtIngredient);
         txtPizzaPrice.setText("P: "+ "R$20,00" + "M: " + "R$30,00" + "G: " + "R$40,00");
     }


}