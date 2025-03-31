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
 * Class representing the instructions screen in the game.
 * It extends {@link Screen} and provides details about game controls and objectives.
 * 
 * @author Group 25
 * @version 1.0
 */
public class Instructions extends Screen {
    /**
     * The background image.
     */
    private Image backGroundImage;

    /**
     * Constructs the Instructions screen with game details.
     *
     * @param cardLayout The CardLayout used for switching screens.
     * @param cardPanel  The JPanel that holds different game screens.
     */
    public Instructions(CardLayout cardLayout, JPanel cardPanel) {
        //call Screen constructor
        super(cardLayout, cardPanel);

        backGroundImage = new ImageIcon(getClass().getResource("/background3.png")).getImage();

        //create the instructions title
        JLabel instructionsLabel = new JLabel("Instructions", SwingConstants.CENTER);
        //set font
        instructionsLabel.setFont(kenneyFont);
        //set color
        instructionsLabel.setForeground(Color.WHITE);
        //set position and dimensions
        instructionsLabel.setBounds(200, 50, 350, 50);

        //create the controls title
        JLabel controlsLabel = new JLabel("Controls");
        //set font
        controlsLabel.setFont(kenneyFont);
        //set color
        controlsLabel.setForeground(Color.WHITE);
        //set position and dimensions
        controlsLabel.setBounds(50, 150, 300, 50);

        //create the controls body
        JLabel controlsInfoLabel = new JLabel("<html>Move Up - W<br>Move Left - A<br>Move Down - S<br>Move Right - D</html>");
        //set font
        controlsInfoLabel.setFont(smallKenneyFont);
        //set color
        controlsInfoLabel.setForeground(Color.WHITE);
        //set position and dimensions
        controlsInfoLabel.setBounds(50, 200, 300, 120);

        //create the objective title
        JLabel objectiveLabel = new JLabel("Objective");
        //set font
        objectiveLabel.setFont(kenneyFont);
        //set color
        objectiveLabel.setForeground(Color.WHITE);
        //set position and dimensions
        objectiveLabel.setBounds(400, 150, 300, 50);

        //create the objective body
        JLabel objectiveInfoLabel = new JLabel("<html><p style='width:250px;'>Collect all 10 coins and make your way to the parking booth to escape!<br><br>Collect student's Lost Notes for 10 bonus points!<br><br>Avoid crashing into parked cars, or you'll lose 5 points!<br><br>If your score drops below zero or you're caught by the Concord Officer, you'll lose the game!</p></html>");
        //set font
        objectiveInfoLabel.setFont(smallKenneyFont);
        //set color
        objectiveInfoLabel.setForeground(Color.WHITE);
        //set position and dimensions
        objectiveInfoLabel.setBounds(400, 200, 350, 450);

        //set position and dimensions of main menu button
        main_menu_button.setBounds(50, 600, 192, 64);

        //add all elements to the instructions panel
        add(instructionsLabel);
        add(controlsLabel);
        add(controlsInfoLabel);
        add(objectiveLabel);
        add(objectiveInfoLabel);
        add(main_menu_button);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backGroundImage != null) {
            g.drawImage(backGroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}