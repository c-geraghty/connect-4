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

    public int[] takeTurnHuman(Piece currentPlayerPiece, Board board) {

        //two turn types - human and computer

            rowPos = -1;

            while (rowPos == -1) {

                System.out.println(" ");
                System.out.print("Please choose a column >>> ");


                columnChoice = getUserInput() - 1;

                while (columnChoice < 0 || columnChoice >= 7) {

                    System.out.println(" ");
                    System.out.println("Invalid column number.");
                    System.out.print("Please choose a column number between 1 and 7 >>> ");
                    System.out.println(" ");
                    columnChoice = getUserInput() - 1;

                }

                //place piece on board

                rowPos = board.checkIfPieceAccepted(currentPlayerPiece, columnChoice);
                placedPos[0] = rowPos;
                placedPos[1] = columnChoice;
                return placedPos;

            }

            return placedPos;
        }

    public int[] takeTurnRobot(Piece currentPlayerPiece, Board board){

        System.out.println(" ");
        System.out.println("Robot Player's Turn");
        rowPos = -1;
        while(rowPos == -1) {
            columnChoice = rand.nextInt(7);
            rowPos = board.checkIfPieceAccepted(currentPlayerPiece, columnChoice);
        }

        placedPos[0] = rowPos;
        placedPos[1] = columnChoice;
        return placedPos;

    }

    private int getUserInput() {

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