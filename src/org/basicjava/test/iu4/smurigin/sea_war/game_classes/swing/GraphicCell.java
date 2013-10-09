package org.basicjava.test.iu4.smurigin.sea_war.game_classes.swing;

import org.basicjava.test.iu4.smurigin.sea_war.game_classes.Cell;
import org.basicjava.test.iu4.smurigin.sea_war.game_classes.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class GraphicCell extends Component implements MouseListener {

    Label label = new Label();

    public static final int SIZE_OF_PRINTED_CELL = 25;

    private boolean mouseOnCell;
    private boolean cellWasAttacked;
    private boolean shipAlive;
    private boolean shipPlayerAlive;
    private int identifierOfShip;

    private boolean userAttackDone = true;
    private boolean computerAttackDone = true;

    private int axisX;
    private int axisY;

    private GraphicField graphicField;

    public GraphicCell(GraphicField field, int x, int y) {
       axisX = x;
       axisY = y;
       mouseOnCell = false;
       cellWasAttacked = false;
       shipAlive = false;
       shipPlayerAlive = false;
       this.graphicField = field;
       this.graphicField.add(this);
       this.setSize(SIZE_OF_PRINTED_CELL, SIZE_OF_PRINTED_CELL);

       setLocation(GraphicField.HEADER_ZONE + GraphicField.SPACE_BETWEEN * 2 +
                        (SIZE_OF_PRINTED_CELL + GraphicField.SPACE_BETWEEN) * axisX,
                   GraphicField.HEADER_ZONE + GraphicField.SPACE_BETWEEN * 2 +
                        (SIZE_OF_PRINTED_CELL + GraphicField.SPACE_BETWEEN) * axisY);
       addMouseListener(this);
    }

    public static GraphicCell createGraphicCell(GraphicField field, int x, int y) {
            return new GraphicCell(field, x, y);
    }


    public void dropGraphicCell(){
        identifierOfShip = 0;
        cellWasAttacked = false;
    }

    public int getIdentifierOfShip() {
        return identifierOfShip;
    }

    public void setIdentifierOfShip(int identifierOfShip) {
        this.identifierOfShip = identifierOfShip;
    }

    public void setCellWasAttacked() {
        this.cellWasAttacked = true;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        if(graphicField.isOpen()) {
            if((identifierOfShip>0) && (identifierOfShip<5) && cellWasAttacked) {
                draw(g2d, 255, 242, 0, 255, 128, 0);        //yellow gradient
            } else if(identifierOfShip == 7){
                draw(g2d, 255, 15, 15, 150, 0, 0);          //red gradient
            } else if((identifierOfShip>0) && (identifierOfShip<5)){
                draw(g2d, 0, 0, 0, 80, 80, 80);            //black gradient
            } else if(cellWasAttacked) {
                draw(g2d, 30, 150, 232 , 14, 33, 43);      // blue gradient
            } else {
                draw(g2d, 158, 200, 69, 34, 140, 20);      // gray gradient
            }
        } else {
            if(mouseOnCell) {
                draw(g2d, 0, 0, 0 , 40, 0, 0);          // black gradient
            } else if(cellWasAttacked ){
                if((identifierOfShip>0) && (identifierOfShip<5)) {
                    if (shipAlive) draw(g2d, 255, 15, 15, 150, 0, 0);      //red gradient
                    else draw(g2d, 255, 242, 0, 255, 128, 0);              //yellow gradient
                } else {
                    draw(g2d, 30, 150, 232 , 14, 33, 43);       // blue gradient
                }
            } else {
                draw(g2d, 255,255,255, 60,60,60);           // gray gradient
            }
        }
    }

   private void draw(Graphics2D g2d, int r1, int g1, int b1, int r2, int g2, int b2) {
        int lw = SIZE_OF_PRINTED_CELL;
        int lh = SIZE_OF_PRINTED_CELL;
        int rw = GraphicField.SPACE_BETWEEN * 2;
        int rh = GraphicField.SPACE_BETWEEN * 2;

        Color startColor = new Color(r1, g1, b1);
        Color endColor = new Color(r2, g2, b2);
        GradientPaint gradient = new GradientPaint(lw, lh, startColor, rw, rh, endColor);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, SIZE_OF_PRINTED_CELL, SIZE_OF_PRINTED_CELL);
   }

    public void mouseEntered(MouseEvent e) {
        if(!graphicField.isOpen()) {
            mouseOnCell = true;
            graphicField.setSelectedGraphicCell(this);
            repaint();
        }
    }

    public void mouseExited(MouseEvent e) {
        if(!graphicField.isOpen()) {
            mouseOnCell = false;
            graphicField.setSelectedGraphicCell(null);
            repaint();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if(!graphicField.isOpen()) {
            userAttack();
            if (userAttackDone){
                computerAttack();
            }
        }
    }


    /*Methods for logic of game - TODO new package*/
    private void computerAttack() {
        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Random random = new Random();
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            GraphicField playerGraphicField = graphicField.getGuiField().getPlayerGraphicField();
            Field playerField = playerGraphicField.getField();

            Cell[][] cells = playerField.getFieldMap();
            Cell cell = cells[x+2][y+2];

            while (cell.getWasFired() == 1) {
                x = random.nextInt(10);
                y = random.nextInt(10);
                cell = cells[x+2][y+2];
            }

            cell.setWasFired(1);
            cellWasAttacked = true;
            graphicField.guiField.labelForComputerTurns.setText("Terns:" + playerGraphicField.incrementComputerTerns());

            if (cell.shipInCell != null){

                if (cell.shipInCell.decrementLiveParts() == 0){
                    graphicField.guiField.labelOfComputer.setText("The Ship with length of "+ cell.shipInCell.lengthOfShip+ " was killed" );
                    playerField.depositKilledShip(cell.shipInCell);
                    shipPlayerAlive = true;
                    if (playerField.getShipsLive() == 0){
                       this.showWinMessageBox(false);
                    }
                }
                else graphicField.guiField.labelOfComputer.setText("Computer hit in Ship!!! and has one more attempts to shoot");
                computerAttackDone = false;
            }
            else {
                computerAttackDone = true;
                graphicField.guiField.labelOfComputer.setText("Yoohuu! Computer doesn't hit in Ship");
            }

            playerGraphicField.printField();
            playerGraphicField.getGraphicCells()[x][y].repaint();
        } while (!computerAttackDone);
    }

    private void userAttack() {
        if(!cellWasAttacked) {
            Cell[][] cells = graphicField.getField().getFieldMap();
            Cell cell = cells[axisX+2][axisY+2];

            cellWasAttacked = true;

            graphicField.guiField.labelForPlayerTurns.setText("Terns:" + graphicField.incrementPlayerTerns());
            if (cell.shipInCell != null){
                if (cell.shipInCell.decrementLiveParts() == 0){
                    graphicField.guiField.labelOfPlayer.setText("The Ship with length of "+ cell.shipInCell.lengthOfShip+ " was killed" );
                    graphicField.depositKilledShip(cell.shipInCell);
                    shipAlive = true;
                    if (graphicField.field.getShipsLive() == 0){
                       this.showWinMessageBox(true);
                    }
                }
                else graphicField.guiField.labelOfPlayer.setText("You hit in Ship!!! and have one more attempts to shoot");
                userAttackDone = false;
            }
            else {
                userAttackDone = true;
                graphicField.guiField.labelOfPlayer.setText("Ooops! You don't hit in Ship");
            }

            cell.setWasFired(1);
            graphicField.printField();
        }
        else {
            userAttackDone = false;
            graphicField.guiField.labelOfPlayer.setText("What's a fuck!? You already hit here!");
        }
    }

    private void showWinMessageBox(boolean userWin) {
        Object[] options = {"Yes", "No"};
        String message;
            if(userWin) {
                message = "All ships were killed. Computer lost. Do you want to play ones more?";
            } else
                message = "All ships were killed by Computer. You lost. Do you want to play ones more?";

            int result = JOptionPane.showOptionDialog(null, message, "Play ones more?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

            if(result == 0) {
                graphicField.guiField.drawGameField();
            }
            else graphicField.guiField.frame.dispose();
        }

    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }

    // TODO выделить шаблон проектирования Observer + MVC

}
