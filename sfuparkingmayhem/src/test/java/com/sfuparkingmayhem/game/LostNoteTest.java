package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;

public class LostNoteTest {
    CardLayout cardLayout;
    JPanel cardPanel;
    Board board;
    LostNote lostNote;

    @BeforeEach
    public void setUp(){
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        board = new Board(cardLayout, cardPanel);

        lostNote = new LostNote(0, 0, board);
    }
}
