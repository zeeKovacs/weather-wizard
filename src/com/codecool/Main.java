package com.codecool;

public class Main {
    public static void main(String[] args) {
        FileHandler fh = new FileHandler();
        Wrapper wr = new Wrapper();
        API api = new API();
        Commands c = new Commands();
        Weather[] records = fh.Read("data/records.txt");
        String[] rec = api.getWeather().split(",");
        records = wr.wrap(records, new Weather(rec[0], rec[1], rec[2], rec[3], rec[4]));
        c.list(records);
        fh.Write("data/records.txt", records);
    }
}