package com.sfuparkingmayhem.game;

public abstract class Reward extends StaticEntity {

    protected boolean collected = false;
    private int value;


    Reward(int x, int y) {
        super(x, y);
    }

    protected abstract boolean isCollected();

}
