package com.sfuparkingmayhem.game;

import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

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
        getImage();
    }

    @Override
    protected void getImage() {
        try{
            this.theImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("parked_car.png")));
        }
        catch(IOException e){
            System.out.println("Error loading main" + e.getMessage());
        }
    }
}
