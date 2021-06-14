package com.example.pizzeriadommortandello.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Promotion implements Parcelable {

    private int id;
    private String nome;
    private Double desconto;
    private ArrayList<Pizza> pizzas;

    public Promotion(int id, String nome, Double desconto, ArrayList<Pizza> pizzas){
        this.id = id;
        this.nome = nome;
        this.desconto = desconto;
        this.pizzas = pizzas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public int getId(){
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public Double getDesconto() {
        return desconto;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public Promotion(){}

    protected Promotion(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        if (in.readByte() == 0) {
            desconto = null;
        } else {
            desconto = in.readDouble();
        }
        pizzas = in.createTypedArrayList(Pizza.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nome);
        if (desconto == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(desconto);
        }
        dest.writeTypedList(pizzas);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Promotion> CREATOR = new Creator<Promotion>() {
        @Override
        public Promotion createFromParcel(Parcel in) {
            return new Promotion(in);
        }

        @Override
        public Promotion[] newArray(int size) {
            return new Promotion[size];
        }
    };

}
