package com.sfuparkingmayhem.game;

//import java swing
import javax.swing.JFrame;

/**
 *
 *
 */
public class Game 
{
    public void initWindow()
    {
        //create a window in which the game will run
        JFrame window = new JFrame("SFU Parking Mayhem");
        //make sure the program shuts down when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the dimensions of the window to be 1280x720 (standard)
        window.setSize(1280,720);
        //make the window visible to the user, keep this at the bottom to make sure user only sees the ready window
        window.setVisible(true);
    }
}