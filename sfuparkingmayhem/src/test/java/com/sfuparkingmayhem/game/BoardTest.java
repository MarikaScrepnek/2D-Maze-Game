package com.sfuparkingmayhem.game;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {

    Board board;
    CardLayout cardLayout;
    JPanel cardPanel;
    LostNote ln;
    EntityLists entityLists;

    @BeforeEach
    public void setUp(){

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        board = new Board(cardLayout, cardPanel);
        ln = new LostNote(0, 0, board);

        entityLists = new EntityLists();
    }

    @Test
    public void testBoardConstruction() {
        assertNotNull(board, "Board should not be null after setup.");
    }

    @Test
    void testLostNoteInitial() {
        assertEquals(1, board.entityLists.ln.size());
    }

    /*@Test 
    void testLostNoteTimer() throws InterruptedException {
        int initialSize = board.entityLists.ln.size();

        Thread.sleep(7000);

        assertEquals(initialSize, board.entityLists.ln.size()); 
    }*/
    
    @Test
    void testLostNoteAdd() {
        board.entityLists.ln.add(new LostNote(1,3, board));

        assertFalse(board.entityLists.ln.isEmpty());

        assertEquals(2, board.entityLists.ln.size());
    }
    @Test
    void testLostNoteRemove() {
        board.entityLists.ln.remove(0);
        assertTrue(board.entityLists.ln.isEmpty());
        assertEquals(0, board.entityLists.ln.size());
    }
    
    @Test
    void testCheckGameEndTrue() {
        MainCharacter mainCharacter = new MainCharacter(14, 13, board);  // Position matches the condition for game end
        board.main_character = mainCharacter;

        // Clear coins list to simulate coins being collected
        board.entityLists.coins.clear();

        // Create and trigger an action event
        ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "test");
        board.actionPerformed(event);

        assertTrue(board.game_ended);  // Ensure the game is marked as ended
        assertTrue(cardPanel.getComponentCount() > 0);  // Check if a component was added to the card panel (for WinScreen)

        // Now ensure the win screen is not added again on the second call to actionPerformed
        int initialComponentCount = cardPanel.getComponentCount();
        board.actionPerformed(event);
        assertEquals(initialComponentCount, cardPanel.getComponentCount(), "Win screen should not be added again.");
    }
}
