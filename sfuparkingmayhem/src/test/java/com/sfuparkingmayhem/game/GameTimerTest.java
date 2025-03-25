package com.sfuparkingmayhem.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Timer;

class GameTimerTest {
    private int timeElapsed;
    private GameTimer gameTimer;
    private Board board;

    @BeforeEach
    void setUp() {
        //board = new Board();
        gameTimer = new GameTimer(board);
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

    // Test lines 14 and 15 in GameTimer.java 
    
    

}
