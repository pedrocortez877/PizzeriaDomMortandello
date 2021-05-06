package com.example.pizzeriadommortandello.ui.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.pizzeriadommortandello.R;

public class RegisterPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pizza);
    }

    public void onClickSave(View view){
        finish();
    }
}