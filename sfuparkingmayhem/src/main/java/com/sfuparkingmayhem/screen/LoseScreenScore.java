package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class representing the screen displayed when the player loses
 * due to their score becoming negative. It extends LoseScreen and provides
 * a specific loss message.
 */
public class LoseScreenScore extends LoseScreen {
    /**
     * Constructs a LoseScreenConcord with a message stating they lost because of their score.
     *
     * @param cardLayout The CardLayout used for switching between screens.
     * @param cardPanel  The JPanel that contains all the game screens.
     */
    public LoseScreenScore(CardLayout cardLayout, JPanel cardPanel) {
        //call LoseScreen constructor
        super(cardLayout, cardPanel);

        //create reason for loss message
        JLabel messageLabel = new JLabel("Your score went negative!", SwingConstants.CENTER);
        //set font
        messageLabel.setFont(smallKenneyFont);
        //set color
        messageLabel.setForeground(Color.WHITE);
        //set position and dimensions
        messageLabel.setBounds(0, 180, 750, 50);

        //add message to panel
        add(messageLabel);
    }
}