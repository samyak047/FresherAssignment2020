package assignment4;

public class Item {
    private String name, type;
    private float price;
    private int quantity;
    private float tax;

    public Item(String name, String type, float price, int quantity) throws RuntimeException {
        if (!"raw".equals(type) && !"manufactured".equals(type) && !"imported".equals(type)) {
            throw new RuntimeException();
        }
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    private float getTax() {
        if (type.equals("raw")) {
            tax = (price * 12.5f) / 100;
        } else if (type.equals("manufactured")) {
            tax = (((price * 12.5f) / 100) + (2f * (price + (price * 12.5f) / 100) / 100));
        } else if (type.equals("imported")) {
            float custom_duty = (price * 10f) / 100;
            if (custom_duty + price <= 100)
                tax = custom_duty + 5;
            else if (custom_duty + price <= 200)
                tax = custom_duty + 10;
            else
                tax = custom_duty + (5f * (custom_duty + price)) / 100;
        }
        return tax;
    }

    public void print() {
        System.out.println("Name of Item : " + name);
        System.out.println("Type of Item : " + type);
        System.out.println("Quantity : " + quantity);
        System.out.println("Price : " + String.valueOf(price));
        float tax = getTax();
        System.out.println("Sales tax liability :" + String.valueOf(tax));
        System.out.println("Final Price :" + String.valueOf(tax + price));

        System.out.println();

    }
}
