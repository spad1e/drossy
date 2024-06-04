package logic.component;

import logic.usage.FacingDirection;

public abstract class Item {
    private int x;
    private int y;

    /**
     * Initialize the item with the given x and y.
     * The facing direction is set to NONE.
     */
    public Item(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Handle the hit event when the item is hit by a human.
     */
    public abstract void hit(Human human);

    /**
     * Return the string representation of the item.
     */
    public abstract String toString();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
