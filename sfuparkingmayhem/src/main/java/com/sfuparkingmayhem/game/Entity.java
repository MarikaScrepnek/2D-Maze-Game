package com.sfuparkingmayhem.game;
import java.awt.Graphics; //for getting the image for the specific entity
import java.awt.image.BufferedImage; //used for drawing images/sprites on game board
import java.awt.image.ImageObserver;

//should this class be abstract since no "Entity" objects will be instantiated (always creating
//objects like MainCharacter, Concord officer, coins etc.)

/**
 * This class provides methods for different entities {@link MovingEntity} and  {@link StaticEntity} to get x and y coordinates to be 
 * placed on the board, getting the entities' images and drawing them on the board. 
 * 
 * @author Group 25
 * @version 1.0
 */
public abstract class Entity {

    /**
     * The x coordinate of the entity on the board.
     */
    protected int x_coordinate;
    /**
     * The y coordinate of the entity on the board.
     */
    protected int y_coordinate;
    /**
     * The entity's image/sprite
     */
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
     */
    abstract protected void getImage();


    /**
     * Draws this Entity's png image, from resources directory, onto game board at this Entity's
     * x and y coordinates. io will usually be passed as "this" since images are already loaded into resources directory.
     *
     * @param graphics helps draw this Entity's png on the board
     * @param io helps monitor the image being loaded for this Entity
     */
    protected void drawTheImage(Graphics graphics, ImageObserver io) {
        graphics.drawImage(theImage, this.x_coordinate*Board.CELL_SIZE, this.y_coordinate*Board.CELL_SIZE, io);
    }




    /**
     * Gets the x-coordinate of this Entity.
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
     * Updates this Entity's position on the board
     */
    public void tick(){

        //prevent this Entity from going off the board horizontally
        if (x_coordinate < 0) {
            x_coordinate = 0;
        } 
        
        else if (x_coordinate >= Board.COLUMNS) {
            x_coordinate = Board.COLUMNS - 1;
        }

        // prevent the player from moving off the edge of the board vertically
        if (y_coordinate < 0) {
            y_coordinate = 0;
        } 
        
        else if (y_coordinate >= Board.ROWS) {
            y_coordinate = Board.ROWS - 1;
        }
        }



}
