package com.sfuparkingmayhem.game;


import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConeTest {

    Cone cone;

    Board board;
    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setUp(){
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        board = new Board(cardLayout, cardPanel);

        cone = new Cone(1,2,board);
    }

    @Test
    public void testConeConstruction() {
        assertNotNull(cone, "Cone should not be null after setup.");
    }
}
