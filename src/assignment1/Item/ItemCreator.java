package assignment1.Item;

import assignment1.Item.Item;
import assignment1.Item.RawItem;

public class ItemCreator {
    public static Item getItem(String name, String type) {
        if("raw".equalsIgnoreCase(type)){
            return new RawItem(name);
        }
        return new RawItem(name);

    }

}
