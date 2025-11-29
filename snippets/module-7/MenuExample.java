/*
 * file: modules/module-7/MenuExample.java
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
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Demonstration of Menus in JavaFX
 * <p>
 * This demonstrates the approach of building a MenuBar
 * programmatically, as oppossed to using FXML.
 * </p>
 * 
 * @author Brittaney Perry-Morgan
 * @version 1.0
 * @since Fall 2025
 */
public class MenuExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");

        saveItem.setOnAction(event -> System.out.println("Save Clicked!"));
        exitItem.setOnAction(event -> {
            System.out.println("Exiting the Application...");
            Platform.exit();
        });

        fileMenu.getItems().addAll(saveItem, exitItem);
        menuBar.getMenus().add(fileMenu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Menu Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}