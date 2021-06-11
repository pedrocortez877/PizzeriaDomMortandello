package com.example.pizzeriadommortandello.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pizza implements Parcelable {

    private int id;
    private String name;
    private Double price;
    private String ingredients;

    public Pizza(int id, String name, String ingredients, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public int getId(){ return id; }

    public String getName() {
        return name;
    }


    public String getPrice() {
        String p = Double.toString(this.price);
        return p;
    }


    public String getIngredients() {
        return ingredients;
    }


    protected Pizza(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        ingredients = in.readString();
    }

    public static final Creator<Pizza> CREATOR = new Creator<Pizza>() {
        @Override
        public Pizza createFromParcel(Parcel in) {
            return new Pizza(in);
        }

        @Override
        public Pizza[] newArray(int size) {
            return new Pizza[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeDouble(price);
        parcel.writeString(ingredients);
    }
}
