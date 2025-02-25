package com.sfuparkingmayhem.game;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainCharacter extends MovingEntity {

    private int score;

    /**
     * Constructs this MainCharacter and sets this MainCharacter's image
     *
     * @param x_coordinate x-coordinate where MainCharcter is on board
     * @param y_coordinate y-coordinate where MainCharcter is on board
     */
    //constructor for the MainCharcter
    MainCharacter(int x_coordinate, int y_coordinate) {
        super( x_coordinate, y_coordinate);
        //setImage();
        getImage();
    }

    //sets the image for the moving entity
//    private void setImage (){
//        try{
//            this.theImage= ImageIO.read(new File("resources/blue_square.png"));
//        }
//        catch(IOException e){
//            System.out.println(e.getMessage());
//        }
//    }


    @Override
    protected void getImage(){
        try{
            this.theImage= ImageIO.read(new File("src/main/resources/car_sprite_right.png"));

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    protected void move (KeyEvent event){

        //get key code for the specific key that was pressed on keyboard
        int keyCode = event.getKeyCode();

        //moving up with W key
        if(keyCode == KeyEvent.VK_W){
            y_coordinate = y_coordinate - 1;
        }

        //moving left with A key
        else if (keyCode == KeyEvent.VK_A){
            x_coordinate = x_coordinate - 1;
        }

        //moving down with S key
        else if (keyCode == KeyEvent.VK_S){
            y_coordinate = y_coordinate + 1;
        }

        //moving right with D key
        else if (keyCode == KeyEvent.VK_D){
            x_coordinate = x_coordinate + 1;
        }

    }

    //potentially add a tick method (name it something else though)
    protected void tickCharacter() {
        // prevents the player from moving off the board horizontally
        if (x_coordinate < 0) {
            x_coordinate = 0;
        }
        else if (x_coordinate >= Board.COLUMNS) {
            x_coordinate = Board.COLUMNS - 1;
        }
        // prevents the player from moving off the board vertically
        if (y_coordinate < 0) {
            y_coordinate = 0;
        }
        else if (y_coordinate >= Board.ROWS) {
            y_coordinate = Board.ROWS - 1;
        }
    }

}
