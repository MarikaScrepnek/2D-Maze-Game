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
            //load up orientation sprite
            try{
                this.theImage= ImageIO.read(new File("src/main/resources/car_sprite_up.png"));
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

        //moving left with A key
        else if (keyCode == KeyEvent.VK_A){
            x_coordinate = x_coordinate - 1;
            //load left orientation sprite
            try{
                this.theImage= ImageIO.read(new File("src/main/resources/car_sprite_left.png"));
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

        //moving down with S key
        else if (keyCode == KeyEvent.VK_S){
            y_coordinate = y_coordinate + 1;
            //load down orientation sprite
            try{
                this.theImage= ImageIO.read(new File("src/main/resources/car_sprite_down.png"));
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

        //moving right with D key
        else if (keyCode == KeyEvent.VK_D){
            x_coordinate = x_coordinate + 1;
            //load right orientation sprite
            try{
                this.theImage= ImageIO.read(new File("src/main/resources/car_sprite_right.png"));
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

    }
    // prevents player from going out of bounds
    protected void tickCharacter() {
        // temporary variables to store new position
        int tempX = x_coordinate;
        int tempY = y_coordinate;

        if (isValidMove(tempX,tempY)) {
            x_coordinate = tempX;
            y_coordinate = tempY;
        } else {
            x_coordinate = Math.max(0, Math.min(Board.COLUMNS - 1, x_coordinate));
            y_coordinate = Math.max(0, Math.min(Board.ROWS - 1, y_coordinate));
        }
    }

    protected boolean isValidMove(int newX, int newY) {
        
        return true;
    }

}
