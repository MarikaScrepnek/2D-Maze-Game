package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Instructions extends Screen {
    public Instructions(CardLayout cardLayout, JPanel cardPanel) {
        //call Screen constructor
        super(cardLayout, cardPanel);

        //set background color to light blue
        setBackground(new Color(111, 194, 232));

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
        JLabel controlsInfoLabel = new JLabel("<html><brk>Move Up - W<br>Move Down - S<br>Move Left - A<br>Move Right - D</html>");
        //set font
        controlsInfoLabel.setFont(smallKenneyFont);
        //set color
        controlsInfoLabel.setForeground(Color.WHITE);
        //set position and dimensions
        controlsInfoLabel.setBounds(50, 200, 300, 100);

        //create the objective title
        JLabel objectiveLabel = new JLabel("Objective");
        //set font
        objectiveLabel.setFont(kenneyFont);
        //set color
        objectiveLabel.setForeground(Color.WHITE);
        //set position and dimensions
        objectiveLabel.setBounds(400, 150, 300, 50);

        //create the objective body
        JLabel objectiveInfoLabel = new JLabel("<html><p style='width:250px;'>Collect all 10 coins and escape to the parking booth!<br><br>Avoid hitting parked cars and don't let the parking officer catch you!</p></html>");
        //set font
        objectiveInfoLabel.setFont(smallKenneyFont);
        //set color
        objectiveInfoLabel.setForeground(Color.WHITE);
        //set position and dimensions
        objectiveInfoLabel.setBounds(400, 200, 300, 200);

        //set position and dimensions of main menu button
        main_menu_button.setBounds(280, 450, 192, 64);

        //add all elements to the instructions panel
        add(instructionsLabel);
        add(controlsLabel);
        add(controlsInfoLabel);
        add(objectiveLabel);
        add(objectiveInfoLabel);
        add(main_menu_button);
    }
}