//import random module

public class MyConnectFour {



    static final int COL_SIZE = 7;      //defines number f columns on the board
    static final int ROW_SIZE = 6;      //defines number f rows on the board

    //initialise class objects
    Connect4Board board;
    CheckWin checker;
    Connect4Player[] players;
    Connect4Player currentPlayer;
    Connect4Player winner = null;
    Piece currentPlayerPiece;
    Randomizer randomizer;

    //initialise variables
    int turnsTaken = 0;
    int[] placedPos;                    //2D array for placed position of a piece - [row, col]


    //MyConnectFour constructors initialises the game state
    //initialises the objects necessary to play the game
    //and then calls the playGame() method
    public MyConnectFour() {

        board = new Connect4Board(COL_SIZE, ROW_SIZE);
        checker = new CheckWin(board);
        players = new Connect4Player[2];
        players[0] = new Connect4Player(1, Piece.RED);
        players[1] = new Connect4Player(2, Piece.YELLOW);
        currentPlayer = players[0];
        randomizer = new Randomizer();


        //playGame() is the main game loop
        playGame();

    }

    private void playGame() {

        System.out.println("\n Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally. \n");


        board.printGame();              //print's game board to console

        randomizeFirstTurn();           //randomize currentPlayer at start of game

        while (true) {                  //while loops runs until game ends - either via a winner being declared or board becoming full

            if (winner == null) {

                //check if board is full with no winner
                //game over
                if (turnsTaken == 42) {

                    System.out.println("Board is full. GAME OVER.");
                    break;

                }

                //returns RED or YELLOW depending on currentPlayer value
                currentPlayerPiece = currentPlayer.getPiece();

                //players[0] is the human player
                if (currentPlayer == players[0]) {

                    //takeTurn returns a 2D int array - row and col that placed piece ends up at
                    placedPos = currentPlayer.takeTurnHuman(currentPlayerPiece, board);
                }
                //players[1] is the robot player
                else {

                    placedPos = currentPlayer.takeTurnRobot(currentPlayerPiece, board);
                }


                //if the rowPos output from a turn == -1
                //means turn was unsuccessful
                //if that is not the case then check for win condition
                //increment turn counter
                //change players
                if(placedPos[0] != -1) {

                    turnsTaken++;

                    //check if placed piece results in a win condition
                    if (checker.checkDiag(placedPos[0], placedPos[1]) ||
                            checker.checkUpDown(placedPos[0], placedPos[1]) ||
                            checker.checkLeftRight(placedPos[0], placedPos[1])) {

                        //if win condition then winner is current player
                        winner = currentPlayer;

                    }

                    //if no winner then change current player
                    if (currentPlayer == players[0]) {

                        currentPlayer = players[1];

                    } else {

                        currentPlayer = players[0];

                    }
                }


            }

            //if winner != null THEN output winner
            else {

                //change output depending on what player wins
                if(winner == players[0]){
                    System.out.println("Player " + String.format("%d", winner.getPlayerNum()) + ", the human player is the winner!");
                    break;
                }else{
                    System.out.println("Player " + String.format("%d", winner.getPlayerNum()) + ", the robot player is the winner!");
                    break;
                }

            }
        }
    }

    private void randomizeFirstTurn() {


        if (randomizer.fiftyFiftyChance()) {             //randomizer.fiftyFiftyChance returns true or false

            currentPlayer = players[0];
            System.out.println("\nHuman Player goes first. ");

        } else {

            currentPlayer = players[1];
            System.out.println("\nRobot Player goes first. ");

        }


    }


}
