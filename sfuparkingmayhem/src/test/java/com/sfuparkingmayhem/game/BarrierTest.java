package com.sfuparkingmayhem.game;

import java.awt.CardLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class BarrierTest {

    Barrier barrier;
    Board aBoard;
    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setUp(){

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        aBoard = new Board(cardLayout, cardPanel);

        barrier = new Barrier(0, 0, aBoard);   
    }
    
    @Test
    public void testBarrierConstruction() {
        assertNotNull(barrier, "Barrier should not be null after setup.");
    }
    @Test
    void testDraw() {
        // Create a mock Graphics object (you may need to use a mocking library like Mockito)
        Graphics g = mock(Graphics.class); 

        barrier.draw(g);
    }
}
