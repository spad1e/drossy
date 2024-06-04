package util;

import logic.component.*;
import logic.level.Level;
import logic.usage.FacingDirection;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

/**
 * A class providing File -> Level conversion utility.
 */
public class FileToLevel {
    /**
     * A function that convert level info from .txt file to Level class.
     * 
     * @see Level for more level information
     * @param inputStream An input stream that will be converted, the format of this file is as
     *             follows :
     *             first line: N -> number of items inside the level.
     *             the following N lines: x y type [human index] [facing direction]
     *             -> the x and y position of an object and type of object. Some
     *             objects may require [human index] or [facing direction].
     *             next line: M -> number of placeable arrows.
     *             the following M lines: facing direction -> the facing direction
     *             of each arrow.
     * @return Level object with the following properties
     */
    public static Level convert(InputStream inputStream) {
        try {
            Scanner scanner = new Scanner(inputStream);
            Level level = new Level();

            // create border walls
            for (int i = 0; i < Constant.BOARD_WIDTH; i++) {
                level.addItem(new Wall(i, 0));
                level.addItem(new Wall(i, Constant.BOARD_HEIGHT - 1));
            }
            for (int i = 1; i < Constant.BOARD_HEIGHT; i++) {
                level.addItem(new Wall(0, i));
                level.addItem(new Wall(Constant.BOARD_WIDTH - 1, i));
            }

            // add humans
            for (int i = 0; i < Constant.HUMAN_COUNT; i++) {
                level.addHuman(new Human(i));
            }

            // input immovable items
            // format: x y type [humanIndex] [facingDirection]
            int numberOfImmovableItems = scanner.nextInt();
            for (int i = 0; i < numberOfImmovableItems; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String type = scanner.next();
                // switch case for each types of items.
                if (type.equals("BED")) {
                    int index = scanner.nextInt();
                    level.addItem(new Bed(x, y, index));
                } else if (type.equals("SOURCE")) {
                    int index = scanner.nextInt();
                    FacingDirection facingDirection = FacingDirection.fromString(scanner.next());
                    Human human = level.getHumans().get(index);
                    level.addItem(new Source(x, y, facingDirection, index));
                    human.setX(x);
                    human.setY(y);
                    human.setFacingDirection(facingDirection);
                } else if (type.equals("STAR")) {
                    int index = scanner.nextInt();
                    level.addItem(new Star(x, y, index));
                } else if (type.equals("ARROW")) {
                    FacingDirection facingDirection = FacingDirection.fromString(scanner.next());
                    level.addItem(new Arrow(x, y, facingDirection));
                } else if (type.equals("WALL")) {
                    level.addItem(new Wall(x, y));
                }
            }

            // input placeable arrows
            // format: facingDirection
            int numberOfMovableItems = scanner.nextInt();
            for (int i = 0; i < numberOfMovableItems; i++) {
                FacingDirection facingDirection = FacingDirection.fromString(scanner.next());
                level.addPlaceableArrow(new Arrow(0, 0, facingDirection));
            }
            return level;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
