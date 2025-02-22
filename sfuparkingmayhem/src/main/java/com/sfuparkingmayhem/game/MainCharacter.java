package com.sfuparkingmayhem.game;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public abstract class MainCharacter extends MovingEntity {

    //constructor for the MainCharcter
    MainCharacter(int x_coordinate, int y_coordinate) {
        super( x_coordinate, y_coordinate);
        setImage();
    }

    //sets the image for the moving entity
    private void setImage (){
        try{
            this.theImage= ImageIO.read(new File("resources/blue_square.png"));
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}
