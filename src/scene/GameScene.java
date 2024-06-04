package scene;

import javafx.scene.layout.AnchorPane;
import logic.game.GameLogic;
import logic.level.LevelSelection;
import logic.level.LevelState;
import scene.component.*;
import util.Constant;

/**
 * This class represents game scene.
 */
public class GameScene extends AnchorPane {
	private final int PADDING = 15;

	/**
	 * GameScene Constructor: creates a new game scene alongside its components.
	 * 
	 * @param level represents level number that will be loaded.
	 */
	public GameScene(int level) {
		LevelSelectionButton lsb = LevelSelection.getInstance().getLevelSelectionButtons().get(level - 1);
		lsb.changeState(LevelState.ATTEMPTED);

		GameLogic.getInstance().setLevel(level);

		// Styles
		setStyle("-fx-background-image: url('" + Constant.getBackground(3) + "')");
		GameController gc = new GameController();
		ArrowList arrowList = new ArrowList();
		GameGrid gameGrid = new GameGrid();
		getChildren().addAll(new Header("Level " + level), arrowList, gc, gameGrid);
		setBottomAnchor(gc, 0.0);
		setLeftAnchor(arrowList, (double) PADDING);

		GameLogic.getInstance().setGameGrid(gameGrid);
		GameLogic.getInstance().setArrowList(arrowList);
	}
}
