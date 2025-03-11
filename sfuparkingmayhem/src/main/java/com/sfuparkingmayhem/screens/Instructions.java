package com.sfuparkingmayhem.screens;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Instructions extends JPanel {
    private ImageIcon main_menu;
    private ImageIcon main_menu_hover;
    public Instructions(CardLayout cardLayout, JPanel cardPanel) {
        load_images();
        setPreferredSize(new Dimension(750,750));
        setBackground(new Color(194, 25, 25));

        setLayout(null);

        Font kenneyFont = loadCustomFont("Kenney Future.ttf", 32f);
        Font smallKenneyFont = loadCustomFont("Kenney Future.ttf", 20f);

        JLabel instructionsLabel = new JLabel("Instructions", SwingConstants.CENTER);
        instructionsLabel.setFont(kenneyFont);
        instructionsLabel.setForeground(Color.WHITE); // Set title text color
        instructionsLabel.setBounds(0, 120, 750, 50);
        add(instructionsLabel);

        JLabel controlsLabel = new JLabel("Controls", SwingConstants.CENTER);
        controlsLabel.setFont(kenneyFont);
        controlsLabel.setForeground(Color.WHITE); // Set title text color
        controlsLabel.setBounds(0, 120, 750, 50);
        add(controlsLabel);

        JLabel controlsInfoLabel = new JLabel("Move Up - W\nMove Down - S\nMove Left - A\nMove Right - D", SwingConstants.CENTER);
        controlsInfoLabel.setFont(smallKenneyFont);
        controlsInfoLabel.setForeground(Color.WHITE); // Set title text color
        controlsInfoLabel.setBounds(0, 120, 750, 50);
        add(controlsInfoLabel);

        JLabel objectiveLabel = new JLabel("Objective", SwingConstants.CENTER);
        objectiveLabel.setFont(kenneyFont);
        objectiveLabel.setForeground(Color.WHITE); // Set title text color
        objectiveLabel.setBounds(0, 120, 750, 50);
        add(objectiveLabel);

        JLabel objectiveInfoLabel = new JLabel("Collect all 10 coins and escape to the ticket booth at the bottom right of the map to buy a parking pass!\nCollecting lost notes will reward you bonus points!\nHitting parked cars will deduct points!\nIf your score goes negative or the concord officer catches you, you lose!", SwingConstants.CENTER);
        objectiveInfoLabel.setFont(smallKenneyFont);
        objectiveInfoLabel.setForeground(Color.WHITE); // Set title text color
        objectiveInfoLabel.setBounds(0, 120, 750, 50);
        add(objectiveInfoLabel);

        JButton main_menu_button = new JButton(main_menu);
        main_menu_button.setRolloverIcon(main_menu_hover);
        main_menu_button.setPreferredSize(new Dimension(192, 64));
        main_menu_button.setBounds(278, 410, 192, 64);
        add(main_menu_button);

        main_menu_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MainMenu");
            }
        });
    }

    private void load_images() {
        try {
            main_menu = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("start_game.png")));
            main_menu_hover = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("start_game_hover.png")));
        } catch (IOException e) {
            System.out.println("Error loading images: " + e.getMessage());
        }
    }

    public Font loadCustomFont(String fontFileName, float size) {
        try {
            // Load font as an InputStream
            InputStream fontStream = getClass().getClassLoader().getResourceAsStream(fontFileName);
            
            if (fontStream == null) {
                System.out.println("Font file not found: " + fontFileName);
                return new Font("SansSerif", Font.BOLD, (int) size); // Fallback font
            }

            // Create a Font instance
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            fontStream.close(); // Close the stream after loading

            // Register the font
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            // Return the derived font with size
            return customFont.deriveFont(size);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("SansSerif", Font.BOLD, (int) size); // Fallback font
        }
    }
}