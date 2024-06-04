package scene.component;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;

/**
 * A class represents JavaFX Button with secondary styling.
 */
public class SecondaryButton extends Button {
	private final int BUTTON_WIDTH = 125;
	private final int BUTTON_HEIGHT = 32;
	private final int GAP = 3;
	private final String BUTTON_PRESSED_PATH = ClassLoader.getSystemResource("image/secondary-button-pressed.png")
			.toString();
	private final String BUTTON_RELEASED_PATH = ClassLoader.getSystemResource("image/secondary-button.png").toString();
	private final String BUTTON_PRESSED_STYLE = "-fx-background-size: cover; -fx-background-color: transparent; -fx-background-image: url('"
			+ BUTTON_PRESSED_PATH + "');";
	private final String BUTTON_RELEASED_STYLE = "-fx-background-size: cover; -fx-background-color: transparent; -fx-background-image: url('"
			+ BUTTON_RELEASED_PATH + "');";
	private final int FONT_SIZE = 16;

	/**
	 * SecondaryButton Constructor: creates a new JavaFX button with secondary
	 * styling.
	 * 
	 * @param text represents the text that would be displayed on the button.
	 */
	public SecondaryButton(String text) {
		super(text);
		setStyle(BUTTON_RELEASED_STYLE);
		setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		setLayoutY(getLayoutY() - GAP);
		setTranslateX((double) -BUTTON_WIDTH / 2);
		setTranslateY((double) -BUTTON_HEIGHT / 2);
		initializeEventHandler();
		setFont(Font.font("LilyUPC", FONT_SIZE));
		setFont(Font.loadFont(ClassLoader.getSystemResourceAsStream("font/LilyUPC.ttf"), FONT_SIZE));
	}

	/**
	 * A function that initializes the shared event handler of primary button: drop
	 * shadow on mouse entered, null on mouse exited, and pressed and released
	 * styles.
	 */
	public void initializeEventHandler() {
		setOnMouseEntered(event -> {
			setEffect(new DropShadow());
		});
		setOnMouseExited(event -> {
			setEffect(null);
		});
		setOnMousePressed(event -> {
			setStyle(BUTTON_PRESSED_STYLE);
			setPrefHeight(BUTTON_HEIGHT - GAP);
			setLayoutY(getLayoutY() + GAP);
		});
		setOnMouseReleased(event -> {
			setStyle(BUTTON_RELEASED_STYLE);
			setPrefHeight(BUTTON_HEIGHT);
			setLayoutY(getLayoutY() - GAP);
		});
	}
}
