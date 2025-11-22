
/* file: modules/module-1/Module1ProgrammingAssignment.java
 *
 * Term: Fall 2025
 * 
 * Course: CSD420 Advanced Java Programming
 * Instructor: Jack Lusby
 * Institution: Bellevue University
 *
 * M1 Programming Assignment
 * Author: Brittaney Perry-Morgan
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * A JavaFX application that displays four random cards from a deck of 52.
 * <p>
 * Includes a "Refresh" button that uses a Lambda expression to deal four new
 * cards.
 * </p>
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */
public class Module1ProgrammingAssignment extends Application {

    /** A list to hold the deck of 52 card numbers (1-52) */
    private final ArrayList<Integer> deck = new ArrayList<>();

    /** The HBox container that holds the four card ImageViews. */
    private HBox cardPane;

    /** The first ImageView for displaying a card. */
    private final ImageView cardView1 = new ImageView();
    /** The second ImageView for displaying a card. */
    private final ImageView cardView2 = new ImageView();
    /** The third ImageView for displaying a card. */
    private final ImageView cardView3 = new ImageView();
    /** The fourth ImageView for displaying a card. */
    private final ImageView cardView4 = new ImageView();

    /**
     * The main entry point for all JavaFX applications.
     * <p>
     * This method is called after the init method has returned and the
     * system is ready for the application to begin running.
     * </p>
     * @param primaryStage The primary stage for this application, onto
     * which the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {

        // 1. Create the HBox for the cards
        // Spacing of 10 pixels between cards
        cardPane = new HBox(10);
        cardPane.setAlignment(Pos.CENTER);
        cardPane.getChildren().addAll(cardView1, cardView2, cardView3, cardView4);

        // 2. Create the Refresh Button
        Button refreshButton = new Button("Refresh Cards");

        // 3. REQUIREMENT: Use a Lambda Expression for the button's action
        // This lambda expression calls our refreshCards() method when clicked.
        refreshButton.setOnAction(_ -> {
            refreshCards();
        });

        // 4. Set up the main layout (VBox)
        // Spacing of 20 pixels between the cardPane and the refreshButton
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20)); // Add 20px padding around the window
        root.getChildren().addAll(cardPane, refreshButton);

        // 5. Load the first set of cards
        refreshCards();

        // 6. Set up and show the stage (window)
        Scene scene = new Scene(root);
        primaryStage.setTitle("Module 1 - Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Clears and repopulates the dick (1-52), shuffles it, and updates the 
     * four ImageViews with the first four cards from the `cards` directory.
     * <p>
     * Handles FileNotFoundException iternally by displaying an error
     * message in the console and the UI if the 'cards' directory or its 
     * images are missing.
     * </p>
     */
    private void refreshCards() {
        // (Re)populate the deck with numbers 1 through 52
        deck.clear();
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        // Shuffle the deck to randomize
        Collections.shuffle(deck);

        try {
            // Get the first four "cards" (numbers) from the shuffled deck
            // and create their file paths.
            String path1 = "cards/" + deck.get(0) + ".png";
            String path2 = "cards/" + deck.get(1) + ".png";
            String path3 = "cards/" + deck.get(2) + ".png";
            String path4 = "cards/" + deck.get(3) + ".png";

            // We use FileInputStream to robustly load from the 'cards' subdir.
            // This ensures we load from the file system, not a URL
            cardView1.setImage(new Image(new FileInputStream(path1)));
            cardView2.setImage(new Image(new FileInputStream(path2)));
            cardView3.setImage(new Image(new FileInputStream(path3)));
            cardView4.setImage(new Image(new FileInputStream(path4)));

        } catch (FileNotFoundException e) {
            // This is a critical error. Handle it gracefully.
            System.err.println("ERROR: Could not find 'cards' directory.");
            System.err.println(
                    "Please ensure the 'cards' folder with 1.png - 52.png exists in the root project directory.");

            // Display an error message in the UI so the user knows what's wrong
            cardPane.getChildren().clear(); // Remove the (now empty) ImageViews
            cardPane.getChildren().add(new Text("Error: 'cards' directory not found."));
        }
    }

    /**
     * Main method to launch the JavaFX application.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}