package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sfuparkingmayhem.screen.LoseScreenConcord;

public class LoseScreenConcordTest {
    LoseScreenConcord loseScreenConcord;

    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setup() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel();

        loseScreenConcord = new LoseScreenConcord(cardLayout, cardPanel);
    }

    @Test
    public void testLoseScreenConcordConstruction() {
        assertNotNull(loseScreenConcord, "LoseScreenConcord should not be null after setup.");
    }
}
