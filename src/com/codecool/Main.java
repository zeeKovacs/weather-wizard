package com.codecool;

public class Main {
    public static void main(String[] args) {
        FileHandler fh = new FileHandler();
        API api = new API();
        System.out.println(api.getWeather());
        System.out.println(fh.fileLines("data/whatever.txt"));
    }
}