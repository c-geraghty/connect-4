enum Piece {

    BLANK(" "),
    RED("R"),
    YELLOW("Y");

    private final String image;

    Piece(String image) {
      
        this.image = image;

    }

    

    public String toString() {

        return String.format("|%s|", image);

    }

    public String getColourString() {

        return String.format("%s", image);

    }

    
  
}