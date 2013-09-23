
public class Field {

    static final int        FieldSize = 10;
    static final char[]     FieldHor = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    static final String[]   FieldVer = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};
    private String FieldId;
    private Ship[] AllShips;
    private int i, j;

    private Cell[][] CellArray = new Cell[FieldSize][FieldSize];

    Field(String Id, boolean hide){
        FieldId = Id;
        for (int i = 0; i < FieldSize; i++)
            for (int j = 0; j < FieldSize; j++)
                CellArray[i][j] = new Cell(hide, i, j);
    }

    private void FieldClear(){
        for (int i = 0; i < FieldSize; i++)
            for (int j = 0; j < FieldSize; j++)
                CellArray[i][j].SetCellStatus(0);
    }

    public void FieldPrint(){

        System.out.println(FieldId);

        for (int i = -1; i < FieldSize; i++)
            if (i == -1) {
                for (int j = -1; j < FieldSize; j++)
                    if (j == -1) System.out.print("  ");
                    else System.out.print("  " + FieldHor[j]);
                System.out.println();
            } else {
                for (int j = -1; j < FieldSize; j++)
                    if (j == -1) System.out.print(FieldVer[i]);
                    else {
                        if (CellArray[i][j].getCellHidden())
                            System.out.print("  #");
                        else {
                            if (CellArray[i][j].GetCellStatus() == 0)
                                if (CellArray[i][j].getCellFired()) System.out.print("  F");
                                else System.out.print("   ");
                            else if (CellArray[i][j].GetCellStatus() == 1)
                                if (CellArray[i][j].getCellFired()) System.out.print("  X");
                                else System.out.print("  *");
                            else if (CellArray[i][j].GetCellStatus() == 2)
                                if (CellArray[i][j].getCellFired()) System.out.print("  F");
                                else System.out.print("   ");
                            else
                                System.out.print("   ");
                        }

                    }
                    System.out.println();
                }
            System.out.println();
    }

    private void CreateShips(){

        AllShips = new Ship[Ships.AllShipsCount];
        i = j = 0;

        for(i = 0; i < Ships.ShipsOneCellCount; i++, j++)
            AllShips[j] = new ShipOneCell();

        for(i = 0; i < Ships.ShipsTwoCellCount; i++, j++)
            AllShips[j] = new ShipTwoCell();

        for(i = 0; i < Ships.ShipsThreeCellCount; i++, j++)
            AllShips[j] = new ShipThreeCell();

        for(i = 0; i < Ships.ShipsFourCellCount; i++, j++)
            AllShips[j] = new ShipFourCell();

        for(i = 0; i < Ships.ShipsFiveCellCount; i++, j++)
            AllShips[j] = new ShipFiveCell();

        for(i = 0; i < Ships.ShipsSubCount; i++, j++)
            AllShips[j] = new ShipSub();

    }

    public void FieldPlaceAllShips(){

        CreateShips();

        java.util.Random rand = new java.util.Random();
        int BaseX, BaseY, BaseZ;
        int x, y;
        int timeout = 0;

        // Start Placing
        do {
            for (i = 0; i < Ships.AllShipsCount; i++){
                timeout = 0;
                do {
                    BaseX = rand.nextInt(FieldSize);
                    BaseY = rand.nextInt(FieldSize);
                    BaseZ = rand.nextInt(4);

                    if(++timeout == 100) break;

                } while (!FieldTryToPlace(BaseX, BaseY, BaseZ, AllShips[i]));
                System.out.println(i);
                if(timeout == 100) {
                    FieldClear();
                    break;
                }
            }
        } while (timeout == 100);
    }

    private boolean FieldTryToPlace(int baseX, int baseY, int BaseZ, Ship CurrentShip){
        int x, y, k;
        int iXX, iXY, iYX, iYY;
        iXX = iXY = iYX = iYY = 0;

        switch (BaseZ){
            case 0: iXX = 1;  iXY = 0;  iYX = 0;  iYY = 1;  break;
            case 1: iXX = 0;  iXY = -1; iYX = 1;  iYY = 0;  break;
            case 2: iXX = -1; iXY = 0;  iYX = 0;  iYY = -1; break;
            case 3: iXX = 0;  iXY = 1;  iYX = -1; iYY = 0;  break;
        }

        for (x = 0; x < CurrentShip.LengthX; x++)
            for (y = 0; y < CurrentShip.LengthY; y++)
                if((baseX + iXX*x + iXY*y) >= 0 && (baseX + iXX*x + iXY*y) < FieldSize
                        && (baseY + iYX*x + iYY*y) >= 0 && (baseY + iYX*x + iYY*y) < FieldSize){
                    if ((CellArray[baseX + iXX*x + iXY*y][baseY + iYX*x + iYY*y].GetCellStatus() != 0)
                            && (CurrentShip.ShipForm[x][y] == 1)) return false;
                }
                else
                if (CurrentShip.ShipForm[x][y] == 1) return false;

        // Placing
        k = 0;

        for (x = 0; x < CurrentShip.LengthX; x++)
            for (y = 0; y < CurrentShip.LengthY; y++)
                if((baseX + iXX*x + iXY*y) >= 0 && (baseX + iXX*x + iXY*y) < FieldSize
                        && (baseY + iYX*x + iYY*y) >= 0 && (baseY + iYX*x + iYY*y) < FieldSize){

                    if((CurrentShip.ShipForm[x][y] == 1)){
                        CellArray[baseX + iXX*x + iXY*y][baseY + iYX*x + iYY*y].SetCellStatus(1);
                        CellArray[baseX + iXX*x + iXY*y][baseY + iYX*x + iYY*y].setCellShip(CurrentShip);

                        CurrentShip.CellArray[k] = CellArray[baseX + iXX*x + iXY*y][baseY + iYX*x + iYY*y];
                        k++;

                        for (int i = -1; i < 2; i++)
                            for (int j = -1; j < 2; j++)
                                if((baseX + iXX*x + iXY*y + i) >= 0 && (baseX + iXX*x + iXY*y + i) < FieldSize
                                        && (baseY + iYX*x + iYY*y + j) >= 0 && (baseY + iYX*x + iYY*y + j) < FieldSize)
                                    if (CellArray[baseX + iXX*x + iXY*y + i][baseY + iYX*x + iYY*y + j].GetCellStatus() == 0)
                                        CellArray[baseX + iXX*x + iXY*y + i][baseY + iYX*x + iYY*y + j].SetCellStatus(2);
                    }
                }

        return true;
    }

    public void fieldAttack(int[] userChoice){
        CellArray[userChoice[1]][userChoice[0]].setCellFired(true);
        CellArray[userChoice[1]][userChoice[0]].setCellHidden(false);

        if ((CellArray[userChoice[1]][userChoice[0]].getCellShip() != null)
                && (CellArray[userChoice[1]][userChoice[0]].getCellShip().getShipAlive()))
            CellArray[userChoice[1]][userChoice[0]].getCellShip().decShipHealth();

        if (CellArray[userChoice[1]][userChoice[0]].getCellShip().getShipAlive())
            System.out.println("Ship is dead");
    }

}



