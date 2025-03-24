package com.sfuparkingmayhem.game;

import java.awt.event.KeyEvent;

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
    public MainCharacter(int x_coordinate, int y_coordinate, Board board) {
        super( x_coordinate, y_coordinate, board);
        getImage("main_character_east.png");
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
    protected void delayedMove (KeyEvent event){

        /**
         * gets the current time in milliseconds
         */
        long currTime = getCurrentTimeMilliseconds();

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
     * prevents the player from moving off the board horizontally
     */
    private void limitPlayerXCoord (){
        if (x_coordinate < 0) {
            x_coordinate = 0;
        } else if (x_coordinate >= Board.COLUMNS) {
            x_coordinate = Board.COLUMNS - 1;
        }
    }

    // Prevent the player from moving off the board vertically
    private void limitPlayerYCoord(){
        if (y_coordinate < 0) {
            y_coordinate = 0;
        } else if (y_coordinate >= Board.ROWS) {
            y_coordinate = Board.ROWS - 1;
        }

    }

    /**
     * Tick the character to ensure it stays within the bounds of the board.
     */
    protected void tick() {
        limitPlayerXCoord();
        limitPlayerYCoord();

        // Allow the player to move into the entrance and exit cells
        if ((x_coordinate == 0 && y_coordinate == 1) || (x_coordinate == Board.COLUMNS - 1 && y_coordinate == Board.ROWS - 2)) {
            // Do nothing, allow the player to stay in these cells
        } else {
            // Prevent the player from moving into the green bushes horizontally
            if (x_coordinate == 0 || x_coordinate == Board.COLUMNS - 1){
                 // Revert to the previous valid position
                 if (x_coordinate == 0) {
                    x_coordinate = 1;
                } else if (x_coordinate == Board.COLUMNS - 1) {
                    x_coordinate = Board.COLUMNS - 2;
                }
            }

            // Prevent the player from moving into the green bushes vertically
            if (y_coordinate == 0 || y_coordinate == Board.ROWS - 1){
                if (y_coordinate == 0) {
                    y_coordinate = 1;
                } else if (y_coordinate == Board.ROWS - 1) {
                    y_coordinate = Board.ROWS - 2;
                }
            }
        }
    }

    //move main_character when a key is pressed
    public void move(KeyEvent e) {
        int oldX = getX_coordinate();
        int oldY = getY_coordinate();
        delayedMove(e);

        // Check if the player is colliding with a cone
        if (isCollidingWithCone(getX_coordinate(), getY_coordinate())) {
            // revert the player position
            x_coordinate = oldX;
            y_coordinate  = oldY;
        }

        // Check if the player is colliding with a parked car
        if(isCollidingWithParkedCar(getX_coordinate(), getY_coordinate())){
            // Subtract points from the player's score
            if(oldX != getX_coordinate() || oldY != getY_coordinate()){
                board.score.subtractPoints(5);
                board.flashRed();
                if(board.score.getScore() < 0 && board.game_ended == false){
                    board.game_ended=true;
                    board.cardLayout.show(board.cardPanel, "Lose Screen Score");
                }
            }

            // revert the player position
            x_coordinate = oldX;
            y_coordinate = oldY;
        }
    }

    /**
     * Removes a coin from coins ArrayList if this MainCharacter's board position matches
     * a coin's board position. Must create a copy of coins ArrayList to prevent iterating
     * and removing (deleting) from same ArrayList, which is not allowed.
     */
    protected void collectCoins(){
        for (Coin aCoin : board.coins){
            
            //remove the coin from arraylist if this coin and MainCharacter have same board position
            if (board.main_character.getX_coordinate() == aCoin.getX_coordinate()
                    && board.main_character.getY_coordinate() == aCoin.getY_coordinate()){

                board.coins.remove(aCoin);
                board.score.addPoints(5);
                board.updateCoinsCollectedCount();
            }
        }
    }

    /**
     * Removes a lostNote from ln ArrayList if this MainCharacter's board position matches
     * a lostNote's board position. Must create a copy of ln ArrayList to prevent iterating
     * and removing (deleting) from same ArrayList, which is not allowed.
     */
    protected void collectLostNote(){
        for (LostNote aLostNote : board.ln){
            if (getX_coordinate() == aLostNote.getX_coordinate()
                    && getY_coordinate() == aLostNote.getY_coordinate()){
                board.ln.remove(aLostNote);
                board.score.addPoints(10);
            }
        }
    }
}
