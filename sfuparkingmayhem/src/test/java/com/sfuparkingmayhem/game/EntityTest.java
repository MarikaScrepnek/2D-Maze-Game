package com.sfuparkingmayhem.game;

import java.awt.CardLayout;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//abstract class
public class EntityTest {

    Entity entityMainChar;
    Entity entityOfficer;
    Entity entityCone;
    Entity entityCoin;
    Entity entityLostNote;
    Entity entityParkedCar;
    Entity entityBarrier; 
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

    //this test might allow us to get rid of the BarrierTest.java file
    @Test
    public void createBarrierEntity(){
        
    }

    
}
