package com.sfuparkingmayhem.game;

//import java swing

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sfuparkingmayhem.screen.Instructions;
import com.sfuparkingmayhem.screen.LoseScreenConcord;
import com.sfuparkingmayhem.screen.LoseScreenScore;
import com.sfuparkingmayhem.screen.MainMenu;

/**
 * This class initializes windows (win/lose/Main Menu/Instructions) to play the game.
 * 
 * @author Group 25
 * @version 1.0
 */
public class Game {
    /**
     * Constructor for Game object.
     * Initializes the window for the game. Displays different windows to show instructions,
     * main menu, or to indicate if player has won/lost game.
     */
    public Game()
    {
        //create a window in which the game will run
        JFrame window = new JFrame("SFU Parking Mayhem");
        
        //make sure the program shuts down when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create a cardLayout which will hold different screens and cardPanel which will act as the main panel that the user sees
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        
        MainMenu mainMenu = new MainMenu(cardLayout, cardPanel); //create main menu panel
        Instructions instructions = new Instructions(cardLayout, cardPanel); //create instructions panel
        LoseScreenScore loseScreenScore = new LoseScreenScore(cardLayout, cardPanel); //create score lose screen panel
        LoseScreenConcord loseScreenConcord = new LoseScreenConcord(cardLayout, cardPanel); //create concord lose screen panel
        //win screen is not initialized here because it takes in score and time parameters

        //add all panels to the list of panels
        cardPanel.add(mainMenu, "MainMenu");
        cardPanel.add(instructions, "Instructions");
        cardPanel.add(loseScreenScore, "Lose Screen Score");
        cardPanel.add(loseScreenConcord, "Lose Screen Concord");

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

        //show main menu panel on start
        cardLayout.show(cardPanel, "MainMenu");
    }
}