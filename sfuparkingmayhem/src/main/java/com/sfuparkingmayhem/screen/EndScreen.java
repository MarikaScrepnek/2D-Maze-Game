package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;

import javax.swing.JPanel;

public abstract class EndScreen extends Screen {
    public EndScreen (CardLayout cardLayout, JPanel cardPanel) {
        //call Screen constructor
        super(cardLayout, cardPanel);

        //set position and dimension of main menu button
        main_menu_button.setBounds(278, 410, 192, 64);
    }
}