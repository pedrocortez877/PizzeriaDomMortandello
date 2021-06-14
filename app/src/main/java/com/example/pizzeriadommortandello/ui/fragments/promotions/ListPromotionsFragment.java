package com.example.pizzeriadommortandello.ui.fragments.promotions;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.data.DAOPromotionsSingleton;
import com.example.pizzeriadommortandello.ui.fragments.list_builders.PromotionsListBuilder;

import org.jetbrains.annotations.NotNull;

public class ListPromotionsFragment extends Fragment {
    public static final String TAG = "ListPromotionsMenu";

    public ListPromotionsFragment() { super(R.layout.list_promotions_fragment); }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new PromotionsListBuilder(getActivity(), R.id.rvPromotions)
                .load(DAOPromotionsSingleton.getINSTANCE().getPromotions(), getActivity());
    }
}
