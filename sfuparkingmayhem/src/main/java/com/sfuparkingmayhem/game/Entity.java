package com.sfuparkingmayhem.game;
import java.awt.Graphics; //for getting the image for the specific entity
import java.awt.image.BufferedImage; //used for drawing images/sprites on game board
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

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
    /**
     * The board that the entity belongs to.
     */
    protected Board board;

    //constructor for an Entity

    /**
     * Constructs an Entity
     *
     * @param x_coordinate x-coordinate of this Entity
     * @param y_coordinate y-coordinate of this Entity
     * @param board The board that the entity is on.
     */
    protected Entity(int x_coordinate, int y_coordinate, Board board) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.board = board;
    }
    /**
     * Gets the image of this Entity and throws IOExceptions e, if any, and prints out the error.
     * Sets theImage of the Entity to the corresponding png in the resources directory.
     * 
     * @param path The path name of the image to load in the resources folder.
     */
    protected void getImage(String path) {
        try{
            // var resourceStream = getClass().getClassLoader().getResourceAsStream(path);
            // if (resourceStream == null) {
            //     throw new IOException("Resource not found: " + path);
            // }
            this.theImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(path)));
        }
        catch(IOException e){
            System.out.println("Error loading image" + e.getMessage());
        }
    }


    /**
     * Draws this Entity's png image, from resources directory, onto game board at this Entity's
     * x and y coordinates. io will usually be passed as "this" since images are already loaded into resources directory.
     *
     * @param graphics helps draw this Entity's png on the board
     * @param io helps monitor the image being loaded for this Entity
     */
    protected void drawTheImage(Graphics graphics, ImageObserver io) {
        graphics.drawImage(theImage, this.x_coordinate*Board.DIMENSIONS.get_cell_size(), this.y_coordinate*Board.DIMENSIONS.get_cell_size(), io);
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
}
