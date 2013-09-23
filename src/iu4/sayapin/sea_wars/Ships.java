package iu4.sayapin.sea_wars;

class Ship {
    private int ShipHealth;
    protected int[][] ShipForm;
    protected int LengthX, LengthY;
    protected Cell[] CellArray;

    Ship(int size, int x, int y){
        ShipHealth = size;
        LengthX = x;
        LengthY = y;

        ShipForm = new int[x][y];
        CellArray = new Cell[size];
    }

    public void decShipHealth()       { ShipHealth--;}
    public boolean getShipAlive()               { if (ShipHealth > 0) return true; else return false;}
}

class ShipOneCell extends Ship {

    ShipOneCell(){
        super(1, 1, 1);
        ShipForm[0][0] = 1;
    }
}

class ShipTwoCell extends Ship {

    ShipTwoCell(){
        super(2, 1, 2);
        ShipForm[0][0] = 1;
        ShipForm[0][1] = 1;
    }
}

class ShipThreeCell extends Ship {

    ShipThreeCell(){
        super(3, 1, 3);
        ShipForm[0][0] = 1;
        ShipForm[0][1] = 1;
        ShipForm[0][2] = 1;
    }
}

class ShipFourCell extends Ship {

    ShipFourCell(){
        super(4, 1, 4);
        ShipForm[0][0] = 1;
        ShipForm[0][1] = 1;
        ShipForm[0][2] = 1;
        ShipForm[0][3] = 1;

    }
}

class ShipFiveCell extends Ship {

    ShipFiveCell(){
        super(5, 1, 5);
        ShipForm[0][0] = 1;
        ShipForm[0][1] = 1;
        ShipForm[0][2] = 1;
        ShipForm[0][3] = 1;
        ShipForm[0][4] = 1;
    }
}

class ShipSub extends Ship {

    ShipSub(){
        super(4, 2, 3);
        ShipForm[0][0] = 1;
        ShipForm[1][1] = 1;
        ShipForm[0][1] = 1;
        ShipForm[0][2] = 1;
    }
}

public class Ships {

    static final int ShipsOneCellCount     = 4;
    static final int ShipsTwoCellCount     = 3;
    static final int ShipsThreeCellCount   = 2;
    static final int ShipsFourCellCount    = 1;
    static final int ShipsFiveCellCount    = 1;
    static final int ShipsSubCount         = 1;

    static final int AllShipsCount = ShipsOneCellCount +  ShipsTwoCellCount +
            ShipsThreeCellCount + ShipsFourCellCount + ShipsFiveCellCount + ShipsSubCount;

}