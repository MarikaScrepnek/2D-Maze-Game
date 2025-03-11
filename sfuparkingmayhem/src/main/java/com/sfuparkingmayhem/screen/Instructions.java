package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Instructions extends Screen {
    public Instructions(CardLayout cardLayout, JPanel cardPanel) {
        super(cardLayout, cardPanel);
        setBackground(new Color(111, 194, 232));

        //create the instructions title
        JLabel instructionsLabel = new JLabel("Instructions", SwingConstants.CENTER);
        instructionsLabel.setFont(kenneyFont);
        instructionsLabel.setForeground(Color.WHITE);
        instructionsLabel.setBounds(200, 50, 350, 50);
        add(instructionsLabel);

        //create the controls title
        JLabel controlsLabel = new JLabel("Controls");
        controlsLabel.setFont(kenneyFont);
        controlsLabel.setForeground(Color.WHITE);
        controlsLabel.setBounds(50, 150, 300, 50);
        add(controlsLabel);

        //create the controls body
        JLabel controlsInfoLabel = new JLabel("<html><brk>Move Up - W<br>Move Down - S<br>Move Left - A<br>Move Right - D</html>");
        controlsInfoLabel.setFont(smallKenneyFont);
        controlsInfoLabel.setForeground(Color.WHITE);
        controlsInfoLabel.setBounds(50, 200, 300, 100);
        add(controlsInfoLabel);

        //create the objective title
        JLabel objectiveLabel = new JLabel("Objective");
        objectiveLabel.setFont(kenneyFont);
        objectiveLabel.setForeground(Color.WHITE);
        objectiveLabel.setBounds(400, 150, 300, 50);
        add(objectiveLabel);

        //create the objective body
        JLabel objectiveInfoLabel = new JLabel("<html><p style='width:250px;'>Collect all 10 coins and escape to the parking booth!<br><br>Avoid hitting parked cars and don't let the parking officer catch you!</p></html>");
        objectiveInfoLabel.setFont(smallKenneyFont);
        objectiveInfoLabel.setForeground(Color.WHITE);
        objectiveInfoLabel.setBounds(400, 200, 300, 200); // Increased width and height
        add(objectiveInfoLabel);

        main_menu_button.setBounds(280, 450, 192, 64);
        add(main_menu_button);
    }
}