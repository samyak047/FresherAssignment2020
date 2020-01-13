package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Item> itemList = new LinkedList<Item>();

        Operation op;
        try {
            op = new Operation();
            System.out.println("Connected to DB");
        } catch (RuntimeException e) {
            System.out.println(e);
            throw new RuntimeException("SQL Table not fetched.");
        }

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (this) {
                            while (itemList.size() == 3)
                                wait();

                            itemList.add(op.getNextItemFromDB());
                            System.out.println("Item added to list");
                            Thread.sleep(1000);
                            notify();
                            System.out.println("Notified");
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println(e);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (this) {
                            while (itemList.size() == 0) {
//                              wait();
                                if (!t1.isAlive()) throw new RuntimeException();
                            }
                            Item item = itemList.remove();
                            item.print();
                            Thread.sleep(1000);
                            notify();
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println(e);
                } catch (RuntimeException e) {
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
