package com.example.pizzeriadommortandello.ui.fragments.promotions;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.model.Pizza;
import com.example.pizzeriadommortandello.model.Promotion;
import com.example.pizzeriadommortandello.ui.activitys.MenuActivity;
import com.example.pizzeriadommortandello.ui.activitys.PromotionInfoActivity;
import com.example.pizzeriadommortandello.ui.lists.promotions.PromotionDataAdapter;

import java.math.BigDecimal;

public class PromotionsDataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private Promotion promotion;
    private final TextView txtPromotionName;
    private final TextView txtPromotionDiscount;
    private final PromotionDataAdapter adapter;
    private final ImageView imgBtn;

    public PromotionsDataViewHolder(@NonNull View itemView, PromotionDataAdapter adapter){
        super(itemView);
        this.txtPromotionName = itemView.findViewById(R.id.txtPromotionName);
        this.txtPromotionDiscount = itemView.findViewById(R.id.txtPromotionDiscount);
        this.imgBtn = itemView.findViewById(R.id.imageViewPromotion);
        itemView.setOnClickListener(this);
        imgBtn.setOnClickListener(this);
        this.adapter = adapter;
    }

    public void Bind(Promotion promotion){
        this.promotion = promotion;
        this.txtPromotionName.setText(promotion.getNome());
        String promotionDiscount = "";
        promotionDiscount += "Desconto: " + BigDecimal.valueOf(promotion.getDesconto()).setScale(0,BigDecimal.ROUND_HALF_UP) + "%\n";
        promotionDiscount += "Pizzas: \n";
        for(Pizza pizza : promotion.getPizzas()){
            promotionDiscount += pizza.getName() + "\n";
        }
        this.txtPromotionDiscount.setText(promotionDiscount);
        this.updateOpenView();
    }

    private void updateOpenView() {
        boolean isOpen = adapter.getOpenViewCacheFor(this.promotion.getId());
        this.txtPromotionDiscount.setVisibility(isOpen ? View.VISIBLE : View.GONE);
    }

    private void toggleDescription() {
        boolean isVisible = this.txtPromotionDiscount.getVisibility() == View.VISIBLE;
        int visibility;
        if(isVisible) {
            visibility = View.GONE;
            this.adapter.unsetOpenViewCacheFor(this.promotion.getId());
        }
        else {
            visibility = View.VISIBLE;
            this.adapter.setOpenViewCacheFor(this.promotion.getId());
        }
        this.txtPromotionDiscount.setVisibility(visibility);
    }

    private void showPromotionInfo(Promotion promotion){
        Intent openPromotionInfo = new Intent(this.adapter.getActivity(), PromotionInfoActivity.class);
        openPromotionInfo.putExtra(PromotionInfoActivity.KEY, promotion);
        this.adapter.getActivity().startActivity(openPromotionInfo);
    }


    @Override
    public void onClick(View view) {
        if(itemView == view){
            this.toggleDescription();
        }else{
            this.showPromotionInfo(this.promotion);
        }
    }
}
