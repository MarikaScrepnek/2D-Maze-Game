package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class representing the Main Menu screen in the game.
 * It extends {@link Screen} and provides buttons for starting game, instructions, and exiting the program.
 * 
 * @author Group 25
 * @version 1.0
 */
public class MainMenu extends Screen {
    /**
     * The background image.
     */
    private Image backGroundImage;

    /**
     * Constructs the Main Menu screen with navigation buttons.
     *
     * @param cardLayout The CardLayout used for switching screens.
     * @param cardPanel  The JPanel that holds different game screens.
     */
    public MainMenu(CardLayout cardLayout, JPanel cardPanel) {
        //call Screen constructor
        super(cardLayout, cardPanel);

        backGroundImage = new ImageIcon(getClass().getResource("/background.png")).getImage();
        
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backGroundImage != null) {
            g.drawImage(backGroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}