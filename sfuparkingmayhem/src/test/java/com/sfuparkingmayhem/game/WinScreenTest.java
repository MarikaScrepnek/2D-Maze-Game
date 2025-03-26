package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sfuparkingmayhem.screen.WinScreen;

public class WinScreenTest {
    WinScreen winScreen;

    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setup() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel();

        winScreen = new WinScreen(cardLayout, cardPanel, 0, 0);
    }

    @Test
    public void testWinScreenConstruction() {
        assertNotNull(winScreen, "WinScreen should not be null after setup.");
    }
}
