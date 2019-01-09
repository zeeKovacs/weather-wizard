package com.codecool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileHandler fh = new FileHandler();
        API api = new API();
        Weather[] records = fh.Read("data/records.txt");
        String[] rec = api.getWeather().split(",");
        records[fh.fileLines("data/records.txt")] = new Weather(rec[0], rec[1], rec[2], rec[3], rec[4]);
        fh.Write("data/records.txt", records[fh.fileLines("data/records.txt")].toWrite());
        for (Weather record : records) {
            if (record != null) {
                System.out.println(record);
            }
        }
    }
}