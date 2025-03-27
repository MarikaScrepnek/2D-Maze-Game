package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

import com.github.stefanbirkner.systemlambda.SystemLambda;

//abstract class
public class EntityTest {

    Entity entityMainChar;
    Entity entityOfficer;
    Entity entityCone;
    Entity entityCoin;
    Entity entityLostNote;
    Entity entityParkedCar;
    Entity entityBarrier; 
    Board aBoard;
    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setUp(){
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        aBoard = new Board(cardLayout, cardPanel);
    }

    @Test
    public void createMainCharacterEntity(){
        entityMainChar = new MainCharacter(1,2,aBoard);
        assertNotNull(entityMainChar);
    }

    @Test
    public void createConcordOfficerEntity(){
        entityOfficer = new ConcordOfficer(1,2,aBoard);
        assertNotNull(entityOfficer);

    }

    @Test
    public void createConeEntity(){
        entityCone = new Cone(2, 3, aBoard);
        assertNotNull(entityCone);
    }

    @Test
    public void createCoinEntity(){
        entityCoin = new Coin(4, 5, aBoard);
        assertNotNull(entityCoin);
    }

    @Test
    public void createLostNoteEntity(){
        entityLostNote = new LostNote(6, 7, aBoard);
        assertNotNull(entityLostNote);
    }

    @Test
    public void createParkedCarEntity(){
        entityParkedCar = new ParkedCar(8, 9, aBoard);
        assertNotNull(entityParkedCar);
    }

    @Test
    public void createBarrierEntity(){
        entityBarrier = new Barrier(10, 11, aBoard);
        assertNotNull(entityBarrier);
    }

    @Test
    void testDrawEntity(){
        // Create a mock Graphics object
        Graphics mockGraphics = Mockito.mock(Graphics.class);

        // Create a mock ImageObserver object
        ImageObserver mockImageObserver = Mockito.mock(ImageObserver.class);

        // Create an entity and set its image
        entityCone = new Cone(1, 2, aBoard);
        entityCone.getImage("cone.png");

        // Call the drawTheImage method
        entityCone.drawTheImage(mockGraphics, mockImageObserver);

        // Verify that the drawImage method was called with the correct parameters
        Mockito.verify(mockGraphics).drawImage(
            Mockito.eq(entityCone.theImage),
            Mockito.eq(entityCone.getX_coordinate() * Board.CELL_SIZE),
            Mockito.eq(entityCone.getY_coordinate() * Board.CELL_SIZE),
            Mockito.eq(mockImageObserver)
        );
    }
    @Test
    void testGetImageHandlesException() throws Exception {
        // // Create an entity (e.g., Cone) with valid coordinates
        Entity entityCone = new Cone(1, 2, new Board(new CardLayout(), new JPanel()));

        //create a "comparison" exception and string
        Exception exception = null;
        String message ="";

        try {
            // Attempt to load a non-existent image file
            entityCone.getImage("non_existent_image.png");
        } catch (Exception e) {

            //update the message (string) and the exception
            exception = e; 
            message=e.getMessage();
        } finally{


        //make sure there is an exception because the image does not exist
        assertNotNull(exception);

        //verify that the messages match
        assertEquals(message, exception.getMessage());
        }
    

    }
}
