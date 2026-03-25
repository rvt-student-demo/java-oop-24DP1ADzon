package rvt.onlineShop;

public class Item {
    String product;
    int qty;
    int unitPrice;

    public Item(String product, int qty, int unitPrice){
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int price(){
        return this.qty * this.unitPrice;
    }
    
    public void increaseQuantity(){
        this.qty += 1;
    }

    @Override
    public String toString(){
        return this.product + ": " + this.qty;
    }
}
