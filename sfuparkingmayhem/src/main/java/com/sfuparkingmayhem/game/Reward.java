package com.sfuparkingmayhem.game;

public abstract class Reward extends StaticEntity {

    private boolean isCollected = false;
    private int value;


    Reward(int x, int y) {
        super(x, y);
    }
}
