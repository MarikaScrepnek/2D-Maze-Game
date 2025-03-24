package com.sfuparkingmayhem.game;

/**
 * This class extends the Reward class. This coin will have an x and y coordinate to be placed on the board. 
 * This class has a getImage() to get the png sprite from resources directory and isCollected() to check if this
 * coin has been collected.
 * 
 * @author Group 25
 * @version 1.0
 */
public class Coin extends Reward{

    /**
     * Constructs a Coin object.
     *
     * @param x The x-coordinate of the Coin.
     * @param y The y-coordinate of the Coin.
     */
    public Coin(int x, int y, Board board) {
        super(x, y, board);
        getImage("coin.png");
    }
}