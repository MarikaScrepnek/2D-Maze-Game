package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;


public class MainCharacterTest {


    MainCharacter mainChar;
    Board board;
    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setUp() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        board = new Board(cardLayout, cardPanel);

        // Clear obstacles
        board.cones.clear();
        board.parkedCars.clear();

        // Create a main character at (1,2)
        mainChar = new MainCharacter(1, 2, board);
        board.main_character = mainChar;

        // Reset score and game_ended for collision tests.
        board.score.reset();
        board.game_ended = false;
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
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 1;
        KeyEvent eventW = createKeyEvent(KeyEvent.VK_W, 'W');
        mainChar.delayedMove(eventW);
        mainChar.tick();

        // Collision with bush should not change position.
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(1, mainChar.getY_coordinate());
        mainChar.keyReleased(eventW);
    }

    @Test
    public void moveMainCharacterUpwardIntoCone(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        board.cones.add(new Cone(5, 4, board));
        KeyEvent eventW = createKeyEvent(KeyEvent.VK_W, 'W');
        mainChar.delayedMove(eventW);
        
        // Collision with cone should not change position.
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());
        mainChar.keyReleased(eventW);
    }

    @Test
    public void moveMainCharacterUpwardIntoParkedCar(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        board.parkedCars.add(new ParkedCar(5, 4, board));
        KeyEvent eventW = createKeyEvent(KeyEvent.VK_W, 'W');
        mainChar.delayedMove(eventW);

        // Collision with parked car should not change position.
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());
        
        // Score should now be -5 and game_ended should be set to true.
        assertEquals(-5, board.score.getScore());
        assertTrue(board.game_ended, "Game should end when score falls below 0 after collision with a parked car.");
        mainChar.keyReleased(eventW);
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
