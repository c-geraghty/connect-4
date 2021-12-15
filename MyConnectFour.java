import java.util.Scanner;
import java.util.Random;

public class MyConnectFour {

    Connect4Board board;
    CheckWin checker;
    Player[] players;
    Player currentPlayer;

    Player winner = null;
    int toReturn;
    int columnChoice = 1;
    int turnsTaken = 0;
    int rowPos = -1;
    int[] placedPos;
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    static final int COL_SIZE = 7;
    static final int ROW_SIZE = 6;
    Piece currentPlayerPiece;

    public MyConnectFour() {
        board = new Connect4Board(COL_SIZE, ROW_SIZE);
        checker = new CheckWin(board);
        players = new Player[2];
        players[0] = new Player(1, Piece.RED);
        players[1] = new Player(2, Piece.YELLOW);
        currentPlayer = players[0];
        playGame();

    }

    private void playGame() {

        System.out.println("\n Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally. \n");

        board.printGame();

        randomizeFirstTurn();

        while (true) {

            if (winner == null) {

                currentPlayerPiece = currentPlayer.getPiece();

                if(currentPlayer == players[0]) {
                    placedPos = currentPlayer.takeTurnHuman(currentPlayerPiece, board);
                }
                else {
                    placedPos = currentPlayer.takeTurnRobot(currentPlayerPiece, board);
                }


                turnsTaken++;


                if (!checker.checkDiag(placedPos[0], placedPos[1]) &&
                        !checker.checkUpDown(placedPos[0], placedPos[1]) &&
                        !checker.checkLeftRight(placedPos[0], placedPos[1])) {

                    winner = null;

                } else {
                    winner = currentPlayer;

                }

                if (turnsTaken == 42) {

                    System.out.println("Board is full. GAME OVER.");
                    break;

                }


                //if you haven't had a winner then change players
                if (currentPlayer == players[0]) {

                    currentPlayer = players[1];

                } else {

                    currentPlayer = players[0];

                }

            } else {

                System.out.println("Player " + String.format("%d", winner.getPlayerNum()) + " is the winner!");
                break;

            }
        }
    }

    private void randomizeFirstTurn(){

        if(rand.nextInt(10) < 5){

            currentPlayer = players[0];
            System.out.println("\nHuman Player goes first. ");

        }

        else{

            currentPlayer = players[1];
            System.out.println("\nRobot Player goes first. ");

        }


    }


}
