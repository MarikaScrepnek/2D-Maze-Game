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

public class LoseScreenScore extends JPanel {
    private ImageIcon main_menu;
    private ImageIcon main_menu_hover;

    public LoseScreenScore(CardLayout cardLayout, JPanel cardPanel) {
        load_images();
        setPreferredSize(new Dimension(750,750));
        setBackground(new Color(194, 25, 25));

        setLayout(null);

        Font kenneyFont = loadCustomFont("Kenney Future.ttf", 32f);
        Font smallKenneyFont = loadCustomFont("Kenney Future.ttf", 20f);

        JLabel loseLabel = new JLabel("You Lose!", SwingConstants.CENTER);
        loseLabel.setFont(kenneyFont);
        loseLabel.setForeground(Color.WHITE); // Set title text color
        loseLabel.setBounds(0, 120, 750, 50);
        add(loseLabel);

        JLabel messageLabel = new JLabel("Your score went negative!", SwingConstants.CENTER);
        messageLabel.setFont(smallKenneyFont); // Adjust font if needed
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setBounds(0, 180, 750, 50);
        add(messageLabel);

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

    private void load_images() { //method to load button images
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