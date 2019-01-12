package com.codecool;

import java.util.Scanner;

public class Commands {
    private FileHandler fh = new FileHandler();
    private String file = "data/records.txt";
    private API api = new API();
    private Wrapper wr = new Wrapper();

    public Weather[] boot() {
        Weather[] records = fh.Read(file);
        String[] rec = api.getWeather().split(",");
        records = wr.wrap(records, new Weather(rec[0], rec[1], rec[2], rec[3], rec[4]));
        return records;
    }

    public void list(Weather[] array) {
        int i = 1;
        for (Weather record : array) {
            if (record != null) {
                System.out.println(i + ": " + record);
                i++;
            }
        }
    }

    public void find(Weather[] array, Scanner scan) {
        System.out.println("Enter a date (YYYY-MM-DD): ");
        String date = scan.nextLine();
        for (Weather record : array) {
            if (record.toString().split(" ")[3].equals(date)) {
                System.out.println(record);
            }
        }
    }

    public Weather add(Scanner scan) {
        String[] labels = {"city.", "date (YYYY-MM-DDDD).", "time (HH:MM).", "temp.", "textual."};
        String[] rec = new String[5];
        for (int i = 0; i < labels.length; i++) {
            System.out.println("Enter a " + labels[i]);
            rec[i] = scan.nextLine();
        }
        return new Weather(rec[0], rec[1], rec[2], rec[3], rec[4]);
    }

    public Weather[] update(Weather[] array, Scanner scan) {
        list(array);
        System.out.println("Enter the index of record you want to update!");
        int i = Integer.parseInt(scan.nextLine());
        array[i-1] = add(scan);
        return array;
    }

    public int remove(Weather[] array, Scanner scan) {
        list(array);
        System.out.println("Enter the index of record you want to remove!");
        int i = Integer.parseInt(scan.nextLine());
        return i;
    }

    public void exit() {
        System.exit(1);
    }
}