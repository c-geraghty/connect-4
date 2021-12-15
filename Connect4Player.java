//connnect4player extends Player class
//ensures that player abides by connect 4 rules
public class Connect4Player extends Player {

    public Connect4Player(int playerNum, Piece piece) {

        super(playerNum, piece);

    }

    //human turn takes a user input
    //calls board method checkIfPieceAccepted
    //verifies that it results in a legitimate position
    //outputs final position of piece in an int array
    public int[] takeTurnHuman(Piece currentPlayerPiece, Connect4Board board) {

            System.out.println();
            System.out.print("Please choose a column >>> ");

            columnChoice = getUserInput() - 1;

            //loop until a valid input is entered
            while (columnChoice < 0 || columnChoice >= MyConnectFour.COL_SIZE) {

                System.out.println();
                System.out.println("Invalid column number.");
                System.out.print("Please choose a column number between 1 and 7 >>> ");
                System.out.println();
                columnChoice = getUserInput() - 1;

            }

            //final row position of piece is determined by board method
            rowPos = board.checkIfPieceAccepted(currentPlayerPiece, columnChoice);
            placedPos[0] = rowPos;
            placedPos[1] = columnChoice;
            return placedPos;




    }

    //robot turn generates a random input instead of taking a user input
    //otherwise operation is the same
    public int[] takeTurnRobot(Piece currentPlayerPiece, Connect4Board board){

        System.out.println(" ");
        System.out.println("Robot Player's Turn");

        columnChoice = randomizer.randomBetween0andX(MyConnectFour.COL_SIZE);
        rowPos = board.checkIfPieceAccepted(currentPlayerPiece, columnChoice);


        placedPos[0] = rowPos;
        placedPos[1] = columnChoice;

        return placedPos;

    }

}
