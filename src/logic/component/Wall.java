package logic.component;

import logic.usage.Renderable;

public class Wall extends Item implements Renderable {
    private String URL;

    public Wall(int x, int y) {
        super(x, y);
        setURL("image/wall.png");
    }

    /**
     * Stop the human from moving, and wake the human up.
     */
    @Override
    public void hit(Human human) {
        human.setAwake(true);
    }

    @Override
    public String toString() {
        return "Wall";
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
