package com.sfuparkingmayhem.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel{
    private ImageIcon start_game; //start game button image
    private ImageIcon instructions; //instructions button image
    private ImageIcon quit; //quit button image

    public MainMenu() { //initializes variables and load button images
        load_images();
        JPanel main_menu = new JPanel();
        setBackground(new Color(111, 194, 232));
        
    }

    private void load_images() { //method to load button images
        ImageIcon start_game = new ImageIcon();
        ImageIcon instructions = new ImageIcon();
        ImageIcon quit = new ImageIcon();
    }

    public void draw (Graphics g) {
        JButton start_game_button = new JButton(start_game);
        start_game_button.setPreferredSize(new Dimension(start_game.getIconWidth(), start_game.getIconHeight()));
        
    }
    public void update() {
        
    }
}