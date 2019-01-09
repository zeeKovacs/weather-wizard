package com.codecool;

public class Weather {
    private String city;
    private String date;
    private String time;
    private String temp_c;
    private String textual;
    private Type type;

    public enum Type {
        COLD, CHILLY, COOL, WARM, HOT;
    }

    public Weather(String city, String date, String time, String temp_c, String textual) {
        float temp = Float.parseFloat(temp_c);
        this.city = city;
        this.date = date;
        this.time = time;
        this.temp_c = temp_c;
        this.textual = textual;
        if (temp < 0) {
            this.type = Type.COLD;
        }
        else if (temp > 0 && temp < 10) {
            this.type = Type.CHILLY;
        }
        else if (temp > 10 && temp < 20) {
            this.type = Type.COOL;
        }
        else if (temp > 20 && temp < 30) {
            this.type = Type.WARM;
        } else {
            this.type = Type.HOT;
        }
    }
    public String toWrite() {
        return city + "," + date + "," + time + "," + temp_c + "," + textual + "\n";
    }

    @Override
    public String toString() {
        return "City: " + city + " Date: " + date + " Time: " + time + " Temp C: " + temp_c + " Textual: " + textual + " Category: " + type + "\n";
    }
}