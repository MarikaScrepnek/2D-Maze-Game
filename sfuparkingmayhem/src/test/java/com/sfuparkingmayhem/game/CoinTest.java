package com.sfuparkingmayhem.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;
import java.awt.CardLayout;


public class CoinTest {
    
    Coin coin;
    Board aBoard;
    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setUp(){

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        aBoard = new Board(cardLayout, cardPanel);

        coin = new Coin(1,2,aBoard);
        
    }
    


}
