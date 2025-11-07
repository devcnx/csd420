/* file: snippets/module-3/m3_db/Module3DiscussionDemo.java
 *
 * Term: Fall 2025  
 * 
 * Course: CSD420 Advanced Java Programming
 * Instructor: Jack Lusby
 * Institution: Bellevue University
 *
 * M3 Discussion Board Snippet
 * Author: Brittaney Perry-Morgan
 */


/**
 * A demonstration of generic methods, implemented correctly.
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */

/**
 * Demonstration using a static generic method.
 */
public class Module3DiscussionDemo {

    /**
     * This generic method can print any array of non-primitive types.
     * <p>
     * The <E> declaration before the return type "void" signifies that this is
     * a generic method.
     * 
     * @param <E> The generic type parameter for the array.
     * @param inputArray The array of type E to be printed.
     */
    public static <E> void printArray(E[] inputArray) {
        // Display the array element
        System.out.println("--- Printing the Array Content");
        for (E element : inputArray) {
            // Print each element followed by a space
            System.out.printf("%s ", element);
        }
        // Print a newline at the end
        System.out.println("\n----------------------------------------");
    }

    public static void main(String args[]) {
        // Create arrays of different types
        Integer[] intArray = { 10, 20, 30, 40, 50 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Character[] charArray = { 'A', 'B', 'C', 'D', 'E' };
        
        // Call the single generic method with different array types
        System.out.println("\n\nCalling the generic method with an Integer array:");
        printArray(intArray);
        
        System.out.println("\n\nCalling the generic method with a Double array:");
        printArray(doubleArray);
        
        System.out.println("\n\nCalling the generic method with a Character array:");
        printArray(charArray);
    }
}