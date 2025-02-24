package com.sfuparkingmayhem.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Board extends JPanel{

    private final int DELAY = 25;

    private MainCharacter player;
    //private Timer timer;

    public Board() {
        //set game board size to be the same as the window size
        setPreferredSize(new Dimension(1280,720));
        //set the background color to a concrete grey
        setBackground(new Color(153, 153, 153));

        // initialize game state
        
    }
}