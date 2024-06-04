package logic.component;

import logic.usage.Directable;
import logic.usage.FacingDirection;

public class Source extends Item implements Directable {
    private FacingDirection facingDirection;
    private int index;

    public Source(int x, int y, FacingDirection facingDirection, int index) {
        super(x, y);
        setFacingDirection(facingDirection);
        setIndex(index);
    }

    @Override
    public void hit(Human human) {
        // do nothing
    }

    @Override
    public String toString() {
        return "Source";
    }

    @Override
    public FacingDirection getFacingDirection() {
        return facingDirection;
    }

    @Override
    public void setFacingDirection(FacingDirection facingDirection) {
        this.facingDirection = facingDirection;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
