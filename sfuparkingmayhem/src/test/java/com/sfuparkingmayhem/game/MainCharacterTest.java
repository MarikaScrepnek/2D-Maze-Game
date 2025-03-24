package com.sfuparkingmayhem.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;
import java.awt.CardLayout;


public class MainCharacterTest {


    MainCharacter mainChar;
    Board aBoard;
    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    void setUp() {
            
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        aBoard = new Board(cardLayout, cardPanel);

        mainChar = new MainCharacter(1, 2, aBoard);
    }

    @Test
    public void getMainCharacterXCoordinate(){

        int x_coord = mainChar.getX_coordinate();

        assertEquals(1, x_coord);
    }
    

    @Test
    public void getMainCharacterYCoordinate(){

        int y_coord = mainChar.getY_coordinate();

        assertEquals(2, y_coord);
    }

    @Test
    public void moveMainCharacterUpward(){

    }

    @Test
    public void moveMainCharacterUpwardIntoBush(){

    }

    @Test
    public void moveMainCharacterLeft(){

    }

    @Test
    public void moveMainCharacterLeftIntoBush(){

    }

    @Test
    public void moveMainCharacterRight(){

    }

    @Test
    public void moveMainCharacterRightIntoBush(){

    }

    @Test
    public void moveMainCharacterDown(){

    }

    @Test
    public void moveMainCharacterDownIntoBush(){

    }

}
