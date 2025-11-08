/* file: snippets/module-3/m3_db/Module3DiscussionDemoIncorrect.java
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

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstration of generic methods, implemented incorrectly.
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */

/**
 * This class demonstrates the problem Generics solve.
 * <p>
 * The class uses a "raw type" List, which bypasses compile-time
 * type checking.
 * 
 * The code WILL COMPILE, but it WILL CRASH at runtime.
 * </p>
 */
public class Module3DiscussionDemoIncorrect {

    public static void main(String[] args) {
        // First, we create a raw ArrayList. The compiler has no idea
        // what's in it. It just knows it holds "Objects"
        List myList = new ArrayList();

        System.out.println("Adding items to the raw list...");

        // 2. We can add anything and there won't be any compiler errors
        myList.add("This is a string");
        myList.add(Integer.valueOf(123));
        myList.add(Double.valueOf(45.67));

        System.out.println("Liste contents: " + myList);
        System.out.println("Attempting to retrieve at cast items...");

        try {
            // 3. This cast works because at index 0, it IS a string.
            String itemOne = (String) myList.get(0);
            System.out.println("Retrieved Item 1: " + itemOne);

            // 4. Here's the issue.
            // This line will compile because the compiler only knows
            // myList.get(1) returns an "Object".
            // But, at runtime, it will fail because the object at index 1
            // is an Integer, NOT a string.
            System.out.println("Attempting to cast item at index 1....");
            String itemTwo = (String) myList.get(1);
            System.out.println("Retrieved item 2: " + itemTwo);
        } catch (ClassCastException e) {
            //  5. The program will crash and land here.
            System.out.println("\n----- Error Caught.");
            System.out.println("Exception:\n" + e.getMessage());
            System.out.println("\n\n******** The runtime error Generics prevent.********\n\n");
        }
    }
}