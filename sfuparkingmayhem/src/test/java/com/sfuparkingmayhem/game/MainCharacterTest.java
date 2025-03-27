package com.sfuparkingmayhem.game;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
        board.entityLists.cones.clear();
        board.entityLists.parkedCars.clear();

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
        board.entityLists.cones.add(new Cone(5, 4, board));
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
        board.entityLists.parkedCars.add(new ParkedCar(5, 4, board));
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
        board.entityLists.cones.add(new Cone(4, 5, board));
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
        board.entityLists.parkedCars.add(new ParkedCar(4, 5, board));
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
        board.entityLists.cones.add(new Cone(6, 5, board));
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
        board.entityLists.parkedCars.add(new ParkedCar(6, 5, board));
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
        board.entityLists.cones.add(new Cone(5, 6, board));
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
        board.entityLists.parkedCars.add(new ParkedCar(5, 6, board));
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
    public void testRandomKeyPress() {
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        KeyEvent event = createKeyEvent(KeyEvent.VK_X, 'X');
        mainChar.delayedMove(event);

        // Position should not change
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(5, mainChar.getY_coordinate());
        mainChar.keyReleased(event);
    }

    @Test
    public void testCollectCoins() {
        mainChar.x_coordinate = 2;
        mainChar.y_coordinate = 3;
        
        board.entityLists.coins.clear();
        Coin coin1 = new Coin(2, 3, board);
        Coin coin2 = new Coin(4, 5, board);
        board.entityLists.coins.add(coin1);
        board.entityLists.coins.add(coin2);
        
        int initialScore = 0;
        int initialCount = 0;
        
        mainChar.collectCoins();
        
        assertEquals(1, board.entityLists.coins.size(), "Only one coin should remain after collection");
        assertEquals(initialScore + 5, board.score.getScore(), "Score should increase by 5 after collecting a coin");
        
        int updatedCount = board.getCoinsCollectedCount();
        assertEquals(initialCount + 1, updatedCount, "coinsCollectedCount should be incremented by 1");
    }

    @Test
    public void testDontCollectCoins(){
        mainChar.x_coordinate = 2;
        mainChar.y_coordinate = 3;
        
        board.coins.clear();
        Coin coin1 = new Coin(2, 5, board);
        board.coins.add(coin1);
        
        int initialScore = 0;
        int initialCount = 0;
        
        mainChar.collectCoins();
        
        assertEquals(1, board.coins.size(), "Only one coin should remain after collection");
        assertEquals(initialScore, board.score.getScore(), "Score should not increase after collecting a coin");
        
        int updatedCount = board.getCoinsCollectedCount();
        assertEquals(initialCount, updatedCount, "coinsCollectedCount should not be incremented");
    }

    @Test
    public void testCollectLostNote() {
        mainChar.x_coordinate = 3;
        mainChar.y_coordinate = 4;

        board.entityLists.ln = new ArrayList<>();
        board.entityLists.ln.clear();
        LostNote note = new LostNote(3, 4, board);
        board.entityLists.ln.add(note);

        // Force note to be at (3, 4) instead of random position
        note.x_coordinate = 3;
        note.y_coordinate = 4;
        
        int initialScore = 0;
        
        mainChar.collectLostNote();
        
        assertEquals(0, board.entityLists.ln.size(), "0 lost notes should remain after collection");
        assertEquals(initialScore + 10, board.score.getScore(), "Score should increase by 10 after collecting a lost note");
    }

    @Test
    public void testDontCollectLostNoteY(){
        mainChar.x_coordinate = 3;
        mainChar.y_coordinate = 4;

        board.ln = new ArrayList<>();
        board.ln.clear();
        LostNote note = new LostNote(3, 5, board);
        board.ln.add(note);

        // Force note to be at (3, 5) instead of random position
        note.x_coordinate = 3;
        note.y_coordinate = 5;
        
        int initialScore = 0;
        
        mainChar.collectLostNote();
        
        assertEquals(1, board.ln.size(), "1 lost note should remain after collection");
        assertEquals(initialScore, board.score.getScore(), "Score should not increase after collecting a lost note");
    }

    @Test
    public void testDontCollectLostNoteX(){
        mainChar.x_coordinate = 3;
        mainChar.y_coordinate = 4;

        board.ln = new ArrayList<>();
        board.ln.clear();
        LostNote note = new LostNote(4, 4, board);
        board.ln.add(note);

        // Force note to be at (4, 4) instead of random position
        note.x_coordinate = 4;
        note.y_coordinate = 4;
        
        int initialScore = 0;
        
        mainChar.collectLostNote();
        
        assertEquals(1, board.ln.size(), "1 lost note should remain after collection");
        assertEquals(initialScore, board.score.getScore(), "Score should not increase after collecting a lost note");
    }

    @Test
    public void moveMainCharacterUpwardOutOfEntranceCell(){
        mainChar.x_coordinate = 0;
        mainChar.y_coordinate = 1;
        KeyEvent eventW = createKeyEvent(KeyEvent.VK_W, 'W');
        mainChar.delayedMove(eventW);

        // Y coordinate should not change
        assertEquals(0, mainChar.getX_coordinate());
        assertEquals(1, mainChar.getY_coordinate());
        mainChar.keyReleased(eventW);
    }

    @Test
    public void moveMainCharacterDownOutOfEntranceCell(){
        mainChar.x_coordinate = 0;
        mainChar.y_coordinate = 1;
        KeyEvent eventS = createKeyEvent(KeyEvent.VK_S, 'S');
        mainChar.delayedMove(eventS);

        // Y coordinate should not change
        assertEquals(0, mainChar.getX_coordinate());
        assertEquals(1, mainChar.getY_coordinate());
        mainChar.keyReleased(eventS);
    }

    @Test
    public void moveMainCharacterRightOutOfEntranceCell(){
        mainChar.x_coordinate = 0;
        mainChar.y_coordinate = 1;
        KeyEvent eventD = createKeyEvent(KeyEvent.VK_D, 'D');
        mainChar.delayedMove(eventD);

        // X coordinate should not change
        assertEquals(1, mainChar.getX_coordinate());
        assertEquals(1, mainChar.getY_coordinate());
        mainChar.keyReleased(eventD);
    }

    @Test
    public void moveMainCharacterUpwardOutOfExitCell(){
        mainChar.x_coordinate = 14;
        mainChar.y_coordinate = 13;
        KeyEvent eventW = createKeyEvent(KeyEvent.VK_W, 'W');
        mainChar.delayedMove(eventW);

        // Y coordinate should not change
        assertEquals(14, mainChar.getX_coordinate());
        assertEquals(13, mainChar.getY_coordinate());
        mainChar.keyReleased(eventW);
    }

    @Test
    public void moveMainCharacterDownOutOfExitCell(){
        mainChar.x_coordinate = 14;
        mainChar.y_coordinate = 13;
        KeyEvent eventS = createKeyEvent(KeyEvent.VK_S, 'S');
        mainChar.delayedMove(eventS);

        // Y coordinate should not change
        assertEquals(14, mainChar.getX_coordinate());
        assertEquals(13, mainChar.getY_coordinate());
        mainChar.keyReleased(eventS);
    }

    @Test
    public void moveMainCharacterLeftOutOfExitCell(){
        mainChar.x_coordinate = 14;
        mainChar.y_coordinate = 13;
        KeyEvent eventA = createKeyEvent(KeyEvent.VK_A, 'A');
        mainChar.delayedMove(eventA);

        // X coordinate should not change
        assertEquals(13, mainChar.getX_coordinate());
        assertEquals(13, mainChar.getY_coordinate());
        mainChar.keyReleased(eventA);
    }

    @Test
    public void testMainCharacterOutOfLeftBound(){
        mainChar.x_coordinate = -1;
        mainChar.y_coordinate = 1;
        mainChar.tick();

        // X coordinate should revert to 0
        assertEquals(0, mainChar.getX_coordinate());
        assertEquals(1, mainChar.getY_coordinate());
    }

    @Test
    public void testMainCharacterOutOfRightBound(){
        mainChar.x_coordinate = 15;
        mainChar.y_coordinate = 13;
        mainChar.tick();

        // X coordinate should revert to 14
        assertEquals(14, mainChar.getX_coordinate());
        assertEquals(13, mainChar.getY_coordinate());
    }

    @Test
    public void testMainCharacterOutOfUpperBound(){
        mainChar.x_coordinate = 1;
        mainChar.y_coordinate = -1;
        mainChar.tick();

        // Y coordinate should revert to 0
        assertEquals(1, mainChar.getX_coordinate());
        assertEquals(1, mainChar.getY_coordinate());
    }

    @Test
    public void testMainCharacterOutOfLowerBound(){
        mainChar.x_coordinate = 1;
        mainChar.y_coordinate = 15;
        mainChar.tick();

        // Y coordinate should revert to 13
        assertEquals(1, mainChar.getX_coordinate());
        assertEquals(13, mainChar.getY_coordinate());
    }

    @Test
    public void testKeyHeldDown(){
        mainChar.x_coordinate = 5;
        mainChar.y_coordinate = 5;
        KeyEvent eventW = createKeyEvent(KeyEvent.VK_W, 'W');

        mainChar.delayedMove(eventW);

        // Y coordinate should decrease by 1
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(4, mainChar.getY_coordinate());

        mainChar.delayedMove(eventW);

        // Y coordinate should stay the same
        assertEquals(5, mainChar.getX_coordinate());
        assertEquals(4, mainChar.getY_coordinate());
        mainChar.keyReleased(eventW);
    }

}
