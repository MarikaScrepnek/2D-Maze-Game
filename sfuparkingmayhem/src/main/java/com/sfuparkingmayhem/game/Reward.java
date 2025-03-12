package com.sfuparkingmayhem.game;
/**
 * This Reward class extends StaticEntity class and contains the following
 * methods: a constructor to instantiate a Reward, and a method to check if the Reward is collected.
 * 
 * @author Group25
 * @version 1.0
 */
public abstract class Reward extends StaticEntity {

    protected boolean collected = false;

    /**
     * Constructs a Reward object.
     *
     * @param x The x-coordinate of the Reward.
     * @param y The y-coordinate of the Reward.
     */
    public Reward(int x, int y) {
        super(x, y);
    }

    /**
     * Returns if the Reward has been collected.
     *
     * @return The value of the Reward.
     */
    protected abstract boolean isCollected();

}
