package com.codecool;

public class Main {
    public static void main(String[] args) {
        Commands c = new Commands();
        UI ui = new UI();
        Weather[] records = c.boot();
        while (true) {
            records = ui.Menu(records);
        }
    }
}