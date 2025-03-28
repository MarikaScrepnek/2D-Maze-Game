package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void testLostNoteTimer() throws InterruptedException {
        int initialSize = board.entityLists.ln.size();

        Thread.sleep(7000);

        assertEquals(initialSize, board.entityLists.ln.size()); 
    }
    
    
}
