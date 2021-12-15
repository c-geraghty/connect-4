//purpose of this class is to verify if the win conditions for connect 4 have been met
//this is done by checking the positions adjacent to a placed piece in each of the 4 directions
//up down , left right , diagonals x2
//adds 1 to count for ebery subsequent adjacent piece which matches the colour of the piece at the board location board[rowPos, colPos]
//if less than 4 it resets count to 1
public class CheckWin {

    Connect4Board board;
    int count = 1;

    //checkwin class requires a board object in order to function
    public CheckWin(Connect4Board board) {

        this.board = board;

    }

    //takes the current piece position
    //returns true if piece results in 4 or more in a row
    //else false
    public boolean checkLeftRight(int rowPos, int colPos) {

        //check right from currrent piece position
        for (int i = colPos; i < MyConnectFour.COL_SIZE - 1; i++) {

            if (board.getPiece(rowPos, i + 1) == board.getPiece(rowPos, colPos)) {

                count = count + 1;

            }
            else { break; }

        }

        //check left frmo current piece's position
        for (int i = colPos; i >= 1; i--) {

            if (board.getPiece(rowPos, i - 1) == board.getPiece(rowPos, colPos)) {


                count = count + 1;


            } else { break; }
        }

        //if total count including left and right = 4 or more
        //then you have a winner and return true
        if (count >= 4) {

            outputWinnerString(colPos, rowPos);
            return true;

        }

        //otherwise no winner
        else {
            count = 1;
            return false;
        }

    }


    public boolean checkUpDown(int rowPos, int colPos) {

        //check down from current piece
        for (int i = rowPos; i < MyConnectFour.ROW_SIZE - 1; i++) {

            if (board.getPiece(i + 1, colPos) == board.getPiece(rowPos, colPos)) {

                count = count + 1;

            } else { break; }

        }

        for (int i = rowPos; i >= 1; i--) {
            if (board.getPiece(i - 1, colPos) == board.getPiece(rowPos, colPos)) {


                count = count + 1;


            } else { break; }
        }
        if (count >= 4) {

            outputWinnerString(colPos, rowPos);
            return true;

        } else {
            count = 1;
            return false;
        }

    }


    public boolean checkDiag(int rowPos, int colPos) {

        int j = 1;
        int i = 1;

        //check down and right
        while (rowPos + j <= MyConnectFour.ROW_SIZE - 1 && colPos + i <= MyConnectFour.COL_SIZE - 1) {


            if (board.getPiece(rowPos + j, colPos + i) == board.getPiece(rowPos, colPos)) {

                j++;
                i++;
                count++;


            } else { break; }

        }

        j = 1;
        i = 1;

        //check up and left
        while (rowPos - j >= 0 && colPos - i >= 0) {


            if (board.getPiece(rowPos - j, colPos - i) == board.getPiece(rowPos, colPos)) {

                j++;
                i++;
                count++;


            } else { break; }

        }

        //if total count including left and right 4 or more
        //then you have a winner and return true
        if (count >= 4) {

            outputWinnerString(colPos, rowPos);
            return true;

        }

        //otherwise no winner
        else {
            count = 1;
        }


        j = 1;
        i = 1;


        //check up and right
        while (rowPos - j >= 0 && colPos + i <= MyConnectFour.COL_SIZE - 1) {


            if (board.getPiece(rowPos - j, colPos + i) == board.getPiece(rowPos, colPos)) {


                j++;
                i++;
                count++;

            } else {

                break;
            }

        }

        j = 1;
        i = 1;

        //check down and left
        while (rowPos + j <= MyConnectFour.ROW_SIZE - 1 && colPos - i >= 0) {


            if (board.getPiece(rowPos + j, colPos - i) == board.getPiece(rowPos, colPos)) {

                j++;
                i++;
                count++;

            } else { break; }

        }


        //if total count including left and right 4 or more
        //then you have a winner and return true
        if (count >= 4) {

            outputWinnerString(colPos, rowPos);
            return true;

        }

        //otherwise no winner
        else {
            count = 1;
            return false;
        }

    }

    //output a string to say that there are 4 or more of a certain colour in a row
    private void outputWinnerString(int colPos, int rowPos) {

        System.out.println("Four or more " + board.getPiece(rowPos, colPos).getColourString() + " piece's in a row.");


    }

}
   