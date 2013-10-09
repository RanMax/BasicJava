package org.basicjava.test.iu4.sayapin.sea_wars;

public class Cell {
    private int CellStatus; // 0 - Free; 1 - ShipPlaced; 2 - Near Ship; 3- Destroid; 4 - Hint
    private Ship CellShip;
    private boolean isFired;
    private boolean isHidden;
    private int x, y;

    Cell(boolean hidden, int x, int y){
        CellStatus = 0;
        CellShip = null;
        isFired = false;
        isHidden = hidden;
        this.x = x;
        this.y = y;
    }

    public void SetCellStatus(int status)       { CellStatus = status;}
    public int GetCellStatus()                  { return CellStatus;}
    public void setCellFired(boolean fired)     { isFired = fired;}
    public boolean getCellFired()               { return isFired;}
    public void setCellHidden(boolean hidden)   { isHidden = hidden;}
    public boolean getCellHidden()              { return isHidden;}
    public void setCellShip(Ship ship)          { CellShip = ship;}
    public Ship getCellShip()                   { return CellShip;}

    public void setCellX(int x)                 { this.x = x;}
    public int getCellX()                       { return x;}
    public void setCellY(int y)                 { this.y = y;}
    public int getCellY()                       { return y;}
}