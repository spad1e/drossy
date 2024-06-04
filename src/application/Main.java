package application;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import scene.MainMenuScene;
import util.Constant;

/**
 * This class represents the main class.
 */

public class Main extends Application {
    /**
     * A field represents the Stage of primaryStage.
     */
    public static Stage primaryStage;

    /**
     * A JavaFX method. Called when the JavaFX application launches.
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            initializeBackgroundMusic();
            Main.primaryStage = primaryStage;
            setScene(new MainMenuScene());
            primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("image/icon.png").toString()));
            primaryStage.setResizable(false);
            primaryStage.setTitle("Drowsy Drossy");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A function to plays the file background-music.mp3 indefinitely.
     */
    private void initializeBackgroundMusic() {
        Media backgroundMusic = new Media(ClassLoader.getSystemResource("audio/background-music.mp3").toString());
        MediaPlayer backGroundMusicPlayer = new MediaPlayer(backgroundMusic);
        backGroundMusicPlayer.setCycleCount(-1); // plays indefinitely
        backGroundMusicPlayer.play();
    }

    /**
     * A function to change the scene.
     * 
     * @param root represents JavaFX node that will be set as scene.
     */
    public static void setScene(Parent root) {
        Scene scene = new Scene(root, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        primaryStage.setScene(scene);
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args Application arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}