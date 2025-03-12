package com.sfuparkingmayhem.game;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

/**
 * This class extends Reward and contains a constructor, getImage() to get the png 
 * of this LostNote from resources directory, getters and setters to check if LostNote has
 * been collected, 
 * 
 * @author Group 25
 * @version 1.0
 */

public class LostNote extends Reward {
    /**
     * Constructs a LostNote object.
     *
     * @param x The x-coordinate of the LostNote.
     * @param y The y-coordinate of the LostNote.
     */
    LostNote(int x, int y) {
        super(x, y);
        getImage();
    }


    @Override
    protected void getImage() {
        try{
            this.theImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("lost_notes_resized.png")));
        }
        catch(IOException e){
            System.out.println("Error loading main" + e.getMessage());
        }
    }


    /**
     * Gets the collected status of the LostNote.
     * 
     * @return returns the collected status of the LostNote.
     */
    @Override
    protected boolean isCollected() {
        return collected;
    }


    /**
     * Sets the collected status of the LostNote.
     * @param bool The boolean value to set the collected status to.
     */
    public void setCollected(boolean bool){
        this.collected = bool;
    }

    /**
     * Generates the coordinates of the LostNote.
     */
    protected void generateCoords(){
        int a = 1;
        int b = 14;

        int randomNum = a + (int) Math.abs(Math.random() * (a - b));
        int randomNum2= a + (int) Math.abs(Math.random() * (a - b));

        this.x_coordinate = randomNum;
        this.y_coordinate = randomNum2;

        }
    }



