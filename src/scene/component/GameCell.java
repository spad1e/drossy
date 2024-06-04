package scene.component;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import logic.game.GameLogic;
import util.Constant;

/**
 * This class represents a game cell in game grid.
 */
public class GameCell extends StackPane {
	private int xPosition;
	private int yPosition;

	/**
	 * GameCell Constructor: creates a new game cell component alongside its
	 * styling.
	 * 
	 * @param x the x coordinate of the cell.
	 * @param y the y coordinate of the cell.
	 */
	public GameCell(int x, int y) {
		int style = (int) (4 * Math.random()) + 1;
		String FLOOR_PATH = ClassLoader.getSystemResource("image/floor-" + style + ".png").toString();
		setStyle("-fx-background-size: cover; -fx-background-color: transparent; -fx-background-image: url('"
				+ FLOOR_PATH + "');");
		setPrefSize(Constant.CELL_SIZE, Constant.CELL_SIZE);

		setxPosition(x);
		setyPosition(y);

		setOnMouseClicked(this::handleClick);

	}

	/**
	 * This function handles the click on the current game cell.
	 * 
	 * @param event mouse event
	 */
	private void handleClick(MouseEvent event) {
		if (!GameLogic.getInstance().getLevel().getPlaceableArrow().isEmpty()) {
			GameLogic.getInstance().placeArrow(this.xPosition, this.yPosition);
		}
	}

	/**
	 * This function draws an image onto the current game cell.
	 * 
	 * @param path path to the image that will be drawn.
	 */
	public void draw(String path) {
		String imagePath = ClassLoader.getSystemResource(path).toString();
		ImageView image = new ImageView(new Image(imagePath));
		getChildren().add(image);
	}

	/**
	 * setter for xPosition.
	 * 
	 * @param xPosition value to be set.
	 */
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * setter for yPosition.
	 * 
	 * @param yPosition value to be set.
	 */
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
}
