package com.sfuparkingmayhem.game;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Cone extends Barrier{
    /**
     * Constructs a Cone at the specified coordinates.
     * It is a Barrier that the MainCharacter cannot pass through.
     *
     * @param x The x-coordinate of the Cone.
     * @param y The y-coordinate of the Cone.
     */
    Cone (int x, int y){
        super(x,y);
        getImage();
    }

    @Override
    protected void getImage() {
        try{
            this.theImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("cone.png")));
        }
        catch(IOException e){
            System.out.println("Error loading main" + e.getMessage());
        }
    }
}
