package com.sfuparkingmayhem.game;

//import java swing

import javax.swing.JFrame;

/**
 *
 *
 */
public class Game 
{
    public Game() {
    }

    public void initWindow()
    {
        //create a window in which the game will run
        JFrame window = new JFrame("SFU Parking Mayhem");
        
        //make sure the program shuts down when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CardLayout cardLayout = new CardLayout();
        //JPanel cardPanel = new JPanel(cardLayout);
        
        //MainMenu mainMenu = new MainMenu(); // Main menu panel
        Board board = new Board();  // Game panel (board)
        //Instructions instructions = new Instructions();

        //cardPanel.add(mainMenu, "MainMenu");
        //cardPanel.add(board, "GameBoard");
        //cardPanel.add(instructions, "Instructions");

        //add the board panel to the window (instead of board it could be different screens)
        //window.add(cardPanel);
        window.add(board);
        //make board panel able to read keyboard inputs (uncomment when moving is implemented)
        window.addKeyListener(board);

        //dont allow user to resize the window
        window.setResizable(false);
        //fit the window size around panels, avoids issues on some platforms
        window.pack();
        //open the window in the center of the screen
        window.setLocationRelativeTo(null);

        //make the window visible to the user, keep this at the bottom to make sure user only sees the ready window
        window.setVisible(true);

        //cardLayout.show(cardPanel, "MainMenu");
    }
}