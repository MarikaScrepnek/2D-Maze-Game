package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LoseScreenConcord extends LoseScreen {
    public LoseScreenConcord(CardLayout cardLayout, JPanel cardPanel) {
        //call LoseScreen constructor
        super(cardLayout, cardPanel);

        //create reason for loss message
        JLabel messageLabel = new JLabel("You were caught by the Concord Officer!", SwingConstants.CENTER);
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