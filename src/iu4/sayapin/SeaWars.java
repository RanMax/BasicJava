
public class SeaWars {
    public static void main(String args[]) throws java.io.IOException {
        int[] userChoice = {0, 0};
        char ignore;

        System.out.println("Starting...\n");

        Field FieldPlayer = new Field("Player Field", false);
        Field FieldBot = new Field("Bot Field", true);

        FieldPlayer.FieldPlaceAllShips();
        FieldBot.FieldPlaceAllShips();
        System.out.println("Placing ships...\n");

        do {
                FieldPlayer.FieldPrint();
                FieldBot.FieldPrint();

                do {
                System.out.print("Attack Coordinates: ");
                userChoice[0] = System.in.read() - 97;
                userChoice[1] = System.in.read() - 48;

                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');

            } while (!((userChoice[0] >= 0) && (userChoice[0] < Field.FieldSize)
                && (userChoice[1] >= 0) && (userChoice[1] < Field.FieldSize)));

            FieldBot.fieldAttack(userChoice);

        } while (true);

    }
}
