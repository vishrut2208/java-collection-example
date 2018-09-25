package com.company;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("Car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 1.10, 70);
        stockList.addStock(temp);

        temp = new StockItem("Chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("Door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("Juice", 2.10, 14);
        stockList.addStock(temp);

        temp = new StockItem("Phone", 12.10, 9);
        stockList.addStock(temp);

        temp = new StockItem("Towel", 8.70, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s: stockList.Items().keySet()){
            System.out.println(s);
        }

        Basket vishrutBasket = new Basket("Vishrut");
        sellItem(vishrutBasket, "Car", 1);
        System.out.println(vishrutBasket);

        sellItem(vishrutBasket, "Car", 1);
        System.out.println(vishrutBasket);

        sellItem(vishrutBasket, "Car", 1);
        //System.out.println(vishrutBasket);
        sellItem(vishrutBasket, "Spanner", 1);
        System.out.println(vishrutBasket);

        sellItem(vishrutBasket, "Juice", 10);
        System.out.println(vishrutBasket);

        sellItem(vishrutBasket, "Cup", 10);
        System.out.println(vishrutBasket);

        sellItem(vishrutBasket, "Towel", 12);
        System.out.println(vishrutBasket);

        System.out.println(stockList);
        for(Map.Entry<String, Double> price : stockList.PriceList().entrySet()){
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity){
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We Don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item,quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
