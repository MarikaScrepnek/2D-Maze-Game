package com.sfuparkingmayhem.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel{
    protected static final int rows = 15;
    protected static final int columns = 15;
    protected static final int cell_size = 50;
    protected static final int[][] board = new int[rows][columns];
    protected static final int num_coins = 10;

    private final MainCharacter main_character;
    //private final Coin[] coins = new Coin[num_coins];
    //private Timer timer;
    //private Score score;

    private final int DELAY = 25;

    public Board() {
        //set game board size
        setPreferredSize(new Dimension(cell_size*columns,cell_size*rows));
        //set the background color to a concrete grey
        setBackground(new Color(153, 153, 153));
        //intialize player
        main_character = new MainCharacter(cell_size, cell_size);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBoard(g);
        main_character.drawTheImage(g, this);
        //implement draw coins
        //drawScore(g);

    }
    private void drawBoard(Graphics g) {
        //draw checkered cells
        g.setColor(new Color(214, 214, 214));
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                //only color every other tile
                if ((row + col) % 2 == 1) {
                    //draw a tile
                    g.fillRect(
                        col * cell_size, 
                        row * cell_size, 
                        cell_size, 
                        cell_size
                    );
                }
            }
        }
        //draw borders
        g.setColor(new Color(0, 128, 0));
        g.fillRect(0, 0, columns * cell_size, cell_size); // Top border
        g.fillRect(0, (rows - 1) * cell_size, columns * cell_size, cell_size); // Bottom border
        g.fillRect(0, 0, cell_size, rows * cell_size); // Left border
        g.fillRect((columns - 1) * cell_size, 0, cell_size, rows * cell_size); // Right border

        //draw entrance and exit red
        g.setColor(new Color(255, 0, 0));
        g.fillRect(0, cell_size, cell_size, cell_size);
        g.fillRect((columns - 1) * cell_size, (rows - 2) * cell_size, cell_size, cell_size);
    }
}