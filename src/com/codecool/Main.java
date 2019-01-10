package com.codecool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileHandler fh = new FileHandler();
        Wrapper wrap = new Wrapper();
        API api = new API();
        Commands c = new Commands();
        Weather[] records = fh.Read("data/records.txt");
        String[] rec = api.getWeather().split(",");
        c.list(records);
        c.remove(records);
        c.list(records);
    }
}