package com.sfuparkingmayhem.game;

public class Score {
    private int score;

    public Score() {
        this.score = 0;
    }

    protected void addPoints(int points) {
        this.score += points;
    }

    protected void subtractPoitns(int points) {
        this.score -= points;
    }

    protected void reset() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }
}
