package com.example.pizzeriadommortandello.ui.activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.ui.fragments.promotions.ListPromotionsFragment;

public class PromotionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotions);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fcvListPromotions, ListPromotionsFragment.class, savedInstanceState, ListPromotionsFragment.TAG)
                .commit();
    }
}
