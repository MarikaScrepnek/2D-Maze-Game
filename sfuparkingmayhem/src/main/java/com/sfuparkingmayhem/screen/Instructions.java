package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Instructions extends Screen {
    private ImageIcon main_menu;
    private ImageIcon main_menu_hover;
    public Instructions(CardLayout cardLayout, JPanel cardPanel) {
        //load button images
        load_images();

        //set the preffered size of the panel and background color
        setPreferredSize(new Dimension(750,750));
        setBackground(new Color(111, 194, 232));

        //make the layout of swing elements manually
        setLayout(null);

        //load both main font and a smaller font for body text
        Font kenneyFont = loadCustomFont("Kenney Future.ttf", 32f);
        Font smallKenneyFont = loadCustomFont("Kenney Future.ttf", 20f);

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

        //create the main menu button
        JButton main_menu_button = new JButton(main_menu);
        main_menu_button.setRolloverIcon(main_menu_hover);
        main_menu_button.setPreferredSize(new Dimension(192, 64));
        main_menu_button.setBounds(280, 450, 192, 64);
        add(main_menu_button);

        //make the panel switch to main menu when hit the main menu button
        main_menu_button.addActionListener((ActionEvent e) -> {
            cardLayout.show(cardPanel, "MainMenu");
        });
    }

    //load main menu button images
    @Override
     public final void load_images() {
        try {
            main_menu = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("main_menu.png")));
            main_menu_hover = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("main_menu_hover.png")));
        } catch (IOException e) {
            System.out.println("Error loading images: " + e.getMessage());
        }
    }
}