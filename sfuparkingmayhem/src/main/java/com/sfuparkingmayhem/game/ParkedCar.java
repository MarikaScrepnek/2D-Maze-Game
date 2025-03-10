package com.sfuparkingmayhem.game;

import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

public class ParkedCar extends Barrier{

    ParkedCar(int x, int y){
        super ( x, y);
        getImage();
    }

    @Override
    protected void getImage() {
        try{
            this.theImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("car_sprite_down.png")));
        }
        catch(IOException e){
            System.out.println("Error loading main" + e.getMessage());
        }
    }

}
