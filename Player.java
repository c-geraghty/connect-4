public class Player {

  int playerNum;
  Player player;
  Piece colour;
 
        
  

  public Player(int playerNum, Piece colour){

    this.playerNum = playerNum;
    this.colour = colour;
  }
  
  public int getPlayerNum() {
        return playerNum;
  }

  public Piece getColourPiece() { 
    return colour; 
  }

  
  

 
  
}