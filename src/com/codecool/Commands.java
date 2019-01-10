package com.codecool;

import java.util.Scanner;

public class Commands {

    public void list(Weather[] records) {
        int i = 1;
        for (Weather record : records) {
            if (record != null) {
                System.out.println(i + ": " + record);
                i++;
            }
        }
    }

    public void find(Weather[] records) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        for (Weather record : records) {
            if (record.toString().split(" ")[3].equals(date)) {
                System.out.println(record);
            }      
        }
    }

    public Weather add() {
        String[] labels = {"city.", "date (YYYY-MM-DDDD).", "time (HH:MM).", "temp.", "textual."};
        String[] rec = new String[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < labels.length; i++) {
            System.out.println("Enter a " + labels[i]);
            rec[i] = sc.nextLine();
        }
        return new Weather(rec[0], rec[1], rec[2], rec[3], rec[4]);
    }

    public Weather[] update(Weather[] records) {
        list(records);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index of record you want to update!");
        int i = Integer.parseInt(sc.nextLine());
        records[i-1] = add();
        return records;
    }

    public Weather[] remove(Weather[] records) {
        Wrapper wrap = new Wrapper();
        list(records);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index of record you want to remove!");
        int i = Integer.parseInt(sc.nextLine());
        wrap.unwrap(records, i);
        return records;
    }

    public void exit() {
        System.exit(1);
    }
}