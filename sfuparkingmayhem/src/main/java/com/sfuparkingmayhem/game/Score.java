package com.sfuparkingmayhem.game;

/**
 * This Score class keeps track of the player's score and contains a 
 * constructor and methods to get and add/subtract/reset the value of this score.
 */
public class Score {
    /**
     * The score of the player/game/board.
     */
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
     * @param points The number of points to add to score.
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
     * Resets this score to 0.
     */
    protected void reset() {
        this.score = 0;
    }

    /**
     * Returns this score
     *
     * @return this.score
     */
    public int getScore() {
        return this.score;
    }
}
