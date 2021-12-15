import java.util.Arrays;

//board class is super class
//board is an 2D array of pieces
//pieces are red, yellow, or blank
//can be extended into other board subclasses for different types of games such as checkers
//board class can describe the board state by printing the board or returning the piece at a given location
public class Board {

  //initialise variables
  int colSize;
  int rowSize;
  public Piece currentPiece;
  public final Piece[][] board;
  
  public Board(int col, int row) {


        this.colSize = col;
        this.rowSize = row;


        board = new Piece[row][col];

        //fill every spot in the board array with blank pieces
        for (Piece[] pos : board) {

              Arrays.fill(pos, Piece.BLANK);
        
    }
  }

  //outputs game board to console
  public void printGame() {

        //print every piece in board
        for (Piece[] pos : board) {
          for (Piece x : pos) {
              System.out.print(x.toString());
          }
          System.out.println();
        }

        //print numbers at bottom of columns
        for (int i = 0; i < colSize; i++) {
          System.out.print(String.format(" %d ", (1 + i)));
        }
        System.out.println();
      }

    //returns the piece at a given position on the board
    public Piece getPiece(int rowPos, int colPos){

        return currentPiece = board[rowPos][colPos];

    }
      




}