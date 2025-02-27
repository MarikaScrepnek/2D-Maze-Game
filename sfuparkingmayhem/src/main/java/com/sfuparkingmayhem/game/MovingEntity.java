package com.sfuparkingmayhem.game;

import java.awt.event.KeyEvent;

public abstract class MovingEntity extends Entity {
    /**
     * Constructs a MovingEntity with the specified coordinates.
     *
     * @param x_coordinate The initial x-coordinate.
     * @param y_coordinate The initial y-coordinate.
     */
    public MovingEntity(int x_coordinate, int y_coordinate) {
        super(x_coordinate, y_coordinate);
    }

    /**
     * Moves the entity.
     */
    protected abstract void move(KeyEvent event);

}
