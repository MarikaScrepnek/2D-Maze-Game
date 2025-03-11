package com.sfuparkingmayhem.screen;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;

public abstract class Screen extends JPanel{
    //method to load a custom font that is held in the resources folder
    public Font loadCustomFont(String fontFileName, float size) { //takes inputs font name and font size to load
        try {
            Font customFont;
            try (InputStream fontStream = getClass().getClassLoader().getResourceAsStream(fontFileName)) { //Load font as file stream
                if (fontStream == null) { //If file can't be found
                    System.out.println("Font file not found: " + fontFileName);
                    return new Font("SansSerif", Font.BOLD, (int) size); // Fallback font
                }
                customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream); // Create a Font instance
            }

            // Register the font
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            // Return the derived font with size
            return customFont.deriveFont(size);
        } catch (FontFormatException | IOException e) {
            return new Font("SansSerif", Font.BOLD, (int) size); // Fallback font
        }
    }

    //method to load images needed for buttons on the selected screen
    public abstract void load_images();
}