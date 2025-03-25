package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sfuparkingmayhem.screen.Instructions;

public class InstructionsTest {
    CardLayout cardLayout;
    JPanel cardPanel;

    Instructions instructions;

    @BeforeEach
    public void setup() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel();

        instructions = new Instructions(cardLayout, cardPanel);
    }

    @Test
    public void testInstructionsConstruction() {
        assertNotNull(instructions, "Instructions should not be null after setup.");
    }
}
