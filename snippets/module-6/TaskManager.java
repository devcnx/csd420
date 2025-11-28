/*
 * file: modules/module-6/TaskManager.java
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A demonstration of using Enums for type safety and a Comparator for
 * custom sorting logic.
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */
public class TaskManager {
    
    /**
     * A fixed set of constants for the task priority
     */
    enum Priority {
        HIGH, MEDIUM, LOW;
    }
    
    /**
     * A simple class that represents a task.
     */
    static class Task {
        String name;
        Priority priority;

        public Task(String name, Priority priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return name + " (" + priority + ")";
        }
    }
    
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("Register for Graduation", Priority.HIGH));
        tasks.add(new Task("Check Holiday Schedule", Priority.MEDIUM));
        tasks.add(new Task("Science Project with Son", Priority.LOW));
        tasks.add(new Task("Schedule Vaccinations for Lazarus", Priority.HIGH));

        System.out.println("--- Unsorted List");
        printList(tasks);

        // Define a custom comparator to sort by the Enum's ordinal value
        Comparator<Task> prioritySorter = new Comparator<Task>() {
            @Override
            public int compare(Task taskOne, Task taskTwo) {
                return taskOne.priority.compareTo(taskTwo.priority);
            }
        };

        Collections.sort(tasks, prioritySorter);

        System.out.println("\n--- Sorted List");
        printList(tasks);
    }

    private static void printList(List<Task> list) {
        for (Task task : list) {
            System.out.println(task);
        }
    }
}
