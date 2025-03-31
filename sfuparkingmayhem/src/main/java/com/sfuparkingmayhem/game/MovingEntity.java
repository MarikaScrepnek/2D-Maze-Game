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
     * @param board The board that the moving enitity is on
     */
    public MovingEntity(int x_coordinate, int y_coordinate, Board board) {
        super(x_coordinate, y_coordinate, board);
    }

    /**
     * Checks if the player is colliding with a cone.
     * @param x x-coordinate of the player.
     * @param y y-coordinate of the player.
     * @return true if the player is colliding with a cone, false otherwise.
     */
    protected boolean isCollidingWithCone(int x, int y) {
        for (Cone cone : board.entityLists.cones) {
            if (cone.getX_coordinate() == x && cone.getY_coordinate() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the player is colliding with a parked car.
     * @param x x-coordinate of the player.
     * @param y y-coordinate of the player.
     * @return true if the player is colliding with a parked car, false otherwise.
     */
    protected boolean isCollidingWithParkedCar(int x, int y) {
        for (ParkedCar parkedCar : board.entityLists.parkedCars) {
            if (parkedCar.getX_coordinate() == x && parkedCar.getY_coordinate() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Moves the entity based on the given key event.
     *
     * @param event The key event that triggered the move.
     */
    protected abstract void delayedMove(KeyEvent event);

}