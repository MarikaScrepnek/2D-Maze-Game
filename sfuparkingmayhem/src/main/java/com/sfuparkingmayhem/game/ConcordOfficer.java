package com.sfuparkingmayhem.game;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

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

        startOfficerTimer(x_coordinate, y_coordinate, board);
    }


    /**
     * Starts the timer for the ConcordOfficer.
     * @param x_coordinate
     * @param y_coordinate
     * @param board
     */
    private void startOfficerTimer(int x_coordinate, int y_coordinate, Board board) {
        officerTimer = new Timer(500, e -> {
            int oldX = this.getX_coordinate();
            int oldY = this.getY_coordinate();

            this.delayedMove(null);  // Call move() without KeyEvent

            officerCollision(oldX, oldY); // Check for collision with cones or parked cars

            this.board.repaint();  // Refresh the screen
        });
        officerTimer.start();
    }

    /**
     * Checks if the ConcordOfficer is colliding with a cone or parked car and Main Character.
     * @param oldX
     * @param oldY
     */
    private void officerCollision(int oldX, int oldY) {
        // Check if the officer is colliding with a cone or parked car
        if (isCollidingWithCone(this.getX_coordinate(), this.getY_coordinate()) ||
        isCollidingWithParkedCar(this.getX_coordinate(), this.getY_coordinate())) {
            this.x_coordinate = oldX;
            this.y_coordinate = oldY;
        }

        //check if officer and mainCharacter are colliding, if so, game has ended
        if (this.board.officer.getX_coordinate() == this.board.main_character.getX_coordinate() 
            && this.board.officer.getY_coordinate() == this.board.main_character.getY_coordinate() && this.board.game_ended == false) {
            this.board.game_ended = true;
            this.board.cardLayout.show(this.board.cardPanel, "Lose Screen Concord");
        }
    }

    /**
     * Moves the ConcordOfficer towards the MainCharacter.
     */
    @Override
    protected void delayedMove(KeyEvent event) {
        int oldX = this.getX_coordinate();
        int oldY = this.getY_coordinate();

        // Use Dijkstra’s algorithm to find next step toward the player.
        java.util.List<Point> path = findPathDijkstra(
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
    /**
     * Finds the shortest path from start to end using Dijkstra's algorithm.
     * 
     * @param startX The x-coordinate of the start cell.
     * @param startY The y-coordinate of the start cell.
     * @param endX The x-coordinate of the end cell.
     * @param endY The y-coordinate of the end cell.
     * @return A list of points representing the path from start to end, or null if no path exists.
     */
    public List<Point> findPathDijkstra(int startX, int startY, int endX, int endY) {
        // If the start or end is blocked, no path
        if (this.board.isCellBlocked(startX, startY) || this.board.isCellBlocked(endX, endY)) {
            return null;
        }

        // Distances array
        int[][] dist = new int[Board.DIMENSIONS.get_rows()][Board.DIMENSIONS.get_columns()];
        for (int r = 0; r < Board.DIMENSIONS.get_rows(); r++) {
            Arrays.fill(dist[r], Integer.MAX_VALUE);
        }

        Point[][] parent = new Point[Board.DIMENSIONS.get_rows()][Board.DIMENSIONS.get_columns()]; // store predecessor

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
                if (!this.board.isCellBlocked(neighbourX, neighbourY)) {
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
     * Reconstructs the path from start to end using the parent array.
     * 
     * @param parent The parent array.
     * @param startX The x-coordinate of the start cell.
     * @param startY The y-coordinate of the start cell.
     * @param endX The x-coordinate of the end cell.
     * @param endY The y-coordinate of the end cell.
     * @return A list of points representing the path from start to end.
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

    /**
    * Inner class to store a point and its distance.
    */
    private static class PointDistance {

        /**
         * distance fields/attributes
         */
        int x, y, distance;

        /**
         * Constructs a PointDistance object.
         * 
         * @param x The x-coordinate of the point.
         * @param y The y-coordinate of the point.
         * @param dist The distance of the point.
         */
        PointDistance(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.distance = dist;
        }
    }
}
