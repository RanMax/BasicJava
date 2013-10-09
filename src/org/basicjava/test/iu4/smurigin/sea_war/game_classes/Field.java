package org.basicjava.test.iu4.smurigin.sea_war.game_classes;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Field extends JComponent{
    public Cell field[][] = new Cell [13] [13];
    public String nameOfPlayer;
    private int shipsLive = Ships.ships_quantity;
    public static int j = 0;

    public Field(String name){
        this.nameOfPlayer = name;
        this.createFieldFromCells();
    }

    public int getShipsLive() {
        return shipsLive;
    }

    public void subtractShipsLive() {
        shipsLive--;
    }

    private void createFieldFromCells(){
        for (int i=1; i<13; i++){
            for (int j=1; j<13; j++){
                //Create border for field
                if(i==1 || i==12 || j==1 || j == 12)
                    field[i][j] = new Cell(i, j, Cell.NUMBER_FOR_BORDER);
                //Create field with 0 value
                else
                    field[i][j] = new Cell(i, j, 0);
            }
        }
    }

    //Method for clearing field(is needed for regenerate field)
    private void clearField(){
        for (int i = 2; i < 12; i++){
            for (int j = 2; j < 12; j++){
                field[i][j].setStateOfCell(0);
                field[i][j].setWasFired(0);
            }
        }
    }

    // Method for printing positions and coordinates and field
    public void printField(){
        int i=0;
        System.out.println("Field of " + nameOfPlayer);

        System.out.print("   ");

        //Print first row with numbers of columns
            System.out.print("A  ");
            System.out.print("B  ");
            System.out.print("C  ");
            System.out.print("D  ");
            System.out.print("E  ");
            System.out.print("F  ");
            System.out.print("G  ");
            System.out.print("I  ");
            System.out.print("J  ");
            System.out.println("K  ");


        for (i=2; i<12; i++){
            //Print numbers of rows
            if (i>10)
                System.out.print((i-1)+" ");
            else
                System.out.print((i-1)+"  ");

            //Print Cells value
            for (int j=2; j<12; j++){
                System.out.print(field[i][j].getStateOfCell() + "  ");
            }
            System.out.println();
        }
    }

    public void createFieldRandShips(){
        createFieldFromCells();
        clearField();
        Ships.createShips();
        placeFourLengthShips();
        placeThreeLengthShips();
        placeTwoLengthShips();
        placeOneLengthShips();
        printBoarderOfField();
    }

    //*****Methods for input random Ships****//
    // Random create four length ships
    private void placeFourLengthShips(){
        Random rand = new Random();
        int mulX = 0, mulY = 0;

        for (int i = 0; i < Ships.FOUR_LENGTH_SHIPS; i++){
            int x=0, y=0;
            while ((x<2) || (y<2) ){
                x = rand.nextInt(11);
                y = rand.nextInt(11);
            }

            boolean position = rand.nextBoolean(); // TRUE  = Vertical
                                                   // FALSE = Horizontal
            if (position){
                mulX = 0; mulY = 1;
            } else {
                mulX = 1; mulY = 0;
            }

            if ((field[x][y].getStateOfCell() == 0) &&
                (field[x + mulX][y+mulY].getStateOfCell() == 0) &&
                (field[x + mulX*2][y+mulY*2].getStateOfCell() == 0) &&
                (field[x + mulX*3][y+mulY*3].getStateOfCell() == 0)){
                    //Placing the ship
                    field[x][y].setShipInCell(Ships.allShips[j]);
                    field[x][y].shipInCell.setShipBegX(x);
                    field[x][y].shipInCell.setShipBegY(y);
                    field[x][y].shipInCell.setPositionOfShip(position);
                    field[x + mulX][y+mulY].setShipInCell(Ships.allShips[j]);
                    field[x + mulX*2][y+mulY*2].setShipInCell(Ships.allShips[j]);
                    field[x + mulX*3][y+mulY*3].setShipInCell(Ships.allShips[j]);

                    //Placing exceptions value to neighbouring cells
                    field[x-1][y-1].setStateOfCell(5);
                    field[x][y-1].setStateOfCell(5);
                    field[x-1][y].setStateOfCell(5);
                    field[x+1][y-1].setStateOfCell(5);
                    field[x-1][y+1].setStateOfCell(5);
                    field[x+1][y+1].setStateOfCell(5);

                    field[x-1+mulX*3][y-1+mulY*3].setStateOfCell(5);
                    field[x-1+mulX*4][y-1+mulY*4].setStateOfCell(5);
                    field[x-1+mulX*5][y-1+mulY*5].setStateOfCell(5);

                    field[x+mulX*4][y+mulY*4].setStateOfCell(5);
                    field[x+mulY][y+mulX].setStateOfCell(5);

                    field[x+1+mulX][y+1+mulY].setStateOfCell(5);
                    field[x+1+mulX*2][y+1+mulY*2].setStateOfCell(5);
                    field[x+1+mulX*3][y+1+mulY*3].setStateOfCell(5);
                    j++;
            }
            else i--;
        }

    }


    // Random create three length ships
    private void placeThreeLengthShips(){
        Random rand = new Random();
        int mulX = 0, mulY = 0;

        for (int i = 0; i < Ships.THREE_LENGTH_SHIPS; i++){
            boolean b = false;
            while (!b){
                int x=0, y=0;
                while ((x<2) || (y<2) ){
                    x = rand.nextInt(12);
                    y = rand.nextInt(12);
                }

                boolean position = rand.nextBoolean(); // TRUE  = Vertical
                                                       // FALSE = Horizontal
                if (position){
                    mulX = 0; mulY = 1;
                } else {
                    mulX = 1; mulY = 0;
                }

                if ((field[x][y].getStateOfCell() == 0) &&
                    (field[x + mulX][y+mulY].getStateOfCell() == 0) &&
                    (field[x + mulX*2][y+mulY*2].getStateOfCell() == 0)){
                        //Placing the ship
                        field[x][y].setShipInCell(Ships.allShips[j]);
                        field[x][y].shipInCell.setShipBegX(x);
                        field[x][y].shipInCell.setShipBegY(y);
                        field[x][y].shipInCell.setPositionOfShip(position);
                        field[x + mulX][y+mulY].setShipInCell(Ships.allShips[j]);
                        field[x + mulX*2][y+mulY*2].setShipInCell(Ships.allShips[j]);

                        //Placing exceptions value to neighbouring cells
                        field[x-1][y-1].setStateOfCell(5);
                        field[x][y-1].setStateOfCell(5);
                        field[x-1][y].setStateOfCell(5);
                        field[x+1][y-1].setStateOfCell(5);
                        field[x-1][y+1].setStateOfCell(5);
                        field[x+1][y+1].setStateOfCell(5);

                        field[x-1+mulX*3][y-1+mulY*3].setStateOfCell(5);
                        field[x-1+mulX*4][y-1+mulY*4].setStateOfCell(5);

                        field[x+mulX*3][y+mulY*3].setStateOfCell(5);
                        field[x+mulY][y+mulX].setStateOfCell(5);

                        field[x+1+mulX][y+1+mulY].setStateOfCell(5);
                        field[x+1+mulX*2][y+1+mulY*2].setStateOfCell(5);

                        b = true;
                }
            }
            j++;
        }
    }

    // Random create two length ships
    private void placeTwoLengthShips(){
        Random rand = new Random();
        int mulX = 0, mulY = 0;

        for (int i = 0; i < Ships.TWO_LENGTH_SHIPS; i++){
            int x=0, y=0;
            while ((x<2) || (y<2) ){
                x = rand.nextInt(12);
                y = rand.nextInt(12);
            }

            boolean position = rand.nextBoolean(); // TRUE  = Vertical
                                                   // FALSE = Horizontal
            if (position){
                mulX = 0; mulY = 1;
            } else {
                mulX = 1; mulY = 0;
            }

            if ((field[x][y].getStateOfCell() == 0) &&
                (field[x + mulX][y+mulY].getStateOfCell() == 0)){
                    field[x][y].setShipInCell(Ships.allShips[j]);
                    field[x][y].shipInCell.setShipBegX(x);
                    field[x][y].shipInCell.setShipBegY(y);
                    field[x][y].shipInCell.setPositionOfShip(position);
                    field[x + mulX][y+mulY].setShipInCell(Ships.allShips[j]);

                    //Placing exceptions value to neighbouring cells
                    field[x-1][y-1].setStateOfCell(5);
                    field[x][y-1].setStateOfCell(5);
                    field[x-1][y].setStateOfCell(5);
                    field[x+1][y-1].setStateOfCell(5);
                    field[x-1][y+1].setStateOfCell(5);
                    field[x+1][y+1].setStateOfCell(5);

                    field[x-1+mulX*3][y-1+mulY*3].setStateOfCell(5);

                    field[x+mulX*2][y+mulY*2].setStateOfCell(5);
                    field[x+mulY][y+mulX].setStateOfCell(5);

                    field[x+1+mulX][y+1+mulY].setStateOfCell(5);
                    j++;
            }
            else i--;
        }
    }

    // Random create one length ships
    private void placeOneLengthShips(){
        Random rand = new Random();

        for (int i = 0; i < Ships.ONE_LENGTH_SHIPS; i++){
            int x=0, y=0;
            while ((x<2) || (y<2) ){
                x = rand.nextInt(11);
                y = rand.nextInt(11);
            }

            if (field[x][y].getStateOfCell() == 0){
                field[x][y].setShipInCell(Ships.allShips[j]);
                field[x][y].shipInCell.setShipBegX(x);
                field[x][y].shipInCell.setShipBegY(y);

                field[x-1][y-1].setStateOfCell(5);
                field[x][y-1].setStateOfCell(5);
                field[x+1][y-1].setStateOfCell(5);
                field[x-1][y].setStateOfCell(5);
                field[x+1][y].setStateOfCell(5);
                field[x-1][y+1].setStateOfCell(5);
                field[x][y+1].setStateOfCell(5);
                field[x+1][y+1].setStateOfCell(5);
                j++;
            }
            else i--;

        }
        j = 0;
    }

    // Border of field
    public void printBoarderOfField(){
       for (int i=1; i<13; i++){
           for (int j=1; j<13; j++){
               if(i==1 || i==12 || j==1 || j == 12)
                   field[i][j] = new Cell(i, j, Cell.NUMBER_FOR_BORDER);
           }
        }
    }
    //************************************//


    //***Methods for deposit killed ships***//
    public void depositKilledShip(Ships killedShip){
        if (killedShip.lengthOfShip==1){
            depositOneBoardShip(killedShip);
            shipsLive--;
        }
        else if (killedShip.lengthOfShip==2){
            depositTwoBoardShip(killedShip);
            shipsLive--;
        }
        else if (killedShip.lengthOfShip==3){
            depositThreeBoardShip(killedShip);
            shipsLive--;
        }
        else if (killedShip.lengthOfShip==4){
            depositFourBoardShip(killedShip);
            shipsLive--;
        }
        printBoarderOfField();
    }

    private void depositOneBoardShip(Ships oneBoardShip){
        int x = oneBoardShip.getShipBegX();
        int y = oneBoardShip.getShipBegY();

        field[x][y].setStateOfCell(7);

        field[x-1][y-1].setWasFired(1);
        field[x][y-1].setWasFired(1);
        field[x+1][y-1].setWasFired(1);
        field[x-1][y].setWasFired(1);
        field[x+1][y].setWasFired(1);
        field[x-1][y+1].setWasFired(1);
        field[x][y+1].setWasFired(1);
        field[x+1][y+1].setWasFired(1);
    }

    private void depositTwoBoardShip(Ships twoBoardShip){
        int x = twoBoardShip.getShipBegX();
        int y = twoBoardShip.getShipBegY();
        int mulX, mulY;
        boolean position = twoBoardShip.getPositionOfShip();

        if (position){
            mulX = 0; mulY = 1;
        } else {
            mulX = 1; mulY = 0;
        }

        //Placing exceptions value to neighbouring cells
        field[x-1][y-1].setWasFired(1);
        field[x][y-1].setWasFired(1);
        field[x-1][y].setWasFired(1);
        field[x+1][y-1].setWasFired(1);
        field[x-1][y+1].setWasFired(1);
        field[x+1][y+1].setWasFired(1);

        field[x-1+mulX*3][y-1+mulY*3].setWasFired(1);

        field[x+mulX*2][y+mulY*2].setWasFired(1);
        field[x+mulY][y+mulX].setWasFired(1);

        field[x+1+mulX][y+1+mulY].setWasFired(1);
    }

    private void depositThreeBoardShip(Ships threeBoardShip){
        int x = threeBoardShip.getShipBegX();
        int y = threeBoardShip.getShipBegY();
        int mulX, mulY;
        boolean position = threeBoardShip.getPositionOfShip();

        if (position){
            mulX = 0; mulY = 1;
        } else {
            mulX = 1; mulY = 0;
        }

        field[x-1][y-1].setWasFired(1);
        field[x][y-1].setWasFired(1);
        field[x-1][y].setWasFired(1);
        field[x+1][y-1].setWasFired(1);
        field[x-1][y+1].setWasFired(1);
        field[x+1][y+1].setWasFired(1);

        field[x-1+mulX*3][y-1+mulY*3].setWasFired(1);
        field[x-1+mulX*4][y-1+mulY*4].setWasFired(1);

        field[x+mulX*3][y+mulY*3].setWasFired(1);
        field[x+mulY][y+mulX].setWasFired(1);

        field[x+1+mulX][y+1+mulY].setWasFired(1);
        field[x+1+mulX*2][y+1+mulY*2].setWasFired(1);
    }

    private void depositFourBoardShip(Ships fourBoardShip){
        int x = fourBoardShip.getShipBegX();
        int y = fourBoardShip.getShipBegY();
        int mulX, mulY;
        boolean position = fourBoardShip.getPositionOfShip();

        if (position){
            mulX = 0; mulY = 1;
        } else {
            mulX = 1; mulY = 0;
        }

        field[x-1][y-1].setWasFired(1);
        field[x][y-1].setWasFired(1);
        field[x-1][y].setWasFired(1);
        field[x+1][y-1].setWasFired(1);
        field[x-1][y+1].setWasFired(1);
        field[x+1][y+1].setWasFired(1);

        field[x-1+mulX*3][y-1+mulY*3].setWasFired(1);
        field[x-1+mulX*4][y-1+mulY*4].setWasFired(1);
        field[x-1+mulX*5][y-1+mulY*5].setWasFired(1);

        field[x+mulX*4][y+mulY*4].setWasFired(1);
        field[x+mulY][y+mulX].setWasFired(1);

        field[x+1+mulX][y+1+mulY].setWasFired(1);
        field[x+1+mulX*2][y+1+mulY*2].setWasFired(1);
        field[x+1+mulX*3][y+1+mulY*3].setWasFired(1);
    }
    //***************************************//

    // method for printing the field in graphic form
    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;
        int k = 0;
        int sizeOfPrintedCell = 25;


        g.setColor(Color.BLACK);
        g.drawString("A",60,45);
        g.drawString("B",60 + sizeOfPrintedCell, 45);
        g.drawString("C",60+2*sizeOfPrintedCell, 45);
        g.drawString("D",60+3*sizeOfPrintedCell, 45);
        g.drawString("E",60+4*sizeOfPrintedCell, 45);
        g.drawString("F",60+5*sizeOfPrintedCell, 45);
        g.drawString("G",60+6*sizeOfPrintedCell, 45);
        g.drawString("I",60+7*sizeOfPrintedCell, 45);
        g.drawString("J",60+8*sizeOfPrintedCell, 45);
        g.drawString("K",60+9*sizeOfPrintedCell, 45);
        for (int i = 1; i < 13; i++){
            if (i>1 && i<12) {
                g.drawString(""+(i-1),35,70+sizeOfPrintedCell*(i-2));
            }
            for (int j = 1; j < 13; j++){
                if (field[i][j].getWasFired()== 1){
                    Color startColor = new Color(60, 60, 60);
                    Color endColor = new Color(150, 150, 150);
                    GradientPaint gradient = new GradientPaint((i)*sizeOfPrintedCell, (j)*sizeOfPrintedCell, startColor,
                                                               (i+1)*sizeOfPrintedCell,(j+1)*sizeOfPrintedCell, endColor);
                    g2d.setPaint(gradient);
                    g2d.fillRect((i)*sizeOfPrintedCell,(j)*sizeOfPrintedCell,sizeOfPrintedCell,sizeOfPrintedCell);
                }
                else if (field[i][j].getStateOfCell() == 6) {
                    g.setColor(Color.GRAY);
                }
                else {
                    if (field[i][j].getStateOfCell() == 1) g.setColor(Color.RED);
                    else if (field[i][j].getStateOfCell() == 2) g.setColor(Color.MAGENTA);
                    else if (field[i][j].getStateOfCell() == 3) g.setColor(Color.DARK_GRAY);
                    else if (field[i][j].getStateOfCell() == 4) g.setColor(Color.BLUE);
                    else if (field[i][j].getStateOfCell() == 5) g.setColor(Color.YELLOW);
                    else if (field[i][j].getStateOfCell() == 7) g.setColor(Color.GRAY);
                    else g.setColor(Color.WHITE);
                    g.fillRect((i)*sizeOfPrintedCell,(j)*sizeOfPrintedCell,sizeOfPrintedCell,sizeOfPrintedCell);
                }
            }
        }
    }

    public Cell[][] getFieldMap() {
        return field;
    }

}

