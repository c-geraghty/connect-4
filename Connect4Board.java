
public class Connect4Board extends Board{

    public Connect4Board(int col, int row) {

        super(col, row);

    }

    public int checkIfPieceAccepted(Piece piece, int colChoice){



        for(int i = row-1; i >= 0; i--){

            if(board[i][colChoice] == Piece.BLANK){

                System.out.println(" ");
                System.out.println("Piece Placed Successfully. ");
                System.out.println(" ");
                board[i][colChoice] = piece;

                printGame();
                return i;


            }

        }


        System.out.println("\nPiece Not Placed. ");
        System.out.println("Column is full. ");



        return -1;

    }


}
