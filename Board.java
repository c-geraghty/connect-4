import java.util.Arrays;
public class Board {

  int col;
  int row;
  public Piece currentPiece;
  public final Piece[][] board;
  
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
      




}