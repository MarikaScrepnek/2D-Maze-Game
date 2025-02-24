package com.sfuparkingmayhem.game;
import javax.imageio.ImageIO; //for getting the image for the specific entity
import java.awt.Graphics; //used for drawing images/sprites on game board
import java.awt.image.ImageObserver;
import java.awt.image.BufferedImage; //used for getting an image

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
     * Gets the image of this Entity's image from resources directory.
     */
    //get the sprite image of this entity. Subclasses to override
    abstract protected void getImage();

    //draws the image on the gameboard
    //might not even need ImageObserver because ImageIO.read will be used to read the images. Remove later.
    protected void drawTheImage(Graphics graphics, ImageObserver io) {
        graphics.drawImage(theImage, x_coordinate, y_coordinate, io);
    }

}
