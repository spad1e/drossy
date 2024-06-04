package logic.usage;

public enum FacingDirection {
    UP, DOWN, LEFT, RIGHT, NONE;

    /**
     * Return the facing direction from a string.
     */
    public static FacingDirection fromString(String direction) {
        if (direction.equals("UP")) {
            return UP;
        } else if (direction.equals("DOWN")) {
            return DOWN;
        } else if (direction.equals("LEFT")) {
            return LEFT;
        } else if (direction.equals("RIGHT")) {
            return RIGHT;
        } else {
            return NONE;
        }
    }

    /**
     * Return the opposite direction of the current facing direction.
     */
    public FacingDirection opposite() {
        if (this == UP) {
            return DOWN;
        } else if (this == DOWN) {
            return UP;
        } else if (this == LEFT) {
            return RIGHT;
        } else if (this == RIGHT) {
            return LEFT;
        } else {
            return NONE;
        }
    }

    /**
     * Return the x direction according to the facing direction.
     */
    public int getXDir() {
        if (this == LEFT) {
            return -1;
        } else if (this == RIGHT) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Return the y direction according to the facing direction.
     */
    public int getYDir() {
        if (this == UP) {
            return -1;
        } else if (this == DOWN) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Return the string representation of the facing direction.
     */
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
