package com.sfuparkingmayhem.game;

import java.util.ArrayList;
import java.util.List;

public class EntityLists {
    /**
     * Arraylists holding all coins in the game.
     */
    ArrayList<Coin> coins;
    /**
     * Arraylists holding all cones in the game.
     */
    ArrayList<Cone> cones;
    /**
     * Arraylists holding all parked cars in the game.
     */
    ArrayList<ParkedCar> parkedCars;
    /**
     * Arraylists holding all lost notes in the game.
     */
    List<LostNote> ln;

    /**
     * Initializes ArrayLists to hold all types of Entities
     * (coins, cones, parked cars, lost notes).
     */
    public EntityLists() {
        coins = new ArrayList<>();
        cones = new ArrayList<>();
        parkedCars = new ArrayList<>();
        ln = new ArrayList<>(); 
    }
}
