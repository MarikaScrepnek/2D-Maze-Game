package com.sfuparkingmayhem.game;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovingEntityTest {

    private MovingEntity movingEntity;
    private Board board;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    @BeforeEach
    public void setUp() {
        board = new Board(cardLayout, cardPanel);
        board.entityLists.cones = new ArrayList<>();
        board.entityLists.parkedCars = new ArrayList<>();

        // Add some cones and parked cars to the board
        board.entityLists.cones.add(new Cone(2, 3, board));
        board.entityLists.cones.add(new Cone(4, 5, board));
        board.entityLists.parkedCars.add(new ParkedCar(6, 7, board));
        board.entityLists.parkedCars.add(new ParkedCar(8, 9, board));

        // Create a concrete subclass of MovingEntity for testing
        movingEntity = new MovingEntity(0, 0, board) {
            @Override
            protected void delayedMove(KeyEvent event) {}
        };
    }
    @Test
    void testConstructor() {
        assertNotNull(movingEntity); // Ensure the object is created
        assertEquals(0, movingEntity.getX_coordinate());
        assertEquals(0, movingEntity.getY_coordinate());
    }

    @Test
    void testIsCollidingWithCone() {
        assertTrue(movingEntity.isCollidingWithCone(2, 3)); // Collides with a cone
        assertTrue(movingEntity.isCollidingWithCone(4, 5)); // Collides with another cone
        assertFalse(movingEntity.isCollidingWithCone(1, 1)); // Does not collide
    }

    @Test
    void testIsCollidingWithParkedCar() {
        assertTrue(movingEntity.isCollidingWithParkedCar(6, 7)); // Collides with a parked car
        assertTrue(movingEntity.isCollidingWithParkedCar(8, 9)); // Collides with another parked car
        assertFalse(movingEntity.isCollidingWithParkedCar(1, 1)); // Does not collide
    }

    @Test
    void testIsCollidingWithParkedCarNoCollision() {
        assertFalse(movingEntity.isCollidingWithParkedCar(1, 1)); // Does not collide
        assertFalse(movingEntity.isCollidingWithParkedCar(10, 10)); // Does not collide
    }

    @Test 
    void testIsCollidingWithParkedCarEmpty() {
        board.entityLists.parkedCars.clear();
        assertFalse(movingEntity.isCollidingWithParkedCar(6, 7)); // Does not collide
        assertFalse(movingEntity.isCollidingWithParkedCar(8, 9)); // Does not collide
    }

    @Test
    void testIsCollidingWithParkedCar_CloseCoordinates() {
        // Test coordinates that are close but not matching
        assertFalse(movingEntity.isCollidingWithParkedCar(6, 8)); // Close but not a collision
        assertFalse(movingEntity.isCollidingWithParkedCar(7, 7)); // Close but not a collision
    }
}
