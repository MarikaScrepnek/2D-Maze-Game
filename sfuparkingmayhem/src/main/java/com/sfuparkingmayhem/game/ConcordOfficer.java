package com.sfuparkingmayhem.game;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A ConcordOfficer is a MovingEntity that chases the MainCharacter.
 */
public class ConcordOfficer extends MovingEntity{
    /**
     * A reference to the MainCharacter instance of the game.
     * This is used for getting its coordinates.
     */
    private MainCharacter target;
    /**
     * A reference to the board instance of the gane.
     */
    private Board board;

    /**
     * Constructs a ConcordOfficer that will chase the MainCharacter.
     *
     * @param x_coordinate The initial x-coordinate of this ConcordOfficer.
     * @param y_coordinate The initial y-coordinate of this ConcordOfficer.
     * @param target       The MainCharacter to chase.
     */
    public ConcordOfficer(int x_coordinate, int y_coordinate, MainCharacter target, Board board) {
        super(x_coordinate, y_coordinate);
        this.target = target;
        this.board = board;
        getImage(); // Load the sprite/image for this entity
    }

    /**
     * Moves the ConcordOfficer towards the MainCharacter.
     */
    protected void move(KeyEvent event) {
        int oldX = this.getX_coordinate();
        int oldY = this.getY_coordinate();

        // Use Dijkstra’s algorithm to find next step toward the player.
        java.util.List<Point> path = board.findPathDijkstra(
            this.getX_coordinate(),
            this.getY_coordinate(),
            target.getX_coordinate(),
            target.getY_coordinate()
        );

        // If a valid path was found and has more than one step, 
        // the first element of path is the current cell, 
        // the second element is the next cell toward the target
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
