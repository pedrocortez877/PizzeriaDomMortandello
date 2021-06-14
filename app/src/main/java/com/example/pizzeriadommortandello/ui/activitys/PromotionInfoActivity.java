package com.example.pizzeriadommortandello.ui.activitys;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.model.Pizza;
import com.example.pizzeriadommortandello.model.Promotion;
import com.example.pizzeriadommortandello.ui.fragments.pizzas.ListPizzasFragment;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class PromotionInfoActivity extends AppCompatActivity {
    public static String KEY = "PromotionInfoActivity.PROMOTION";
    private Promotion promotion;
    private TextView txtPromotionName;
    private TextView txtPromotionDiscount;
    private TextView txtTotalPriceDiscountInfo;
    private Bundle bundle = new Bundle();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_info);

        this.txtPromotionName = findViewById(R.id.txtPromotionNameInfo);
        this.txtPromotionDiscount = findViewById(R.id.txtPromotionDiscountInfo);
        this.txtTotalPriceDiscountInfo = findViewById(R.id.txtTotalPriceDiscountInfo);

        this.promotion = getIntent().getParcelableExtra(KEY);

        this.txtPromotionName.setText(this.promotion.getNome());
        String desconto = "";
        Double price = 0.0;

        ListPizzasFragment l = new ListPizzasFragment();

        bundle.putParcelableArrayList(ListPizzasFragment.KEYPIZZAS, promotion.getPizzas());

        l.setArguments(bundle);

        desconto += BigDecimal.valueOf(promotion.getDesconto()).setScale(0, BigDecimal.ROUND_HALF_UP);
        this.txtPromotionDiscount.setText(desconto);

        for(Pizza pizza : promotion.getPizzas()){
            price += Double.parseDouble(pizza.getPrice());
        }

        this.txtTotalPriceDiscountInfo.setText("R$: " + price.toString());

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fcvPizzasDiscountInfo, l, ListPizzasFragment.KEYPIZZAS)
                .commit();
    }
}
