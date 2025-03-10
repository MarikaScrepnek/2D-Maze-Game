package com.sfuparkingmayhem.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sfuparkingmayhem.game.Score;

public class WinScreen extends JPanel {
    private ImageIcon main_menu;
    private ImageIcon main_menu_hover;
    Score score;


    public WinScreen(Score score, int time) {
        load_images();
        setPreferredSize(new Dimension(750,750));
        JPanel win_screen = new JPanel();
        setBackground(new Color(111, 194, 232));
        
        setLayout(null);

        Font kenneyFont = loadCustomFont("Kenney Future.ttf", 32f);

        JLabel winLabel = new JLabel("You Win!", SwingConstants.CENTER);
        winLabel.setFont(kenneyFont);
        winLabel.setForeground(Color.WHITE); // Set title text color
        winLabel.setBounds(0, 150, 750, 50);

        JButton main_menu_button = new JButton(main_menu);

        main_menu_button.setRolloverIcon(main_menu_hover);

        main_menu_button.setPreferredSize(new Dimension(192, 64));

        main_menu_button.setBounds(278, 410, 192, 64);
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


