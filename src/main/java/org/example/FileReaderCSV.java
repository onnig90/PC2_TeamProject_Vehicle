package org.example;

import java.io.*;
import java.util.ArrayList;

public final class FileReaderCSV {
    private static final String carCsvFile = "src/main/resources/CSV_Car.csv";
    private static final String motorbikeCsvFile = "src/main/resources/CSV_Motorbike.csv";
    private static final String csvSplitBy = ",";

    private static ArrayList<String[]> LoadFromCSV(String csvPath) {
        ArrayList<String[]> carValuesList = new ArrayList<>();
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            // Get headers
            line = br.readLine();

            // Get values
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                carValuesList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return carValuesList;
    }

    public static ArrayList<String[]> LoadCarCSV() {
        return LoadFromCSV(carCsvFile);
    }

    public static ArrayList<String[]> LoadMotorbikeCSV() {
        return LoadFromCSV(motorbikeCsvFile);
    }
}
