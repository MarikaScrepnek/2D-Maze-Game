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
     */
    public ParkedCar(int x, int y) {
        super ( x, y);
        getImage("parked_car.png");
    }
}
