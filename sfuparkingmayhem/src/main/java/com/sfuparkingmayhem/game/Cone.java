package com.sfuparkingmayhem.game;

/**
 * A cone barrier that acts as an obstacle in the game.
 */
public class Cone extends Barrier{
    /**
     * Constructs a Cone at the specified coordinates.
     * It is a Barrier that the MainCharacter cannot pass through.
     *
     * @param x The x-coordinate of the Cone.
     * @param y The y-coordinate of the Cone.
     */
    public Cone (int x, int y, Board board){
        super(x, y, board);
        getImage("cone.png");
    }
}
