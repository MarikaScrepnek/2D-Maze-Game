package com.sfuparkingmayhem.screens;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainMenu {
    private int x,y;
    private BufferedImage start_game;
    private BufferedImage instructions;
    private BufferedImage quit;

    public MainMenu(int x, int y) {
        this.x=x;
        this.y=y;
        load_images();
    }

    private void load_images() {
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
}