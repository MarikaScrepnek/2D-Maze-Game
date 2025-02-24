package com.sfuparkingmayhem.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Board extends JPanel{
    private final int rows = 15;
    private final int columns = 15;
    private final int cellsize = 50;
    private final int[][] board = new int[rows][columns];
    public Board() {
        //set game board size to be the same as the window size
        setPreferredSize(new Dimension(1280,720));
        //set the background color to a concrete grey
        setBackground(new Color(153, 153, 153));
    }
}