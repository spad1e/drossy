package scene;

import application.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logic.level.LevelSelection;
import logic.level.LevelState;
import scene.component.*;
import util.Constant;

/**
 * This class represents the end game scene.
 */
public class EndGameScene extends AnchorPane {
	private final String TITLE_PATH = ClassLoader.getSystemResource("image/clear-title.png").toString();
	private final int TITLE_WIDTH = 300;
	private final int TITLE_HEIGHT = 150;
	private final int TITLE_Y = 50;
	private final int NEXT_BUTTON_Y = 300;
	private final int REPLAY_BUTTON_Y = 400;
	private final int BACK_BUTTON_Y = 500;

	/**
	 * EndGameScene Constructor: creates a new end game scene alongside its
	 * components.
	 * 
	 * @param level the level that had been completed.
	 */
	public EndGameScene(int level) {
		LevelSelectionButton lsb = LevelSelection.getInstance().getLevelSelectionButtons().get(level - 1);
		lsb.changeState(LevelState.SOLVED);
		setStyle("-fx-background-image: url('" + Constant.getBackground(1) + "')");
		if (level < Constant.LEVEL_COUNT) {
			PrimaryButton nextLevelButton = new PrimaryButton("NEXT LEVEL");
			nextLevelButton.setOnMouseClicked(event -> {
				Main.setScene(new GameScene(level + 1));
			});
			nextLevelButton.setLayoutX((double) Constant.GAME_WIDTH / 2);
			nextLevelButton.setLayoutY(NEXT_BUTTON_Y);
			getChildren().add(nextLevelButton);
		}

		PrimaryButton replayButton = new PrimaryButton("REPLAY");
		replayButton.setOnMouseClicked(event -> {
			Main.setScene(new GameScene(level));
		});
		replayButton.setLayoutX((double) Constant.GAME_WIDTH / 2);
		replayButton.setLayoutY(REPLAY_BUTTON_Y);

		SecondaryButton backToMainMenuButton = new SecondaryButton("Back to Main Menu");
		backToMainMenuButton.setOnMouseClicked(event -> {
			Main.setScene(new MainMenuScene());
		});
		backToMainMenuButton.setLayoutX((double) Constant.GAME_WIDTH / 2);
		backToMainMenuButton.setLayoutY(BACK_BUTTON_Y);
		getChildren().addAll(getTitle(), replayButton, backToMainMenuButton);
	}

	/**
	 * A function that styles the game title image.
	 * 
	 * @return clear title as JavaFX ImageView component.
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
