package logic.component;

import logic.usage.Directable;
import logic.usage.FacingDirection;
import logic.usage.Renderable;

public class Arrow extends Item implements Directable, Renderable {
    private FacingDirection facingDirection;
    private String URL;

    public Arrow(int x, int y, FacingDirection facingDirection) {
        super(x, y);
        setFacingDirection(facingDirection);
        setURL("image/" + facingDirection.toString() + "-arrow.png");
    }

    /**
     * Change the facing direction of the human to the facing direction of the
     * arrow.
     */
    @Override
    public void hit(Human human) {
        human.setFacingDirection(getFacingDirection());
    }

    @Override
    public String toString() {
        return "Arrow";
    }

    @Override
    public FacingDirection getFacingDirection() {
        return facingDirection;
    }

    @Override
    public void setFacingDirection(FacingDirection facingDirection) {
        this.facingDirection = facingDirection;
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