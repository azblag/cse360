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
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> stage.close());
        fileMenu.getItems().add(exitItem);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction(e ->
                new Alert(Alert.AlertType.INFORMATION,
                        "Simple JavaFX GUI\nCreated by Blake Guinn").showAndWait()
        );
        helpMenu.getItems().add(aboutItem);

        MenuBar menuBar = new MenuBar(fileMenu, helpMenu);

        // ----- Form Fields -----
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField("Blake Guinn");

        Label programLabel = new Label("Program:");
        TextField programField = new TextField("JavaFX GUI Assignment");

        HBox nameBox = new HBox(10, nameLabel, nameField);
        HBox programBox = new HBox(10, programLabel, programField);

        // ----- Buttons -----
        Button submitButton = new Button("Submit");
        Button clearButton = new Button("Clear");

        submitButton.setOnAction(e ->
                new Alert(Alert.AlertType.INFORMATION,
                        "Submitted by: " + nameField.getText()).showAndWait()
        );

        clearButton.setOnAction(e -> {
            nameField.clear();
            programField.clear();
        });

        HBox buttonBox = new HBox(10, submitButton, clearButton);

        // ----- Layout -----
        VBox layout = new VBox(15, menuBar, nameBox, programBox, buttonBox);
        layout.setStyle("-fx-padding: 15;");

        // ----- Scene -----
        Scene scene = new Scene(layout, 400, 250);
        stage.setTitle("Simple JavaFX GUI - Blake Guinn");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
