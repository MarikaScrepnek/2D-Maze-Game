package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class representing the screen displayed when the player wins the game.
 * It extends the EndScreen class and displays the player's final score and completion time.
 * 
 * @author Group 25
 * @version 1.0
 */
public class WinScreen extends EndScreen {
    /**
     * Constructs a WinScreen with a showing that they win and displays their score and time.
     *
     * @param cardLayout The CardLayout used for switching between screens.
     * @param cardPanel  The JPanel that contains all the game screens.
     * @param score      The player's final score.
     * @param time       The total time taken to complete the game (in seconds).
     */
    public WinScreen(CardLayout cardLayout, JPanel cardPanel, int score, int time) {
        //call EndScreen constructor
        super(cardLayout, cardPanel);

        //set background color to green
        setBackground(new Color(35, 102, 14));
        
        //create "you win" label
        JLabel winLabel = new JLabel("You Win!", SwingConstants.CENTER);
        //set font
        winLabel.setFont(kenneyFont);
        //set color
        winLabel.setForeground(Color.WHITE);
        //set position and dimensions
        winLabel.setBounds(0, 150, 750, 50);

        //create score label
        JLabel scoreLabel = new JLabel("Score: " + score, SwingConstants.CENTER);
        //set font with smaller font size
        scoreLabel.setFont(kenneyFont.deriveFont(24f));
        //set color
        scoreLabel.setForeground(Color.WHITE);
        //set position and dimensions
        scoreLabel.setBounds(0, 200, 750, 50);

        //create time label
        JLabel timeLabel = new JLabel("Time: " + time/60 + " minutes, " + time%60 + " seconds", SwingConstants.CENTER);
        //set font with smaller font size
        timeLabel.setFont(kenneyFont.deriveFont(24f));
        //set color
        timeLabel.setForeground(Color.WHITE);
        //set position and dimensions
        timeLabel.setBounds(0, 250, 750, 50);

        //add elements to panel
        add(winLabel);
        add(scoreLabel);
        add(timeLabel);
    }
}


