package org.example;

import java.io.*;

public final class FileReaderCSV {
    private static final String csvFile = "data.csv"; // Path to your file
    private static final String csvSplitBy = ",";

    public static void LoadFromCSV(){
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Split line by comma
                String[] data = line.split(csvSplitBy);

                // Example: Print the first two columns
                System.out.println("Column 1: " + data[0] + ", Column 2: " + data[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
