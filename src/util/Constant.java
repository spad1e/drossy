package util;

/**
 * A class represents shared constants used throughout the application
 */
public class Constant {
	public static final int GAME_WIDTH = 900;
	public static final int GAME_HEIGHT = 600;
	public static final int LEVEL_COUNT = 8;
	public static final int BOARD_WIDTH = 12;
	public static final int BOARD_HEIGHT = 9;
	public static final int CELL_SIZE = 48;
	public static final int HUMAN_COUNT = 2;

	public static String getBackground(int index) {
		return ClassLoader.getSystemResource("image/background-image-" + index + ".png").toString();
	}
}
