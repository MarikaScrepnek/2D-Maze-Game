package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LoseScreen extends EndScreen {
    public LoseScreen(CardLayout cardLayout, JPanel cardPanel, boolean concord) {
        //call EndScreen constructor
        super(cardLayout, cardPanel);

        //set background color to red
        setBackground(new Color(194, 25, 25));

        //create "you lose" title
        JLabel loseLabel = new JLabel("You Lose!", SwingConstants.CENTER);
        //set font
        loseLabel.setFont(kenneyFont);
        //set color
        loseLabel.setForeground(Color.WHITE);
        //set position and dimension
        loseLabel.setBounds(0, 120, 750, 50);
        add(loseLabel);

        //create lose message
        JLabel messageLabel;
        //if caught by concord write select concord message, if not select negative score message
        if (concord == true){
            messageLabel = new JLabel("The Concord Officer caught you!", SwingConstants.CENTER);
        } else {
            messageLabel = new JLabel("Your score went negative!", SwingConstants.CENTER);
        }
        //set font
        messageLabel.setFont(smallKenneyFont);
        //set color
        messageLabel.setForeground(Color.WHITE);
        //set postion and dimension
        messageLabel.setBounds(0, 180, 750, 50);

        //add labels and messages to panel
        add(loseLabel);
        add(messageLabel);
    }
}