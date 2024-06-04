package scene.component;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import application.Main;
import logic.game.GameLogic;
import scene.MainMenuScene;
import util.Constant;

/**
 * Class represents JavaFX AnchorPane for Header on some scenes.
 */
public class Header extends AnchorPane {
	private final int HEADER_HEIGHT = 50;
	private final int BACK_WIDTH = 40;
	private final int BACK_HEIGHT = 30;
	private final int GAP = 15;
	private final String BACK_BUTTON_PATH = ClassLoader.getSystemResource("image/back-button.png").toString();
	private final String BACK_BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-size: cover; -fx-background-image: url('"
			+ BACK_BUTTON_PATH + "');";
	private final String HEADER_STYLE = "-fx-background-color: rgba(8, 22, 50, 0.5);";
	private final int FONT_SIZE = 28;
	private final int LABEL_WIDTH = 150;

	/**
	 * Header Constructor: creates a new header component alongside its components.
	 * 
	 * @param text the text that would be displayed on the right-side of the header.
	 */
	public Header(String text) {
		setStyle(HEADER_STYLE);
		setPrefSize(Constant.GAME_WIDTH, HEADER_HEIGHT);
		Label sceneLabel = getSceneLabel(text);
		getChildren().addAll(getBackButton(), getMainMenuLabel(), sceneLabel);
		setRightAnchor(sceneLabel, (double) GAP);
	}

	/**
	 * A function that styles the back button.
	 * 
	 * @return back button as JavaFX Button component.
	 */
	private Button getBackButton() {
		Button backButton = new Button();
		backButton.setStyle(BACK_BUTTON_STYLE);
		backButton.setPrefSize(BACK_WIDTH, BACK_HEIGHT);
		backButton.setTranslateY((double) -BACK_HEIGHT / 2);
		backButton.setLayoutY((double) HEADER_HEIGHT / 2);
		backButton.setLayoutX(GAP);
		backButton.setOnMouseClicked(event -> {
			Main.setScene(new MainMenuScene());
			GameLogic.getInstance().stop();
		});
		backButton.setOnMouseEntered(event -> {
			backButton.setEffect(new DropShadow());
		});
		backButton.setOnMouseExited(event -> {
			backButton.setEffect(null);
		});
		return backButton;
	}

	/**
	 * A function that styles the back label.
	 * 
	 * @return back label as JavaFX Label component.
	 */
	private Label getMainMenuLabel() {
		Label label = new Label("Back to Main Menu");
		label.setAlignment(Pos.CENTER_LEFT);
		label.setPrefHeight((double) HEADER_HEIGHT / 2);
		label.setTextAlignment(TextAlignment.CENTER);
		label.setTextFill(Color.WHITE);
		label.setTranslateY((double) -HEADER_HEIGHT / 4);
		label.setLayoutY((double) HEADER_HEIGHT / 2);
		label.setLayoutX(2 * GAP + BACK_WIDTH);
		label.setFont(Font.loadFont(ClassLoader.getSystemResourceAsStream("font/LilyUPC.ttf"), FONT_SIZE));
		return label;
	}

	/**
	 * A function that styles the scene label.
	 * 
	 * @param text text that will be displayed in right-side of header.
	 * @return scene label as JavaFX Label component.
	 */
	private Label getSceneLabel(String text) {
		Label label = new Label(text);
		label.setAlignment(Pos.CENTER_RIGHT);
		label.setPrefSize(LABEL_WIDTH, (double) HEADER_HEIGHT / 2);
		label.setTextAlignment(TextAlignment.CENTER);
		label.setTextFill(Color.WHITE);
		label.setTranslateY((double) -HEADER_HEIGHT / 4);
		label.setLayoutY((double) HEADER_HEIGHT / 2);
		label.setFont(Font.loadFont(ClassLoader.getSystemResourceAsStream("font/LilyUPC.ttf"), FONT_SIZE));
		return label;
	}
}
