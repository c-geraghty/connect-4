import java.util.Random;
import java.util.Scanner;

public class Player {

    int playerNum;
    Piece piece;
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    int columnChoice;
    int rowPos = -1;
    int[] placedPos = {0,0};


    public Player(int playerNum, Piece piece) {

        this.playerNum = playerNum;
        this.piece = piece;

    }

    public int getPlayerNum() {
        return playerNum;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getUserInput() {

        int toReturn;

        try {

            toReturn = scan.nextInt();

        } catch (Exception e) {

            scan.next();
            System.out.println("Don't enter non-numeric values.");
            System.out.print("Please choose a column number >>>");
            toReturn = getUserInput();
        }

        return toReturn;
    }

}