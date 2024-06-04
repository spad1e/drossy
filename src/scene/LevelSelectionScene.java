package scene;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import scene.component.Header;
import scene.component.LevelSelectionButton;
import util.Constant;
import logic.level.LevelSelection;

/**
 * A class represents level selection scene.
 */
public class LevelSelectionScene extends AnchorPane {
	private final int TITLE_WIDTH = 370;
	private final int TITLE_HEIGHT = 60;
	private final int TITLE_Y = 100;
	private final int FONT_SIZE = 32;
	private final int BUTTON_SIZE = 100;
	private final int GAP = 50;
	private final int LEVEL_COL = 4;
	private final int LEVEL_ROW = 2;

	/**
	 * LevelSelectionScene Constructor: creates a new level selection scene
	 * alongside its components.
	 */
	public LevelSelectionScene() {
		setStyle("-fx-background-image: url('" + Constant.getBackground(2) + "')");
		getChildren().addAll(new Header("Level Selection"), getTitle(), getLevelGrid());
	}

	/**
	 * A function that styles the level selection title.
	 * 
	 * @return game title as JavaFX Label component.
	 */
	public Label getTitle() {
		Label title = new Label("Pick a Level");
		title.setPrefSize(TITLE_WIDTH, TITLE_HEIGHT);
		title.setTextAlignment(TextAlignment.CENTER);
		title.setAlignment(Pos.CENTER);
		title.setTranslateX((double) -TITLE_WIDTH / 2);
		title.setTranslateY((double) -TITLE_HEIGHT / 2);
		title.setLayoutX((double) Constant.GAME_WIDTH / 2);
		title.setLayoutY(TITLE_Y);
		title.setTextFill(Color.WHITE);
		title.setFont(Font.loadFont(ClassLoader.getSystemResourceAsStream("font/JetBrainsMono.ttf"), FONT_SIZE));
		return title;
	}

	/**
	 * A function that styles the level selection grid.
	 * 
	 * @return level grid as JavaFX GridPane component.
	 */
	public GridPane getLevelGrid() {
		GridPane levelGrid = new GridPane();
		levelGrid.setHgap(GAP);
		levelGrid.setVgap(GAP);
		levelGrid.setPrefSize(LEVEL_COL * BUTTON_SIZE + (LEVEL_COL - 1) * GAP,
				LEVEL_ROW * BUTTON_SIZE + (LEVEL_ROW - 1) * GAP);
		levelGrid.setTranslateX(-levelGrid.getPrefWidth() / 2);
		levelGrid.setTranslateY(-levelGrid.getPrefHeight() / 2);
		levelGrid.setLayoutX((double) Constant.GAME_WIDTH / 2);
		levelGrid.setLayoutY((double) Constant.GAME_HEIGHT / 2);
		for (int i = 0; i < Constant.LEVEL_COUNT; ++i) {
			LevelSelectionButton lsb = LevelSelection.getInstance().getLevelSelectionButtons().get(i);
			lsb.initialize();
			levelGrid.add(lsb, i % LEVEL_COL, i / LEVEL_COL);
		}
		return levelGrid;
	}
}
