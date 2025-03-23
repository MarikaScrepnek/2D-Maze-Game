package com.sfuparkingmayhem.game;

import java.awt.event.KeyEvent;

/**
 * This MovingEntity class extends Entity class and contains the following
 * methods: a constructor to instantiate a MovingEntity, and a method to move the entity.
 * 
 * @author Group25
 * @version 1.0
 */
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
     * Moves the entity based on the given key event.
     *
     * @param event The key event that triggered the move.
     */
    protected abstract void KeyPressed(KeyEvent event);

}
