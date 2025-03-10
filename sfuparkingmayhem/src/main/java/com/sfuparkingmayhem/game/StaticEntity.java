package com.sfuparkingmayhem.game;

public class StaticEntity extends Entity{

    /**
     * Constructs a StaticEntity object.
     *
     * @param x The x-coordinate of the StaticEntity.
     * @param y The y-coordinate of the StaticEntity.
     */
    StaticEntity(int x, int y) {
        super(x,y);
    }

    @Override
    protected void getImage() {
        System.out.println("test");
    }
}
