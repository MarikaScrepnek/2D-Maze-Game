package com.sfuparkingmayhem.screen;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sfuparkingmayhem.game.Board;

public class MainMenu extends Screen {

    public MainMenu(CardLayout cardLayout, JPanel cardPanel) { //initializes variables and load button images
        super(cardLayout, cardPanel);

        setBackground(new Color(111, 194, 232));
        
        JLabel titleLabel = new JLabel("SFU Parking Mayhem", SwingConstants.CENTER);
        titleLabel.setFont(kenneyFont);
        titleLabel.setForeground(Color.WHITE); // Set title text color
        titleLabel.setBounds(0, 150, 750, 50);
        

        start_game_button.setBounds(278, 250, 192, 64); // Position the start game button
        instructions_button.setBounds(278, 330, 192, 64); // Position the instructions button
        exit_button.setBounds(278, 410, 192, 64); // Position the exit button

        start_game_button.addActionListener((ActionEvent e) -> {
            Board board = new Board(cardLayout, cardPanel);
            cardPanel.add(board, "GameBoard");
            cardLayout.show(cardPanel, "GameBoard");
            board.setFocusable(true);
            board.requestFocusInWindow();
            board.addKeyListener(board);
        });

        instructions_button.addActionListener((ActionEvent e) -> {
            cardLayout.show(cardPanel, "Instructions");
        });

        exit_button.addActionListener((ActionEvent e) -> {
            System.exit(0); // Exit the program
        });

        add(titleLabel);
        add(start_game_button);
        add(instructions_button);
        add(exit_button);
    }
}