package com.codecool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.JsonException;
import java.net.MalformedURLException;

public class API {
    private String weather;

    public String getWeather() {
        weather = "";
        try {
            URL url = new URL("http://api.apixu.com/v1/current.json?key=fe2c7d968b2343b8b8a12457182312&q=Miskolc");
            try (InputStream api = url.openStream();
                JsonParser parser = Json.createParser(api)) {
                while (parser.hasNext()) {
                    Event e = parser.next();
                    if (e == Event.KEY_NAME) {
                        switch (parser.getString()) {
                            case "name" :
                                parser.next();
                                weather += (parser.getString() + ",");
                                break;
                            case "localtime" :
                                parser.next();
                                weather += (parser.getString().replace(" ", ",") + ",");
                                break;
                            case "temp_c":
                                parser.next();
                                weather += (parser.getString() + ",");
                                break;
                            case "text":
                                parser.next();
                                weather += (parser.getString());
                                break;
                        }
                    }
                }
                return weather;
            } catch (IOException e) {
                System.out.println("IOException occured!");
                return null;
            } catch (JsonException e) {
                System.out.println("Could not reach API!");
                return null;
            }
        } catch (MalformedURLException e) {
            System.out.println("URL was not found!");
            return null;
        }
    }

    public String getText() {
        return weather.split(" ")[4];
    }

    public String getTemp() {
        return weather.split(" ")[3];
    }

    public String getName() {
        return weather.split(" ")[0];
    }

    public String getDate() {
        return weather.split(" ")[1];
    }

    public String getTime() {
        return weather.split(" ")[2];
    }
}