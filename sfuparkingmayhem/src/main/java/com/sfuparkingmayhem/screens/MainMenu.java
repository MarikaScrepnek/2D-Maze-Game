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

        start_game_button.setPreferredSize(new Dimension(192, 64));
        instructions_button.setPreferredSize(new Dimension(192, 64));
        exit_button.setPreferredSize(new Dimension(192, 64));

    }

    private void load_images() { //method to load button images
        ImageIcon start_game = new ImageIcon();
        try {
            start_game = ImageIO.read(getClass().getClassLoader().getResourceAsStream("start_game.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ImageIcon start_game_hover = new ImageIcon();
        try {
            start_game_hover = ImageIO.read(getClass().getClassLoader().getResourceAsStream("start_game_hover.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ImageIcon instructions = new ImageIcon();
        try {
            instructions = ImageIO.read(getClass().getClassLoader().getResourceAsStream("instructions.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ImageIcon instructions_hover = new ImageIcon();
        try {
            instructions_hover = ImageIO.read(getClass().getClassLoader().getResourceAsStream("instructions_hover.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ImageIcon exit = new ImageIcon();
        try {
            quit = ImageIO.read(getClass().getClassLoader().getResourceAsStream("exit.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ImageIcon exit = new ImageIcon();
        try {
            quit_hover = ImageIO.read(getClass().getClassLoader().getResourceAsStream("exit.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}