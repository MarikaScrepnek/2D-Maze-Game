package com.sfuparkingmayhem.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {
    private final int rows = 15;
    private final int columns = 15;
    private final int cell_size = 50;
    private final int[][] board = new int[rows][columns];
    public Board() {
        //set game board size to be the same as the window size
        setPreferredSize(new Dimension(cell_size*columns,cell_size*rows));
        //set the background color to a concrete grey
        setBackground(new Color(153, 153, 153));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawCells(g);
        //drawScore(g);
        //implement draw coing
        //player.draw(g, this);

    }
    private void drawCells(Graphics g) {
        g.setColor(new Color(0, 128, 0));
        for (int row = 0; row < rows + 1; row++) {
            g.fillRect(row*cell_size, cell_size, cell_size, cell_size);
        }
        g.setColor(new Color(214, 214, 214));
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                // only color every other tile
                if ((row + col) % 2 == 1) {
                    // draw a square tile at the current row/column position
                    g.fillRect(
                        col * cell_size, 
                        row * cell_size, 
                        cell_size, 
                        cell_size
                    );
                }
            }
        }
    }
}