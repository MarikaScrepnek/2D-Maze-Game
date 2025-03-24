package com.sfuparkingmayhem.game;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

/**
 * A ConcordOfficer is a MovingEntity that chases the MainCharacter.
 */
public class ConcordOfficer extends MovingEntity{
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
        super(x_coordinate, y_coordinate, board);
        this.board = board;
        getImage("officer_north.png"); // Load the sprite/image for this entity

        officerTimer = new Timer(500, e -> {
            int oldX = this.getX_coordinate();
            int oldY = this.getY_coordinate();

            this.delayedMove(null);  // Call move() without KeyEvent

            // Check if the officer is colliding with a cone or parked car
            if (isCollidingWithCone(this.getX_coordinate(), this.getY_coordinate(), this.board.cones) ||
                isCollidingWithParkedCar(this.getX_coordinate(), this.getY_coordinate(), this.board.parkedCars)) {
                this.x_coordinate = oldX;
                this.y_coordinate = oldY;
            }

            //check if officer and mainCharacter are colliding, if so, game has ended
            if (this.board.officer.x_coordinate == this.board.main_character.getMainCharacterXCoordinate() 
                && this.board.officer.y_coordinate == this.board.main_character.getMainCharacterYCoordinate() && this.board.game_ended == false) {
                this.board.game_ended = true;
                this.board.cardLayout.show(this.board.cardPanel, "Lose Screen Concord");
            }

            this.board.repaint();  // Refresh the screen
        });
        officerTimer.start();
    }

    /**
     * Moves the ConcordOfficer towards the MainCharacter.
     */
    @Override
    protected void delayedMove(KeyEvent event) {
        int oldX = this.getX_coordinate();
        int oldY = this.getY_coordinate();

        // Use Dijkstra’s algorithm to find next step toward the player.
        java.util.List<Point> path = this.board.findPathDijkstra(
            this.getX_coordinate(),
            this.getY_coordinate(),
            this.board.main_character.getX_coordinate(),
            this.board.main_character.getY_coordinate()
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
                getImage("officer_east.png");
                // Move Left
            } else if (this.x_coordinate < oldX) {
                getImage("officer_west.png");
                // Move Down
            } else if (this.y_coordinate > oldY) {
                getImage("officer_south.png");
                // Move Up
            } else if (this.y_coordinate < oldY) { 
                getImage("officer_north.png");
            }
        }

    }
}
