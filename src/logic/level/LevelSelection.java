package logic.level;

import scene.component.LevelSelectionButton;
import util.Constant;

import java.util.ArrayList;

public class LevelSelection {
	private static LevelSelection instance;
	private ArrayList<LevelSelectionButton> levelSelectionButtons;

	private LevelSelection() {
		levelSelectionButtons = new ArrayList<>();
		for (int i = 0; i < Constant.LEVEL_COUNT; ++i) {
			levelSelectionButtons.add(new LevelSelectionButton(i + 1));
		}
	}

	public static LevelSelection getInstance() {
		if (instance == null) {
			instance = new LevelSelection();
		}
		return instance;
	}

	public ArrayList<LevelSelectionButton> getLevelSelectionButtons() {
		getInstance();
		return levelSelectionButtons;
	}
}
