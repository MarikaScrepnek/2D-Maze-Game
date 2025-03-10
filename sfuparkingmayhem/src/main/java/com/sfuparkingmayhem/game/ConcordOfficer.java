package com.sfuparkingmayhem.game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;


public class ConcordOfficer extends MovingEntity{
    // Reference to the MainCharacter
    private MainCharacter target;

    /**
     * Constructs a ConcordOfficer that will chase the MainCharacter.
     *
     * @param x_coordinate The initial x-coordinate of this ConcordOfficer.
     * @param y_coordinate The initial y-coordinate of this ConcordOfficer.
     * @param target       The MainCharacter to chase.
     */
    public ConcordOfficer(int x_coordinate, int y_coordinate, MainCharacter target) {
        super(x_coordinate, y_coordinate);
        this.target = target;
        getImage(); // Load the sprite/image for this entity
    }

    /**
     * Moves the ConcordOfficer towards the MainCharacter.
     */

    protected void move(KeyEvent event) {

        if (this.x_coordinate < target.getX_coordinate()) {
            this.x_coordinate++;
        } else if (this.x_coordinate > target.getX_coordinate()) {
            this.x_coordinate--;
        }
    
        else if(this.y_coordinate < target.getY_coordinate()) {
            this.y_coordinate++;
        } else if (this.y_coordinate > target.getY_coordinate()) {
            this.y_coordinate--;
        }

        // If Concord officer is out of bounds, move it back to the board
        if (this.x_coordinate < 1) {
            this.x_coordinate = 1;
        } else if (this.x_coordinate >= Board.COLUMNS-1) {
            this.x_coordinate = Board.COLUMNS - 2;
        }
        if (this.y_coordinate < 1) {
            this.y_coordinate = 1;
        } else if (this.y_coordinate >= Board.ROWS-1) {
            this.y_coordinate = Board.ROWS - 2;
        }

    }
    

    @Override
    protected void getImage() {
        try{
            this.theImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("officer_placeholder.png"));

        }
        catch(IOException e){
            System.out.println("Error displaying officer" + e.getMessage());
        }
    }
    
}
