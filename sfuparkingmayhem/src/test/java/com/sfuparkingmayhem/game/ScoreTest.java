package com.sfuparkingmayhem.game;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


class ScoreTest {
    private Score score;
    private int points;

    @BeforeEach
    void setUp() {
        score = new Score();
    }

    @Test
    void testAddPoints() {
        points = 10;
        score.addPoints(points);
        assertEquals(10, score.getScore());
    }

    @Test
    void testSubtractPoints() {
        points = 10;
        score.subtractPoints(points);
        assertEquals(-10, score.getScore());
    }
    @Test
    void testReset() {
        points = 10;
        score.addPoints(points);
        score.reset();
        assertEquals(0, score.getScore());
    }
    @Test
    void testDrawScore() {
        Graphics g = mock(Graphics.class);
        score.draw(g);
        verify(g).setColor(Color.WHITE);
        verify(g).setFont(new Font("Bahnschrift", Font.BOLD, 20));
        verify(g).drawString("SCORE: 0 PTS", 555, 730);
    }
}
