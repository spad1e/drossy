package scene.component;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.component.Arrow;
import logic.game.GameLogic;
import util.Constant;

/**
 * This class represents arrow list in game scene.
 */
public class ArrowList extends VBox {
	private final int ARROW_LIST_HEIGHT = 410;

	/**
	 * ArrowList Constructor: creates a new arrow list component alongside its
	 * styling.
	 */
	public ArrowList() {
		setPrefHeight(ARROW_LIST_HEIGHT);
		setSpacing(10);
		setTranslateY((double) -ARROW_LIST_HEIGHT / 2);
		setLayoutY((double) Constant.GAME_HEIGHT / 2);
		drawList();
	}

	/**
	 * A function that get the current placeable arrow from gameLogic and draw them.
	 * 
	 * @see GameLogic
	 */
	public void drawList() {
		getChildren().clear();
		boolean first = true;
		for (Arrow arrow : GameLogic.getInstance().getLevel().getPlaceableArrow()) {
			ImageView image = new ImageView(new Image(arrow.getURL()));
			DropShadow shadow = new DropShadow();
			shadow.setSpread(0.75);
			if (first) {
				shadow.setColor(Color.LIGHTGREEN);
				first = false;
			} else {
				shadow.setColor(Color.GRAY);
			}
			image.setEffect(shadow);
			getChildren().add(image);
		}
	}
}
