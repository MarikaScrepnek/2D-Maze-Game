package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sfuparkingmayhem.screen.MainMenu;

public class MainMenuTest {
    MainMenu mainMenu;

    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setup() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel();


        mainMenu = new MainMenu(cardLayout, cardPanel);
    }

    @Test
    public void testMainMenuConstruction() {
        assertNotNull(mainMenu, "MainMenu should not be null after setup.");
    }
}
