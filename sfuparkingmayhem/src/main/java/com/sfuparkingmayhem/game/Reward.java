package com.sfuparkingmayhem.game;

public abstract class Reward extends StaticEntity {

    protected boolean collected = false;

    /**
     * Constructs a Reward object.
     *
     * @param x The x-coordinate of the Reward.
     * @param y The y-coordinate of the Reward.
     */
    Reward(int x, int y) {
        super(x, y);
    }

    /**
     * Returns the value of the Reward.
     *
     * @return The value of the Reward.
     */
    protected abstract boolean isCollected();

}
