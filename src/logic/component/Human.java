package logic.component;

import logic.usage.Directable;
import logic.usage.FacingDirection;
import logic.usage.Renderable;

public class Human implements Directable, Renderable {
    private String URL;
    private int x;
    private int y;
    private int index;
    private FacingDirection facingDirection;
    private boolean isAwake;

    /**
     * Initialize the human with the index.
     * Set the image URL based on the index.
     */
    public Human(int index) {
        setX(0);
        setY(0);
        setFacingDirection(FacingDirection.NONE);
        setAwake(false);
        setIndex(index);
    }

    /**
     * Move the human according to the facing direction.
     */
    public void move() {
        this.x += facingDirection.getXDir();
        this.y += facingDirection.getYDir();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public FacingDirection getFacingDirection() {
        return facingDirection;
    }

    @Override
    public void setFacingDirection(FacingDirection facingDirection) {
        if (facingDirection == FacingDirection.NONE)
            setURL("image/human-" + index + "-up.png");
        else
            setURL("image/human-" + index + "-" + facingDirection.toString() + ".png");
        this.facingDirection = facingDirection;
    }

    public boolean getAwake() {
        return isAwake;
    }

    public void setAwake(boolean isAwake) {
        this.isAwake = isAwake;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String getURL() {
        return URL;
    }

    @Override
    public void setURL(String URL) {
        this.URL = URL;
    }
}
