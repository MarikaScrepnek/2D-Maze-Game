package com.sfuparkingmayhem.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Timer;

/**
 * Class for the timer in the game that counts up while the player plays
 * and displays when they win.
 */
public class GameTimer {
    private int timeElapsed;

    /**
     * Initializes the game timer and starts the time.
     * Calls repaint every second to update the game ui.
     * 
     * @param board The board that the timer is on.
     */
    public GameTimer (Board board) {
        Timer gameTimer = new Timer(1000, e -> {
            timeElapsed++;
            board.repaint();
        });
        gameTimer.start();
    }

    /**
     * Draws the timer on the game board.
     * 
     * @param g Graphics object
     */
    public void draw(Graphics g) {
        int minutes = timeElapsed / 60;
        int seconds = timeElapsed % 60;

        g.setFont(new Font("Bahnschrift", Font.BOLD, 25));
        g.setColor(Color.WHITE);

        String timeString = String.format("%02d:%02d", minutes, seconds);

        g.drawString(timeString, 343, 30);
    }

    /**
     * Returns the time elapsed of the game timer.
     * 
     * @return timeElapsed Time elapsed of the game timer.
     */
    public int getTimeElapsed() {
        return timeElapsed;
    }
}
