package scene.component;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;
import logic.level.LevelState;
import scene.GameScene;
import application.Main;

/**
 * Class represents JavaFX Button for level selection
 */
public class LevelSelectionButton extends Button {
	private LevelState levelState;
	private final int BUTTON_SIZE = 100;
	private final int GAP = 8;
	private final int FONT_SIZE = 32;

	/**
	 * LevelSelectionButton Constructor: creates a new JavaFX button with level
	 * selection styling.
	 * 
	 * @param level represents the level number that would be displayed on the
	 *              button.
	 */
	public LevelSelectionButton(int level) {
		super(Integer.toString(level));
		levelState = LevelState.NOT_ATTEMPTED;
		setStyle(levelState.getReleasedStyle());
		setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
		initializeEventHandler(level);
		setFont(Font.loadFont(ClassLoader.getSystemResourceAsStream("font/Impact.ttf"), FONT_SIZE));
	}

	/**
	 * A function that changes the state of a level from not-attempted -> attempted
	 * -> solved. The states cannot be changed backwards.
	 * 
	 * @param levelState the enumerator levelState. Effect will take place if the
	 *                   transition is valid.
	 */
	public void changeState(LevelState levelState) {
		if (this.levelState == LevelState.SOLVED || levelState == LevelState.SOLVED)
			this.levelState = LevelState.SOLVED;
		else if (this.levelState == LevelState.ATTEMPTED || levelState == LevelState.ATTEMPTED)
			this.levelState = LevelState.ATTEMPTED;
		else
			this.levelState = LevelState.NOT_ATTEMPTED;
		setStyle(levelState.getReleasedStyle());
	}

	/**
	 * A function that initialized a shared event handler of level selection button:
	 * drop shadow on mouse entered, null on mouse exited, and pressed and released
	 * styles.
	 * 
	 * @param level the level number that will be redirected to.
	 */
	private void initializeEventHandler(int level) {
		setOnMouseEntered(event -> {
			setEffect(new DropShadow());
		});
		setOnMouseExited(event -> {
			setEffect(null);
		});
		setOnMousePressed(event -> {
			setStyle(levelState.getPressedStyle());
			setPrefHeight(BUTTON_SIZE - GAP);
			setLayoutY(getLayoutY() + GAP);
		});
		setOnMouseReleased(event -> {
			setStyle(levelState.getReleasedStyle());
			setPrefHeight(BUTTON_SIZE);
			setLayoutY(getLayoutY() - GAP);
		});
		setOnMouseClicked(event -> {
			Main.setScene(new GameScene(level));
		});
	}

	/**
	 * A function that initializes the level selection button styling.
	 */
	public void initialize() {
		setStyle(levelState.getReleasedStyle());
	}
}
