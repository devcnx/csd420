/*
 * file: modules/module-6/Module6ProgrammingAssignment.java
 *
 * Term: Fall 2025
 * 
 * Course: CSD420 Advanced Java Programming
 * Instructor: Jack Lusby
 * Institution: Bellevue University
 * 
 * M6 Programming Assignment
 * Author: Brittaney Perry-Morgan
 */

import java.util.Comparator;

/**
 * Demonstration of the Bubble Sort algorithm.
 * <p>
 * This program uses Java Generics to create a Bubble Sort algorithm. There
 * are two sorting methods. One that uses a Comparable interface for natural
 * ordering, and one that uses a Comparator for custom ordering.
 * </p>
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */
public class Module6ProgrammingAssignment {

    /**
     * Main method to test the generic bubble sort implementation.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test 1: Sorting Integers using Comparable (Natural Order)
        Integer[] intArray = { 23, 14, 5, 99, 1, 45, 67, 8, 2, 100 };
        System.out.println("Original Integer Array: ");
        printArray(intArray);

        bubbleSort(intArray);

        System.out.println("Sorted Integer Array (Ascending): ");
        printArray(intArray);
        System.out.println("-".repeat(50));

        // Test 2: Sorting Strings Using Comparator (Custom Order)
        String[] strArray = { "Banana", "Apple", "Kiwi", "Strawberry", "Grape", "Blueberry", "Watermelon",
                "Honey Dew" };
        System.out.println("Original String Array: ");
        printArray(strArray);

        // Sorting strings by length (shortest to longest)
        Comparator<String> lengthComparator = (strOne, strTwo) -> {
            int lenCompare = Integer.compare(strOne.length(), strTwo.length());
            return (lenCompare != 0) ? lenCompare : strOne.compareTo(strTwo);
        };

        bubbleSort(strArray, lengthComparator);

        System.out.println("Sorted String Array (By Length): ");
        printArray(strArray);

        // Test 3: Sorting Strings Using Comparator (Reverse Alphabetical)
        String[] charArray = { "A", "C", "B", "D", "E" };
        System.out.println("Original Character Array: ");
        printArray(charArray);

        // Passing a comparator that reverses the natural ordering
        bubbleSort(charArray, Comparator.reverseOrder());

        System.out.println("Sorted Character Array (Reverse Alphabetical): ");
        printArray(charArray);
        System.out.println("-".repeat(50));
    }

    /**
     * Generic method to sort an array
     * <p>
     * Usinig the bubble sort algorithm, this method sorts an array. It relies
     * on the elements implementing the Comparable interface.
     * </p>
     * 
     * @param list The array of elements to sort
     * @param <E> The type of element, which must implement Comparable
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;

            // Iterate through the unsorted portion of the array
            for (int index = 0; index < list.length - k; index++) {
                // Compare the current element with the next
                if (list[index].compareTo(list[index + 1]) > 0) {
                    E temp = list[index];
                    list[index] = list[index + 1];
                    list[index + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }

    /**
     * Generic method to sort an array
     * <p>
     * Using the bubble sort algorithm, and using an external Comparator to
     * determine the order, this method sorts an array.
     * </p>
     * 
     * @param list The array of elements to sort
     * @param comparator The comparator to use for sorting
     * @param <E> The type of element to sort
     */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;

            for (int index = 0; index < list.length - k; index++) {
                // Use the comparator to compare elements
                if (comparator.compare(list[index], list[index + 1]) > 0) {
                    E temp = list[index];
                    list[index] = list[index + 1];
                    list[index + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }

    /**
     * Helper method to print the elements of an array
     * 
     * @param list The array to print
     * @param <E> The type of elements in the array
     */
    public static <E> void printArray(E[] list) {
        for (E element : list) {
            System.out.println(element + " ");
        }
        System.out.println();
    }
}