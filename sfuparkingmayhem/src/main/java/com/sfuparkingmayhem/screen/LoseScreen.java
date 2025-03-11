package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LoseScreen extends EndScreen {
    private ImageIcon main_menu;
    private ImageIcon main_menu_hover;

    public LoseScreen(CardLayout cardLayout, JPanel cardPanel, boolean concord) {
        super(cardLayout, cardPanel);

        setBackground(new Color(194, 25, 25));

        setLayout(null);

        Font kenneyFont = loadCustomFont("Kenney Future.ttf", 32f);
        Font smallKenneyFont = loadCustomFont("Kenney Future.ttf", 20f);

        JLabel loseLabel = new JLabel("You Lose!", SwingConstants.CENTER);
        loseLabel.setFont(kenneyFont);
        loseLabel.setForeground(Color.WHITE); // Set title text color
        loseLabel.setBounds(0, 120, 750, 50);
        add(loseLabel);

        JLabel messageLabel = new JLabel("The Concord Officer caught you!", SwingConstants.CENTER);
        messageLabel.setFont(smallKenneyFont); // Adjust font if needed
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setBounds(0, 180, 750, 50);
        add(messageLabel);

        JButton main_menu_button = new JButton(main_menu);
        main_menu_button.setRolloverIcon(main_menu_hover);
        main_menu_button.setPreferredSize(new Dimension(192, 64));
        main_menu_button.setBounds(278, 410, 192, 64);
        add(main_menu_button);
    }
}