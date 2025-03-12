package com.sfuparkingmayhem.game;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;


/**
 * This class extends the Reward class. This coin will have an x and y coordinate to be placed on the board. 
 * This class has a getImage() to get the png sprite from resources directory and isCollected() to check if this
 * coin has been collected.
 * 
 * @author Group 25
 * @version 1.0
 */
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
