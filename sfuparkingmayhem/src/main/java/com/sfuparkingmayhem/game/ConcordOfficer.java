package com.sfuparkingmayhem.game;

public class ConcordOfficer extends MovingEntity{
    // Reference to the MainCharacter
    private MainCharacter target;

    /**
     * Constructs a ConcordOfficer that will chase the MainCharacter.
     *
     * @param x_coordinate The initial x-coordinate of this ConcordOfficer.
     * @param y_coordinate The initial y-coordinate of this ConcordOfficer.
     * @param target       The MainCharacter to chase.
     */
    public ConcordOfficer(int x_coordinate, int y_coordinate, MainCharacter target) {
        super(x_coordinate, y_coordinate);
        this.target = target;
        getImage(); // Load the sprite/image for this entity
    }
    
}
