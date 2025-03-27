package com.sfuparkingmayhem.game;

public class Dimensions {
    private final int ROWS;
    private final int COLUMNS;
    private final int CELL_SIZE;

    public Dimensions() {
        ROWS = 15;
        COLUMNS = 15;
        CELL_SIZE = 50;
    }

    public int get_rows() {
        return ROWS;
    }

    public int get_columns() {
        return COLUMNS;
    }

    public int get_cell_size() {
        return CELL_SIZE;
    }
}