package com.example.pizzeriadommortandello.ui.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeriadommortandello.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickPizzaRegister(View view){
        Intent openPizzaForms = new Intent(this, RegisterPizzaActivity.class);
        startActivity(openPizzaForms);
    }

    public void onClickMenu(View view){
        Intent openPizzaMenu = new Intent(this, MenuActivity.class);
        startActivity(openPizzaMenu);
    }
}