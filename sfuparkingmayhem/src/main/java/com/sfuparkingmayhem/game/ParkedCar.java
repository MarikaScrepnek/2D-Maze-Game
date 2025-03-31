package com.sfuparkingmayhem.game;

/**
 * This class extends the Barrier class and represents a ParkedCar.
 * 
 * @version 1.0
 */
public class ParkedCar extends Barrier{

    /**
     * Constructs a ParkedCar at the specified coordinates.
     *
     * @param x The x-coordinate of the ParkedCar.
     * @param y The y-coordinate of the ParkedCar.
     * @param board The board that the parked car is on.
     */
    public ParkedCar(int x, int y, Board board) {
        super (x, y, board);
        getImage("parked_car.png");
    }
}
