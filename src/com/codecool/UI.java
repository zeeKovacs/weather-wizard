package com.codecool;

import java.util.Scanner;

public class UI {
    
    public void Menu(String file, Weather[] records, Scanner sc, FileHandler fh, Wrapper wrap) {
        Commands c = new Commands();
        String[] labels = {"1: List", "2: Add", "3: Update", "4: Remove",
                        "5: Find", "6: Current", "7: Save", "X: Exit"};
        for (String label : labels) {
            System.out.println(label);
        }
        System.out.println("Choose an option!");
        String inp = sc.nextLine();
        switch (inp) {
            case "1" :
                c.list(records);
                break;
            case "2" :
                wrap.wrap(records, c.add(sc));
                break;
            case "3" :
                c.update(records, sc);
                break;
            case "4" :
                c.remove(records, sc, wrap);
                break;
            case "5" :
                c.find(records, sc);
                break;
            case "6" :
                System.out.println(records[records.length - 1]);
                break;
            case "7" :
                fh.Write(file, records);
                break;
            case "X" :
                c.exit();
            default:
                System.out.println("Wrong input!");
        }
    }
}