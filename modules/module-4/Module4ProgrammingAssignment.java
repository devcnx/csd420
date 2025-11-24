/*
 * file: modules/module-4/Module4ProgrammingAssignment.java
 *
 * Term: Fall 2025
 * 
 * Course: CSD420 Advanced Java Programming
 * Instructor: Jack Lusby
 * Institution: Bellevue University
 * 
 * M4 Programming Assignment
 * Author: Brittaney Perry-Morgan
 */

import java.util.LinkedList;
import java.util.Iterator;

/**
 * A performance test for traversal of LinkedList objects.
 * <p>
 * This program tests the performance of traversing a LinkedList storing Integer
 * objects. It specifically compares the execution time of traversing the list
 * using an Iterator vs using the get(index) method.
 * 
 * The tests compare two different sizes of lists: 50,000 and 500,000 integers.
 * 
 * The application:
 * <ul>
 * <li>Stores 50,000 integers in a LinkedList</li>
 * <li>Tests traversal time using an Iterator</li>
 * <li>Tests traversal time using the get(index) method</li>
 * <li>Repeats the tests with 500,000 integers</li>
 * </ul>
 * 
 * The results highlight a significant performance difference between the two
 * methods, with the Iterator being much faster for larger lists. The Iterator
 * is efficient because it maintains its position in the list. In contrast, the
 * get(index) method must traverse from the start of the list for every single
 * call, causing exponential delays as the list grows to 500,000.
 * </p>
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */
public class Module4ProgrammingAssignment {

    /**
     * Main entry point for the performance test.
     * <p>
     * This method executes the logic to fill the lists and time the traversals
     * for both 50,000 and 500,000 integers.
     * </p>
     * 
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        // Test 1: 50,000 Integers
        System.out.println("-".repeat(75));
        // Center the text
        System.out.println("Test 1: 50,000 Integers");
        System.out.println("-".repeat(75));

        // Store the 50,000 Integers in a LinkedList
        LinkedList<Integer> linkedList50K = new LinkedList<>();
        for (int index = 0; index < 50000; index++) {
            linkedList50K.add(index);
        }

        // Test the Iterator traversal
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator50K = linkedList50K.iterator();
        while (iterator50K.hasNext()) {
            iterator50K.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Iterator Traversal Time: " + (endTime - startTime) + "ms");

        // Test the get(index) traversal
        startTime = System.currentTimeMillis();
        for (int index = 0; index < linkedList50K.size(); index++) {
            linkedList50K.get(index);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Get(index) Traversal Time: " + (endTime - startTime) + "ms");

        // Test 2: 500,000 Integers
        System.out.println("-".repeat(75));
        System.out.println("Test 2: 500,000 Integers");
        System.out.println("-".repeat(75));

        // Store the 500,000 Integers in a LinkedList
        LinkedList<Integer> linkedList500K = new LinkedList<>();
        for (int index = 0; index < 500000; index++) {
            linkedList500K.add(index);
        }

        // Test the Iterator traversal
        startTime = System.currentTimeMillis();
        Iterator<Integer> iterator500K = linkedList500K.iterator();
        while (iterator500K.hasNext()) {
            iterator500K.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Iterator Traversal Time: " + (endTime - startTime) + "ms");

        // Test the get(index) traversal
        startTime = System.currentTimeMillis();
        for (int index = 0; index < linkedList500K.size(); index++) {
            linkedList500K.get(index);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Get(index) Traversal Time: " + (endTime - startTime) + "ms");

        System.out.println("-".repeat(75));
        System.out.println("End of Program");
        System.out.println("-".repeat(75));
    }
}