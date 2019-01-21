package com.codecool;

import java.util.Scanner;
import java.io.IOException;
import java.net.MalformedURLException;

public class UI {
    Scanner sc = new Scanner(System.in);
    Wrapper wrap = new Wrapper();
    Commands c = new Commands(wrap);
    Weather current = null;
    Weather[] records = null; { 
        try {
            records = c.boot(records);
            current = records[records.length - 1];
        } catch (ClassNotFoundException l) {
            System.out.println("ClassNotFoundException occurred... program exits.");
            System.exit(1);
        } catch (MalformedURLException e) {
            System.out.println("URL was not found!");
            System.exit(1);
        } catch (IOException i) {
            System.out.println("IOException occurred... program exits." + i.getLocalizedMessage());
            System.exit(1);
        }
    }
    
    public Weather[] showMenu() {
        String[] rec = new String[5];
        printMenuLabels();
        String inp = sc.nextLine();
        switch (inp) {
            case "1" :
                printArray(records);
                break;
            case "2" :
                rec = getData();
                records = wrap.wrap(records, c.addRecord(rec[0], rec[1], rec[2], rec[3], rec[4]));
                break;
            case "3" :
                printArray(records);
                System.out.println("Enter the index of record you want to update!");
                int i = Integer.parseInt(sc.nextLine());
                rec = getData();
                records = c.updateRecord(records, rec, i);
                break;
            case "4" :
                printArray(records);
                System.out.println("Enter the index of record you want to remove!");
                i = Integer.parseInt(sc.nextLine());
                records = c.removeRecord(records, i);
                break;
            case "5" :
                System.out.println("Enter a date (YYYY-MM-DD): ");
                String date = sc.nextLine();
                printArray(c.findRecord(records, date));
                break;
            case "6" :
                System.out.println(current);
                break;
            case "7" :
                FileHandler.writeObject(records);
                break;
            case "X" :
                exit();
            default:
                System.out.println("Wrong input!");
        }
        return records;
    }

    private void printMenuLabels() {
        String[] labels = {"1: List", "2: Add", "3: Update", "4: Remove",
                           "5: Find", "6: Current", "7: Save", "X: Exit"};
        for (String label : labels) {
            System.out.println(label);
        }
        System.out.println("Choose an option!");
    }

    private void printArray(Weather[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1)+ ": " + array[i]);
        }
        System.out.println();
    }

    private String[] getData() {
        String[] labels = {"city.", "date (YYYY-MM-DD).", "time (HH:MM).", "temp.", "textual."};
        String[] rec = new String[5];
        for (int i = 0; i < labels.length; i++) {
            System.out.println("Enter a " + labels[i]);
            rec[i] = sc.nextLine();
        }
        return rec;
    }

    private void exit() {
        System.exit(1);
    }
}