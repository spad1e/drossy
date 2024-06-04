package scene;

import application.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import scene.component.PrimaryButton;
import scene.component.SecondaryButton;
import util.Constant;

/**
 * This class represents the main menu scene.
 */

public class MainMenuScene extends AnchorPane {
	private final String TITLE_PATH = ClassLoader.getSystemResource("image/title.png").toString();
	private final int TITLE_WIDTH = 400;
	private final int TITLE_HEIGHT = 200;
	private final int TITLE_Y = 50;
	private final int START_BUTTON_Y = 300;
	private final int TUTORIAL_BUTTON_Y = 400;
	private final int EXIT_BUTTON_Y = 500;

	/**
	 * MainMenuScene Constructor: creates a new main menu scene alongside its
	 * components.
	 */
	public MainMenuScene() {
		setPrefSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT); // Size of scene
		setStyle("-fx-background-image: url('" + Constant.getBackground(1) + "')");
		PrimaryButton startButton = new PrimaryButton("START");
		startButton.setOnMouseClicked(event -> {
			Main.setScene(new LevelSelectionScene());
		});
		startButton.setLayoutX((double) Constant.GAME_WIDTH / 2);
		startButton.setLayoutY(START_BUTTON_Y);

		PrimaryButton tutorialButton = new PrimaryButton("TUTORIAL");
		tutorialButton.setOnMouseClicked(event -> {
			Main.setScene(new TutorialScene());
		});
		tutorialButton.setLayoutX((double) Constant.GAME_WIDTH / 2);
		tutorialButton.setLayoutY(TUTORIAL_BUTTON_Y);

		SecondaryButton exitButton = new SecondaryButton("EXIT");
		exitButton.setOnMouseClicked(event -> {
			Main.primaryStage.close();
		});
		exitButton.setLayoutX((double) Constant.GAME_WIDTH / 2);
		exitButton.setLayoutY(EXIT_BUTTON_Y);

		getChildren().addAll(getTitle(), startButton, tutorialButton, exitButton);
	}

	/**
	 * A function that styles the game title image.
	 * 
	 * @return game title as JavaFX ImageView component.
	 */
	public ImageView getTitle() {
		ImageView title = new ImageView(new Image(TITLE_PATH));
		title.setFitHeight(TITLE_HEIGHT);
		title.setFitWidth(TITLE_WIDTH);
		title.setLayoutX((double) Constant.GAME_WIDTH / 2);
		title.setTranslateX(-(double) TITLE_WIDTH / 2);
		title.setLayoutY(TITLE_Y);
		return title;
	}
}
