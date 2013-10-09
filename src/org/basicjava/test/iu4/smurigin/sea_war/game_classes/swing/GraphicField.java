package org.basicjava.test.iu4.smurigin.sea_war.game_classes.swing;

import org.basicjava.test.iu4.smurigin.sea_war.game_classes.Cell;
import org.basicjava.test.iu4.smurigin.sea_war.game_classes.Field;
import org.basicjava.test.iu4.smurigin.sea_war.game_classes.Ships;

import javax.swing.*;
import java.awt.*;

public class GraphicField extends JComponent{

    public static int SECTOR_COUNT = 10;
    public static int SPACE_BETWEEN = 2;
    public static int HEADER_ZONE = 40;

    public static int HEIGHT = HEADER_ZONE + SPACE_BETWEEN * 2 + (GraphicCell.SIZE_OF_PRINTED_CELL + SPACE_BETWEEN) * (SECTOR_COUNT+1);
    public static int WIDTH = HEADER_ZONE + SPACE_BETWEEN * 2 + (GraphicCell.SIZE_OF_PRINTED_CELL + SPACE_BETWEEN) * (SECTOR_COUNT+1);

    private GraphicCell [][] graphicCells = new GraphicCell [SECTOR_COUNT] [SECTOR_COUNT];
    public GraphicCell selectedGraphicCell;

    private static int computerTerns;
    private static int playerTerns;

    public Field field;
    public Gui guiField;

    private boolean isOpen;

    public GraphicField(boolean isOpen, Gui guiField){
        this.isOpen = isOpen;
        this.guiField = guiField;

        for(int i = 0; i < SECTOR_COUNT; i++)
            for(int j = 0; j < SECTOR_COUNT; j++)
                graphicCells[i][j] = new GraphicCell(this, i, j);

        selectedGraphicCell = null;
        setSize(WIDTH, HEIGHT);
        printLettersAndNumbers();
    }

    public int incrementPlayerTerns(){
        return GraphicField.playerTerns++;
    }

    public int incrementComputerTerns(){
        return GraphicField.computerTerns++;
    }

    public void setPlayerTerns(int playerTerns) {
        GraphicField.playerTerns = playerTerns;
    }

