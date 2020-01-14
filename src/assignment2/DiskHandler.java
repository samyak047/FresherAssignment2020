package assignment2;

import java.io.*;
import java.util.*;

public class DiskHandler {
    public static void saveToDisk(Set<User> users) {
        try {
            FileOutputStream fstream = new FileOutputStream("userdetails.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fstream);
            objectOutputStream.writeObject(users);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<User> getFromDisk() {
        Set<User> users = new TreeSet<>();
        try {
            FileInputStream fstream = new FileInputStream("userdetails.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fstream);
            users = (Set<User>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("No User details stored in disk yet.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
