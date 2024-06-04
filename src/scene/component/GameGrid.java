package scene.component;

import javafx.scene.layout.GridPane;
import logic.component.Human;
import logic.component.Item;
import logic.usage.Renderable;
import logic.game.GameLogic;
import util.Constant;

import java.util.ArrayList;

public class GameGrid extends GridPane {
	private final int GAME_GRID_X = 240;
	private ArrayList<GameCell> boardState;

	public GameGrid() {
		boardState = new ArrayList<>();
		for (int j = 0; j < Constant.BOARD_HEIGHT; ++j) {
			for (int i = 0; i < Constant.BOARD_WIDTH; ++i) {
				GameCell currentCell = new GameCell(i, j);
				getBoardState().add(currentCell);
				add(currentCell, i, j);
			}
		}
		drawBoard();
		// Styling
		setTranslateY((double) -Constant.CELL_SIZE * Constant.BOARD_HEIGHT / 2);
		setLayoutY((double) Constant.GAME_HEIGHT / 2);
		setLayoutX(GAME_GRID_X);
	}

	public void drawBoard() {
		for (GameCell gameCell : getBoardState()) {
			gameCell.getChildren().clear();
		}

		ArrayList<Item> items = GameLogic.getInstance().getLevel().getItems();
		for (Item item : items) {
			if (item instanceof Renderable) {
				drawCell(item.getX(), item.getY(), ((Renderable) item).getURL());
			}
		}

		ArrayList<Human> humans = GameLogic.getInstance().getLevel().getHumans();
		for (Human human : humans) {
			drawCell(human.getX(), human.getY(), human.getURL());
		}
	}

	public void drawCell(int x, int y, String path) {
		getBoardState().get(Constant.BOARD_WIDTH * y + x).draw(path);
	}

	public ArrayList<GameCell> getBoardState() {
		return boardState;
	}
}
