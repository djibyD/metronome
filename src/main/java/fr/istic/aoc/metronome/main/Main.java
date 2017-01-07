package fr.istic.aoc.metronome.main;

import fr.istic.aoc.metronome.controller.ControllerImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/metronome.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Metronome version 1");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
        primaryStage.show();


        ControllerImpl controller = loader.getController();

    }
    public static void main(String[] args) {
        launch(args);
    }
}