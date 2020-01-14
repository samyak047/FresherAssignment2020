package assignment1.Item;

import assignment1.Item.Item;
import assignment1.Item.RawItem;

public class ItemCreator {
    public static Item getItem(String name, String type) {
        switch (type){
            case "raw":
                return new RawItem(name);
            case "manufactured":
                return new ManufacturedItem(name);
            case "imported":
                return new ImportedItem(name);
            default:
                return null;
        }
    }

}
