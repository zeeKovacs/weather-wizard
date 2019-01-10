package com.codecool;

import java.util.Arrays;

public class Wrapper {

    public Weather[] wrap(Weather[] records, Weather record) {
        Weather[] tempRecords = Arrays.copyOf(records, records.length);
        tempRecords[records.length] = record;
        records = tempRecords;
        return records;    
    }

    public Weather[] unwrap(Weather[] records, int indexToRemove) {
        records[indexToRemove] = records[records.length - 1];
        Weather[] tempRecords = Arrays.copyOf(records, records.length-1);
        records = tempRecords;
        return records;
    }
}