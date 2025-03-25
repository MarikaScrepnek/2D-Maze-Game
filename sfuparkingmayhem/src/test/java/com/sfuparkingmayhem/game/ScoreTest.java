package com.sfuparkingmayhem.game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class ScoreTest {
    private Score score;
    private int points;

    @BeforeEach
    public void setUp() {
        score = new Score();
    }

    @Test
    public void testScoreConstruction() {
        assertNotNull(score, "Score should not be null after setup.");
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
