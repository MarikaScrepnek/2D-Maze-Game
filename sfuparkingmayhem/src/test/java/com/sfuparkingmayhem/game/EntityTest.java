package com.sfuparkingmayhem.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;
import java.awt.CardLayout;

public class EntityTest {

    Entity entityMainChar;
    Entity entityOfficer;
    Entity entityCone;
    Entity entityCoin;
    Entity entityLostNote;
    Entity entityParkedCar;
    Board aBoard;
    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setUp(){

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        aBoard = new Board(cardLayout, cardPanel);
        
    }

    @Test
    public void createMainCharacterEntity(){
        entityMainChar = new MainCharacter(1,2,aBoard);
        assertNotNull(entityMainChar);
    }

    @Test
    public void createConcordOfficerEntity(){

    }

    @Test
    public void createConeEntity(){
        
    }

    @Test
    public void createCoinEntity(){
        
    }

    @Test
    public void createLostNoteEntity(){
        
    }

    @Test
    public void createParkedCarEntity(){
        
    }

    
}
