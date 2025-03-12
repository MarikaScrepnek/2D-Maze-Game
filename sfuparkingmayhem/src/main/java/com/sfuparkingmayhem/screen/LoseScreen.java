package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Abstract class representing the screen displayed when the player loses the game that is 
 * extended based on reason for loss by either {@link LoseScreenConcord} or {@link LoseScreenScore}.
 * It extends the {@link EndScreen} and displays a message indicating that the player lost.
 * 
 * @author Group 25
 * @version 1.0
 */
abstract public class LoseScreen extends EndScreen {
    /**
     * Constructs a LoseScreen with a specified displaying you lose text and a red background.
     *
     * @param cardLayout The CardLayout used for switching between screens.
     * @param cardPanel  The JPanel that contains all the game screens.
     */
    public LoseScreen(CardLayout cardLayout, JPanel cardPanel) {
        //call EndScreen constructor
        super(cardLayout, cardPanel);

        //set background color to red
        setBackground(new Color(102, 14, 14));

        //create "you lose" title
        JLabel loseLabel = new JLabel("You Lose!", SwingConstants.CENTER);
        //set font
        loseLabel.setFont(kenneyFont);
        //set color
        loseLabel.setForeground(Color.WHITE);
        //set position and dimension
        loseLabel.setBounds(0, 120, 750, 50);

        //add labels and messages to panel
        add(loseLabel);
    }
}