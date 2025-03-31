package com.sfuparkingmayhem.game;


/**
 * This EntityCoordinates class contains 2D arraylists to hold the X and Y coordinates of the StaticEntities
 * and a constructor.
 *
 * @author Group25
 * @version 1.0
 */
public class EntityCoordinates  {

    /**
     * Array holding the coordinates for coins.
     */
    protected int[][] coin_coords;

    /**
     * Array holding the coordinates for cones.
     */
    protected int[][] cone_coords;

    /**
     * Array holding the coordinates for parked cars.
     */
    protected int[][] pc_coords = {{2, 6, 8, 12, 12, 3, 4, 4, 8, 9}, {2, 5, 5, 6, 7, 7, 11, 12, 11, 11}};

    EntityCoordinates(){
        coin_coords = new int[][] {{2, 7, 10, 7, 3, 11, 6, 12, 9, 3}, {3, 2, 4, 5, 8, 8, 9, 11, 12, 13}};
        cone_coords = new int[][] {{4, 11, 12, 4, 9, 6, 12, 2, 10, 7}, {3, 3, 3, 5, 7, 8,9, 10, 10, 13}};
        pc_coords = new int [][] {{2, 6, 8, 12, 12, 3, 4, 4, 8, 9}, {2, 5, 5, 6, 7, 7, 11, 12, 11, 11}};

    }
    
}
