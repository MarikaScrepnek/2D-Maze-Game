package com.sfuparkingmayhem.game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Point;


public class ConcordOfficer extends MovingEntity{
    // Reference to the MainCharacter
    private MainCharacter target;
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
        // Use Dijkstra’s pathfinding to find next step toward the player.
        java.util.List<Point> path = board.findPathDijkstra(
            this.getX_coordinate(),
            this.getY_coordinate(),
            target.getX_coordinate(),
            target.getY_coordinate()
        );

        // If a valid path was found and has more than one step, 
        // the first element of 'path' is our current cell, 
        // the second element is the next cell toward the target:
        if (path != null && path.size() > 1) {
            Point nextStep = path.get(1);
            this.x_coordinate = nextStep.x;
            this.y_coordinate = nextStep.y;
        }
    }

    

    @Override
    protected void getImage() {
        try{
            this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("officer_placeholder.png"));

        }
        catch(IOException e){
            System.out.println("Error displaying officer" + e.getMessage());
        }
    }
    
}
