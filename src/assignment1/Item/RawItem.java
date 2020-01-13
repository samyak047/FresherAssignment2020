package assignment1.Item;

import assignment1.Item.Item;

public class RawItem extends Item {

    public RawItem(String name) {
        super(name);
    }

    @Override
    float getTax() {
        if (tax == null) tax = (price * 12.5f) / 100;
        return tax;
    }
}
