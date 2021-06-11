package com.example.pizzeriadommortandello.ui.activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.data.DAOPizzasSingleton;
import com.example.pizzeriadommortandello.data.DummyData;
import com.example.pizzeriadommortandello.model.Pizza;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int FORM_REQUEST_CODE = 2211;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DummyData();
    }

    public void onClickPizzaRegister(View view){
        Intent openPizzaForms = new Intent(this, RegisterPizzaActivity.class);
        startActivityForResult(openPizzaForms, FORM_REQUEST_CODE);
    }

    public void onClickMenu(View view){
        Intent openPizzaMenu = new Intent(this, MenuActivity.class);
        startActivity(openPizzaMenu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == FORM_REQUEST_CODE && resultCode == RESULT_OK && data != null){
            Pizza pizza = data.getParcelableExtra(RegisterPizzaActivity.RESULT_KEY);
            DAOPizzasSingleton.getInstance().addPizza(pizza);
        }
    }
}