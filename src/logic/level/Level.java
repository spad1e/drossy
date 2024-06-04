package logic.level;

import logic.component.*;

import java.util.ArrayList;

public class Level {
    private ArrayList<Item> items;
    private ArrayList<Arrow> placeableArrow;
    private ArrayList<Human> humans;

    public Level() {
        items = new ArrayList<>();
        placeableArrow = new ArrayList<>();
        humans = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addPlaceableArrow(Arrow arrow) {
        placeableArrow.add(arrow);
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Arrow> getPlaceableArrow() {
        return placeableArrow;
    }

    public ArrayList<Human> getHumans() {
        return humans;
    }
}
