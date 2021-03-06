package com.codecool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.net.MalformedURLException;

public class API {
    private String weather;

    public String getWeather() throws MalformedURLException, IOException {
        weather = "";
            URL url = new URL("http://api.apixu.com/v1/current.json?key=fe2c7d968b2343b8b8a12457182312&q=Miskolc");
            InputStream api = url.openStream();
            JsonParser parser = Json.createParser(api);
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
            }
}
