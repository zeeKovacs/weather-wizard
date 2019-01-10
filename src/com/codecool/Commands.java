package com.codecool;

import java.util.Scanner;

public class Commands {

    public void list(Weather[] array) {
        int i = 1;
        for (Weather record : array) {
            if (record != null) {
                System.out.println(i + ": " + record);
                i++;
            }
        }
    }

    public void find(Weather[] array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        for (Weather record : array) {
            if (record.toString().split(" ")[3].equals(date)) {
                System.out.println(record);
            }
        sc.close();
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
        sc.close();
        return new Weather(rec[0], rec[1], rec[2], rec[3], rec[4]);
    }

    public Weather[] update(Weather[] array) {
        list(array);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index of record you want to update!");
        int i = Integer.parseInt(sc.nextLine());
        array[i-1] = add();
        sc.close();
        return array;
    }

    public Weather[] remove(Weather[] array) {
        Wrapper wrap = new Wrapper();
        list(array);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index of record you want to remove!");
        int i = Integer.parseInt(sc.nextLine());
        array = wrap.unwrap(array, i-1);
        sc.close();
        return array;
    }

    public void exit() {
        System.exit(1);
    }
}