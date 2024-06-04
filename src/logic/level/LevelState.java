package logic.level;

/**
 * Enumerator represents the state of each level (not_attempted, solved,
 * attempted).
 */
public enum LevelState {
	/**
	 * Solved state.
	 */
	SOLVED,
	/**
	 * Attempted state.
	 */
	ATTEMPTED,
	/**
	 * Not attempted state.
	 */
	NOT_ATTEMPTED;

	/**
	 * A function that returns style of level selection button when pressed for each
	 * state.
	 * 
	 * @return a css format String for each state's styling.
	 */
	public String getPressedStyle() {
		String BUTTON_PATH = ClassLoader.getSystemResource("image/level-" + this.format() + "-pressed.png").toString();
		return "-fx-background-size: cover; -fx-background-color: transparent; -fx-background-image: url('"
				+ BUTTON_PATH + "')";
	}

	/**
	 * A function that returns style of level selection button when released for
	 * each state.
	 * 
	 * @return a css format String for each state's styling.
	 */
	public String getReleasedStyle() {
		String BUTTON_PATH = ClassLoader.getSystemResource("image/level-" + this.format() + ".png").toString();
		return "-fx-background-size: cover; -fx-background-color: transparent; -fx-background-image: url('"
				+ BUTTON_PATH + "')";
	}

	/**
	 * A function that formats the enumerator into string.
	 * 
	 * @return a String formatted enumerator name.
	 */
	private String format() {
		return super.toString().toLowerCase().replaceAll("_", "-");
	}
}
