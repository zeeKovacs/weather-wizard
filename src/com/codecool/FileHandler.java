package com.codecool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandler {

    public Weather[] Read(String file) {
        Weather[] record = new Weather[fileLines(file) + 1];
        int i = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                String[] data = br.readLine().split(",");
                record[i] = new Weather(data[0], data[1], data[2], data[3], data[4]);
                i++;                
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

    public void Write(String file, String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(line);
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
        }
    }

    public int fileLines(String file) {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                br.readLine();
                i++;
            }
            return i;
        } catch (FileNotFoundException f) {
            System.out.println("File not found!");
            return 0;
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
            return 0;
        }
    }
}