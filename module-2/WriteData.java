// Kyle Marlia-Conner
// 03/30/25
// Assignment 2

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        // Create arrays for five random integers and five random doubles.
        int[] randomInts = new int[5];
        double[] randomDoubles = new double[5];
        Random rand = new Random();

        // Populate arrays with random values.
        for (int i = 0; i < 5; i++) {
            randomInts[i] = rand.nextInt(100); // random integer between 0 and 99
            randomDoubles[i] = rand.nextDouble() * 100; // random double between 0.0 and 100.0
        }

        // File name
        String fileName = "KyleMCDatafile.dat";

        // Write the data to the file, appending if already exists.
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName, true))) {
            pw.println("Random Integers:");
            for (int i : randomInts) {
                pw.print(i + " ");
            }
            pw.println();

            pw.println("Random Doubles:");
            for (double d : randomDoubles) {
                pw.printf("%.2f ", d); // Format to 2 decimal places
            }
            pw.println();
            pw.println("----------------");
            System.out.println("Data successfully written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
