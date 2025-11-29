/*
 * file: modules/module-7/FXMLMenuExample.java
 *
 * Term: Fall 2025
 * 
 * Course: CSD420 Advanced Java Programming
 * Instructor: Jack Lusby
 * Institution: Bellevue University
 * 
 * M7 Discussion Board Demo
 * Author: Brittaney Perry-Morgan
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Demonstration of Menus in JavaFX using FXML
 * <p>
 * This demonstrates the approach of building a MenuBar
 * using FXML, as oppossed to building it programmatically.
 * </p>
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */
public class FXMLMenuExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            URL fxmlLocation = getClass().getResource("MenuLayout.fxml");
            if (fxmlLocation == null) {
                System.err.println("Could not find `MenuLayout.fxml`");
                return;
            }

            Parent root = FXMLLoader.load(fxmlLocation);

            Scene scene = new Scene(root, 300, 200);
            primaryStage.setTitle("FXML Menu Example");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleSave(ActionEvent event) {
        System.out.println("Save Clicked from FXML");
    }

    @FXML
    public void handleExit(ActionEvent event) {
        System.out.println("Exiting from FXML...");
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}