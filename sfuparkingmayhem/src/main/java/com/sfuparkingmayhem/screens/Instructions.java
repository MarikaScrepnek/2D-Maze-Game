package com.sfuparkingmayhem.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Instructions extends JPanel {
    private ImageIcon main_menu;
    private ImageIcon main_menu_hover;
    public Instructions() {
        load_images();
        setPreferredSize(new Dimension(750,750));
        setBackground(new Color(194, 25, 25));

        setLayout(null);

        Font kenneyFont = loadCustomFont("Kenney Future.ttf", 32f);
        Font smallKenneyFont = loadCustomFont("Kenney Future.ttf", 20f);

        JButton main_menu_button = new JButton(main_menu);
        main_menu_button.setRolloverIcon(main_menu_hover);
        main_menu_button.setPreferredSize(new Dimension(192, 64));
        main_menu_button.setBounds(278, 410, 192, 64);
        add(main_menu_button);
    }

    private void load_images() {
        throw new UnsupportedOperationException("Not supported yet.");
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