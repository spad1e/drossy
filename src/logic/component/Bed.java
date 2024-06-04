package logic.component;

import logic.usage.FacingDirection;
import logic.usage.Renderable;

public class Bed extends Item implements Renderable {
    private String URL;
    private int index;

    /**
     * Constructor.
     * Set the image URL based on the index.
     */
    public Bed(int x, int y, int index) {
        super(x, y);
        setIndex(index);
        setURL("image/bed-" + index + ".png");
    }

    /**
     * Stop the human from moving.
     * If the human is not the same as the bed, wake the human up.
     */
    @Override
    public void hit(Human human) {
        human.setFacingDirection(FacingDirection.NONE);
        if (human.getIndex() != getIndex()) {
            human.setAwake(true);
        }
    }

    @Override
    public String toString() {
        return "Bed";
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
