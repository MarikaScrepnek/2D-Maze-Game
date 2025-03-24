package com.sfuparkingmayhem.game;


/**
 * This class extends {@link Entity} class, and this class contains a constructor
 * and a getImage method to retrieve the png from resources directory
 * 
 * @author Group 25
 * @version 1.0
 */
public class StaticEntity extends Entity{

    /**
     * Constructs a StaticEntity object using the x-coordinate
     * and y-coordinates as parameters
     *
     * @param x The x-coordinate of the StaticEntity.
     * @param y The y-coordinate of the StaticEntity.
     */
    public StaticEntity(int x, int y) {
        super(x,y);
    }
}
