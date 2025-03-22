package com.sfuparkingmayhem.game;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 * A ConcordOfficer is a MovingEntity that chases the MainCharacter.
 */
public class ConcordOfficer extends MovingEntity{
    /**
     * A reference to the board instance of the gane.
     */
    private final Board board;

    /**
     * Timer that sets the speed of the concord officer
     */
    public Timer officerTimer;

    /**
     * Constructs a ConcordOfficer that will chase the MainCharacter.
     *
     * @param x_coordinate The initial x-coordinate of this ConcordOfficer.
     * @param y_coordinate The initial y-coordinate of this ConcordOfficer.
     * @param board The board that the game is happening on.
     */
    public ConcordOfficer(int x_coordinate, int y_coordinate, Board board) {
        super(x_coordinate, y_coordinate);
        this.board = board;
        getImage(); // Load the sprite/image for this entity

        officerTimer = new Timer(500, e -> {
            int oldX = this.getX_coordinate();
            int oldY = this.getY_coordinate();

            this.move(null);  // Call move() without KeyEvent

            // Check if the officer is colliding with a cone or parked car
            if (isCollidingWithCone(this.getX_coordinate(), this.getY_coordinate(), Board.cones) ||
                isCollidingWithParkedCar(this.getX_coordinate(), this.getY_coordinate(), Board.parkedCars)) {
                this.x_coordinate = oldX;
                this.y_coordinate = oldY;
            }

            //check if officer and mainCharacter are colliding, if so, game has ended
            if (board.officer.x_coordinate == board.main_character.getMainCharacterXCoordinate() 
                && board.officer.y_coordinate == board.main_character.getMainCharacterYCoordinate() && board.game_ended == false) {
                board.game_ended = true;
                board.cardLayout.show(board.cardPanel, "Lose Screen Concord");
            }

            board.repaint();  // Refresh the screen
        });
        officerTimer.start();
    }

    /**
     * Moves the ConcordOfficer towards the MainCharacter.
     */
    @Override
    protected void move(KeyEvent event) {
        int oldX = this.getX_coordinate();
        int oldY = this.getY_coordinate();

        // Use Dijkstra’s algorithm to find next step toward the player.
        java.util.List<Point> path = board.findPathDijkstra(
            this.getX_coordinate(),
            this.getY_coordinate(),
            board.main_character.getX_coordinate(),
            board.main_character.getY_coordinate()
        );

        // If a valid path was found and has more than one step, 
        // the first element of path is the current cell, 
        // the second element is the next cell toward the board.main_character
        if (path != null && path.size() > 1) {
            Point nextStep = path.get(1);
            this.x_coordinate = nextStep.x;
            this.y_coordinate = nextStep.y;

            if (this.x_coordinate > oldX) {
                // Move Right
                try{
                    this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("officer_east.png"));
                }
                catch(IOException e){
                    System.out.println("Error displaying officer" + e.getMessage());
                }
                // Move Left
            } else if (this.x_coordinate < oldX) { 
                try{
                    this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("officer_west.png"));
                }
                catch(IOException e){
                    System.out.println("Error displaying officer" + e.getMessage());
                } 
                // Move Down
            } else if (this.y_coordinate > oldY) { 
                try{
                    this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("officer_south.png"));
                }
                catch(IOException e){
                    System.out.println("Error displaying officer" + e.getMessage());
                }
                // Move Up
            } else if (this.y_coordinate < oldY) { 
                try{
                    this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("officer_north.png"));
                }
                catch(IOException e){
                    System.out.println("Error displaying officer" + e.getMessage());
                } 
            }
        }

    }

    @Override
    protected void getImage() {
        try{
            this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("officer_north.png"));
        }
        catch(IOException e){
            System.out.println("Error displaying officer" + e.getMessage());
        }
    }
}
