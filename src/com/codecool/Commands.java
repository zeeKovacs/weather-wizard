package com.codecool;

import java.io.IOException;

public class Commands {
    private API api = new API();
    private Wrapper wr;

    public Commands(Wrapper wr) {
        this.wr = wr;
    }

    public Weather[] boot(Weather[] records) throws IOException, ClassNotFoundException {
        records = FileHandler.readObject();
        String[] rec = api.getWeather().split(",");
        records = wr.wrap(records, new Weather(rec[0], rec[1], rec[2], rec[3], rec[4]));
        return records;
    }

    public Weather[] findRecord(Weather[] array, String date) {
        Weather[] matches = new Weather[0];
        for (Weather record : array) {
            if (record.toString().split(" ")[3].equals(date)) {
                matches = wr.wrap(matches, record);
            }
        }
        return matches;
    }

    public Weather addRecord(String date, String city, String time, String temp, String textual) {
        return new Weather(date, city, time, temp, textual);
    }

    public Weather[] updateRecord(Weather[] array, String[] rec, int i) {
        array[i-1] = addRecord(rec[0], rec[1], rec[2], rec[3], rec[4]);
        return array;
    }

    public Weather[] removeRecord(Weather[] array, int i) {
        array = wr.unwrap(array, i-1);
        return array;
    }
}