package logic.game;

import javafx.application.Platform;
import logic.component.*;
import logic.level.Level;
import logic.usage.FacingDirection;
import scene.EndGameScene;
import application.Main;
import scene.component.ArrowList;
import scene.component.GameGrid;
import util.Constant;
import util.FileToLevel;

import java.io.File;

public class GameLogic {
	private static GameLogic instance;
	private Level level;
	private int levelNumber;
	private GameGrid gameGrid;
	private ArrowList arrowList;
	private Thread thread;

	private GameLogic() {
		level = null;
	}

	/**
	 * Get the instance of the GameLogic
	 * If the instance is null, create a new instance
	 */
	public static GameLogic getInstance() {
		if (instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}

	/**
	 * Simulate the game using a thread.
	 * If the level is completed, trigger the end game scene.
	 * If the level is not completed, reset the level.
	 */
	public void simulate() {
		if (!level.getPlaceableArrow().isEmpty()) {
			return;
		}
		thread = new Thread(() -> {
			int correctBed;
			boolean awake = false;
			while (true) {
				correctBed = 0;
				for (int i = 0; i < Constant.HUMAN_COUNT; i++) {
					Human human = level.getHumans().get(i);
					boolean move = human.getFacingDirection() != FacingDirection.NONE;
					human.move();
					for (int j = 0; j < Constant.HUMAN_COUNT; j++) {
						if (i != j) {
							Human otherHuman = level.getHumans().get(j);
							if (human.getX() == otherHuman.getX() && human.getY() == otherHuman.getY()) {
								human.setAwake(true);
								otherHuman.setAwake(true);
							}
						}
					}
					for (Item item : level.getItems()) {
						if (human.getX() == item.getX() && human.getY() == item.getY()) {
							item.hit(human);
						}
					}
					for (Item item : level.getItems()) {
						if (item instanceof Bed) {
							Bed bed = (Bed) item;
							if (human.getX() == bed.getX() && human.getY() == bed.getY()
									&& human.getIndex() == bed.getIndex()) {
								correctBed++;
							}
						}
					}
					if (!move) {
						continue;
					}
					Platform.runLater(() -> {
						gameGrid.drawBoard();
					});
					if (human.getAwake()) {
						awake = true;
						break;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						return;
					}
				}
				if (awake || correctBed == 2) {
					break;
				}
			}
			boolean completed = correctBed == 2 && !awake;
			for (Item item : level.getItems()) {
				if (item instanceof Star) {
					Star star = (Star) item;
					if (!star.isCollected()) {
						completed = false;
					}
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				return;
			}
			if (completed) {
				Platform.runLater(() -> {
					Main.setScene(new EndGameScene(levelNumber));
				});
			} else {
				Platform.runLater(() -> {
					reset();
				});
			}
		});
		thread.start();
	}

	/**
	 * If there is no item at the given position, place the first arrow at the given
	 * position.
	 */
	public void placeArrow(int x, int y) {
		for (Item item : level.getItems()) {
			if (item.getX() == x && item.getY() == y) {
				return;
			}
		}
		Arrow a = getInstance().getLevel().getPlaceableArrow().remove(0);
		a.setX(x);
		a.setY(y);
		level.getItems().add(a);
		getGameGrid().drawBoard();
		getArrowList().drawList();
	}

	/**
	 * If the thread is running, interrupt the thread.
	 */
	public void stop() {
		if (thread != null && thread.isAlive()) {
			thread.interrupt();
		}
	}

	/**
	 * Reset the level.
	 */
	public void reset() {
		stop();
		setLevel(getLevelNumber());
		gameGrid.drawBoard();
		arrowList.drawList();
	}

	public Level getLevel() {
		return level;
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevel(int levelNumber) {
		this.level = FileToLevel
				.convert(ClassLoader.getSystemResourceAsStream("level/level" + levelNumber + ".txt"));
		this.levelNumber = levelNumber;
	}

	public GameGrid getGameGrid() {
		return gameGrid;
	}

	public void setGameGrid(GameGrid gameGrid) {
		this.gameGrid = gameGrid;
	}

	public ArrowList getArrowList() {
		return arrowList;
	}

	public void setArrowList(ArrowList arrowList) {
		this.arrowList = arrowList;
	}
}