    public void setComputerTerns(int computerTerns) {
        GraphicField.computerTerns = computerTerns;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Field getField() {
        return this.field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Gui getGuiField() {
        return guiField;
    }

    public void setGuiField(Gui guiField) {
        this.guiField = guiField;
    }

    public GraphicCell[][] getGraphicCells() {
        return graphicCells;
    }

    public void setGraphicCells(GraphicCell[][] graphicCells) {
        this.graphicCells = graphicCells;
    }

    private void printLettersAndNumbers() {
        char[] letters = {'А', 'B', 'C', 'D', 'E', 'F', 'G', 'I', 'J', 'K'};
        for(int i = 0; i < SECTOR_COUNT; i++) {
            JLabel horizontal = new JLabel(String.valueOf(i + 1));
            if(i < letters.length)
                horizontal.setText(String.valueOf(letters[i]));
            JLabel vertical = new JLabel(String.valueOf(i + 1));
            horizontal.setHorizontalAlignment(JLabel.CENTER);
            horizontal.setVerticalAlignment(JLabel.CENTER);
            vertical.setHorizontalAlignment(JLabel.CENTER);
            vertical.setVerticalAlignment(JLabel.CENTER);
            horizontal.setSize(GraphicCell.SIZE_OF_PRINTED_CELL, HEADER_ZONE);
            vertical.setSize(HEADER_ZONE, GraphicCell.SIZE_OF_PRINTED_CELL);
            horizontal.setLocation(HEADER_ZONE + SPACE_BETWEEN * 2 +
                                  (GraphicCell.SIZE_OF_PRINTED_CELL + SPACE_BETWEEN) * i, SPACE_BETWEEN);
            vertical.setLocation(SPACE_BETWEEN, HEADER_ZONE + SPACE_BETWEEN * 2 +
                                  (GraphicCell.SIZE_OF_PRINTED_CELL + SPACE_BETWEEN) * i);
            add(horizontal);
            add(vertical);
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        //paintGradientBoxForFieldBottom(g2d);
        paintCurrentSelectedElement(g2d);
        super.paint(g);
    }


    public void setSelectedGraphicCell(GraphicCell graphicCell) {
        selectedGraphicCell = graphicCell;
        repaint();
    }

    private void paintCurrentSelectedElement(Graphics2D g2d) {
        if(selectedGraphicCell != null) {
            int spx = selectedGraphicCell.getLocation().x;
            int spy = selectedGraphicCell.getLocation().y;
            int slw = GraphicCell.SIZE_OF_PRINTED_CELL - 1 - 1;
            int slh = GraphicCell.SIZE_OF_PRINTED_CELL - 1;
            int srw = SPACE_BETWEEN * 2;
            int srh = SPACE_BETWEEN * 2;
            g2d.setPaint(new GradientPaint(spx + slw, SPACE_BETWEEN + HEADER_ZONE, Color.white,
                  spx + slw / 4, SPACE_BETWEEN + HEADER_ZONE / 4, Color.red, true));
            g2d.fillRoundRect(spx, SPACE_BETWEEN, slw, HEADER_ZONE, srw, srh);
            g2d.setPaint(new GradientPaint(SPACE_BETWEEN + HEADER_ZONE, spy + slh, Color.white,
                  SPACE_BETWEEN + HEADER_ZONE / 4, spy + slh / 4, Color.red, true));
            g2d.fillRoundRect(SPACE_BETWEEN, spy, HEADER_ZONE, slh, srw, srh);
            g2d.setColor(Color.red);
            g2d.drawRoundRect(spx, SPACE_BETWEEN, slw, HEADER_ZONE, srw, srh);
            g2d.drawRoundRect(SPACE_BETWEEN, spy, HEADER_ZONE, slh, srw, srh);
        }
    }

/*    private void paintGradientBoxForFieldBottom(Graphics2D g) {
        int lw = GraphicCell.SIZE_OF_PRINTED_CELL - 1;
        int lh = GraphicCell.SIZE_OF_PRINTED_CELL - 1;
        int rw = SPACE_BETWEEN * 2;
        int rh = SPACE_BETWEEN * 2;
        g.setPaint(new GradientPaint(lw, lh, Color.white,
              lw / 4, lh / 4, Color.lightGray, true));
        g.fillRoundRect(0, 0, lw, lh, rw, rh);
        g.setColor(Color.lightGray);
        g.drawRoundRect(0, 0, lw, lh, rw, rh);
    }*/

    public void printField() {
        Cell[][] cells = this.field.getFieldMap();
        for(int i = 2; i < SECTOR_COUNT+2; i++) {
            for(int j = 2; j < SECTOR_COUNT+2; j++) {
                if((cells[i][j].getStateOfCell()>0) &&(cells[i][j].getStateOfCell()<5)) {
                    graphicCells[i-2][j-2].setIdentifierOfShip(cells[i][j].getStateOfCell());
                    if(cells[i][j].getWasFired() == 1) {
                        graphicCells[i-2][j-2].setCellWasAttacked();
                    }
                    graphicCells[i-2][j-2].repaint();
                } else if(cells[i][j].getWasFired() == 1) {
                    graphicCells[i-2][j-2].setCellWasAttacked();
                }
            }
        }
    }

    public void clearField(){
        for(int i = 0; i < SECTOR_COUNT; i++)
            for(int j = 0; j < SECTOR_COUNT; j++)
                 graphicCells[i][j].dropGraphicCell();

    }

        //***Methods for deposit killed ships***//
    public void depositKilledShip(Ships killedShip){
        if (killedShip.lengthOfShip==1){
            depositOneBoardShip(killedShip);
            field.subtractShipsLive();
        }
        else if (killedShip.lengthOfShip==2){
            depositTwoBoardShip(killedShip);
            field.subtractShipsLive();
        }
        else if (killedShip.lengthOfShip==3){
            depositThreeBoardShip(killedShip);
            field.subtractShipsLive();
        }
        else if (killedShip.lengthOfShip==4){
            depositFourBoardShip(killedShip);
            field.subtractShipsLive();
        }
        field.printBoarderOfField();
    }

    private void depositOneBoardShip(Ships oneBoardShip){
        int x = oneBoardShip.getShipBegX();
        int y = oneBoardShip.getShipBegY();

        field.field[x-1][y-1].setWasFired(1);
        field.field[x][y-1].setWasFired(1);
        field.field[x+1][y-1].setWasFired(1);
        field.field[x-1][y].setWasFired(1);
        field.field[x+1][y].setWasFired(1);
        field.field[x-1][y+1].setWasFired(1);
        field.field[x][y+1].setWasFired(1);
        field.field[x+1][y+1].setWasFired(1);
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
        field.field[x-1][y-1].setWasFired(1);
        field.field[x][y-1].setWasFired(1);
        field.field[x-1][y].setWasFired(1);
        field.field[x+1][y-1].setWasFired(1);
        field.field[x-1][y+1].setWasFired(1);
        field.field[x+1][y+1].setWasFired(1);

        field.field[x-1+mulX*3][y-1+mulY*3].setWasFired(1);

        field.field[x+mulX*2][y+mulY*2].setWasFired(1);
        field.field[x+mulY][y+mulX].setWasFired(1);

        field.field[x+1+mulX][y+1+mulY].setWasFired(1);
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

        field.field[x-1][y-1].setWasFired(1);
        field.field[x][y-1].setWasFired(1);
        field.field[x-1][y].setWasFired(1);
        field.field[x+1][y-1].setWasFired(1);
        field.field[x-1][y+1].setWasFired(1);
        field.field[x+1][y+1].setWasFired(1);

        field.field[x-1+mulX*3][y-1+mulY*3].setWasFired(1);
        field.field[x-1+mulX*4][y-1+mulY*4].setWasFired(1);

        field.field[x+mulX*3][y+mulY*3].setWasFired(1);
        field.field[x+mulY][y+mulX].setWasFired(1);

        field.field[x+1+mulX][y+1+mulY].setWasFired(1);
        field.field[x+1+mulX*2][y+1+mulY*2].setWasFired(1);
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

        field.field[x-1][y-1].setWasFired(1);
        field.field[x][y-1].setWasFired(1);
        field.field[x-1][y].setWasFired(1);
        field.field[x+1][y-1].setWasFired(1);
        field.field[x-1][y+1].setWasFired(1);
        field.field[x+1][y+1].setWasFired(1);

        field.field[x-1+mulX*3][y-1+mulY*3].setWasFired(1);
        field.field[x-1+mulX*4][y-1+mulY*4].setWasFired(1);
        field.field[x-1+mulX*5][y-1+mulY*5].setWasFired(1);

        field.field[x+mulX*4][y+mulY*4].setWasFired(1);
        field.field[x+mulY][y+mulX].setWasFired(1);

        field.field[x+1+mulX][y+1+mulY].setWasFired(1);
        field.field[x+1+mulX*2][y+1+mulY*2].setWasFired(1);
        field.field[x+1+mulX*3][y+1+mulY*3].setWasFired(1);
    }
    //***************************************//

}
