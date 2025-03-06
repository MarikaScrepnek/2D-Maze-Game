package com.sfuparkingmayhem.game;

public class LostNote extends Reward {

    private int value = 10;
    private int expiryTime = 5; //put 5 seconds as the time limit

    LostNote(int x, int y) {
        super(x, y);
    }


}
