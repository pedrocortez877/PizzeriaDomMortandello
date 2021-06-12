package com.example.pizzeriadommortandello.ui.fragments.pizzas;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pizzeriadommortandello.R;
import com.example.pizzeriadommortandello.data.DAOPizzasSingleton;
import com.example.pizzeriadommortandello.ui.fragments.list_builders.PizzaListBuilder;

public class ListPizzasFragment extends Fragment {
    public static final String TAG = "ListPizzasMenu";

    public ListPizzasFragment() { super(R.layout.list_pizzas_fragment); }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        new PizzaListBuilder(getActivity(), R.id.rvPizzas)
                .load(DAOPizzasSingleton.getInstance().getPizzas(), getActivity());
    }
}
