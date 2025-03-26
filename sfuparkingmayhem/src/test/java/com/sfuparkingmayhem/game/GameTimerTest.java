package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

class GameTimerTest {
    private int timeElapsed;
    private GameTimer gameTimer;

    private Board board;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    @BeforeEach
    public void setUp() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        board = new Board(cardLayout, cardPanel);

        gameTimer = new GameTimer(board);
    }

    @Test
    public void testGameTimerConstruction() {
        assertNotNull(gameTimer, "GameTimer should not be null after setup.");
    }

    @Test
    void testGetTimeElapsed() {
        //timeElapsed = 10;
        assertEquals(timeElapsed, gameTimer.getTimeElapsed());
    }

    @Test 
    void testDraw() {
        Graphics g = mock(Graphics.class);
        gameTimer.draw(g);
        verify(g).setColor(Color.WHITE);
        verify(g).setFont(new Font("Bahnschrift", Font.BOLD, 25));
        verify(g).drawString("00:00", 343, 30);
    }
}
