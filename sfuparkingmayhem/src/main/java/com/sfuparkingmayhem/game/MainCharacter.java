package com.sfuparkingmayhem.game;

import java.awt.event.KeyEvent;
import java.util.Iterator;

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
     * Feild holding if the key action has been performed already.
     */
    private boolean key_pressed;

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
     * Moves the MainCharacter in the direction of the key pressed on the keyboard.
     * @param e
     */
    private void changeImageDirection(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                y_coordinate = y_coordinate - 1;
                getImage("main_character_north.png");
            }
            case KeyEvent.VK_A -> {
                x_coordinate = x_coordinate - 1;
                getImage("main_character_west.png");
            }
            case KeyEvent.VK_S -> {
                y_coordinate = y_coordinate + 1;
                getImage("main_character_south.png");
            }
            case KeyEvent.VK_D -> {
                x_coordinate = x_coordinate + 1;
                getImage("main_character_east.png");
            }
            default -> {
            }
        }
    }

    /**
     * Makes sure you cant hold down move key.
     * 
     * @param e The event of the key press.
     */
    @Override
    public void delayedMove(KeyEvent event) {
        if (key_pressed) {
            return; // Ignore if key is still held down
        }
        key_pressed = true; // Mark key as pressed
        
        int oldX = getX_coordinate();
        int oldY = getY_coordinate();

        //Prevent movement out of the entrance cell
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
        changeImageDirection(event);
        checkCollision(oldX, oldY);
    }

    private void checkCollision(int oldX, int oldY){
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
     * Resets key_pressed flag when a key is released.
     */
    public void keyReleased(KeyEvent e) {
        key_pressed = false; // Allow movement again when the key is released
    }

    private void limitPlayerCoord() {
        if (x_coordinate < 0) {
            x_coordinate = 0;
        } else if (x_coordinate >= Board.COLUMNS) {
            x_coordinate = Board.COLUMNS - 1;
        }
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

        limitPlayerCoord();

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

    /**
     * Removes a coin from coins ArrayList if this MainCharacter's board position matches
     * a coin's board position. Must create a copy of coins ArrayList to prevent iterating
     * and removing (deleting) from same ArrayList, which is not allowed.
     */
    protected void collectCoins(){
        Iterator<Coin> coinIterator = board.coins.iterator();
    
        while (coinIterator.hasNext()) {
            Coin aCoin = coinIterator.next();
            
            if (board.main_character.getX_coordinate() == aCoin.getX_coordinate()
                    && board.main_character.getY_coordinate() == aCoin.getY_coordinate()) {
                
                coinIterator.remove();
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
        Iterator<LostNote> iterator = board.ln.iterator();

        while (iterator.hasNext()) {
            LostNote aLostNote = iterator.next();
            if (getX_coordinate() == aLostNote.getX_coordinate()
                    && getY_coordinate() == aLostNote.getY_coordinate()) {
                iterator.remove();
                board.score.addPoints(10);
            }
        }
    }
}
