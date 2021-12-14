import java.util.Scanner;
import java.util.Random;

public class MyConnectFour {

  Board board;
  CheckWin checker;
  Player[] players;
  Player currentPlayer;
  Piece currentPlayerPiece;
  Player winner = null;
  int columnChoice = 1;
  int turnsTaken = 0;
  int rowPos = -1;
  Scanner scan = new Scanner(System.in);
  Random rand = new Random();
  static final int COL_SIZE = 7;
	static final int ROW_SIZE = 6;
	
	public MyConnectFour(){
    
		board = new Board(COL_SIZE,ROW_SIZE);
    checker = new CheckWin(board);
    players = new Player[2];
    players[0] = new Player(1, Piece.RED);
    players[1] = new Player(2, Piece.YELLOW);
    currentPlayer = players[0];



    playGame();
    
	}

  private void playGame(){
    System.out.println("");
    System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
    System.out.println("");
		board.printGame();
    
    while(true){

    if(winner == null){
      
    
    takeTurn();
    turnsTaken++;
    

    if(turnsTaken == 42){

      System.out.println("Board is full. GAME OVER.");

    }
    
    if(checker.checkDiag(rowPos, columnChoice) == false && 
      checker.checkUpDown(rowPos, columnChoice) == false &&
      checker.checkLeftRight(rowPos, columnChoice) == false){

        winner = null;

      } 
      else { 
        winner = currentPlayer; 
      
    }

        
    

      
    
    
    rowPos = -1;
    
    //if you haven't had a winner then change players
    if(currentPlayer == players[0]){

      currentPlayer = players[1];

    }

    else{

      currentPlayer = players[0];

      }

    }

    else{

      System.out.println("Player " + String.format("%d", winner.getPlayerNum()) + " is the winner!");
      break;

    }
    }
  }

  private void takeTurn() {

      //two turn types - human and computer
      if(currentPlayer == players[0]){
        while(rowPos == -1){
        
        System.out.println(" ");
        System.out.print("Please choose a column >>> ");
        

        columnChoice = getUserInput() - 1;

        while(columnChoice < 0 || columnChoice >= 7){
          
          System.out.println(" ");
          System.out.println("Invalid column number.");
          System.out.print("Please choose a column number between 1 and 7 >>> ");
          System.out.println(" ");
          columnChoice = getUserInput() - 1;

        }

        //place piece on board
        currentPlayerPiece = currentPlayer.getColourPiece();
        rowPos = board.placePiece(currentPlayerPiece, columnChoice);
        
        }
        }
      
      else if (currentPlayer == players[1]){

        System.out.println(" ");
        System.out.println("Robot Player's Turn");

        columnChoice = rand.nextInt(7); 
        currentPlayerPiece = currentPlayer.getColourPiece();
        rowPos = board.placePiece(currentPlayerPiece, columnChoice);
      

      }

  }
  
  private int getUserInput(){
      
      int toReturn = 0;
      try{			
        toReturn = scan.nextInt();
      }
      catch(Exception e){

        scan.next();
        System.out.println("Don't enter non-numeric values.");
        System.out.print("Please choose a column number >>>");
        toReturn = getUserInput();
      }
      return toReturn;
    }


}
