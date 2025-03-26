package com.sfuparkingmayhem.game;

import java.awt.event.KeyEvent;

import java.awt.CardLayout;
import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ConcordOfficerTest {


    ConcordOfficer officer;

    Board board;
    CardLayout cardLayout;
    JPanel cardPanel;

    @BeforeEach
    public void setUp(){

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        board = new Board(cardLayout, cardPanel);
        board.cones = new ArrayList<>();
        board.parkedCars = new ArrayList<>();

        // Add some cones and parked cars to the board
        board.cones.add(new Cone(2, 3, board));
        board.cones.add(new Cone(4, 5, board));
        board.parkedCars.add(new ParkedCar(6, 7, board));
        board.parkedCars.add(new ParkedCar(8, 9, board));

        officer = new ConcordOfficer(1,2,board){
            @Override
            protected void delayedMove(KeyEvent event) {
            }
        };
        
    }

    @Test
    public void testOfficerConstruction() {
        assertNotNull(officer, "Officer should not be null after setup.");
        assertEquals(1, officer.getX_coordinate());
        assertEquals(2, officer.getY_coordinate());
    }

    @Test
    void testOfficerCollidingWithCone() {
        assertTrue(officer.isCollidingWithCone(2, 3)); // Collides with a cone
        assertTrue(officer.isCollidingWithCone(4, 5)); // Collides with another cone
        assertFalse(officer.isCollidingWithCone(1, 1)); // Does not collide
    }

    @Test
    void testOfficerCollidingWithParkedCars() {
        assertTrue(officer.isCollidingWithParkedCar(6, 7)); // Collides with a parked car
        assertTrue(officer.isCollidingWithParkedCar(8, 9)); // Collides with another parked car
        assertFalse(officer.isCollidingWithParkedCar(1, 1)); // Does not collide
    }

    @Test
    void testOfficerCollisionWithConeRevertsPosition() {
        officer.x_coordinate = 2;
        officer.y_coordinate = 3; // Position of a cone
        int oldX = officer.getX_coordinate();
        int oldY = officer.getY_coordinate();

        officer.delayedMove(null); // Simulate movement

        assertEquals(oldX, officer.getX_coordinate(), "Officer should revert to old X after colliding with a cone.");
        assertEquals(oldY, officer.getY_coordinate(), "Officer should revert to old Y after colliding with a cone.");
    }

    @Test
    void testOfficerCollisionWithParkedCarRevertsPosition() {
        officer.x_coordinate = 6;
        officer.y_coordinate = 7; // Position of a parked car
        int oldX = officer.getX_coordinate();
        int oldY = officer.getY_coordinate();

        officer.delayedMove(null); // Simulate movement

        assertEquals(oldX, officer.getX_coordinate(), "Officer should revert to old X after colliding with a parked car.");
        assertEquals(oldY, officer.getY_coordinate(), "Officer should revert to old Y after colliding with a parked car.");
    }
}   
