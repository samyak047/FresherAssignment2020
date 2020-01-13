package assignment1.Item;

import assignment1.Item.Item;

public class ManufacturedItem extends Item {
    public ManufacturedItem(String name) {
        super(name);
    }

    @Override
    float getTax() {
        if (tax == null) tax = (((price * 12.5f) / 100) + (2f * (price + (price * 12.5f) / 100) / 100));
        return tax;
    }
}
