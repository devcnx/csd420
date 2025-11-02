/* file: modules/module-2/WriteData.java
 *
 * Term: Fall 2025
 * 
 * Course: CSD420 Advanced Java Programming
 * Instructor: Jack Lusby
 * Institution: Bellevue University
 *
 * M2 Programming Snippet
 * Author: Brittaney Perry-Morgan
 */

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;


/**
 * Creates and appends random integer and double data to a binary file.
 */
public class WriteData {
    
    public static void main(String[] args) {
        // Define the filename.
        final String FILENAME = "PerryMorgan_datafile.dat";

        // 1. Create the arrays and populate them with random values.
        Random rand = new Random();
        int[] randomIntegers = new int[5];
        double[] randomDoubles = new double[5];

        System.out.println("Generating new data set...");
        for (int index = 0; index < 5; index++) {
            // Generate random integers (between 0 and 999)
            randomIntegers[index] = rand.nextInt(1000);
            // Generate random doubles (between 0.0 and 1.0, scaled by 100)
            randomDoubles[index] = rand.nextDouble() * 100.0;

            // Print what is about to be written.
            System.out.printf("    Writing: int=%d, double=%.2f\n", randomIntegers[index], randomDoubles[index]);
        }
        // 2. Write the data to the file using a try-with-resources block.
        // This automatically closes all streams.
        // DataOutputStream is used to write primitive Java data types.
        // We buffer the stream for efficiency (BufferedOutputStream).
        // FileOutputStream is used with `true` to enable APPEND mode.
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(FILENAME, true)))) {
            // Write the integer array.
            for (int value : randomIntegers) {
                dos.writeInt(value);
            }
            // Write the double array.
            for (double value : randomDoubles) {
                dos.writeDouble(value);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file");
            e.printStackTrace();
        }
        System.out.println("\nSuccessfully appended data to " + FILENAME);
    }
}
