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
     * Moves the MainCharacter in the direction of the key pressed on the keyboard.
     * If the key pressed is W, the MainCharacter moves up.
     * If the key pressed is A, the MainCharacter moves left.
     * If the key pressed is S, the MainCharacter moves down.
     * If the key pressed is D, the MainCharacter moves right.
     *
     * @param event KeyEvent object that represents the key pressed on the keyboard
     */
    protected void KeyPressed (KeyEvent event){

        /**
         * gets the current time in milliseconds
         */
        long currTime = System.currentTimeMillis();

        //find the time difference from current time and time since the last action/move was made.
        //if difference is less than the delay, no action should be allowed for this Main Character
        // if ((currTime - prevMoveTime) < delay){
        //     return;
        // }
        if (checkDifferenceInTime(currTime, prevMoveTime, delay) == false){
            return;
        }
        

        //get key code for the specific key that was pressed on keyboard
        int keyCode = event.getKeyCode();

        switch (keyCode){
            case KeyEvent.VK_W:
                y_coordinate = y_coordinate - 1;
                //load up orientation sprite
                try{
                    this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("main_character_north.png"));
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
                break;

            case KeyEvent.VK_A:
                x_coordinate = x_coordinate - 1;
                //load up orientation sprite
                try{
                    this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("main_character_west.png"));
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }    
                break;
                

            case KeyEvent.VK_S:
                y_coordinate = y_coordinate + 1;
                //load up orientation sprite
                try{
                    this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("main_character_south.png"));
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }      
                break;

            case KeyEvent.VK_D:
                x_coordinate = x_coordinate + 1;
                //load up orientation sprite
                try{
                    this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("main_character_east.png"));
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }      
                break;
            

        }
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
