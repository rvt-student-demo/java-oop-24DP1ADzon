package rvt.onlineShop;
import java.util.HashMap;

public class ShoppingCart{
    HashMap<String, Item> cart = new HashMap<>();
    
    public void add(String product, int price){
        Item item = cart.get(product);
        if(item == null){
            cart.put(product, new Item(product, 1, price));
            return;
        }
        item.increaseQuantity();
    }

    public void print(){
        for(Item product : cart.values()){
            System.out.println(product);
        }
    }

    public int price(){
        int sum = 0;
        for(Item product : cart.values()){
            sum += product.price();
        }
        return sum;
    }
}