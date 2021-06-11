package com.example.pizzeriadommortandello.ui.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.model.Pizza;

public class RegisterPizzaActivity extends AppCompatActivity {

    public static final String RESULT_KEY = "RegisterPizzaActivity.RESULT_KEY";
    private TextView etxtPizzaName;
    private TextView etxtPizzaPrice;
    private TextView etxtPizzaIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pizza);
        this.etxtPizzaName = findViewById(R.id.etxtPizzaName);
        this.etxtPizzaPrice = findViewById(R.id.etxtPizzaPrice);
        this.etxtPizzaIngredients = findViewById(R.id.etxtPizzaIngredient);
    }

    public void onClickSave(View view){
        String pizzaName = this.etxtPizzaName.getText().toString();
        Double pizzaPrice = Double.parseDouble(this.etxtPizzaPrice.getText().toString());
        String pizzaIngredients = this.etxtPizzaIngredients.getText().toString();

        if(pizzaName.isEmpty() || pizzaPrice.toString().isEmpty() || pizzaIngredients.isEmpty()){
            return;
        }

        Pizza pizza = new Pizza(1, pizzaName, pizzaIngredients, pizzaPrice);

        Intent output = new Intent();
        output.putExtra(RESULT_KEY, pizza);
        setResult(RESULT_OK, output);
        finish();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}