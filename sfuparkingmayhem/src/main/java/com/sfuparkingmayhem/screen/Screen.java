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

/**
 * Abstract class representing a screen in the game that is extended by {MainMenu}, {@link Instructions}, and {@link EndScreen}.
 * Extends JPanel and manages UI elements like buttons, button images, and fonts.
 * 
 * @author Group 25
 * @version 1.0
 */
public abstract class Screen extends JPanel{
    /**
     * The icon representing the "Start Game" button in its normal state.
     * This icon is used when the "Start Game" button is not being hovered over.
     */
    private ImageIcon start_game;

    /**
     * The icon representing the "Start Game" button when hovered over.
     * This icon changes when the user hovers their cursor over the "Start Game" button.
     */
    private ImageIcon start_game_hover;

    /**
     * The icon representing the "Instructions" button in its normal state.
     * This icon is used when the "Instructions" button is not being hovered over.
     */
    private ImageIcon instructions;

    /**
     * The icon representing the "Instructions" button when hovered over.
     * This icon changes when the user hovers their cursor over the "Instructions" button.
     */
    private ImageIcon instructions_hover;

    /**
     * The icon representing the "Exit" button in its normal state.
     * This icon is used when the "Exit" button is not being hovered over.
     */
    private ImageIcon exit;

    /**
     * The icon representing the "Exit" button when hovered over.
     * This icon changes when the user hovers their cursor over the "Exit" button.
     */
    private ImageIcon exit_hover;

    /**
     * The icon representing the "Main Menu" button in its normal state.
     * This icon is used when the "Main Menu" button is not being hovered over.
     */
    private ImageIcon main_menu;

    /**
     * The icon representing the "Main Menu" button when hovered over.
     * This icon changes when the user hovers their cursor over the "Main Menu" button.
     */
    private ImageIcon main_menu_hover;

    /**
     * The font used for the main game interface, typically used for larger text.
     * This font provides the primary visual style for in-game labels and buttons.
     */
    protected Font kenneyFont;

    /**
     * The font used for smaller text in the game interface.
     * This font is used for auxiliary text like instructions or tooltips.
     */
    protected Font smallKenneyFont;

    /**
     * The "Start Game" button on the user interface.
     * This button is clickable and starts the game when pressed.
     */
    JButton start_game_button;

    /**
     * The "Instructions" button on the user interface.
     * This button is clickable and opens the instructions screen when pressed.
     */
    JButton instructions_button;

    /**
     * The "Exit" button on the user interface.
     * This button is clickable and exits the game when pressed.
     */
    JButton exit_button;

    /**
     * The "Main Menu" button on the user interface.
     * This button is clickable and returns the player to the main menu when pressed.
     */
    JButton main_menu_button;
    
    /**
     * Loads images for all needed UI in screens, creates needed buttons, handles their events, and loads needed fonts.
     * 
     * @param cardLayout The CardLayout managing screen transitions.
     * @param cardPanel The main panel containing different screens.
     */
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

        //create start game button
        start_game_button = new JButton(start_game);
        start_game_button.setRolloverIcon(start_game_hover);
        start_game_button.setPreferredSize(new Dimension(192, 64));

        //create instructions button
        instructions_button = new JButton(instructions);
        instructions_button.setRolloverIcon(instructions_hover);
        instructions_button.setPreferredSize(new Dimension(192, 64));

        //create exit button
        exit_button = new JButton(exit);
        exit_button.setRolloverIcon(exit_hover);
        exit_button.setPreferredSize(new Dimension(192, 64));

        //create main menu button
        main_menu_button = new JButton(main_menu);
        main_menu_button.setRolloverIcon(main_menu_hover);
        main_menu_button.setPreferredSize(new Dimension(192, 64));

        //handle click of main menu button
        start_game_button.addActionListener((ActionEvent e) -> {
            //start a new game
            Board board = new Board(cardLayout, cardPanel);
            //add game as a panel
            cardPanel.add(board, "GameBoard");
            //show the game to user
            cardLayout.show(cardPanel, "GameBoard");
            //allow input
            board.setFocusable(true);
            board.requestFocusInWindow();
            board.addKeyListener(board);
        });

        //handle click of instructions button
        instructions_button.addActionListener((ActionEvent e) -> {
            cardLayout.show(cardPanel, "Instructions"); //show instructions panel to user
        });

        //handle click of exit button
        exit_button.addActionListener((ActionEvent e) -> {
            System.exit(0); //exit the program
        });

        //handle click of main menu button
        main_menu_button.addActionListener((ActionEvent e) -> {
            cardLayout.show(cardPanel, "MainMenu"); //show main menu panel to user
        });
    }

    /**
     * Loads a custom font from the resources folder.
     * 
     * @param fontFileName The font file name.
     * @param size The desired font size.
     * @return The loaded Font instance, or a fallback font if loading fails.
     */
    public final Font loadCustomFont(String fontFileName, float size) { //takes inputs font name and font size to load
        try {
            Font customFont;
            try (InputStream fontStream = getClass().getClassLoader().getResourceAsStream(fontFileName)) { //Load font as file stream
                if (fontStream == null) { //if file can't be found
                    System.out.println("Font file not found: " + fontFileName);
                    return new Font("SansSerif", Font.BOLD, (int) size); //fallback font
                }
                customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream); //create a Font instance
            }

            //register the font
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            //return the derived font with size
            return customFont.deriveFont(size);
        } catch (FontFormatException | IOException e) {
            return new Font("SansSerif", Font.BOLD, (int) size); //fallback font
        }
    }

    /**
     * Loads images required for the buttons.
     */
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