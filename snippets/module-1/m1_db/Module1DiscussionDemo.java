/* file: snippets/module-1/m1_db/Module1DiscussionDemo.java
 *
 * Term: Fall 2025
 * 
 * Course: CSD420 Advanced Java Programming
 * Instructor: Jack Lusby
 * Institution: Bellevue University
 *
 * M1 Discussion Board Snippet
 * Author: Brittaney Perry-Morgan
 */

import javafx.application.Application;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * A JavaFX application to demonstrate the use of JavaFX Text and JavaFX Path.
 * <p>
 * This class makes a JavaFX application that displays text elements with different
 * styling and a custom triangle shape using JavaFX Path.
 * </p>
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */
public class Module1DiscussionDemo extends Application {

    /**
     * The main entry point for the JavaFX application.
     * <p>
     * This method sets up the user interface by create a VBox container, adding text elements
     * with different styling, and a custom triangle shape. Then, it configures the scene and
     * stage for display.
     * </p>
     * 
     * @param primaryStage the primary stage for this application. This is where the scene can
     * be set.
     */

    @Override
    public void start(Stage primaryStage) {
        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);

        // --- JavaFX Text Code ---
        Text basicText = new Text("My understanding: This is a basic Text node.");
        basicText.setFont(Font.font("Verdana", 16));
        basicText.setFill(Color.DARKSLATEBLUE);

        Text styledText = new Text("This is styled with fill and stroke.");
        styledText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        styledText.setFill(Color.ORANGERED);
        styledText.setStroke(Color.BLACK);
        styledText.setStrokeWidth(0.5);

        // --- JavaFX Path Code ---
        Path customTriangle = new Path();

        MoveTo startPoint = new MoveTo(100, 150);
        LineTo line1 = new LineTo(200, 150);
        LineTo line2 = new LineTo(150, 220);
        ClosePath close = new ClosePath();

        customTriangle.getElements().addAll(startPoint, line1, line2, close);
        customTriangle.setFill(Color.LIGHTCORAL);
        customTriangle.setStroke(Color.MAROON);
        customTriangle.setStrokeWidth(2);

        // Add all elements to the VBox
        contentBox.getChildren().addAll(basicText, styledText, customTriangle);

        // --- Scene/Stage setup ---
        Scene scene = new Scene(contentBox, 500, 400);
        primaryStage.setTitle("M1 Discussion Board Snippet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main method to launch the application.
     * <p>
     * This method calls the launch method to start the JavaFX application.
     * </p>
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
