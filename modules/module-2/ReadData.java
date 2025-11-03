/* file: modules/module-2/ReadData.java
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

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

/**
 * Reads and displays all data from the binary file created by WriteData.java.
 */
public class ReadData {

    public static void main(String[] args) {

        // The filename must match the one used in WriteData.java
        final String FILENAME = "PerryMorgan_datafile.dat";
        int dataSetCount = 0;

        // Check if the file exists before attempting to read
        File dataFile = new File(FILENAME);
        if (!dataFile.exists()) {
            System.out.println("No data file found. Please run WriteData.java first to create the data file.");
            return;
        }

        System.out.println("Reading all data from " + FILENAME + "...\n");

        // 1. Read data using a try-with-resources block.
        // We use DataInputStream to read primitive Java data types.
        // We buffer the stream for efficiency (BufferedInputStream).
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(FILENAME)))) {

            // 2. Use a while(true) loop to read until the end of the file.
            // When the end is reached, a 'EOFException' will be thrown,
            // which we will catch to exit the loop gracefully.
            while (true) {
                dataSetCount++;
                System.out.println("--- Data Set " + dataSetCount + " ---");

                // Read the 5 integers
                System.out.print("  Integers: ");
                for (int i = 0; i < 5; i++) {
                    System.out.print(dis.readInt() + " ");
                }
                System.out.println(); // Newline

                // Read the 5 doubles
                System.out.print("  Doubles:  ");
                for (int i = 0; i < 5; i++) {
                    System.out.printf("%.2f ", dis.readDouble());
                }
                System.out.println("\n"); // Two newlines for spacing

            } // Loop repeats until EOFException

        } catch (EOFException e) {
            // This is the expected and normal way to end the loop.
            System.out.println("...End of file reached. \n\n");
            System.out.println("Total data sets read: " + dataSetCount);

        } catch (IOException e) {
            // This catches other errors, like "File Not Found".
            System.err.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}