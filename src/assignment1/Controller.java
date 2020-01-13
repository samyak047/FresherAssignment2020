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


                if (name.equals("")) {
                    throw new RuntimeException("Name is required.");
                }
                if (!("raw".equalsIgnoreCase(type) || "manufactured".equalsIgnoreCase(type) || "imported".equalsIgnoreCase(type))) {
                    throw new RuntimeException("Type shoud be either raw, manufactured or imported.");
                }
                Item item;
                item = ItemCreator.getItem(name, type);
                if(!"".equals(priceText)){
                    item.setPrice(Float.parseFloat(priceText));
                }
                if(!"".equals(quantityText)){
                    item.setQuantity(Integer.parseInt(quantityText));
                }

                item.print();
                System.out.println("Do you want to enter details of any other item? (y/n):");
                choice = sc.nextLine();
            } catch (NumberFormatException e){
                System.out.println(e);
                System.out.println("Do you want to try again? (y/n):");
                choice = sc.nextLine();
            } catch (RuntimeException e){
                System.out.println(e);
                System.out.println("Do you want to try again? (y/n):");
                choice = sc.nextLine();
            }

        } while (choice.equalsIgnoreCase("y"));

    }
}
