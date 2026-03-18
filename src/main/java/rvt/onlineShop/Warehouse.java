package rvt.onlineShop;

import java.util.HashMap;
import java.util.Set;

public class Warehouse{
    HashMap<String, Integer> prices = new HashMap<>();
    HashMap<String, Integer> stock = new HashMap<>();
    
    public void addProduct(String product, int price, int stock){
        this.prices.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product){
        try {
            return prices.get(product);
        } catch (Exception e) {
            return -99;
        }
    }

    public int stock(String product){
        try {
            return stock.get(product);
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean take(String product){
        try {
            if(stock.get(product) > 0){
                stock.put(product, stock.get(product) - 1);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Set<String> products(){
        return prices.keySet();
    }
}