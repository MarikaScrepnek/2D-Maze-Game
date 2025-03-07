package com.sfuparkingmayhem.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, KeyListener{
    protected static final int ROWS = 15;
    protected static final int COLUMNS = 15;
    protected static final int CELL_SIZE = 50;
    protected static final int[][] BOARD = new int[ROWS][COLUMNS];
    protected static final int NUM_COINS = 10;

    private final MainCharacter main_character;
    private final ConcordOfficer officer;
    private final Timer timer;
    private final Timer officerTimer;
    private final Timer gameTimer; 
    private final Score score;
    //private final Coin[] coins = new Coin[NUM_COINS];
    private ArrayList<Coin> coins = new ArrayList<Coin>();
    Coin coin1;
    Coin coin2;
    Coin coin3;
    Coin coin4;
    Coin coin5;
    Coin coin6;
    Coin coin7;
    Coin coin8;
    Coin coin9;
    Coin coin10;
    protected LostNote lost_note;

    private final int DELAY = 25;

    private int timeElapsed = 0;

    public Board() {
        //set game board size
        setPreferredSize(new Dimension(CELL_SIZE*COLUMNS,CELL_SIZE*ROWS));
        //set the background color to a concrete grey
        setBackground(new Color(153, 153, 153));
        //intialize player
        main_character = new MainCharacter(0, 1);
        //initialize officer
        officer = new ConcordOfficer(7, 7, main_character);
        //initialize score
        score = new Score();

        //test adding a coin onto board
        coin1 = new Coin(1,1);
        coin2 = new Coin(6,6);
        coin3 = new Coin(7,7);
        coin4 = new Coin(8,8);
        coin5 = new Coin(9,9);
        coin6 = new Coin(10,10);
        coin7 = new Coin(11,11);
        coin8 = new Coin(12,12);
        coin9 = new Coin(13,13);
        coin10 = new Coin(2,2);

        //add the coins to the coins arraylist
        coins.add(coin1);
        coins.add(coin2);
        coins.add(coin3);
        coins.add(coin4);
        coins.add(coin5);
        coins.add(coin6);
        coins.add(coin7);
        coins.add(coin8);
        coins.add(coin9);
        coins.add(coin10);

        //place a lost note onto board
        lost_note = new LostNote(5,5);


        //timer that will make sure actionPerformed is ran every DELAY interval
        timer = new Timer(DELAY, this);
        timer.start();

        officerTimer = new Timer(1000, e -> {
            officer.move(null);  // Call move() without KeyEvent
            repaint();  // Refresh the screen
        });
        officerTimer.start();

        gameTimer = new Timer(1000, e -> {
            timeElapsed++;
            repaint();
        });
        gameTimer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // This method is to update the state of the game

        // prevent the player from disapearing off the board
        main_character.tickCharacter();

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBoard(g);
        main_character.drawTheImage(g, this);
        officer.drawTheImage(g, this);

        //draw coins onto board
        for (int i =0; i<NUM_COINS; i++){
            Coin aCoin = coins.get(i);
            aCoin.drawTheImage(g, this);
        }

        lost_note.drawTheImage(g,this);

        drawScore(g);
        drawTimer(g);

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
        // Set the font and colour for the UI of Score
        g.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        g.setColor(Color.WHITE);

        // Draw the score
        g.drawString("SCORE: " + score.getScore() + " PTS", 555, 730);
    }

    private void drawTimer(Graphics g) {
        int minutes = timeElapsed / 60;
        int seconds = timeElapsed % 60;

        g.setFont(new Font("Bahnschrift", Font.BOLD, 25));
        g.setColor(Color.WHITE);

        String timeString = String.format("%02d:%02d", minutes, seconds);

        g.drawString(timeString, 343, 30);
    }

    public int getTimeElapsed(){
        return timeElapsed;
    }

    //doesn't need to be implemented but needs to be here because of interface
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //move main_character when a key is pressed
    @Override
    public void keyPressed(KeyEvent e) {
        main_character.move(e);
    }

    //doesn't need to be implemented but needs to be here because of interface
    @Override
    public void keyReleased(KeyEvent e) {
    }

    public int getMainCharXCoord(){
        return main_character.getMainCharacterXCoordinate();
    }

    public int getMainCharYCoord(){
        return main_character.getMainCharacterYCoordinate();
    }
}