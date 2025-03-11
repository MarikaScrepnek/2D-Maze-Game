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
        instructionsLabel.setForeground(Color.WHITE);
        instructionsLabel.setBounds(200, 50, 350, 50);
        add(instructionsLabel);

        // Controls Section
        JLabel controlsLabel = new JLabel("Controls");
        controlsLabel.setFont(kenneyFont);
        controlsLabel.setForeground(Color.WHITE);
        controlsLabel.setBounds(50, 150, 300, 50);
        add(controlsLabel);

        JLabel controlsInfoLabel = new JLabel("<html><brk>Move Up - W<br>Move Down - S<br>Move Left - A<br>Move Right - D</html>");
        controlsInfoLabel.setFont(smallKenneyFont);
        controlsInfoLabel.setForeground(Color.WHITE);
        controlsInfoLabel.setBounds(50, 200, 300, 100);
        add(controlsInfoLabel);

        // Objective Section
        JLabel objectiveLabel = new JLabel("Objective");
        objectiveLabel.setFont(kenneyFont);
        objectiveLabel.setForeground(Color.WHITE);
        objectiveLabel.setBounds(400, 150, 300, 50);
        add(objectiveLabel);

        JLabel objectiveInfoLabel = new JLabel("<html><p style='width:250px;'>Collect all 10 coins and escape to the parking booth!<br><br>Avoid hitting parked cars and don't let the parking officer catch you!</p></html>");
        objectiveInfoLabel.setFont(smallKenneyFont);
        objectiveInfoLabel.setForeground(Color.WHITE);
        objectiveInfoLabel.setBounds(400, 200, 300, 200); // Increased width and height
        add(objectiveInfoLabel);

        JButton main_menu_button = new JButton(main_menu);
        main_menu_button.setRolloverIcon(main_menu_hover);
        main_menu_button.setPreferredSize(new Dimension(192, 64));
        main_menu_button.setBounds(280, 450, 192, 64);
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
            main_menu = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("main_menu.png")));
            main_menu_hover = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("main_menu_hover.png")));
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