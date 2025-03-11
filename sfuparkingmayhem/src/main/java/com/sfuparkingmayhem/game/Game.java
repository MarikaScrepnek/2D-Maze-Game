package com.sfuparkingmayhem.game;

//import java swing

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sfuparkingmayhem.screen.Instructions;
import com.sfuparkingmayhem.screen.MainMenu;

/**
 *
 *
 */
public class Game 
{
    /**
     * Constructor for the Game class
     */
    public Game() {
    }
    
    /**
     * Initializes the window for the game
     */
    public void initWindow()
    {
        //create a window in which the game will run
        JFrame window = new JFrame("SFU Parking Mayhem");
        
        //make sure the program shuts down when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        
        MainMenu mainMenu = new MainMenu(cardLayout, cardPanel); // Main menu panel
        Instructions instructions = new Instructions(cardLayout, cardPanel);

        cardPanel.add(mainMenu, "MainMenu");
        cardPanel.add(instructions, "Instructions");

        //add the board panel to the window (instead of board it could be different screens)
        window.add(cardPanel);

        //dont allow user to resize the window
        window.setResizable(false);
        //fit the window size around panels, avoids issues on some platforms
        window.pack();
        //open the window in the center of the screen
        window.setLocationRelativeTo(null);

        //make the window visible to the user, keep this at the bottom to make sure user only sees the ready window
        window.setVisible(true);

        cardLayout.show(cardPanel, "MainMenu");
    }
}