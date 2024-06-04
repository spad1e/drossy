package logic.component;

import logic.usage.Renderable;

public class Star extends Item implements Renderable {
    private String URL;
    private int index;
    private boolean collected;

    public Star(int x, int y, int index) {
        super(x, y);
        setIndex(index);
        setCollected(false);
        setURL("image/star-" + getIndex() + ".png");
    }

    /**
     * If the human is not the same as the star, wake the human up.
     * Otherwise, set the star as collected.
     */
    @Override
    public void hit(Human human) {
        if (isCollected()) {
            return;
        }
        if (human.getIndex() != getIndex()) {
            human.setAwake(true);
        } else {
            setCollected(true);
            setURL("image/star-collected.png");
        }
    }

    @Override
    public String toString() {
        return "Star";
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(Boolean collected) {
        this.collected = collected;
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
