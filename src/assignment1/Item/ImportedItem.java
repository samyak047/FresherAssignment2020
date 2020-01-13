package assignment1.Item;

import assignment1.Item.Item;

public class ImportedItem extends Item {

    public ImportedItem(String name) {
        super(name);
    }

    @Override
    float getTax() {
        if (tax == null){
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
}
