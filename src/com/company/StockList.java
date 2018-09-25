package com.company;

import java.util.*;

public class StockList {

    private final Map<String , StockItem> list;

    public StockList(){
        this.list = new TreeMap<>();
    }

    public int addStock(StockItem item){
        if(item != null){
            //check if already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // if there are already stocks on this item, adjust the quantity
            if(inStock != item){
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item,null);

        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity >0)){
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }


    public Map<String, Double> PriceList(){
        Map<String,Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()){
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item : list.entrySet()){
            StockItem stockitem = item.getValue();

            double itemValue = stockitem.getPrice() * stockitem.quantityInStock();

            s = s + stockitem + ". There are " + stockitem.quantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total Stock value " + String.format("%.2f", totalCost);
    }
}
