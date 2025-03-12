package com.sfuparkingmayhem.game;


/**
 * This main class instantiates a new {@link Game} and uses the initWindow() method
 * to run the game.
 * 
 * @author Group 25
 * @version 1.0
 */
public class Main {

    /**
     * Runs a new {@link Game} and uses initWindow() method
     * 
     * @param args
     */
    public static void main( String[] args ) {
        Game game = new Game();
        game.initWindow();
    }
}