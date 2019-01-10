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
        array[indexToRemove] = array[array.length - 1];
        Weather[] tempRecords = Arrays.copyOf(array, array.length-1);
        array = tempRecords;
        return array;
    }
}