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
     * Constructs this MainCharacter and sets this MainCharacter's image
     *
     * @param x_coordinate x-coordinate where MainCharcter is on board
     * @param y_coordinate y-coordinate where MainCharcter is on board
     */
    MainCharacter(int x_coordinate, int y_coordinate) {
        super( x_coordinate, y_coordinate);
        //setImage();
        getImage();
    }

    /**
     * Gets the image of the MainCharacter and catches IOExceptions, if any. and prints out the error.
     * Sets theImage of MainCharacter to a picture of car facing right, initially (start of game).
     */
    @Override
    protected void getImage(){
        try{
            this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Blue_CIVIC_EAST.png"));
        }
        catch(IOException e){
            System.out.println("Error loading main" + e.getMessage());
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

        //get key code for the specific key that was pressed on keyboard
        int keyCode = event.getKeyCode();

        //moving up with W key
        if(keyCode == KeyEvent.VK_W){
            y_coordinate = y_coordinate - 1;
            //load up orientation sprite
            try{
                this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Blue_CIVIC_NORTH.png"));
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

        //moving left with A key
        else if (keyCode == KeyEvent.VK_A){
            x_coordinate = x_coordinate - 1;
            //load left orientation sprite
            try{
                this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Blue_CIVIC_WEST.png"));
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

        //moving down with S key
        else if (keyCode == KeyEvent.VK_S){
            y_coordinate = y_coordinate + 1;
            //load down orientation sprite
            try{
                this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Blue_CIVIC_SOUTH.png"));
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

        //moving right with D key
        else if (keyCode == KeyEvent.VK_D){
            x_coordinate = x_coordinate + 1;
            //load right orientation sprite
            try{
                this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Blue_CIVIC_EAST.png"));
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

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
        // Entrance: (0, 1)
        // Exit: (COLUMNS - 1, ROWS - 2)
        if ((x_coordinate == 0 && y_coordinate == 1) || (x_coordinate == Board.COLUMNS - 1 && y_coordinate == Board.ROWS - 2)) {
            // Do nothing, allow the player to stay in these cells
        } else {
            // Prevent the player from moving into the green borders
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
