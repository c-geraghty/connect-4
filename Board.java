import java.util.Arrays;
public class Board {

  private int col;
  private int row;
  public Piece currentPiece;
  

  private final Piece[][] game;
  
  public Board(int col, int row) {
        
        this.col = col;
        this.row = row;

        //game is an array of pieces
        //pieces are red, yellow, or blank  
        game = new Piece[row][col];

        for (Piece[] x : game) {

              Arrays.fill(x, Piece.BLANK);
        
    }
  }
  public void printGame() {

          for (Piece[] pos : game) {
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
      
    public int placePiece(Piece piece, int colChoice){

     

	     for(int i = row-1; i >= 0; i--){

        if(game[i][colChoice] == Piece.BLANK){
        
        System.out.println(" ");
        System.out.println("Piece Placed Successfully. ");
        System.out.println(" ");
        game[i][colChoice] = piece;
        
        printGame();
        return i;
        
        
        }

       }

       System.out.println(" ");
       System.out.println("Piece Not Placed. ");
       System.out.println("Column is full. ");
       System.out.println(" ");
       

       return -1;

    } 

    public Piece getPiece(int rowPos, int colPos){

      return currentPiece = game[rowPos][colPos];

    }

    
  
}