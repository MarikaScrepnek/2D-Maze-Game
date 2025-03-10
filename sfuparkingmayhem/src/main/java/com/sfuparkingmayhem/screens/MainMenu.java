package com.sfuparkingmayhem.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel{
    private ImageIcon start_game;
    private ImageIcon start_game_hover;
    private ImageIcon instructions;
    private ImageIcon instructions_hover;
    private ImageIcon exit;
    private ImageIcon exit_hover;

    public MainMenu() { //initializes variables and load button images
        load_images();
        setPreferredSize(new Dimension(750,750));
        JPanel main_menu = new JPanel();
        setBackground(new Color(111, 194, 232));
        
        JButton start_game_button = new Jbutton(start_game);
        JButton instructions_button = new Jbutton(instructions);
        JButton exit_button = new Jbutton(exit);

        start_game_button.setRolloverIcon(start_game_hover);
        instructions_button.setRolloverIcon(instructions_hover);
        exit_button.setRolloverIcon(exit_hover);

        start_game_button.setPreferredSize(new Dimension(192, 64));
        instructions_button.setPreferredSize(new Dimension(192, 64));
        exit_button.setPreferredSize(new Dimension(192, 64));

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