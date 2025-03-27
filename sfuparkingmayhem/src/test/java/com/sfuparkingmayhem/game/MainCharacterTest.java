package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;


public class MainCharacterTest {


    MainCharacter mainChar;
    Board aBoard;
    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setUp() {
            
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        aBoard = new Board(cardLayout, cardPanel);

        mainChar = new MainCharacter(1, 2, aBoard);
    }

    private KeyEvent createKeyEvent(int keyCode, char keyChar) {
        return new KeyEvent(new JPanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, keyChar);
    }

    @Test
    public void testMainCharacterConstruction() {
        assertNotNull(mainChar, "MainCharacter should not be null after setup.");
    }

    @Test
    public void getMainCharacterXCoordinate(){

        int x_coord = mainChar.getX_coordinate();

        assertEquals(1, x_coord);
    }
    

    @Test
    public void getMainCharacterYCoordinate(){

        int y_coord = mainChar.getY_coordinate();

        assertEquals(2, y_coord);
    }

    @Test
    public void moveMainCharacterUpward(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        KeyEvent eventW = createKeyEvent(KeyEvent.VK_W, 'W');
        mainChar.delayedMove(eventW);
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(4, mainChar.getY_coordinate());
        mainChar.keyReleased(eventW);
    }

    @Test
    public void moveMainCharacterUpwardIntoBush(){

    }

    @Test
    public void moveMainCharacterUpwardIntoCone(){

    }

    @Test
    public void moveMainCharacterUpwardIntoParkedCar(){

    }

    @Test
    public void moveMainCharacterLeft(){

    }

    @Test
    public void moveMainCharacterLeftIntoBush(){

    }

    @Test
    public void moveMainCharacterLeftIntoCone(){

    }

    @Test
    public void moveMainCharacterLeftIntoParkedCar(){

    }

    @Test
    public void moveMainCharacterRight(){

    }

    @Test
    public void moveMainCharacterRightIntoBush(){

    }

    @Test
    public void moveMainCharacterRightIntoCone(){

    }

    @Test
    public void moveMainCharacterRightIntoParkedCar(){

    }

    @Test
    public void moveMainCharacterDown(){

    }

    @Test
    public void moveMainCharacterDownIntoBush(){

    }

    @Test
    public void moveMainCharacterDownIntoCone(){

    }

    @Test
    public void moveMainCharacterDownIntoParkedCar(){

    }

}
