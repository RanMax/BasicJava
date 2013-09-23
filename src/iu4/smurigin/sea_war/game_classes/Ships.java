package iu4.smurigin.sea_war.game_classes;

public class Ships {
    public static final int ONE_LENGTH_SHIPS = 4;
    public static final int TWO_LENGTH_SHIPS = 3;
    public static final int THREE_LENGTH_SHIPS = 2;
    public static final int FOUR_LENGTH_SHIPS = 1;

    public static int ships_quantity = ONE_LENGTH_SHIPS+TWO_LENGTH_SHIPS+THREE_LENGTH_SHIPS+1;

    public static Ships allShips[] = new Ships[ships_quantity];

    public int lengthOfShip = 0;
    private int leaveLiveParts;
    public String positionOfShip = "V"; // Could be the value of V or G
    private int shipBegX, shipBegY;

    public Ships(int lengthOfShip){
        this.lengthOfShip = lengthOfShip;
        this.leaveLiveParts = lengthOfShip;
    }

    public static void createShips(){
        int j = 0;
        for (int i=0; i < FOUR_LENGTH_SHIPS; i++){
           allShips[j] = new Ships(4);
           j++;
        }
        for (int i=0; i < THREE_LENGTH_SHIPS; i++){
           allShips[j] = new Ships(3);
           j++;
        }
        for (int i=0; i < TWO_LENGTH_SHIPS; i++){
           allShips[j] = new Ships(2);
           j++;
        }
        for (int i=0; i < ONE_LENGTH_SHIPS; i++){
           allShips[j] = new Ships(1);
           j++;
        }
    }

    public int decrementLiveParts(){
        return --this.leaveLiveParts;
    }

    public int getShipBegX() {
        return shipBegX;
    }

    public void setShipBegX(int shipBegX) {
        this.shipBegX = shipBegX;
    }

    public int getShipBegY() {
        return shipBegY;
    }

    public void setShipBegY(int shipBegY) {
        this.shipBegY = shipBegY;
    }

    public boolean getPositionOfShip() {
        boolean position = false;
        if (positionOfShip.equals("V"))
            position = true;
        return position;
    }

    public void setPositionOfShip(boolean positionOfShip) {
        if (positionOfShip){
            this.positionOfShip = "V";
        }
        else this.positionOfShip = "G";
    }

    public int getLeaveLiveParts() {
        return leaveLiveParts;
    }

    public void setLeaveLiveParts(int leaveLiveParts) {
        this.leaveLiveParts = leaveLiveParts;
    }
}