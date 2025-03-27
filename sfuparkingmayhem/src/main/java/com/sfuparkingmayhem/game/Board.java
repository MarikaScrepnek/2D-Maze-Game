package com.sfuparkingmayhem.game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sfuparkingmayhem.screen.WinScreen;


/**
 * This class implements the ActionListener and KeyListener and implements 
 * the JPanel classes. This class creates the game board and has entites,
 * timers and is 15 by 15 (height = 15, width = 15). 
 * 
 * @author Group 25
 * @version 1.0
 */

public class Board extends JPanel implements ActionListener, KeyListener{
    /**
     * Field to hold the number of rows in a board.
     */
    protected static final int ROWS = 15;
    /**
     * Field to hold the number of columns in a board.
     */
    protected static final int COLUMNS = 15;
    /**
     * Field to hold the size of a cell on the board.
     */
    protected static final int CELL_SIZE = 50;

    /**
     * Main character entity.
     */
    protected MainCharacter main_character;
    /**
     * Concord Officer entity.
     */
    protected ConcordOfficer officer;
    /**
     * LostNote entity.
     */
    protected LostNote lost_note;

    /**
     * Timer that ensures game state is updated every interval.
     */
    private final Timer timer;
    /**
     * Field holding the delay for Timer updating game state.
     */
    private final int DELAY = 25;
    /**
     * Timer that counts the seconds of the game for the player's time.
     */
    private GameTimer gameTimer;

    /**
     * Keeps track of the player's score.
     */
    protected Score score;
    
    /**
     * Arraylists holding all coins in the game.
     */
    ArrayList<Coin> coins = new ArrayList<>();
    /**
     * Arraylists holding all cones in the game.
     */
    ArrayList<Cone> cones = new ArrayList<>();
    /**
     * Arraylists holding all parked cars in the game.
     */
    ArrayList<ParkedCar> parkedCars = new ArrayList<>();
    /**
     * Arraylists holding all lost notes in the game.
     */
    List<LostNote> ln = new ArrayList<>(); 

    /**
     * variable to help display the number of coins collected by user
     */
    private int coinsCollectedCount = 0;

    /**
     * Field that tells you if the game has ended to ensure lose screen doesn't pop up multiple times.
     */
    protected boolean game_ended = false;

    /**
     * The CardLayout used for switching between screens.
     */
    CardLayout cardLayout;
    /**
     * The JPanel that holds the game screens.
     */
    JPanel cardPanel;
    
    /**
     * Constructs a Board object. Uses methods to populate this Board with a score, static entities
     * and a concord officer. Timers are created to start counting upward when game begins.
     * 
     * @param cardLayout The CardLayout used for switching between screens.
     * @param cardPanel The JPanel that contains all the game screens.
     */
    public Board(CardLayout cardLayout, JPanel cardPanel) {
        initBoardPanel(cardLayout, cardPanel);

        populateBoard();

        //timer that will make sure actionPerformed is ran every DELAY interval
        timer = new Timer(DELAY, this);
        timer.start();
    }

    /**
     * Initializes Board Panel by setting dimensions, background color, and
     * assigning a cardLayout and cardPanel.
     * 
     * @param cardLayout
     * @param cardPanel
     */
    private void initBoardPanel(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout=cardLayout;
        this.cardPanel=cardPanel;

        //set game board size
        setPreferredSize(new Dimension(CELL_SIZE*COLUMNS,CELL_SIZE*ROWS));

        //set the background color to a concrete grey
        setBackground(new Color(43, 43, 43));
    }

    /**
     * Populates the board with all entities and timer and score.
     */
    private void populateBoard() {
        //intialize player
        main_character = new MainCharacter(0, 1, this);
        //initialize officer
        officer = new ConcordOfficer(7, 7, this);
        //initialize score
        score = new Score();
        //initialize game timer
        gameTimer = new GameTimer(this);

        //populate the game board with coins, cones, parked cars, and lost notes
        createCoins();
        createCones();
        createParkedCars();
        createLostNote();
    }

