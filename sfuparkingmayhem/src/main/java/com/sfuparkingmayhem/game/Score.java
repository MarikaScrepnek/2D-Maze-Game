package com.sfuparkingmayhem.game;
/**
 * The Score class keeps track of the player's score.
 */
public class Score {
    private int score;

    /**
     * Constructs a Score object.
     */
    public Score() {
        this.score = 0;
    }

    /**
     * Adds points to the score.
     *
     * @param points The number of points to add.
     */
    protected void addPoints(int points) {
        this.score += points;
    }

    /**
     * Subtracts points from the score.
     *
     * @param points The number of points to subtract.
     */
    protected void subtractPoints(int points) {
        this.score -= points;
    }

    /**
     * Resets the score to 0.
     */
    protected void reset() {
        this.score = 0;
    }

    /**
     * Returns the score.
     *
     * @return The score.
     */
    public int getScore() {
        return this.score;
    }
}
