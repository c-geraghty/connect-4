public class Connect4Player extends Player {

    public Connect4Player(int playerNum, Piece piece) {

        super(playerNum, piece);

    }

    public int[] takeTurnHuman(Piece currentPlayerPiece, Connect4Board board) {

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

    public int[] takeTurnRobot(Piece currentPlayerPiece, Connect4Board board){

        System.out.println(" ");
        System.out.println("Robot Player's Turn");
        rowPos = -1;
        while(rowPos == -1) {

            columnChoice = randomizer.randomBetween0andX(7);
            rowPos = board.checkIfPieceAccepted(currentPlayerPiece, columnChoice);

        }

        placedPos[0] = rowPos;
        placedPos[1] = columnChoice;
        return placedPos;

    }

}
