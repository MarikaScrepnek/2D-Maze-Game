package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 * Class serves as an abstract base class for game-over screens.
 * It extends the Screen class and provides a common structure for different
 * types of end screens, such as win or lose screens.
 */
public abstract class EndScreen extends Screen {
    /**
     * Constructs an EndScreen with a main menu button which is needed in every end screen.
     *
     * @param cardLayout The CardLayout used for switching between screens.
     * @param cardPanel  The JPanel that contains all the game screens.
     */
    public EndScreen (CardLayout cardLayout, JPanel cardPanel) {
        //call Screen constructor
        super(cardLayout, cardPanel);

        //set position and dimension of main menu button
        main_menu_button.setBounds(278, 410, 192, 64);

        //add main menu button to panel
        add(main_menu_button);
    }
}