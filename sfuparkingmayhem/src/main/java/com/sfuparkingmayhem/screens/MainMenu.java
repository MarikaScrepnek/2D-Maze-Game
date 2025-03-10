package com.sfuparkingmayhem.screens;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class MainMenu {
    private int x,y; //mouse position
    private ImageIcon start_game; //start game button image
    private ImageIcon instructions; //instructions button image
    private ImageIcon quit; //quit button image

    public MainMenu(int x, int y) { //initializes variables and load button images
        this.x=x;
        this.y=y;
        load_images();
    }

    private void load_images() { //method to load button images
        ImageIcon start_game = new ImageIcon();
        ImageIcon instructions = new ImageIcon();
        ImageIcon quit = new ImageIcon();
    }

    public void draw (Graphics g) {
        
    }
    public void update() {
        
    }
}