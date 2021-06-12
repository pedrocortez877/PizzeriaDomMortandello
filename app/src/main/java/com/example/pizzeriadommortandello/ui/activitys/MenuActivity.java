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
import com.example.pizzeriadommortandello.ui.fragments.pizzas.ListPizzasFragment;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fcvListPizzas, ListPizzasFragment.class, savedInstanceState, ListPizzasFragment.TAG)
                .commit();
    }
}