package com.kosiasuzu;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

    StockPriceCalculator.showPortfolio();
    StockPriceCalculator.buyStock("apple", 32.3, 200);
    StockPriceCalculator.buyStock("tesla", 41.2, 312);
    StockPriceCalculator.buyStock("google", 37.8, 223);

    StockPriceCalculator.sellStock("ethereum", 60.4, 211);
    StockPriceCalculator.sellStock("apple", 42.3, 100);

    StockPriceCalculator.buyStock("ethereum", 60.4, 211);

    StockPriceCalculator.showPortfolio();
    System.out.println("Your total capital is : " + StockPriceCalculator.getCapital());
    System.out.println("Your total capital for apple is :" + StockPriceCalculator.getCapital("apple") );
    System.out.println("Your total capital for ethereum is :" + StockPriceCalculator.getCapital("ethereum"));

    }
}
