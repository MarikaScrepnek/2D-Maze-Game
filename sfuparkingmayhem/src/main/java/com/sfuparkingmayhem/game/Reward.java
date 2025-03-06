package com.sfuparkingmayhem.game;

public abstract class Reward extends StaticEntity {

    private boolean isCollected = false;


    Reward(int x, int y) {
        super(x, y);
    }
}
