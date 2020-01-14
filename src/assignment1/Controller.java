package assignment1;

import assignment1.Item.Item;
import assignment1.Item.ItemCreator;

import java.util.Scanner;

public class Controller {
    public static void start(){
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            try {
                System.out.println("Enter name of item :");
                String name = sc.nextLine();

                System.out.println("Enter type of item [ raw , manufactured , imported ] : ");
                String type = sc.nextLine();

                System.out.println("Enter price of item (optional) :");
                String  priceText = sc.nextLine();

                System.out.println("Enter quantity of item (optional) : ");
                String quantityText = sc.nextLine();


                if (name.isEmpty()) {
                    throw new RuntimeException("Name is required.");
                }
                switch (type){
                    case "raw" : break;
                    case "manufactured" : break;
                    case "imported" : break;
                    default: throw new RuntimeException("Type shoud be either raw, manufactured or imported.");
                }
                Item item;
                item = ItemCreator.getItem(name, type);
                if(!priceText.isBlank()){
                    item.setPrice(Float.parseFloat(priceText));
                }
                if(!quantityText.isBlank()){
                    item.setQuantity(Integer.parseInt(quantityText));
                }

                item.print();
                System.out.println("Do you want to enter details of any other item? (y/n):");
                choice = sc.nextLine();
            } catch (RuntimeException e){
                System.out.println(e);
                System.out.println("Do you want to try again? (y/n):");
                choice = sc.nextLine();
            }

        } while (choice.equalsIgnoreCase("y"));

    }
}
