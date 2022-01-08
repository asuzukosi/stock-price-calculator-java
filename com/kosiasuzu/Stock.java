package com.kosiasuzu;

public class Stock {
    private final String name;
    private int shares = 0;
    private double price = 0;
    private double capital = 0;

    Stock(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void buy(double buyingPrice, int quantity){
        this.shares += quantity;
        this.price = buyingPrice;
        this.capital += buyingPrice * quantity;
    }

    public boolean sell(double sellingPrice, int quantity){
        if (quantity > this.shares){
            return false;
        }
        this.shares -= quantity;
        this.price = sellingPrice;
        this.capital -= sellingPrice * quantity;
        return true;
    }

    public double getPrice(){
        return this.price;
    }

    public int getShares(){
        return this.shares;
    }

    public double getCapital(){
        return this.capital;
    }
    public double getAveragePrice(){
        return this.capital / this.shares;
    }
}
