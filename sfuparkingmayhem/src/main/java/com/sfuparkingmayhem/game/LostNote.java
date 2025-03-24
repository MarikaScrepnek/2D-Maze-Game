package com.sfuparkingmayhem.game;

import java.util.ArrayList;

/**
 * This class extends Reward class and contains a constructor, getImage method to get the png 
 * of this LostNote from resources directory, and method to randomly generate X and Y coordinates
 * for this LostNote
 * 
 * @author Group 25
 * @version 1.0
 */

public class LostNote extends Reward {

    /**
     * Constructs a LostNote object using the X and Y coordinates and getImage method
     *
     * @param x The x-coordinate of the LostNote.
     * @param y The y-coordinate of the LostNote.
     */
    public LostNote(int x, int y, Board board) {
        super(x, y);
        getImage("lost_notes_resized.png");
        setLostNote(board);
    }

    /**
     * Generates random X and Y coordinates for this LostNote.
     */
    protected void generateCoords(){
        int a = 1;
        int b = 14;

        int randomNum = a + (int) Math.abs(Math.random() * (a - b));
        int randomNum2= a + (int) Math.abs(Math.random() * (a - b));

        this.x_coordinate = randomNum;
        this.y_coordinate = randomNum2;

        }

    /**
     * Sets coordinates for lost note.
     * The lostnote's random coordinates are verified if an entity already exists on that coordinate,
     * if so, lostnote needs to have another set of random coordinates generated.
     * Finally adds its to the lost note ArrayList.
     */
    protected final void setLostNote(Board board) { 
        //boolean value needed for do-while loop
        boolean check;
        ArrayList<Coin> coins = board.coins;
        ArrayList<ParkedCar> parkedCars = board.parkedCars;
        ArrayList<Cone> cones = board.cones;

        do{
            generateCoords(); //generate random x and y coordinates

            check = false; //assume that it is not needed to find another set of coords for lostNote

            //check all the coins to see if any of the coins' coords matches the lostnotes' coords
            for (int i = 0; i < coins.size(); i++){

                //get a coin in the coins arraylist
                Coin coin = coins.get(i);

                //get the x and y coordinates of that coin
                int coinXCoord = coin.getX_coordinate();
                int coinYCoord = coin.getY_coordinate();

                //boolean variables needed for checking if the lostnote has matching coordinates
                boolean coinCoordConflict = false;

                if (this.getX_coordinate() == coinXCoord && this.getY_coordinate() == coinYCoord){
                    coinCoordConflict = true;
                }

                //check if another entity is already on that position on board
                if(coinCoordConflict){

                    //set check to be true as another set of coords needs to be generate for lostNote
                    check = true;

                    //already know there is a coin's coordinates that matches lostnotes's coordinates so break out of for loop
                    break;
                }
            }


            for (int i = 0; i < parkedCars.size(); i++){
                //get a coin in the coins arraylist
                ParkedCar pc = parkedCars.get(i);

                //get the x and y coordinates of that ParkedCar
                int pcXCoord = pc.getX_coordinate();
                int pcYCoord = pc.getY_coordinate();



                //boolean variables needed for checking if the lostnote has matching coordinates
                boolean pcCoordConflict = false;

                if (this.getX_coordinate() == pcXCoord && this.getY_coordinate() == pcYCoord){
                    pcCoordConflict = true;
                }

                //check if another entity is already on that position on board
                if(pcCoordConflict){

                    //set check to be true as another set of coords needs to be generate for lostNote
                    check = true;

                    //already know there is a coin's coordinates that matches lostnotes's coordinates so break out of for loop
                    break;
                }

            }

            //check cones' coordinates to see if any match with the lostnote's coordinates
            for (int i = 0; i < cones.size(); i++){
                //get a cone in the cone arraylist
                Cone cone = cones.get(i);

                //get the x and y coordinates of that cone
                int coneXCoord = cone.getX_coordinate();
                int coneYCoord = cone.getY_coordinate();

                //boolean variables needed for checking if the lostnote has matching coordinates
                boolean coneCoordConflict = false;

                if (this.getX_coordinate() == coneXCoord && this.getY_coordinate() == coneYCoord){
                    coneCoordConflict = true;
                }

                //check if another entity is already on that position on board
                if(coneCoordConflict){

                    //set check to be true as another set of coords needs to be generate for lostNote
                    check = true;

                    //already know there is a coin's coordinates that matches lostnotes's coordinates so break out of for loop
                    break;
                }

            }

        } while (check);
    }
}


