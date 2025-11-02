/* file: snippets/module-2/m2_db/Module2DiscussionDemo.java
 *
 * Term: Fall 2025
 * 
 * Course: CSD420 Advanced Java Programming
 * Instructor: Jack Lusby
 * Institution: Bellevue University
 *
 * M2 Discussion Board Snippet
 * Author: Brittaney Perry-Morgan
 */

import java.io.File;

/**
 * A demonstration of two key recursive algorithms.
 * <p>
 * 1. A recursive binary search for a sorted integer array.
 * 2. A recursive method to print a file directory structure, similar to the 
 * `tree` command in the terminal.
 * </p>
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */
public class Module2DiscussionDemo {

    /**
     * Main method to test both recursive functions.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        /** Binary Search Demo */
        System.out.println("----- Recursive Binary Search Demo");
        int[] sortedArray = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
        int keyToFind = 23;
        int index = recursiveBinarySearch(sortedArray, keyToFind, 0, sortedArray.length - 1);
        System.out.println("Found Key " + keyToFind + " at Index: " + index);

        int keyNotFound = 44;
        index = recursiveBinarySearch(sortedArray, keyNotFound, 0, sortedArray.length - 1);
        System.out.println("Found Key " + keyNotFound + " at Index: " + index);
        System.out.println();

        /** 
         * Print Directory Structure Demo 
         * NOTE: Change this path to a real dir on your machine to test.
         * Using user.home as a safe, cross-platform default.
         */
        System.out.println("----- Recursive Print Directory Structure Demo");

        // Using /Users/brittaneyperry-morgan/Desktop
        String pathToScan = System.getProperty("user.home") + File.separator + "Desktop";
        File startDir = new File(pathToScan);

        if (startDir.exists() && startDir.isDirectory()) {
            System.out.println("Scanning " + startDir.getAbsolutePath());
            // Limiting to 3 levels deep for demo purposes.
            printDirectoryTree(startDir, 0, 3);
        } else {
            System.out.println("Cannot Find Directory to Scan: " + pathToScan);
        }
    }


    /**
     * Performs a binary search on a sorted array using recursion.
     * 
     * @param arr The sorted array to search.
     * @param key The integer key to find.
     * @param low The low boundary (starting index) of the current search range.
     * @param high The high boundary (ending index) of the current search range.
     * 
     * @return The index of the key if found. Otherwise, -1.
     */
    public static int recursiveBinarySearch(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        // Base Case 2: Key is Found at Mid
        if (arr[mid] == key) {
            return mid;
        }
        // Recursive Step 1: Key is in the Left Half
        else if (key < arr[mid]) {
            return recursiveBinarySearch(arr, key, low, mid - 1);
        }
        // Recursive Step 2: Key is in the Right Half
        else {
            return recursiveBinarySearch(arr, key, mid + 1, high);
        }
    }

    /**
     * Recursively prints the file and directory structure from a starting dir.
     * <p>
     * This mimics the behavior of the `tree` command.
     * </p>
     * 
     * @param dir The directory to scan.
     * @param indentLevel The current indentation level for pretty-printing.
     */
    public static void printDirectoryTree(File dir, int indentLevel) {
        printDirectoryTree(dir, indentLevel, "", true);
    }
    
    public static void printDirectoryTree(File dir, int indentLevel, int maxDepth) {
        printDirectoryTree(dir, indentLevel, "", true, 0, maxDepth);
    }
    
    private static void printDirectoryTree(File dir, int indentLevel, String indent, boolean isLast) {
        // Print the current directory or file with proper prefix
        String prefix = indent + (isLast ? "└── " : "├── ");
        
        if (dir.isFile()) {
            System.out.println(prefix + dir.getName());
            return;
        }
        
        System.out.println(prefix + "[" + dir.getName() + "]");
        
        // Get the contents of the directory
        File[] contents = dir.listFiles();
        if (contents == null) return;
        
        // Process each item in the directory
        for (int i = 0; i < contents.length; i++) {
            File item = contents[i];
            boolean isLastItem = (i == contents.length - 1);
            
            // Create the new indent for the next level
            String newIndent = indent + (isLast ? "    " : "│   ");
            
            // Recursively print the item
            printDirectoryTree(item, indentLevel + 1, newIndent, isLastItem);
        }
    }
    
    private static void printDirectoryTree(File dir, int indentLevel, String indent, boolean isLast, int currentDepth, int maxDepth) {
        // Limit depth to prevent excessive output
        if (currentDepth > maxDepth) {
            return;
        }
        
        // Print the current directory or file with proper prefix
        String prefix = indent + (isLast ? "└── " : "├── ");
        
        if (dir.isFile()) {
            System.out.println(prefix + dir.getName());
            return;
        }
        
        System.out.println(prefix + "[" + dir.getName() + "]");
        
        // Get the contents of the directory
        File[] contents = dir.listFiles();
        if (contents == null) return;
        
        // Process each item in the directory
        for (int i = 0; i < contents.length; i++) {
            File item = contents[i];
            boolean isLastItem = (i == contents.length - 1);
            
            // Create the new indent for the next level
            String newIndent = indent + (isLast ? "    " : "│   ");
            
            // Recursively print the item
            printDirectoryTree(item, indentLevel + 1, newIndent, isLastItem, currentDepth + 1, maxDepth);
        }
    }
}