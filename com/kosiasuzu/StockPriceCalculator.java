package com.kosiasuzu;

import java.util.ArrayList;
import java.util.HashMap;

public class StockPriceCalculator {
    private static final HashMap<String, Stock> portfolio = new HashMap<String, Stock>();
    public static final ArrayList<String> companies = new ArrayList<String>();

    public static void showPortfolio(){
        // print portfolio by printing out all the stock owned
        for(String company: companies){
            Stock stock = portfolio.get(company);
            System.out.println("Your portfolio for company "+ company + " is ....");
            System.out.printf("You have %d number of stock for a total capital of %.2f and an average stock price of %.2f the last recorded price is %.2f \n", stock.getShares(), stock.getCapital(), stock.getAveragePrice(), stock.getPrice());
        }
    }

    public static void buyStock(String companyName, double buyingPrice, int quantity){
        int index = companies.indexOf(companyName);

        if(index < 0 ){
            Stock stock = new Stock(companyName);
            companies.add(companyName);
            stock.buy(buyingPrice, quantity);
            portfolio.put(companyName, stock);
            System.out.printf("You have bought %d amount of stock from company %s at a price of %.2f for a total capital of %.2f \n", quantity, companyName, buyingPrice, (buyingPrice*quantity));

            return;
        }

        Stock stock = portfolio.get(companyName);
        stock.buy(buyingPrice, quantity);

        System.out.printf("You have bought %d amount of stock from company %s at a price of %.2f for a total capital of %.2f \n", quantity, companyName, buyingPrice, (buyingPrice*quantity));
    }

    public static boolean sellStock(String companyName, double sellingPrice, int quantity){
        int index = companies.indexOf(companyName);

        if (index < 0 ){
            System.out.println("Failed to sell stock because such stock does not exist in the portfolio");
            return false;
        }
        Stock stock = portfolio.get(companyName);

        boolean sellSuccessful = stock.sell(sellingPrice, quantity);
        if(!sellSuccessful){
            System.out.println("Failed to sell stock");
            return false;
        } else {
            System.out.println("Stock sale successful");
            System.out.printf("You have sold %d amount of stock from company %s at a price of %.2f for a total capital of %.2f \n", quantity, companyName, sellingPrice, (sellingPrice*quantity));
            if (stock.getShares() == 0){
                companies.remove(companyName);
                portfolio.remove(companyName);
            }
            return true;
        }
    }

    public static double getCapital(){
        double totalCapital = 0;
        for(String company: companies){
            totalCapital += portfolio.get(company).getCapital();
        }
        return totalCapital;
    }

    public static double getCapital(String companyName){
        int index = companies.indexOf(companyName);
        if (index < 0 ){
            System.out.println("No such company found in portfolio");
            return 0.0;
        }
        return portfolio.get(companyName).getCapital();
    }

}
