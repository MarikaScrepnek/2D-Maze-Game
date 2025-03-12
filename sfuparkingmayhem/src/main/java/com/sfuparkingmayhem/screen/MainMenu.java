package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenu extends Screen {
    public MainMenu(CardLayout cardLayout, JPanel cardPanel) {
        //call Screen constructor
        super(cardLayout, cardPanel);

        //set background color to light blue
        setBackground(new Color(2, 54, 94));
        
        //create the game name title
        JLabel titleLabel = new JLabel("SFU Parking Mayhem", SwingConstants.CENTER);
        //set font
        titleLabel.setFont(kenneyFont);
        //set color
        titleLabel.setForeground(Color.WHITE);
        //set position and dimensions
        titleLabel.setBounds(0, 150, 750, 50);
        
        //set positions and dimensions of buttons
        start_game_button.setBounds(278, 250, 192, 64);
        instructions_button.setBounds(278, 330, 192, 64);
        exit_button.setBounds(278, 410, 192, 64);
        
        //add all elements to the main menu panel
        add(titleLabel);
        add(start_game_button);
        add(instructions_button);
        add(exit_button);
    }
}