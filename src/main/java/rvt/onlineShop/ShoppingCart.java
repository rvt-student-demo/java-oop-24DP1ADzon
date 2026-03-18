package rvt.onlineShop;
import java.util.HashMap;

public class ShoppingCart{
    HashMap<String, Integer> cart = new HashMap<>();
    
    public void add(String product, int price){

    }

    public int price(){

        return 0;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.add("milk", 3);
        cart.add("buttermilk", 2);
        cart.add("cheese", 5);
        System.out.println("cart price: " + cart.price());
        cart.add("computer", 899);
        System.out.println("cart price: " + cart.price());
    }
}