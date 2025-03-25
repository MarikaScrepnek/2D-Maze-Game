package com.sfuparkingmayhem.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;
import java.awt.CardLayout;

public class BarrierTest {

    Barrier barrier;
    Board aBoard;
    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setUp(){

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        aBoard = new Board(cardLayout, cardPanel);

        barrier = new Barrier(0, 0, aBoard);
        
    }
    
}
