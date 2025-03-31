package com.sfuparkingmayhem.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class extends StaticEntity class and contains a constructor
 * for a Barrier object.
 * 
 * @author Group 25
 * @version 1.0
 */

public class Barrier extends StaticEntity{
    /**
     * Constructs a Barrier object using the x-coordinate and y-coordinate
     * as parameters
     *
     * @param x The x-coordinate of the Barrier.
     * @param y The y-coordinate of the Barrier.
     * @param board The board that the Barrier is on.
     */
    public Barrier(int x, int y, Board board) {
        super(x, y, board);
        getImage("bush.png");
    }

    /**
     * Method that draws the barriers/borders on the board.
     * 
     * @param ROWS
     * @param COLUMNS
     * @param CELL_SIZE
     * @param g
     */
    public void draw (int ROWS, int COLUMNS, int CELL_SIZE, Graphics g) {
        //top
        for (int col = 0; col < COLUMNS; col++) {
            g.drawImage(this.theImage, col * CELL_SIZE, 0, 50, 50, null);
        }

        // Bottom border
        for (int col = 0; col < COLUMNS; col++) {
            g.drawImage(this.theImage, col * CELL_SIZE, (ROWS - 1) * CELL_SIZE, 50, 50, null);
        }

        // Left border
        for (int row = 0; row < ROWS; row++) {
            g.drawImage(this.theImage, 0, row * CELL_SIZE, 50, 50, null);
        }

        // Right border
        for (int row = 0; row < ROWS; row++) {
            g.drawImage(this.theImage, (COLUMNS - 1) * CELL_SIZE, row * CELL_SIZE, 50, 50, null);
        }

        //draw entrance
        g.setColor(new Color(43, 43, 43));
        g.fillRect(0, CELL_SIZE, CELL_SIZE, CELL_SIZE);
        g.fillRect((COLUMNS - 1) * CELL_SIZE, (ROWS - 2) * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
}
