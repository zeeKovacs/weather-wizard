package com.codecool;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FileHandler fh = new FileHandler();
        Commands c = new Commands();
        Wrapper wr = new Wrapper();
        UI ui = new UI();
        String file = "data/records.txt";
        Weather[] records = c.boot();
        while (true) {
            records = ui.Menu(file, records, scan, fh, wr);
        }
    }
}