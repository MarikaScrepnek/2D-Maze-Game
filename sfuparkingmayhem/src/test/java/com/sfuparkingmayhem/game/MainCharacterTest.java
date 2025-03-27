package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.Point;


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

        // Y coordinate should decrease by 1
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
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        KeyEvent eventA = createKeyEvent(KeyEvent.VK_A, 'A');
        mainChar.delayedMove(eventA);

        // X coordinate should decrease by 1
        assertEquals(4, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());
        mainChar.keyReleased(eventA);
    }

    @Test
    public void moveMainCharacterLeftIntoBush(){
        mainChar.x_coordinate = 1;
        mainChar.y_coordinate = 5;
        KeyEvent eventA = createKeyEvent(KeyEvent.VK_A, 'A');
        mainChar.delayedMove(eventA);

        // Collision with bush should not change position.
        mainChar.tick();
        assertEquals(1, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());
        mainChar.keyReleased(eventA);
    }

    @Test
    public void moveMainCharacterLeftIntoCone(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        board.cones.add(new Cone(4, 5, board));
        KeyEvent eventA = createKeyEvent(KeyEvent.VK_A, 'A');
        mainChar.delayedMove(eventA);

        // Collision with cone should not change position.
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());
        mainChar.keyReleased(eventA);
    }

    @Test
    public void moveMainCharacterLeftIntoParkedCar(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        board.parkedCars.add(new ParkedCar(4, 5, board));
        KeyEvent eventA = createKeyEvent(KeyEvent.VK_A, 'A');
        mainChar.delayedMove(eventA);

        // Collision with parked car should not change position.
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());

        // Score should now be -5 and game_ended should be set to true.
        assertEquals(-5, board.score.getScore());
        assertTrue(board.game_ended, "Game should end on collision with parked car.");
        mainChar.keyReleased(eventA);
    }

    @Test
    public void moveMainCharacterRight(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        KeyEvent eventD = createKeyEvent(KeyEvent.VK_D, 'D');
        mainChar.delayedMove(eventD);

        // X coordinate should increase by 1
        assertEquals(6, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());
        mainChar.keyReleased(eventD);
    }

    @Test
    public void moveMainCharacterRightIntoBush(){
        mainChar.x_coordinate = 13;
        mainChar.y_coordinate = 5;
        KeyEvent eventD = createKeyEvent(KeyEvent.VK_D, 'D');
        mainChar.delayedMove(eventD);

        // Collision with bush should not change position.
        mainChar.tick();
        assertEquals(13, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());
        mainChar.keyReleased(eventD);
    }

    @Test
    public void moveMainCharacterRightIntoCone(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        board.cones.add(new Cone(6, 5, board));
        KeyEvent eventD = createKeyEvent(KeyEvent.VK_D, 'D');
        mainChar.delayedMove(eventD);

        // Collision with cone should not change position.
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());
        mainChar.keyReleased(eventD);
    }

    @Test
    public void moveMainCharacterRightIntoParkedCar(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        board.parkedCars.add(new ParkedCar(6, 5, board));
        KeyEvent eventD = createKeyEvent(KeyEvent.VK_D, 'D');
        mainChar.delayedMove(eventD);

        // Collision with parked car should not change position.
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());

        // Score should now be -5 and game_ended should be set to true.
        assertEquals(-5, board.score.getScore());
        assertTrue(board.game_ended, "Game should end on collision with parked car.");
        mainChar.keyReleased(eventD);
    }

    @Test
    public void moveMainCharacterDown(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        KeyEvent eventS = createKeyEvent(KeyEvent.VK_S, 'S');
        mainChar.delayedMove(eventS);

        // Y coordinate should increase by 1
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(6, mainChar.getY_coordinate());
        mainChar.keyReleased(eventS);
    }

    @Test
    public void moveMainCharacterDownIntoBush(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 13;
        KeyEvent eventS = createKeyEvent(KeyEvent.VK_S, 'S');
        mainChar.delayedMove(eventS);

        // Collision with bush should not change position.
        mainChar.tick();
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(13, mainChar.getY_coordinate());
        mainChar.keyReleased(eventS);
    }

    @Test
    public void moveMainCharacterDownIntoCone(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        board.cones.add(new Cone(5, 6, board));
        KeyEvent eventS = createKeyEvent(KeyEvent.VK_S, 'S');
        mainChar.delayedMove(eventS);

        // Collision with cone should not change position.
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());
        mainChar.keyReleased(eventS);
    }

    @Test
    public void moveMainCharacterDownIntoParkedCar(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        board.parkedCars.add(new ParkedCar(5, 6, board));
        KeyEvent eventS = createKeyEvent(KeyEvent.VK_S, 'S');
        mainChar.delayedMove(eventS);

        // Collision with parked car should not change position.
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());

        // Score should now be -5 and game_ended should be set to true.
        assertEquals(-5, board.score.getScore());
        assertTrue(board.game_ended, "Game should end on collision with parked car.");
        mainChar.keyReleased(eventS);
    }

    @Test
    public void testCollectCoins() {
        mainChar.x_coordinate = 2;
        mainChar.y_coordinate = 3;
        
        board.coins.clear();
        Coin coin1 = new Coin(2, 3, board);
        Coin coin2 = new Coin(4, 5, board);
        board.coins.add(coin1);
        board.coins.add(coin2);
        
        int initialScore = 0;
        int initialCount = 0;
        
        mainChar.collectCoins();
        
        assertEquals(1, board.coins.size(), "Only one coin should remain after collection");
        assertEquals(initialScore + 5, board.score.getScore(), "Score should increase by 5 after collecting a coin");
        
        int updatedCount = board.getCoinsCollectedCount();
        assertEquals(initialCount + 1, updatedCount, "coinsCollectedCount should be incremented by 1");
    }

    @Test
    public void testCollectLostNote() {
        mainChar.x_coordinate = 3;
        mainChar.y_coordinate = 4;

        board.ln = new CopyOnWriteArrayList<>();
        board.ln.clear();
        LostNote note = new LostNote(3, 4, board);
        board.ln.add(note);

        // Force note to be at (3, 4) instead of random position
        note.x_coordinate = 3;
        note.y_coordinate = 4;
        
        int initialScore = 0;
        
        mainChar.collectLostNote();
        
        assertEquals(0, board.ln.size(), "0 lost notes should remain after collection");
        assertEquals(initialScore + 10, board.score.getScore(), "Score should increase by 10 after collecting a lost note");

    }

}
