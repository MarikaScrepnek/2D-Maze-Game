package com.sfuparkingmayhem.game;

import java.awt.CardLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        board.entityLists.cones = new ArrayList<>();
        board.entityLists.parkedCars = new ArrayList<>();

        // Create a main character
        board.main_character = new MainCharacter(1,2,board);

        // Add some cones and parked cars to the board
        board.entityLists.cones.add(new Cone(2, 3, board));
        board.entityLists.cones.add(new Cone(4, 5, board));
        board.entityLists.parkedCars.add(new ParkedCar(6, 7, board));
        board.entityLists.parkedCars.add(new ParkedCar(8, 9, board));

        officer = new ConcordOfficer(1, 2, board); 
        board.officer = officer; 
        
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

    @Test
    void testOfficerCollisionWithMainCharacterEndsGame() {
        officer.x_coordinate = 3;
        officer.y_coordinate = 4;

        // Position of the officer
        board.main_character.x_coordinate = 3;
        board.main_character.y_coordinate = 4; 
        
        board.game_ended = true;

        officer.officerTimer.getActionListeners()[0].actionPerformed(null); // Simulate movement

        assertTrue(board.game_ended, "Game should end when officer collides with main character.");
    }

    @Test
    void testOfficerDoesNotCollideWithMainCharacter() {
        officer.x_coordinate = 5;
        officer.y_coordinate = 6;

        board.main_character.x_coordinate = 7;
        board.main_character.y_coordinate = 8;

        board.game_ended = false;

        officer.officerTimer.getActionListeners()[0].actionPerformed(null);

        assertFalse(board.game_ended, "Game should not end when officer does not collide with main character.");
    }

    @Test
    public void testOfficerDelayedMoveRight() {
        board.officer.x_coordinate = 5;
        board.officer.y_coordinate = 5;
        board.main_character.x_coordinate = 6;
        board.main_character.y_coordinate = 5;
    
        board.officer.delayedMove(null);
    
        assertEquals(6, board.officer.getX_coordinate());
        assertEquals(5, board.officer.getY_coordinate());
    }
    
    @Test
    public void testOfficerDelayedMoveLeft() {
        board.officer.x_coordinate = 6;
        board.officer.y_coordinate = 5;
        board.main_character.x_coordinate = 5;
        board.main_character.y_coordinate = 5;
    
        board.officer.delayedMove(null);
    
        assertEquals(5, board.officer.getX_coordinate());
        assertEquals(5, board.officer.getY_coordinate());
    }
    
    @Test
    public void testOfficerDelayedMoveDown() {
        board.officer.x_coordinate = 5;
        board.officer.y_coordinate = 5;
        board.main_character.x_coordinate = 5;
        board.main_character.y_coordinate = 6;
    
        board.officer.delayedMove(null);
    
        assertEquals(5, board.officer.getX_coordinate());
        assertEquals(6, board.officer.getY_coordinate());
    }
    
    @Test
    public void testOfficerDelayedMoveUp() {
        ConcordOfficer officer = new ConcordOfficer(3, 4, board) {
            @Override
            public java.util.List<Point> findPathDijkstra(int startX, int startY, int endX, int endY) {
                // Force a path that moves up
                java.util.List<Point> path = new ArrayList<>();
                path.add(new Point(3, 4)); // current position
                path.add(new Point(3, 3)); // next position (up)
                return path;
            }
        };
        board.officer = officer;
    
        // Run the move logic
        officer.delayedMove(null);
    
        // Officer should have moved up
        assertEquals(3, officer.getX_coordinate());
        assertEquals(3, officer.getY_coordinate());
    }
    
}   
