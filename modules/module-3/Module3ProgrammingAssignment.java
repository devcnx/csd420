/* file: modules/module-3/Module3ProgrammingAssignment.java
 *
 * Term: Fall 2025
 * 
 * Course: CSD420 Advanced Java Programming
 * Instructor: Jack Lusby
 * Institution: Bellevue University
 *
 * M3 Programming Assignment
 * Author: Brittaney Perry-Morgan
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * A test program that generates 50 random integers (1-20).
 * <p>
 * The program stores the integers in an ArrayList and uses a generic method to
 * remove duplicates while preserving the original order.
 * <p>
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */
public class Module3ProgrammingAssignment {

    public static void main(String[] args) {
        // Create the original list to hold Integers
        ArrayList<Integer> originalList = new ArrayList<>();

        // Initialize the Random object
        Random rand = new Random();

        // Fill the original ArrayList with 50 random values from 1 to 20
        System.out.println("Generating 50 random integers between 1 and 20...\n\n");
        for (int index = 0; index < 50; index++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        // Display the original list
        System.out.println("Original List (with Duplicates):");
        printList(originalList);

        // Call the generic method to remove duplicates
        ArrayList<Integer> noDuplicates = removeDuplicates(originalList);

        // Display the new list
        System.out.println("\n\nFiltered List (No Duplicates):");
        printList(noDuplicates);
    }

    /**
     * Remove duplicate elements from an ArrayList.
     * <p>
     * This method is Generic <E>, meaning it can accept an ArrayList of any object
     * type (Integer, String, Double, etc.).
     * </p>
     * 
     * @param list The original ArrayList containing potential Duplicates
     * @param <E>  The element type
     * 
     * @return A new ArrayList containing only unique elements from the original
     *         list.
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Create a new ArrayList to store unique elements
        ArrayList<E> uniqueList = new ArrayList<>();

        // Iterate through the original list
        for (E element : list) {
            // If the new list doesn't already contain an element, add it
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }

        // Return the distinct list
        return uniqueList;
    }

    /**
     * Helper method to print list elements in a readable format
     * 
     * @param list The list to print
     * @param <E>  The element type
     */
    public static <E> void printList(ArrayList<E> list) {
        for (int index = 0; index < list.size(); index++) {
            System.out.print(list.get(index) + " ");

            // Optionally, print a new line every 20 numbers for readability
            if ((index + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}