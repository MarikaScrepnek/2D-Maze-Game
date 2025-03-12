package com.sfuparkingmayhem.game;


/**
 * This class extends {@link Entity} class
 * 
 * @author Group 25
 * @version 1.0
 */
public class StaticEntity extends Entity{

    /**
     * Constructs a StaticEntity object.
     *
     * @param x The x-coordinate of the StaticEntity.
     * @param y The y-coordinate of the StaticEntity.
     */
    public StaticEntity(int x, int y) {
        super(x,y);
    }

    @Override
    protected void getImage() {
        System.out.println("test");
    }
}