    /**
     * Creates coins and adds them to the coins arraylist
     */
    protected void createCoins(){
        coins.add(new Coin(2,3, this));
        coins.add(new Coin(7,2, this));
        coins.add(new Coin(10,4, this));
        coins.add(new Coin(7,5, this));
        coins.add(new Coin(3,8, this));
        coins.add(new Coin(11,8, this));
        coins.add(new Coin(6,9, this));
        coins.add(new Coin(12,11, this));
        coins.add(new Coin(9,12, this));
        coins.add(new Coin(3,13, this));
    }

    /**
     * Creates cones and adds them to the cones arraylist
     */
    private void createCones(){
        cones.add(new Cone(4,3, this));
        cones.add(new Cone(11,3, this));
        cones.add(new Cone(12,3, this));
        cones.add(new Cone(4,5, this));
        cones.add(new Cone(9,7, this));
        cones.add(new Cone(6,8, this));
        cones.add(new Cone(12,9, this));
        cones.add(new Cone(2,10, this));
        cones.add(new Cone(10,10, this));
        cones.add(new Cone(7,13, this));
    }

    /**
     * Creates parked cars and adds them to the parkedCars arraylist
     */
    private void createParkedCars(){
        parkedCars.add(new ParkedCar(2, 2, this));
        parkedCars.add(new ParkedCar(6, 5, this));
        parkedCars.add(new ParkedCar(8, 5, this));
        parkedCars.add(new ParkedCar(12, 6, this));
        parkedCars.add(new ParkedCar(12, 7, this));
        parkedCars.add(new ParkedCar(3, 7, this));
        parkedCars.add(new ParkedCar(4, 11, this));
        parkedCars.add(new ParkedCar(4, 12, this));
        parkedCars.add(new ParkedCar(8, 11, this));
        parkedCars.add(new ParkedCar(9, 11, this));
    }

    /**
     * Populates the lostNote arraylist with a lostNote object every 7 seconds.
     * Removes a lost note every 7 seconds if there is a lost note to remove.
     */
    private void createLostNote(){
        LostNote lostNote = new LostNote(0,0, this);
        ln.add(lostNote);
        Timer lostNoteTimer = new Timer(7000, e -> {
            if (!ln.isEmpty()) {
                ln.remove(0);
            }
            LostNote newLostNote = new LostNote(0,0, this);
            ln.add(newLostNote);
        });
        lostNoteTimer.start();
    }

