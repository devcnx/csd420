/*
 * file: modules/module-5/Module5ProgrammingAssignment.java
 *
 * Term: Fall 2025
 * 
 * Course: CSD420 Advanced Java Programming
 * Instructor: Jack Lusby
 * Institution: Bellevue University
 * 
 * M5 Programming Assignment
 * Author: Brittaney Perry-Morgan
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A program that reads from a text file.
 * <p>
 * This program reads a text file containing a collection of words,
 * filters out any duplicates, and displays the unique words in both
 * ascending and descending alphabetical orer.
 * </p>
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */
public class Module5ProgrammingAssignment {

    /**
     * The main entry point for the application.
     * 
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        String filePath = "collection_of_words.txt";
        TreeSet<String> uniqueWords = new TreeSet<>();

        System.out.println("\n\nAttempting to read from file: " + filePath);

        try {
            File file = new File(filePath);
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String word = input.next();
                uniqueWords.add(word);
            }
            input.close();
            
            System.out.println("\nUnique Words (Ascending Order):\n");
            for (String word : uniqueWords) {
                System.out.println(word);
            }
            NavigableSet<String> descendingWords = uniqueWords.descendingSet();
            System.out.println("\nUnique Words (Descending Order):\n");
            for (String word : descendingWords) {
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + filePath);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}