package com.sfuparkingmayhem.game;

import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This MainCharacter class extends MovingEntity class and contains the following
 * methods: a constructor to instantiate a MainCharacter, a method to get the image of this MainCharacter, and a move
 * method allowing this MainCharacter to move Left,Right,Up,and Down on game board.
 *
 * @author Group25
 * @version 1.0
 */
public class MainCharacter extends MovingEntity {

    /**
     * track the time of the most recent move made by this Main Character
     */
    private long prevMoveTime = 0;

    /**
     * gives a delay for this main character's movement. Prevents this main character from moving too fast
     * if a valid movement key is held on keyboard.
     */
    private static final long delay = 250;

    /**
     * Constructs this MainCharacter and sets this MainCharacter's image
     *
     * @param x_coordinate x-coordinate where MainCharcter is on board
     * @param y_coordinate y-coordinate where MainCharcter is on board
     */
    public MainCharacter(int x_coordinate, int y_coordinate) {
        super( x_coordinate, y_coordinate);
        //setImage();
        getImage();
    }


    @Override
    protected void getImage(){
        try{
            this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("main_character_east.png"));
        }
        catch(IOException e){
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    /**
     * loads the image for this main character on game board using the parameter s to indicate which png
     * should be loaded.
     * 
     * @param s path of the image/png for this main character
     * @throws e an IOException with a message if an image was unable to be loaded correctly
     */
    protected void getImage(String s){
        try{
            this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(s));
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * checks the difference between a previous time stamp and the current time stamp. If the difference
     * betweent the timess are less than the delay value, return false. Otherwise, return true. 
     * 
     * @param currentTime gets a long value that represents the current time in milliseconds
     * @param previousTime takes in a long value that represents the time since last move was made by this main character
     * @return
     */
    private boolean checkDifferenceInTime(long currentTime, long previousTime, long delay){
        //find the time difference from current time and time since the last action/move was made.
        //if difference is less than the delay, no action should be allowed for this Main Character
        if ((currentTime - previousTime) < delay){
            return false;
        }
        return true;
    }


    /**
     * returns the current time in milliseconds using System.currentTimeMillis() method. 
     * 
     * @return current time, in milliseconds
     */
    private long getCurrentTimeMilliseconds (){
        return System.currentTimeMillis();
    }


    /**
     * decrements this main character's y_coordinate on board and loads north facing png onto board
     * 
     * @param e a Keyevent that will be checked if it corresponds to the W key being pressed by user
     */
    private void eventMoveUp(KeyEvent e){
        
        if (e.getKeyCode() == KeyEvent.VK_W ){
            y_coordinate = y_coordinate - 1;

            //load up orientation sprite
            getImage("main_character_north.png");
        }
    }


    /**
     * decrements this main character's x_coordinate on board and loads west facing png onto board
     * 
     * @param e a Keyevent that will be checked if it corresponds to the A key being pressed by user
     */
    private void eventMoveLeft(KeyEvent e){
        
        if (e.getKeyCode() == KeyEvent.VK_A ){
            x_coordinate = x_coordinate - 1;

            //load up orientation sprite
            getImage("main_character_west.png");
        }
    }


    /**
     * increments this main character's y_coordinate on board and loads south facing png onto board
     * 
     * @param e a Keyevent that will be checked if it corresponds to the S key being pressed by user
     */
    private void eventMoveDown(KeyEvent e){
        
        if (e.getKeyCode() == KeyEvent.VK_S ){
            y_coordinate = y_coordinate + 1;

            //load up orientation sprite
            getImage("main_character_south.png");  
        }
    }


    /**
     * increments this main character's x_coordinate on board and loads east facing png onto board
     * 
     * @param e a Keyevent that will be checked if it corresponds to the D key being pressed by user
     */
    private void eventMoveRight(KeyEvent e){
        
        if (e.getKeyCode() == KeyEvent.VK_D ){
            x_coordinate = x_coordinate + 1;

            //load up orientation sprite
            getImage("main_character_east.png");
        }
    }



   
    /**
     * Moves the MainCharacter in the direction of the key pressed on the keyboard.
     * If the key pressed is W, the MainCharacter moves up.
     * If the key pressed is A, the MainCharacter moves left.
     * If the key pressed is S, the MainCharacter moves down.
     * If the key pressed is D, the MainCharacter moves right.
     *
     * @param event KeyEvent object that represents the key pressed on the keyboard
     */
    protected void move (KeyEvent event){

        /**
         * gets the current time in milliseconds
         */
        long currTime = getCurrentTimeMilliseconds();//System.currentTimeMillis();

        //find the time difference from current time and time since the last action/move was made.
        if (checkDifferenceInTime(currTime, prevMoveTime, delay) == false){
            return;
        }

        // Prevent movement out of the entrance cell
        if (x_coordinate == 0 && y_coordinate == 1) {
            if (event.getKeyCode() == KeyEvent.VK_W || event.getKeyCode() == KeyEvent.VK_S) {
                return;
            }
        }

        // Prevent movement out of the exit cell
        if (x_coordinate == 14 && y_coordinate == 13) {
            if (event.getKeyCode() == KeyEvent.VK_W || event.getKeyCode() == KeyEvent.VK_S) {
                return;
            }
        }        
        
        eventMoveUp(event);
        eventMoveLeft(event);
        eventMoveDown(event);
        eventMoveRight(event);

        //update the prevMoveTime variable to current time (in milliseconds)
        prevMoveTime = currTime;

    }

    /**
     * Tick the character to ensure it stays within the bounds of the board.
     */
    protected void tickCharacter() {
        // Prevent the player from moving off the board horizontally
        if (x_coordinate < 0) {
            x_coordinate = 0;
        } else if (x_coordinate >= Board.COLUMNS) {
            x_coordinate = Board.COLUMNS - 1;
        }

        // Prevent the player from moving off the board vertically
        if (y_coordinate < 0) {
            y_coordinate = 0;
        } else if (y_coordinate >= Board.ROWS) {
            y_coordinate = Board.ROWS - 1;
        }

        // Allow the player to move into the entrance and exit cells
        if ((x_coordinate == 0 && y_coordinate == 1) || (x_coordinate == Board.COLUMNS - 1 && y_coordinate == Board.ROWS - 2)) {
            // Do nothing, allow the player to stay in these cells
        } else {
            // Prevent the player from moving into the green bushes
            if (x_coordinate == 0 || x_coordinate == Board.COLUMNS - 1 || y_coordinate == 0 || y_coordinate == Board.ROWS - 1) {
                // Revert to the previous valid position
                if (x_coordinate == 0) {
                    x_coordinate = 1;
                } else if (x_coordinate == Board.COLUMNS - 1) {
                    x_coordinate = Board.COLUMNS - 2;
                }
                if (y_coordinate == 0) {
                    y_coordinate = 1;
                } else if (y_coordinate == Board.ROWS - 1) {
                    y_coordinate = Board.ROWS - 2;
                }
            }
        }
    }

    /**
     * Gets the x-coordinate of this MainCharacter
     *
     * @return x-coordinate of this MainCharacter as an int
     */
    public int getMainCharacterXCoordinate(){
        return x_coordinate;
    }

    /**
     * Gets the y-coordinate of this MainCharacter
     *
     * @return y-coordinate of this MainCharacter as an int
     */
    public int getMainCharacterYCoordinate(){
        return y_coordinate;
    }

}
