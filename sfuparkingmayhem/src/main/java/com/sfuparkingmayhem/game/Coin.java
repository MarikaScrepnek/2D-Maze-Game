package com.sfuparkingmayhem.game;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Coin extends Reward{

    /**
     * Constructs a Coin object.
     *
     * @param x The x-coordinate of the Coin.
     * @param y The y-coordinate of the Coin.
     */
    Coin(int x, int y) {
        super(x, y);
        getImage();
    }

    @Override
    protected void getImage() {
        try{
            this.theImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("coin.png")));
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
