package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // ----- Menu Bar -----
        Menu fileMenu = new Menu("Settings");
        
        MenuItem fullscreenItem = new MenuItem("Fullscreen");
        fullscreenItem.setOnAction(event -> {
            stage.setFullScreen(!stage.isFullScreen());
        });
        
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> stage.close());
        
        fileMenu.getItems().add(fullscreenItem);
        fileMenu.getItems().add(exitItem);

        Menu infoMenu = new Menu("Info");
        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction(e ->
                new Alert(Alert.AlertType.INFORMATION,
                        "Assignment 1 / February 9th, 2026 / Blake Guinn").showAndWait()
        );
        infoMenu.getItems().add(aboutItem);

        MenuBar menuBar = new MenuBar(fileMenu, infoMenu);

        // ----- Form Fields ----- //
        Label nameLabel = new Label("Username:");
        TextField nameField = new TextField("");

        Label colorLabel = new Label("Favorite Color:");
        TextField colorField = new TextField("");

        HBox nameBox = new HBox(10, nameLabel, nameField);
        HBox programBox = new HBox(10, colorLabel, colorField);

        // ----- Buttons ----- //
        Button submitButton = new Button("Submit");
        Button clearButton = new Button("Clear");

        submitButton.setOnAction(e ->
                new Alert(Alert.AlertType.INFORMATION,
                        nameField.getText() + " has a favorite color and it is color it is " + colorField.getText() + "!").showAndWait()
        );

        clearButton.setOnAction(e -> {
            nameField.clear();
            colorField.clear();
        });

        HBox buttonBox = new HBox(10, submitButton, clearButton);

        // ----- Layout ----- //
        VBox layout = new VBox(15, menuBar, nameBox, programBox, buttonBox);
        layout.setStyle("-fx-padding: 15;");

        // ----- Scene ----- //
        Scene scene = new Scene(layout, 350, 200);
        stage.setTitle("CSE360_A1_BlakeGuinn");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
