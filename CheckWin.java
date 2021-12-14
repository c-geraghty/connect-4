public class CheckWin{

  Board board;
  int colPos;
  int rowPos;
  int pos;
  int count = 1;

  public CheckWin(Board board){

    this.board = board;
    

  }

  public boolean checkLeftRight(int rowPos, int colPos){
    
    //check right from currrent piece position
    for(int i = colPos; i < MyConnectFour.COL_SIZE-1; i++){
    if(board.getPiece(rowPos, i+1) == board.getPiece(rowPos,colPos)){
   
    count = count+1;
    
    }
    else{
      
      break;
    }

    }

    //check left frmo current piece's position
    for(int i = colPos; i >= 1; i--){
    if(board.getPiece(rowPos, i-1) == board.getPiece(rowPos,colPos)){
      
  
    count = count+1;
    
    
    }
    else{
      
      break;
    }
    }

    //if total count including left and right 4 or more
    //then you have a winner and return true
    if (count >= 4){

      outputWinner(colPos, rowPos);
      return true;

    }

    //otherwise no winner
    else{
      count = 1;
      return false;
     }

  }





public boolean checkUpDown(int rowPos, int colPos){
    
    for(int i = rowPos; i < MyConnectFour.ROW_SIZE-1; i++){
    if(board.getPiece(i+1, colPos) == board.getPiece(rowPos,colPos)){
    
  
    count = count+1;
    
    }
    else{
      
      break;
    }

    }
    for(int i = rowPos; i >= 1; i--){
    if(board.getPiece(i-1, colPos) == board.getPiece(rowPos,colPos)){
      

    count = count+1;
    
    
    }
    else{
     
      break;
    }
    }
    if (count >= 4){

      outputWinner(colPos, rowPos);
      return true;

    }
    else{
      count = 1;
      return false;
  }

  }

 

  public boolean checkDiag(int rowPos, int colPos){

      int j = 1;
      int i = 1;
    
      while(rowPos+j <= MyConnectFour.ROW_SIZE-1 && colPos+i <= MyConnectFour.COL_SIZE-1){
      

      if(board.getPiece(rowPos+j, colPos+i) == board.getPiece(rowPos,colPos)){

        j++;
        i++;
        count++;
        
        
        }
    else{
      
      break;
    }
        
    }

    j=1;
    i=1;

    while(rowPos-j >= 0 && colPos-i >= 0){
      

      if(board.getPiece(rowPos-j, colPos-i) == board.getPiece(rowPos,colPos)){
        
        j++;
        i++;
        count++;
        
    
        }
    else{
     
      break;
    }
        
    }

    //if total count including left and right 4 or more
    //then you have a winner and return true
    if (count >= 4){

      outputWinner(colPos, rowPos);
      return true;

    }

    //otherwise no winner
    else{
      count = 1;
    }
    

    j=1;
    i=1;

    while(rowPos-j >= 0 && colPos+i <= MyConnectFour.COL_SIZE-1){
      

      if(board.getPiece(rowPos-j, colPos+i) == board.getPiece(rowPos,colPos)){
      
    
        j++;
        i++;
        count++;
        
        }
    else{
      
      break;
    }
        
    }

    j=1;
    i=1;

    while(rowPos+j <= MyConnectFour.ROW_SIZE-1 && colPos-i >= 0){
      

      if(board.getPiece(rowPos+j, colPos-i) == board.getPiece(rowPos,colPos)){
  
        j++;
        i++;
        count++;
     
        }
    else{
      
      break;
    }
        
    }

    
    

  
    

    //if total count including left and right 4 or more
    //then you have a winner and return true
    if (count >= 4){

      outputWinner(colPos, rowPos);
      return true;

    }

    //otherwise no winner
    else{
      count = 1;
      return false;
     }

    }

    private void outputWinner(int colPos, int rowPos){

      System.out.println("Four or more " + board.getPiece(rowPos,colPos).getColourString() + " piece's in a row.");


    }

}
   