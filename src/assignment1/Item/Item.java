package assignment1.Item;

import java.nio.channels.FileLock;

public abstract class Item {
    protected String name;
    protected Float tax, price;
    protected Integer quantity;
    abstract float getTax();

    public Item(String name) {
        this.name = name;
    }
    public void print(){
        System.out.println("Name of Item : " + name);
        System.out.println("Type of Item : Manufactured");
        if (price != null) {
            System.out.println("Price : " + price);
            System.out.println("Sales tax liability :" + String.valueOf(getTax()));
            System.out.println("Final Price :" + String.valueOf(getTax() + price));
        }
        if(quantity != null){
            System.out.println("Quantity :" + String.valueOf(quantity));
        }
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

