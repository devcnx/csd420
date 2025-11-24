/*
 * file: snippets/module-5/Module5DiscussionDemo.java
 *
 * Term: Fall 2025
 * 
 * Course: CSD420 Advanced Java Programming
 * Instructor: Jack Lusby
 * Institution: Bellevue University
 * 
 * M5 Discussion Demo
 * Author: Brittaney Perry-Morgan
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * An illustration of the behavioral differences between HashMap, LinkedHashMap,
 * and TreeMap.
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */
public class Module5DiscussionDemo {

    /**
     * The main entry point for the application.
     * <p>
     * This method instantiates three different Map types and
     * populates them to compare the output.
     * </p>
     * 
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        // 1. HashMap: No guaranteed order
        Map<String, Double> exampleHashMap = new HashMap<>();
        populateAndPrint(exampleHashMap, "HashMap");

        // 2. LinkedHashMap: Preserves the insertion order
        Map<String, Double> exampleLinkedHashMap = new LinkedHashMap<>();
        populateAndPrint(exampleLinkedHashMap, "LinkedHashMap");

        // 3. TreeMap: Natural ordering of keys
        Map<String, Double> exampleTreeMap = new TreeMap<>();
        populateAndPrint(exampleTreeMap, "TreeMap");
    }

    /**
     * Populates a provided Map with key-value pairs.
     * <p>
     * This method uses student nmes and GPAs as the key-value pairs,
     * and then prints the map type and its content to the console.
     * </p>
     * 
     * @param map The map to populate and print
     * @param mapType The type of map being populated
     */
    public static void populateAndPrint(Map<String, Double> map, String mapType) {
        map.put("Brittaney", 3.5);
        map.put("Aaleigha", 4.0);
        map.put("Gabriel", 3.8);
        map.put("Austin", 4.0);
        map.put("Peggy", 3.9);
        map.put("Justin", 3.7);

        System.out.println("--- " + mapType + " Output ---");
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }
}