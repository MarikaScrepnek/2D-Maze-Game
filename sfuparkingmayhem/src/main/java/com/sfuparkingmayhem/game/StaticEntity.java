package com.sfuparkingmayhem.game;

public class StaticEntity extends Entity{

    StaticEntity(int x, int y) {
        super(x,y);
    }

    @Override
    protected void getImage() {
        System.out.println("test");
    }
}
