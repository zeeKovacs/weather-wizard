package com.codecool;

import java.io.Serializable;

public class Weather implements Serializable {
    private static final long serialVersionUID = 4816798732108131990L;
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
        this.city = city;
        this.date = date;
        this.time = time;
        this.temp_c = temp_c;
        this.textual = textual;
        this.type = whatType(temp_c);
    }
    public String toWrite() {
        return city + "," + date + "," + time + "," + temp_c + "," + textual + "\n";
    }

    private Type whatType(String temp_c) {
        float temp = Float.parseFloat(temp_c);
        if (temp < 0) {
            return Type.COLD;
        }
        else if (temp > 0 && temp < 10) {
            return Type.CHILLY;
        }
        else if (temp > 10 && temp < 20) {
            return Type.COOL;
        }
        else if (temp > 20 && temp < 30) {
            return Type.WARM;
        } else {
            return Type.HOT;
        }
    }

    @Override
    public String toString() {
        return "City: " + city + " Date: " + date + " Time: " + time + " Temp C: " + temp_c + " Textual: " + textual + " Category: " +
                type.toString().substring(0, 1).toUpperCase() + (type.toString()).substring(1, type.toString().length()).toLowerCase() + "\n";
    }
}