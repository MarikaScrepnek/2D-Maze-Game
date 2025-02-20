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
    private BufferedImage theImage;

    //constructor for an Entity
    protected Entity(int x_coordinate, int y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    //get the sprite image of this entity. Subclasses to override
    abstract protected void getImage();

    //draws the image on the gameboard
    protected void drawTheImage(Graphics graphics, ImageObserver io) {
        graphics.drawImage(theImage, x_coordinate, y_coordinate, io);
    }

}
