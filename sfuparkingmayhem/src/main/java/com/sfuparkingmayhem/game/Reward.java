package com.sfuparkingmayhem.game;

public abstract class Reward extends StaticEntity {

    private boolean collected = false;
    private int value;


    Reward(int x, int y) {
        super(x, y);
    }

    protected boolean isCollected() {
        return collected;
    }

}
