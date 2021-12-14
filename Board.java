import java.util.Arrays;
public class Board {

  int col;
  int row;
  public Piece currentPiece;
  private final Piece[][] board;
  
  public Board(int col, int row) {
        
        this.col = col;
        this.row = row;

        //game is an array of pieces
        //pieces are red, yellow, or blank  
        board = new Piece[row][col];

        for (Piece[] x : board) {

              Arrays.fill(x, Piece.BLANK);
        
    }
  }
  public void printGame() {

          for (Piece[] pos : board) {
              for (Piece game : pos) {
                  System.out.print(game.toString());
              }
              System.out.println();
          }
          for (int i = 0; i < col; i++) {
              System.out.print(String.format(" %d ", (1 + i)));
          }
          System.out.println();
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

    public Piece getPiece(int rowPos, int colPos){

      return currentPiece = board[rowPos][colPos];

    }



}