package com.sfuparkingmayhem.game;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
