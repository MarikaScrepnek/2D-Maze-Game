package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sfuparkingmayhem.screen.LoseScreenScore;

public class LoseScreenScoreTest {
    LoseScreenScore loseScreenScore;

    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setup() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel();

        loseScreenScore = new LoseScreenScore(cardLayout, cardPanel);
    }

    @Test
    public void testLoseScreenScoreConstruction() {
        assertNotNull(loseScreenScore, "LoseScreenConcord should not be null after setup.");
    }
}
