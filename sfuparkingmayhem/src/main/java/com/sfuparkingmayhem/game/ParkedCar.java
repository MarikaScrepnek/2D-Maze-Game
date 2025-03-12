package com.sfuparkingmayhem.game;

import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

public class ParkedCar extends Barrier{
    /**
     * Constructs a ParkedCar at the specified coordinates.
     * It is a Barrier that the MainCharacter cannot pass through and subtracts 5 points from the score if the MainCharacter collides with it.
     *
     * @param x The x-coordinate of the ParkedCar.
     * @param y The y-coordinate of the ParkedCar.
     */
    ParkedCar(int x, int y){
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
