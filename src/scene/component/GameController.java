package scene.component;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import logic.game.GameLogic;
import util.Constant;

public class GameController extends AnchorPane {
	private final int CONTROLLER_HEIGHT = 50;
	private final int PADDING = 15;
	private final int PLAY_BUTTON_WIDTH = 40;
	private final int PLAY_BUTTON_HEIGHT = 30;
	private final String PLAY_BUTTON_PATH = ClassLoader.getSystemResource("image/play-button.png").toString();
	private final String PLAY_BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-size: cover; -fx-background-image: url('"
			+ PLAY_BUTTON_PATH + "');";
	private final int RESET_BUTTON_WIDTH = 36;
	private final int RESET_BUTTON_HEIGHT = 36;
	private final String RESET_BUTTON_PATH = ClassLoader.getSystemResource("image/reset-button.png").toString();
	private final String RESET_BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-size: cover; -fx-background-image: url('"
			+ RESET_BUTTON_PATH + "');";
	private final String CONTROLLER_STYLE = "-fx-background-color: rgba(8, 22, 50, 0.5);";
	private final int FONT_SIZE = 28;
	private final int LABEL_SIZE = 150;

	public GameController() {
		setStyle(CONTROLLER_STYLE);
		setPrefSize(Constant.GAME_WIDTH, CONTROLLER_HEIGHT);
		getChildren().addAll(getSimulateButton(), getSimulateLabel(), getResetButton(), getResetLabel());
	}

	public Button getSimulateButton() {
		Button simulateButton = new Button();
		simulateButton.setStyle(PLAY_BUTTON_STYLE);
		simulateButton.setPrefSize(PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
		simulateButton.setTranslateY((double) -PLAY_BUTTON_HEIGHT / 2);
		simulateButton.setLayoutY((double) CONTROLLER_HEIGHT / 2);
		simulateButton.setLayoutX(PADDING);
		simulateButton.setOnMouseClicked(event -> {
			GameLogic.getInstance().simulate();
		});
		simulateButton.setOnMouseEntered(event -> {
			simulateButton.setEffect(new DropShadow());
		});
		simulateButton.setOnMouseExited(event -> {
			simulateButton.setEffect(null);
		});
		return simulateButton;
	}

	public Label getSimulateLabel() {
		Label label = new Label("Start Simulation");
		label.setAlignment(Pos.CENTER_LEFT);
		label.setPrefSize(LABEL_SIZE, (double) CONTROLLER_HEIGHT / 2);
		label.setTextAlignment(TextAlignment.CENTER);
		label.setTextFill(Color.WHITE);
		label.setTranslateY((double) -CONTROLLER_HEIGHT / 4);
		label.setLayoutY((double) CONTROLLER_HEIGHT / 2);
		label.setLayoutX(2 * PADDING + PLAY_BUTTON_WIDTH);
		label.setFont(Font.loadFont(ClassLoader.getSystemResourceAsStream("font/LilyUPC.ttf"), FONT_SIZE));
		return label;
	}

	public Button getResetButton() {
		Button resetButton = new Button();
		resetButton.setStyle(RESET_BUTTON_STYLE);
		resetButton.setPrefSize(RESET_BUTTON_WIDTH, RESET_BUTTON_HEIGHT);
		resetButton.setTranslateY((double) -RESET_BUTTON_HEIGHT / 2);
		resetButton.setLayoutY((double) CONTROLLER_HEIGHT / 2);
		resetButton.setLayoutX(3 * PADDING + PLAY_BUTTON_WIDTH + LABEL_SIZE);
		resetButton.setOnMouseClicked(event -> {
			GameLogic.getInstance().reset();
		});
		resetButton.setOnMouseEntered(event -> {
			resetButton.setEffect(new DropShadow());
		});
		resetButton.setOnMouseExited(event -> {
			resetButton.setEffect(null);
		});
		return resetButton;
	}

	public Label getResetLabel() {
		Label label = new Label("Reset");
		label.setAlignment(Pos.CENTER_LEFT);
		label.setPrefSize(LABEL_SIZE, (double) CONTROLLER_HEIGHT / 2);
		label.setTextAlignment(TextAlignment.CENTER);
		label.setTextFill(Color.WHITE);
		label.setTranslateY((double) -CONTROLLER_HEIGHT / 4);
		label.setLayoutY((double) CONTROLLER_HEIGHT / 2);
		label.setLayoutX(4 * PADDING + PLAY_BUTTON_WIDTH + LABEL_SIZE + RESET_BUTTON_WIDTH);
		label.setFont(Font.loadFont(ClassLoader.getSystemResourceAsStream("font/LilyUPC.ttf"), FONT_SIZE));
		return label;
	}
}
