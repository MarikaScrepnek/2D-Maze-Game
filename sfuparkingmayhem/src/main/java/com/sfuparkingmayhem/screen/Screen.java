package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.sfuparkingmayhem.game.Board;

public abstract class Screen extends JPanel{
    private ImageIcon start_game;
    private  ImageIcon start_game_hover;
    private  ImageIcon instructions;
    private  ImageIcon instructions_hover;
    private  ImageIcon exit;
    private  ImageIcon exit_hover;
    private  ImageIcon main_menu;
    private  ImageIcon main_menu_hover;

    protected Font kenneyFont;
    protected Font smallKenneyFont;

    JButton start_game_button;
    JButton instructions_button;
    JButton exit_button;
    JButton main_menu_button; 
    
    public Screen(CardLayout cardLayout, JPanel cardPanel) {
        //load images needed for buttons
        load_images();
        //set the preffered panel size to match the window size
        setPreferredSize(new Dimension(750,750));

        //set the layout of swing elements to be manually made
        setLayout(null);

        //load both main font and a smaller font for body text
        kenneyFont = loadCustomFont("Kenney Future.ttf", 32f);
        smallKenneyFont = loadCustomFont("Kenney Future.ttf", 20f);

        start_game_button = new JButton(start_game);
        start_game_button.setRolloverIcon(start_game_hover);
        start_game_button.setPreferredSize(new Dimension(192, 64));

        instructions_button = new JButton(instructions);
        instructions_button.setRolloverIcon(instructions_hover);
        instructions_button.setPreferredSize(new Dimension(192, 64));

        exit_button = new JButton(exit);
        exit_button.setRolloverIcon(exit_hover);
        exit_button.setPreferredSize(new Dimension(192, 64));

        //create the main menu button
        main_menu_button = new JButton(main_menu);
        main_menu_button.setRolloverIcon(main_menu_hover);
        main_menu_button.setPreferredSize(new Dimension(192, 64));


        start_game_button.addActionListener((ActionEvent e) -> {
            Board board = new Board(cardLayout, cardPanel);
            cardPanel.add(board, "GameBoard");
            cardLayout.show(cardPanel, "GameBoard");
            board.setFocusable(true);
            board.requestFocusInWindow();
            board.addKeyListener(board);
        });

        instructions_button.addActionListener((ActionEvent e) -> {
            cardLayout.show(cardPanel, "Instructions");
        });

        exit_button.addActionListener((ActionEvent e) -> {
            System.exit(0); // Exit the program
        });

        main_menu_button.addActionListener((ActionEvent e) -> {
            cardLayout.show(cardPanel, "MainMenu");
        });
    }

    //method to load a custom font that is held in the resources folder
    public final Font loadCustomFont(String fontFileName, float size) { //takes inputs font name and font size to load
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
    private void load_images() {
        try {
            start_game = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("start_game.png")));
            start_game_hover = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("start_game_hover.png")));
            instructions = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("instructions.png")));
            instructions_hover = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("instructions_hover.png")));
            exit = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("exit.png")));
            exit_hover = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("exit_hover.png")));
            main_menu = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("main_menu.png")));
            main_menu_hover = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("main_menu_hover.png")));

        } catch (IOException e) {
            System.out.println("Error loading images: " + e.getMessage());
        }
    }
}