package com.sfuparkingmayhem.game;

import javax.swing.JFrame;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //create a window in which the game will run
        JFrame window = new JFrame("Game Window");
        //make sure the program shuts down when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the dimensions of the window to be 1280x720 (standard)
        window.setSize(1280,720);
        //make the window visible to the user
        window.setVisible(true);
    }
}