    /**
     * Updates the state of the game by repainting and uses tickCharacter()
     * from {@link MainCharacter} class to prevent player from disappearing off 
     * this Board.
     * 
     * @param e an Actionevent that has occurred during game
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // prevent the player from disapearing off the board
        main_character.tick();

        repaint();
    }

    /**
     * Draws this Board's Entitys and updates the board
     * if certain entitys have been collected and do not need to be drawn
     * anymore.
     * 
     * @param g a Graphics object to help draw
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBoardBackground(g);
        main_character.drawTheImage(g, this);
        officer.drawTheImage(g, this);


        main_character.collectCoins();
        main_character.collectLostNote();
        checkGameEnd();
        

        //draw coins onto board
        for (int i =0; i<coins.size(); i++){
            Coin aCoin = coins.get(i);
            aCoin.drawTheImage(g, this);
        }
        
        //draw cones onto board
        for (int i =0; i<cones.size(); i++){
            Cone aCone = cones.get(i);
            aCone.drawTheImage(g, this);
        }

        //draw parked cars onto board
        for (int i =0; i<parkedCars.size(); i++){
            ParkedCar aParkedCar = parkedCars.get(i);
            aParkedCar.drawTheImage(g, this);
        }

        //draw lost note onto board
        for (int i =0; i<ln.size(); i++){
            LostNote aLostNote = ln.get(i);
            aLostNote.drawTheImage(g, this);
        }

        score.draw(g);
        gameTimer.draw(g);
        drawCoinsCollected(g);

    }

    /**
     * Draws the game board and the boarder.
     * 
     * @param g Graphics object to help draw this Board
     * @throws e Exception if an exception occurs during loading images
     */
    private void drawBoardBackground(Graphics g) {
        Barrier barrier = new Barrier(0, 0, this);
        //top
        for (int col = 1; col < COLUMNS; col++) {
            g.drawImage(barrier.theImage, col * CELL_SIZE, 0, 50, 50, null);
        }

        // Bottom border
        for (int col = 0; col < COLUMNS; col++) {
            g.drawImage(barrier.theImage, col * CELL_SIZE, (ROWS - 1) * CELL_SIZE, 50, 50, null);
        }

        // Left border
        for (int row = 0; row < ROWS; row++) {
            g.drawImage(barrier.theImage, 0, row * CELL_SIZE, 50, 50, null);
        }

        // Right border
        for (int row = 0; row < ROWS; row++) {
            g.drawImage(barrier.theImage, (COLUMNS - 1) * CELL_SIZE, row * CELL_SIZE, 50, 50, null);
        }

        //draw entrance
        g.setColor(new Color(43, 43, 43));
        g.fillRect(0, CELL_SIZE, CELL_SIZE, CELL_SIZE);
        g.fillRect((COLUMNS - 1) * CELL_SIZE, (ROWS - 2) * CELL_SIZE, CELL_SIZE, CELL_SIZE);

        //draw parking entrance
        Image parkingSign=null;
        try {
            parkingSign = ImageIO.read(getClass().getClassLoader().getResourceAsStream("parkingSign.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        g.drawImage(parkingSign, 0,0,50,50,null);

        //draw ticketbooth
        Image ticketBooth=null;
        try {
            ticketBooth = ImageIO.read(getClass().getClassLoader().getResourceAsStream("ticketBooth.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        g.drawImage(ticketBooth, 14*CELL_SIZE,12*CELL_SIZE,50,50,null);
    }

    /**
     * Draws how many coins have been collected on the game board.
     * 
     * @param g Graphics object
     */
    private void drawCoinsCollected(Graphics g) {
        g.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        g.setColor(Color.WHITE);

        g.drawString("COINS COLLECTED: " + coinsCollectedCount + "/10", 50, 730);
    }

    protected void updateCoinsCollectedCount() {
        coinsCollectedCount++;
    }

    public int getCoinsCollectedCount() {
        return coinsCollectedCount;
    }

    /**
     * 
     */
    private void checkGameEnd() {
        if (main_character.getX_coordinate() == 14 && main_character.getY_coordinate() == 13) {
            if (coins.isEmpty()) {
            int finalTime = gameTimer.getTimeElapsed(); // Implement a method to track time
            int finalScore = score.getScore(); // Assuming Score class has this method

            WinScreen winScreen = new WinScreen(cardLayout, cardPanel, finalScore, finalTime);
            cardPanel.add(winScreen, "Win Screen");
            cardLayout.show(cardPanel, "Win Screen");
        }
        }
    }

    /**
     * Doesn't need to be implemented but needs to be here because of interface.
     * 
     * @param e - KeyEvent type that checks when keys are typed on keyboard
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Is implemented in main character. Moves the main character when getting a key input.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        main_character.delayedMove(e);
    }

    //doesn't need to be implemented but needs to be here because of interface
    @Override
    public void keyReleased(KeyEvent e) {
        main_character.keyReleased(e);
    }

    /**
     * Helper method to check if a cell is blocked by a cone or parked car.
     * 
     * @param x The x-coordinate of the cell.
     * @param y The y-coordinate of the cell.
     * @return true if the cell is blocked, false otherwise.
     */
    public boolean isCellBlocked(int x, int y) {
        // Return true if out-of-bounds
        if (x <= 0 || x >= COLUMNS-1 || y <= 0 || y >= ROWS-1) {
            return true;
        }
        // Check for cones
        for (Cone cone : cones) {
            if (cone.getX_coordinate() == x && cone.getY_coordinate() == y) {
                return true;
            }
        }
        // Check for parked cars
        for (ParkedCar pc : parkedCars) {
            if (pc.getX_coordinate() == x && pc.getY_coordinate() == y) {
                return true;
            }
        }
        return false;
    }
  
    /**
     * Flashes the background red.
     */
    public void flashRed() {
        //save original background color
        Color originalColor = getBackground();

        //set background color to red
        setBackground(Color.RED);

        //repaint screen to apply color change immediately
        repaint();

        //use a Timer to revert the color after 50ms
        Timer flash_timer;
        flash_timer = new Timer(50, (ActionEvent e) -> {
            //revert background color back to original color
            setBackground(originalColor);
            
            //repaint to apply color change immediately
            repaint();
        });
        flash_timer.setRepeats(false);//only execute once
        flash_timer.start(); //start the timer
    }

}