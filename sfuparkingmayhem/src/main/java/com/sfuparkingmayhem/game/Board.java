package com.sfuparkingmayhem.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, KeyListener{
    protected static final int ROWS = 15;
    protected static final int COLUMNS = 15;
    protected static final int CELL_SIZE = 50;
    protected static final int[][] BOARD = new int[ROWS][COLUMNS];
    protected static final int NUM_COINS = 10;

    private final MainCharacter main_character;
    private final Timer timer;
    //private final Coin[] coins = new Coin[num_coins];
    //private Score score;

    private final int DELAY = 25;

    public Board() {
        //set game board size
        setPreferredSize(new Dimension(CELL_SIZE*COLUMNS,CELL_SIZE*ROWS));
        //set the background color to a concrete grey
        setBackground(new Color(153, 153, 153));
        //intialize player
        main_character = new MainCharacter(0, 1);

        timer = new Timer(DELAY, this);
        timer.start();
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
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                //only color every other tile
                if ((row + col) % 2 == 1) {
                    //draw a tile
                    g.fillRect(
                        col * CELL_SIZE, 
                        row * CELL_SIZE, 
                        CELL_SIZE, 
                        CELL_SIZE
                    );
                }
            }
        }
        //draw borders
        g.setColor(new Color(0, 128, 0));
        g.fillRect(0, 0, COLUMNS * CELL_SIZE, CELL_SIZE); // Top border
        g.fillRect(0, (ROWS - 1) * CELL_SIZE, COLUMNS * CELL_SIZE, CELL_SIZE); // Bottom border
        g.fillRect(0, 0, CELL_SIZE, ROWS * CELL_SIZE); // Left border
        g.fillRect((COLUMNS - 1) * CELL_SIZE, 0, CELL_SIZE, ROWS * CELL_SIZE); // Right border

        //draw entrance and exit blue
        g.setColor(new Color(19, 3, 252));
        g.fillRect(0, CELL_SIZE, CELL_SIZE, CELL_SIZE);
        g.fillRect((COLUMNS - 1) * CELL_SIZE, (ROWS - 2) * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
    private void drawScore(Graphics g) {
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //player.tick()
        //collectCoins()
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        main_character.move(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}