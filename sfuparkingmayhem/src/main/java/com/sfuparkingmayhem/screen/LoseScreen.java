package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

abstract public class LoseScreen extends EndScreen {
    public LoseScreen(CardLayout cardLayout, JPanel cardPanel) {
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

        //add labels and messages to panel
        add(loseLabel);
    }
}