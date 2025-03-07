package com.sfuparkingmayhem.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Objects;

public class Coin extends Reward{

    private int value = 5;

    Coin(int x, int y) {
        super(x, y);
        getImage();
    }

    @Override
    protected void getImage() {
        try{
            this.theImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("coin_resized.png")));
        }
        catch(IOException e){
            System.out.println("Error loading main" + e.getMessage());
        }
    }

    @Override
    protected boolean isCollected() {
        return collected;
    }

}
