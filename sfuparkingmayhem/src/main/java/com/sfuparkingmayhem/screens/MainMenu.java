package com.sfuparkingmayhem.screens;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sfuparkingmayhem.game.Board;

public class MainMenu extends JPanel {
    private ImageIcon start_game;
    private ImageIcon start_game_hover;
    private ImageIcon instructions;
    private ImageIcon instructions_hover;
    private ImageIcon exit;
    private ImageIcon exit_hover;

    public MainMenu(CardLayout cardLayout, JPanel cardPanel, JFrame window) { //initializes variables and load button images
        load_images();
        setPreferredSize(new Dimension(750,750));
        JPanel main_menu = new JPanel();
        setBackground(new Color(111, 194, 232));
        
        setLayout(null);

        try {
            // Load the font from the file
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/Kenney Future.ttf"));
            // Register the font
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); // Handle errors
        }

        JLabel titleLabel = new JLabel("SFU Parking Mayhem", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Kenney Future", Font.BOLD, 32)); // Customize font and size
        titleLabel.setForeground(Color.WHITE); // Set title text color
        titleLabel.setBounds(0, 150, 750, 50);
        
        JButton start_game_button = new JButton(start_game);
        JButton instructions_button = new JButton(instructions);
        JButton exit_button = new JButton(exit);

        start_game_button.setRolloverIcon(start_game_hover);
        instructions_button.setRolloverIcon(instructions_hover);
        exit_button.setRolloverIcon(exit_hover);

        start_game_button.setPreferredSize(new Dimension(192, 64));
        instructions_button.setPreferredSize(new Dimension(192, 64));
        exit_button.setPreferredSize(new Dimension(192, 64));

        start_game_button.setBounds(278, 250, 192, 64); // Position the start game button
        instructions_button.setBounds(278, 330, 192, 64); // Position the instructions button
        exit_button.setBounds(278, 410, 192, 64); // Position the exit button

        start_game_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board board = new Board();
                cardPanel.add(board, "GameBoard");
                window.addKeyListener(board);
                cardLayout.show(cardPanel, "GameBoard");
            }
        });

        instructions_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Instructions clicked!");
                // Show instructions
            }
        });

        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit clicked!");
                System.exit(0); // Exit the program
            }
        });

        add(titleLabel);
        add(start_game_button);
        add(instructions_button);
        add(exit_button);
    }

    private void load_images() { //method to load button images
        try {
            start_game = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("start_game.png")));
            start_game_hover = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("start_game_hover.png")));
            instructions = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("instructions.png")));
            instructions_hover = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("instructions_hover.png")));
            exit = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("exit.png")));
            exit_hover = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("exit_hover.png")));
        } catch (IOException e) {
            System.out.println("Error loading images: " + e.getMessage());
        }
    }
}