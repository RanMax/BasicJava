package org.basicjava.test.iu4.smurigin.sea_war.game_classes;

import java.awt.*;

public class Cell extends Component{


    public Ships shipInCell;
    private int stateOfCell;  // = 0  if no objects
                              // = 1  if some ship exist
                              // = 6  for border
                              // = 5  if can't be a ship in cell(neighbouring cells near ships cells)
                              // = 7  ship was killed
    public static final int NUMBER_FOR_BORDER = 6;
    private int wasFired = 0;  // 0 - wasn't fired
                              // 1 - was fired

    public Cell(int x, int y, int state) {
        stateOfCell = state;
        wasFired = 0;
    }

    public int getStateOfCell() {
        return stateOfCell;
    }

    public int getWasFired() {
        return wasFired;
    }

    public void setWasFired(int wasFired) {
        this.wasFired = wasFired;
    }

    public void setStateOfCell(int stateOfCell) {
        this.stateOfCell = stateOfCell;
    }

    public void setShipInCell(Ships shipInCell) {
        this.shipInCell = shipInCell;
        int lengthForCalculating = 0;
        if (lengthForCalculating != this.shipInCell.lengthOfShip){
        }
        this.stateOfCell = this.shipInCell.lengthOfShip;
    }

    public boolean viewShipAlive(){
        if (shipInCell.getLeaveLiveParts() == 0){
            return true;
        }
        else return false;
    }

}
