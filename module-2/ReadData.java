// Kyle Marlia-Conner
// 03/30/25
// Assignment 2

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
    public static void main(String[] args) {
        // Link the file name created in the WriteData program.
        String fileName = "KyleMCDatafile.dat";

        // Read the file and display its contents.
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Data from " + fileName + ":");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
