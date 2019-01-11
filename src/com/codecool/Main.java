package com.codecool;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FileHandler fh = new FileHandler();
        Wrapper wr = new Wrapper();
        API api = new API();
        UI ui = new UI();
        String file = "data/records.txt";
        Weather[] records = fh.Read(file);
        String[] rec = api.getWeather().split(",");
        records = wr.wrap(records, new Weather(rec[0], rec[1], rec[2], rec[3], rec[4]));
        while (true) {
            ui.Menu(file, records, scan, fh, wr);
        }
    }
}