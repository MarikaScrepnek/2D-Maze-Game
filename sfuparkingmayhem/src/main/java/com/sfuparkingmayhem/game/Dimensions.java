package com.sfuparkingmayhem.game;


/**
 * This Dimensions class extends contains the following methods: a constructor
 * and getters to get the values of the ROWS, COLUMNS, and CELL_SIZE attributes.
 *
 * @author Group25
 * @version 1.0
 */
public class Dimensions {
    /**
     * Field holding number of rows on the board.
     */
    private final int ROWS;
    /**
     * Field holding number of columns on the board.
     */
    private final int COLUMNS;
    /**
     * Field holding cell size.
     */
    private final int CELL_SIZE;

    /**
     * Initialize dimensions of the board.
     */
    public Dimensions() {
        ROWS = 15;
        COLUMNS = 15;
        CELL_SIZE = 50;
    }

    /**
     * Getter method to get number of rows.
     * 
     * @return ROWS Number of rows in the board.
     */
    public int get_rows() {
        return ROWS;
    }

    /**
     * Getter method to get number of columns.
     * 
     * @return COLUMNS Number of columns in the board.
     */
    public int get_columns() {
        return COLUMNS;
    }

    /**
     * Getter method to get cell size.
     * 
     * @return CELL_SIZE The cell size of each cell in the board (CELL_SIZE x CELL_SIZE).
     */
    public int get_cell_size() {
        return CELL_SIZE;
    }
}