package com.sfuparkingmayhem.game;

import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import javax.imageio.ImageIO;
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
    private ArrayList<Coin> coins = new ArrayList<Coin>();
    private ArrayList <Cone> cones = new ArrayList<Cone>();
    private ArrayList <ParkedCar> parkedCars = new ArrayList<ParkedCar>();

    protected LostNote lost_note;
    private ArrayList<LostNote> ln = new ArrayList<LostNote>(); //added this but not on class diagram

    private final int DELAY = 25;

    private int timeElapsed = 0;

    public Board() {
        //set game board size
        setPreferredSize(new Dimension(CELL_SIZE*COLUMNS,CELL_SIZE*ROWS));
        //set the background color to a concrete grey
        setBackground(new Color(43, 43, 43));
        //intialize player
        main_character = new MainCharacter(0, 1);
        //initialize officer
        officer = new ConcordOfficer(7, 7, main_character, this);
        //initialize score
        score = new Score();


        createCoins();
        populateLostNote();
        createCones();
        System.out.println("cones size = "+cones.size());
        createParkedCars();
        System.out.println("parkedCars size = "+parkedCars.size());



        //timer that will make sure actionPerformed is ran every DELAY interval
        timer = new Timer(DELAY, this);
        timer.start();

        officerTimer = new Timer(500, e -> {
            int oldX = officer.getX_coordinate();
            int oldY = officer.getY_coordinate();

            officer.move(null);  // Call move() without KeyEvent

            // Check if the officer is colliding with a cone or parked car
            if (isCollidingWithCone(officer.getX_coordinate(), officer.getY_coordinate()) ||
                isCollidingWithParkedCar(officer.getX_coordinate(), officer.getY_coordinate())) {
                officer.x_coordinate = oldX;
                officer.y_coordinate = oldY;
            }

            if (officer.x_coordinate == main_character.getMainCharacterXCoordinate() 
                && officer.y_coordinate == main_character.getMainCharacterYCoordinate()) {
                // TO DO - Add game over logic
                System.out.println("Game Over: Officer caught you");
            }

            repaint();  // Refresh the screen
        });
        officerTimer.start();

        gameTimer = new Timer(1000, e -> {
            timeElapsed++;
            repaint();
        });
        gameTimer.start();
    }

    /**
     * Creates coins and adds them to the coins arraylist
     */
    private void createCoins(){
        //created and added new coins to the coins arraylist
        coins.add(new Coin(2,3));
        coins.add(new Coin(7,2));
        coins.add(new Coin(10,4 ));
        coins.add(new Coin(7,5));
        coins.add(new Coin(3,8));
        coins.add(new Coin(11,8));
        coins.add(new Coin(6,9));
        coins.add(new Coin(12,11));
        coins.add(new Coin(9,12));
        coins.add(new Coin(3,13));

    }

    /**
     * Populates the lostNote arraylist with a lostNote object
     */
    private void populateLostNote(){
        //create a lostNote with initial x and y coordinates of 0
        lost_note = new LostNote(0,0);

        //boolean value needed for do-while loop
        boolean check;


        do{

            lost_note.generateCoords(); //generate random x and y coordinates

            check = false; //assume that it is not needed to find another set of coords for lostNote

            //check all the coins to see if any of the coins' coords matches the lostnotes' coords
            for (int i = 0; i < coins.size(); i++){

                //get a coin in the coins arraylist
                Coin coin = coins.get(i);

                //get the x and y coordinates of that coin
                int coinXCoord = coin.getX_coordinate();
                int coinYCoord = coin.getY_coordinate();

                //boolean variables needed for checking if the lostnote has matching coordinates
                boolean coinCoordConflict = false;

                if (lost_note.getX_coordinate() == coinXCoord && lost_note.getY_coordinate() == coinYCoord){
                    coinCoordConflict = true;
                }

                //check if another entity is already on that position on board
                if(coinCoordConflict){

                    //set check to be true as another set of coords needs to be generate for lostNote
                    check = true;

                    //already know there is a coin's coordinates that matches lostnotes's coordinates so break out of for loop
                    break;
                }
            }

            for (int i = 0; i < parkedCars.size(); i++){
                //get a coin in the coins arraylist
                ParkedCar pc = parkedCars.get(i);

                //get the x and y coordinates of that ParkedCar
                int pcXCoord = pc.getX_coordinate();
                int pcYCoord = pc.getY_coordinate();

                //boolean variables needed for checking if the lostnote has matching coordinates
                boolean pcCoordConflict = false;

                if (lost_note.getX_coordinate() == pcXCoord && lost_note.getY_coordinate() == pcYCoord){
                    pcCoordConflict = true;
                }

                //check if another entity is already on that position on board
                if(pcCoordConflict){

                    //set check to be true as another set of coords needs to be generate for lostNote
                    check = true;

                    //already know there is a coin's coordinates that matches lostnotes's coordinates so break out of for loop
                    break;
                }

            }


            for (int i = 0; i < cones.size(); i++){
                //get a cone in the cone arraylist
                Cone cone = cones.get(i);

                //get the x and y coordinates of that cone
                int coneXCoord = cone.getX_coordinate();
                int coneYCoord = cone.getY_coordinate();

                //boolean variables needed for checking if the lostnote has matching coordinates
                boolean coneCoordConflict = false;

                if (lost_note.getX_coordinate() == coneXCoord && lost_note.getY_coordinate() == coneYCoord){
                    coneCoordConflict = true;
                }

                //check if another entity is already on that position on board
                if(coneCoordConflict){

                    //set check to be true as another set of coords needs to be generate for lostNote
                    check = true;

                    //already know there is a coin's coordinates that matches lostnotes's coordinates so break out of for loop
                    break;
                }

            }


        } while (check);


        //add lost note to ln arraylist
        ln.add(lost_note);

    }

    /**
     * Creates cones and adds them to the cones arraylist
     */
    private void createCones(){
        //created and added new cones to the cones arraylist
        cones.add(new Cone(4,3));
        cones.add(new Cone(11,3));
        cones.add(new Cone(12,3));
        cones.add(new Cone(4,5));
        cones.add(new Cone(9,7));
        cones.add(new Cone(6,8));
        cones.add(new Cone(12,9));
        cones.add(new Cone(2,10));
        cones.add(new Cone(10,10));
        cones.add(new Cone(7,13));
    }

    /**
     * Creates parked cars and adds them to the parkedCars arraylist
     */
    private void createParkedCars(){
        parkedCars.add(new ParkedCar(2, 2));
        parkedCars.add(new ParkedCar(6, 5));
        parkedCars.add(new ParkedCar(8, 5));
        parkedCars.add(new ParkedCar(12, 6));
        parkedCars.add(new ParkedCar(12, 7));
        parkedCars.add(new ParkedCar(3, 7));
        parkedCars.add(new ParkedCar(4, 11));
        parkedCars.add(new ParkedCar(4, 12));
        parkedCars.add(new ParkedCar(8, 11));
        parkedCars.add(new ParkedCar(9, 11));

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

        collectCoins();
        collectLostNote();
        

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

        //draw note if between 3 and 10 seconds of playing game
        if (3<=getTimeElapsed() && getTimeElapsed()<=10){

            //draw lost note onto board
            for (int i =0; i<ln.size(); i++){
                LostNote aLostNote = ln.get(i);
                aLostNote.drawTheImage(g, this);
                }
        }
        //remove the lostNote from ln arraylist if time >10 secs
        else if (getTimeElapsed()>10){
            ln.clear();
        }
        //lost_note.drawTheImage(g,this);

        drawScore(g);
        drawTimer(g);

    }

    /**
     * Draws the game board
     * @param g Graphics object
     */
    private void drawBoard(Graphics g) {
        Image grass=null;
        try {
            grass = ImageIO.read(getClass().getClassLoader().getResourceAsStream("bush.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //top
        for (int col = 1; col < COLUMNS; col++) {
            g.drawImage(grass, col * CELL_SIZE, 0, 50, 50, null);
        }

        // Bottom border
        for (int col = 0; col < COLUMNS; col++) {
            g.drawImage(grass, col * CELL_SIZE, (ROWS - 1) * CELL_SIZE, 50, 50, null);
        }

        // Left border
        for (int row = 0; row < ROWS; row++) {
            g.drawImage(grass, 0, row * CELL_SIZE, 50, 50, null);
        }

        // Right border
        for (int row = 0; row < ROWS; row++) {
            g.drawImage(grass, (COLUMNS - 1) * CELL_SIZE, row * CELL_SIZE, 50, 50, null);
        }

        //draw entrance
        g.setColor(new Color(43, 43, 43));
        g.fillRect(0, CELL_SIZE, CELL_SIZE, CELL_SIZE);
        g.fillRect((COLUMNS - 1) * CELL_SIZE, (ROWS - 2) * CELL_SIZE, CELL_SIZE, CELL_SIZE);

        //draw parking entrance
        Image parkingSign=null;
        try {
            parkingSign = ImageIO.read(getClass().getClassLoader().getResourceAsStream("parkingSign.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        g.drawImage(parkingSign, 0,0,50,50,null);

        //draw ticketbooth
        Image ticketBooth=null;
        try {
            ticketBooth = ImageIO.read(getClass().getClassLoader().getResourceAsStream("ticketBooth.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        g.drawImage(ticketBooth, 14*CELL_SIZE,12*CELL_SIZE,50,50,null);
    }

    /**
     * Draws the score on the game board
     * @param g Graphics object
     */
    private void drawScore(Graphics g) {
        // Set the font and colour for the UI of Score
        g.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        g.setColor(Color.WHITE);

        // Draw the score
        g.drawString("SCORE: " + score.getScore() + " PTS", 555, 730);
    }

    /**
     * Draws the timer on the game board
     * @param g Graphics object
     */
    private void drawTimer(Graphics g) {
        int minutes = timeElapsed / 60;
        int seconds = timeElapsed % 60;

        g.setFont(new Font("Bahnschrift", Font.BOLD, 25));
        g.setColor(Color.WHITE);

        String timeString = String.format("%02d:%02d", minutes, seconds);

        g.drawString(timeString, 343, 30);
    }

    /**
     * Gets the time elapsed in the game
     * @return timeElapsed
     */
    public int getTimeElapsed(){
        return timeElapsed;
    }

    /**
     * Removes a coin from coins ArrayList if this MainCharacter's board position matches
     * a coin's board position. Must create a copy of coins ArrayList to prevent iterating
     * and removing (deleting) from same ArrayList, which is not allowed.
     */
    private void collectCoins(){
        //collect the coins from the board
        ArrayList<Coin> coinsCopy = new ArrayList<Coin>(coins); //make a copy of coins arraylist
        for (Coin aCoin : coinsCopy){

            //remove the coin from arraylist if this coin and MainCharacter have same board position
            if (main_character.getMainCharacterXCoordinate() == aCoin.getX_coordinate()
                    && main_character.getMainCharacterYCoordinate() == aCoin.getY_coordinate()){
                coins.remove(aCoin);
                score.addPoints(5);
            }
        }
    }

    /**
     * Removes a lostNote from ln ArrayList if this MainCharacter's board position matches
     * a lostNote's board position. Must create a copy of ln ArrayList to prevent iterating
     * and removing (deleting) from same ArrayList, which is not allowed.
     */
    private void collectLostNote(){
        //collect the lostNote from the board if lostNote and MainCharacter have same board position
        ArrayList<LostNote> lnCopy = new ArrayList<LostNote>(ln);
        for (LostNote aLostNote : lnCopy){
            if (main_character.getMainCharacterXCoordinate() == aLostNote.getX_coordinate()
                    && main_character.getMainCharacterYCoordinate() == aLostNote.getY_coordinate()){
                ln.remove(aLostNote);
                score.addPoints(10);

            }
        }
    }

    /**
     * Checks if the player is colliding with a cone
     * @param x x-coordinate of the player
     * @param y y-coordinate of the player
     * @return true if the player is colliding with a cone, false otherwise
     */
    private boolean isCollidingWithCone(int x, int y) {
        for (Cone cone : cones) {
            if (cone.getX_coordinate() == x && cone.getY_coordinate() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the player is colliding with a parked car
     * @param x x-coordinate of the player
     * @param y y-coordinate of the player
     * @return true if the player is colliding with a parked car, false otherwise
     */
    private boolean isCollidingWithParkedCar(int x, int y) {
        for (ParkedCar parkedCar : parkedCars) {
            if (parkedCar.getX_coordinate() == x && parkedCar.getY_coordinate() == y) {
                return true;
            }
        }
        return false;
    }


    //doesn't need to be implemented but needs to be here because of interface
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //move main_character when a key is pressed
    @Override
    public void keyPressed(KeyEvent e) {
        int oldX = main_character.getX_coordinate();
        int oldY = main_character.getY_coordinate();
        main_character.move(e);

        // Check if the player is colliding with a cone
        if (isCollidingWithCone(main_character.getX_coordinate(), main_character.getY_coordinate())) {
            // revert the player position
            main_character.x_coordinate = oldX;
            main_character.y_coordinate  = oldY;
        }

        // Check if the player is colliding with a parked car
        if(isCollidingWithParkedCar(main_character.getX_coordinate(), main_character.getY_coordinate())){
            // Subtract points from the player's score
            if(oldX != main_character.getX_coordinate() || oldY != main_character.getY_coordinate()){
                score.subtractPoints(5);
                if(score.getScore() < 0){
                    // TO DO - Add game over logic
                    System.out.println("Game Over: Score is negative");
                }
            }

            // revert the player position
            main_character.x_coordinate = oldX;
            main_character.y_coordinate = oldY;
        }
    }

    //doesn't need to be implemented but needs to be here because of interface
    @Override
    public void keyReleased(KeyEvent e) {
    }


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
     * Returns a path (as a list of Points) from (startX,startY) to (endX,endY),
     * or null if no path exists.
     */
    public List<Point> findPathDijkstra(int startX, int startY, int endX, int endY) {
        // If the start or end is blocked, no path
        if (isCellBlocked(startX, startY) || isCellBlocked(endX, endY)) {
            return null;
        }

        // Distances array
        int[][] dist = new int[ROWS][COLUMNS];
        for (int r = 0; r < ROWS; r++) {
            Arrays.fill(dist[r], Integer.MAX_VALUE);
        }

        Point[][] parent = new Point[ROWS][COLUMNS]; // store predecessor

        PriorityQueue<PointDistance> q = new PriorityQueue<>(Comparator.comparingInt(pd -> pd.distance));

        // Initialize distance for start node
        dist[startY][startX] = 0;
        q.offer(new PointDistance(startX, startY, 0));

        // Directions for up/down/left/right movement
        int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1} };

        while (!q.isEmpty()) {
            PointDistance current = q.poll();
            int currX = current.x;
            int currY = current.y;
            int currDist = current.distance;

            // If there's already a better route before, skip
            if (currDist > dist[currY][currX]) {
                continue;
            }

            // If we reached the target, stop
            if (currX == endX && currY == endY) {
                // Reconstruct path from end -> start using 'parent'
                return buildPath(parent, startX, startY, endX, endY);
            }

            // Explore neighbors
            for (int[] d : directions) {
                int neighbourX = currX + d[0];
                int neighbourY = currY + d[1];
                // If in-bounds and not blocked
                if (!isCellBlocked(neighbourX, neighbourY)) {
                    int newDist = currDist + 1; // cost of 1 step
                    if (newDist < dist[neighbourY][neighbourX]) {
                        dist[neighbourY][neighbourX] = newDist;
                        parent[neighbourY][neighbourX] = new Point(currX, currY);
                        q.offer(new PointDistance(neighbourX, neighbourY, newDist));
                    }
                }
            }
        }

        return null;
    }

    /**
     * Reconstructs the path by backtracking from the end cell’s parent pointer
     * up to the start cell. Then reverse that list to get start->end order.
     */
    private List<Point> buildPath(Point[][] parent, int startX, int startY,
                                  int endX, int endY) {
        LinkedList<Point> path = new LinkedList<>();
        int currX = endX;
        int currY = endY;
        while (!(currX == startX && currY == startY)) {
            path.addFirst(new Point(currX, currY));
            Point par = parent[currY][currX];
            currX = par.x;
            currY = par.y;
        }
        // Add the start cell at the front
        path.addFirst(new Point(startX, startY));
        return path;
    }

    // helper class to store (x, y) plus a distance in priority queue
    private static class PointDistance {
        int x, y, distance;
        PointDistance(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.distance = dist;
        }
    }
}