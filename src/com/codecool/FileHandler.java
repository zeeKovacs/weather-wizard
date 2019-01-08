package com.codecool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

public class FileHandler {

    public String[] Read(String file) {
        String[] record = new String[fileLines(file)];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                System.out.println(br.readLine().split(" "));
            }
            return record;

        } catch (FileNotFoundException f) {
            System.out.println("File not found!");
            return null;
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
            return null;
        }
    }

    public int fileLines(String file) {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                br.readLine();
                i++;
            }
            return i+1;
        } catch (FileNotFoundException f) {
            System.out.println("File not found!");
            return 0;
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
            return 0;
        }
    }
}