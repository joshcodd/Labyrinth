package views.scenes;
/**
 * Player Selection scene class
 * @author James Charnock
 * @StudentID 1909700
 */
import javafx.fxml.FXML;
import javafx.scene.media.MediaView;
import models.FileHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controllers.PlayerSelectionController;

import javafx.scene.media.MediaPlayer;



import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SelectPlayerScene {
    private Stage primaryStage;
    private ArrayList<String> players;
    private PlayerSelectionController controller;


    public SelectPlayerScene (Stage stage, String level, MediaPlayer backgroundMusic) throws FileNotFoundException {
        this.primaryStage = stage;
        this.players = FileHandler.getAllNames();

        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getClassLoader().getResource("views/layouts/PlayerSelectionView.fxml").openStream());
            this.controller = loader.getController();
            controller.setProfileBox(players);
            controller.setPrimaryStage(primaryStage);
            controller.setGameName(level);
            controller.setBackgroundMusic(new MediaView(backgroundMusic));
            Scene scene = new Scene(root, 1200, 650);
            scene.getStylesheets().add("styles.css");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e){
            e.printStackTrace();

        }
    }
}
