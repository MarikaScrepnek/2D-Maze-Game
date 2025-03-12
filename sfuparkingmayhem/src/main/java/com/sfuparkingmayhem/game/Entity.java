package com.sfuparkingmayhem.game;
import java.awt.Graphics; //for getting the image for the specific entity
import java.awt.image.BufferedImage; //used for drawing images/sprites on game board
import java.awt.image.ImageObserver;
import java.io.IOException;

//should this class be abstract since no "Entity" objects will be instantiated (always creating
//objects like MainCharacter, Concord officer, coins etc.)
public abstract class Entity {

    //the attributes of an entity on the game board
    protected int x_coordinate;
    protected int y_coordinate;
    protected BufferedImage theImage;

    //constructor for an Entity

    /**
     * Constructs an Entity
     *
     * @param x_coordinate x-coordinate of this Entity
     * @param y_coordinate y-coordinate of this Entity
     */
    protected Entity(int x_coordinate, int y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }
    /**
     * Gets the image of this Entity and throws IOExceptions e, if any, and prints out the error.
     * Sets theImage of the Entity to the corresponding png in the resources directory.
     *
     * @throws IOException e if there is an error with loading this Entity's image
     */
    //get the sprite image of this entity. Subclasses to override
    abstract protected void getImage();


    /**
     * Draws the image on board
     *
     * @param graphics
     * @param io
     */
    //draws the image on the gameboard
    //might not even need ImageObserver because ImageIO.read will be used to read the images. Remove later.
    protected void drawTheImage(Graphics graphics, ImageObserver io) {
        graphics.drawImage(theImage, this.x_coordinate*Board.CELL_SIZE, this.y_coordinate*Board.CELL_SIZE, io);
    }

    /**
     * Gets the x-coordinate of this Entity
     *
     * @return x-coordinate of this Entity as an int
     */

    protected int getX_coordinate() {
        return this.x_coordinate;
    }

    /**
     * Gets the y-coordinate of this Entity
     *
     * @return y-coordinate of this Entity as an int
     */
    protected int getY_coordinate() {
        return this.y_coordinate;
    }

    /**
     * Updates the Entity's position on the board
     */
    public void tick(){
        if (x_coordinate < 0) {
            x_coordinate = 0;
        } else if (x_coordinate >= Board.COLUMNS) {
            x_coordinate = Board.COLUMNS - 1;
        }
        // prevent the player from moving off the edge of the board vertically
        if (y_coordinate < 0) {
            y_coordinate = 0;
        } else if (y_coordinate >= Board.ROWS) {
            y_coordinate = Board.ROWS - 1;
        }
        }



}
