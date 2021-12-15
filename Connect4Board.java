//connect 4 board is a subclass of board
//board class can be extended to different classes for different type of games
//the subclass is in control of determining whether a move is acceptable for its given ruleset
public class Connect4Board extends Board{

    public Connect4Board(int colSize, int rowSize) {

        super(colSize, rowSize);

    }

    //method takes a piece (red/yellow) and a column as args
    //if move results in an acceptable position for a piece
    //then the row position is returned
    public int checkIfPieceAccepted(Piece piece, int colChoice){


        //for each row starting at the top of the array / bottom of the console output
        for(int i = rowSize-1; i >= 0; i--){

            //check if the piece in that position is blank
            if(board[i][colChoice] == Piece.BLANK){

                System.out.println(" ");
                System.out.println("Piece Placed Successfully. ");
                System.out.println(" ");

                //change the piece at that position to the piece of the current player
                board[i][colChoice] = piece;

                //display game with new piece included
                printGame();

                //i is the row position that the piece ends up at
                return i;


            }

        }

        //if none of the pieces in the column are blank
        //column is full
        System.out.println("\nPiece Not Placed. ");
        System.out.println("Column is full. ");


        //return -1 means unsuccessful place
        //rowPos is verified in MyConnectFour class
        //if -1 then turn must be taken again
        return -1;

    }


}
