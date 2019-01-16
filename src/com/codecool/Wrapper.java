package com.codecool;

import java.util.Arrays;

public class Wrapper {

    public Weather[] wrap(Weather[] array, Weather record) {
        Weather[] tempRecords = Arrays.copyOf(array, array.length + 1);
        tempRecords[array.length] = record;
        array = tempRecords;
        return array;    
    }

    public Weather[] unwrap(Weather[] array, int indexToRemove) {
        Weather[] tempRecords = new Weather[array.length - 1];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == indexToRemove) {
            } else {
                tempRecords[k] = array[i];
                k++; 
            }
        }
        array = tempRecords;
        return array;
    }
}