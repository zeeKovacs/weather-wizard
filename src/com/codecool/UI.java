package com.codecool;

import java.util.Scanner;

public class UI {
    
    public Weather[] Menu(Weather[] array) {
        Scanner sc = new Scanner(System.in);
        FileHandler fh = new FileHandler();
        Wrapper wrap = new Wrapper();
        Commands c = new Commands();
        String file = "data/records.txt";
        String[] labels = {"1: List", "2: Add", "3: Update", "4: Remove",
                        "5: Find", "6: Current", "7: Save", "X: Exit"};
        for (String label : labels) {
            System.out.println(label);
        }
        System.out.println("Choose an option!");
        String inp = sc.nextLine();
        switch (inp) {
            case "1" :
                c.list(array);
                break;
            case "2" :
                array = wrap.wrap(array, c.add(sc));
                break;
            case "3" :
                array = c.update(array, sc);
                break;
            case "4" :
                array = wrap.unwrap(array, c.remove(array, sc));
                break;
            case "5" :
                c.find(array, sc);
                break;
            case "6" :
                System.out.println(array[array.length - 1]);
                break;
            case "7" :
                fh.Write(file, array);
                break;
            case "X" :
                c.exit();
            default:
                System.out.println("Wrong input!");
        }
        return array;
    }
}