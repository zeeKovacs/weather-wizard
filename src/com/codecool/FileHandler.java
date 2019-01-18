package com.codecool;

import java.io.*;

public class FileHandler {

    public static Weather[] readObject() throws IOException, ClassNotFoundException {
        Weather[] records = null;

        try (FileInputStream data = new FileInputStream("data/records.txt");
             ObjectInputStream ois = new ObjectInputStream(data)) {
            records = (Weather[])ois.readObject();
            return records;
        }
    }

    public static void writeObject(Weather[] records) {
        try (FileOutputStream data = new FileOutputStream("data/records.txt");
            ObjectOutputStream oos = new ObjectOutputStream(data)) {
                oos.writeObject(records);
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
        }
    }
}