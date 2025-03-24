package com.sfuparkingmayhem.game;

/**
 * This class extends Reward class and contains a constructor, getImage method to get the png 
 * of this LostNote from resources directory, and method to randomly generate X and Y coordinates
 * for this LostNote
 * 
 * @author Group 25
 * @version 1.0
 */

public class LostNote extends Reward {

    /**
     * Constructs a LostNote object using the X and Y coordinates and getImage method
     *
     * @param x The x-coordinate of the LostNote.
     * @param y The y-coordinate of the LostNote.
     */
    public LostNote(int x, int y) {
        super(x, y);
        getImage("lost_notes_resized.png");
    }

    /**
     * Generates random X and Y coordinates for this LostNote.
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



