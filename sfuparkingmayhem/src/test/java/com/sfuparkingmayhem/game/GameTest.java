package com.sfuparkingmayhem.game;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class GameTest {

    Game game;

    @BeforeEach
    public void setUp(){
        game = new Game();
    }

    @Test
    public void testGameConstruction() {
        assertNotNull(game, "Game should not be null after setup.");
    }
}
