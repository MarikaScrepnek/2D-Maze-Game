package com.sfuparkingmayhem.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Objects;

public class LostNote extends Reward {

    private int value = 10;
    private int expiryTime = 5; //put 5 seconds as the time limit

    LostNote(int x, int y) {
        super(x, y);
        getImage();
    }


    @Override
    protected void getImage() {
        try{
            this.theImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("lost_notes_resized.png")));
        }
        catch(IOException e){
            System.out.println("Error loading main" + e.getMessage());
        }
    }

    @Override
    protected boolean isCollected() {
        return collected;
    }

    public boolean getCollected(){
        return collected;
    }

    public void setCollected(boolean bool){
        this.collected = bool;
    }
}
