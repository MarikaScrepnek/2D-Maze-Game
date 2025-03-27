package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        int ROWS = 10;
        int COLUMNS = 10;
        int CELL_SIZE = 50;

        // Create a mock Graphics object (you may need to use a mocking library like Mockito)
        Graphics g = mock(Graphics.class); 

        barrier.draw(ROWS, COLUMNS, CELL_SIZE, g);
    }
}
