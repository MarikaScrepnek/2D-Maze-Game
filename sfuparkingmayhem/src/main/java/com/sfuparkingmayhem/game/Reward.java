package com.sfuparkingmayhem.game;
/**
 * This Reward class extends StaticEntity class and contains the following
 * methods: a constructor to instantiate a Reward, and a method to check if the Reward is collected.
 * 
 * @author Group25
 * @version 1.0
 */
public abstract class Reward extends StaticEntity {

    /**
     * Constructs a Reward object.
     *
     * @param x The x-coordinate of the Reward.
     * @param y The y-coordinate of the Reward.
     * @param board The board that the reward is on.
     */
    public Reward(int x, int y, Board board) {
        super(x, y, board);
    }
}
