package com.sfuparkingmayhem.screens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainMenu {
    private int x,y; //mouse position
    private BufferedImage start_game; //start game button image
    private BufferedImage instructions; //instructions button image
    private BufferedImage quit; //quit button image

    public MainMenu(int x, int y) { //initializes variables and load button images
        this.x=x;
        this.y=y;
        load_images();
    }

    private void load_images() { //method to load button images
        try{
            this.start_game = ImageIO.read(getClass().getClassLoader().getResourceAsStream("start_game.png"));
        }
        catch(IOException e){
            System.out.println("Error loading main" + e.getMessage());
        }
        try{
            this.instructions = ImageIO.read(getClass().getClassLoader().getResourceAsStream("instructions.png"));
        }
        catch(IOException e){
            System.out.println("Error loading main" + e.getMessage());
        }
        try{
            this.quit = ImageIO.read(getClass().getClassLoader().getResourceAsStream("quit.png"));
        }
        catch(IOException e){
            System.out.println("Error loading main" + e.getMessage());
        }
    }

    public void draw (Graphics g) {
        
    }
}