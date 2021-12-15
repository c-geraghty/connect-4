import java.util.Scanner; //used for user inputs

//player class is only responsible for taking turns
public class Player {

    int playerNum;
    int columnChoice;
    int rowPos = -1;
    int[] placedPos = {0,0};
    int userInput;

    Piece piece;

    Scanner scan = new Scanner(System.in);
    Randomizer randomizer = new Randomizer();


    //no setter methods used as player should not be able to change colour after they are created
    //player only has 2 pieces of data - an ID and a Piece
    //ID is used for display purposes and piece determines the colour that is placed on the board
    public Player(int playerNum, Piece piece) {

        this.playerNum = playerNum;
        this.piece = piece;

    }

    //get methods return player data
    public int getPlayerNum() {
        return playerNum;
    }

    public Piece getPiece() {
        return piece;
    }

    //only allows numeric values
    //used for accepting choices from the player on their turn
    public int getUserInput() {

        try {

            userInput = scan.nextInt();

        } catch (Exception e) {

            scan.next();
            System.out.println("Don't enter non-numeric values.");
            System.out.print("Please choose a column number >>> ");
            userInput = getUserInput();
        }

        return userInput;
    }

}