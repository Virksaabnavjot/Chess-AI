class Square{
  public int xCoor;
  public int yCoor;
  public String pieceName;

  ////////////////////////////////////////////////////////////////////////////////////////////////
  /*Object Class to represent Squares on the board*/
  ////////////////////////////////////////////////////////////////////////////////////////////////

  public Square(int x, int y, String name){
    xCoor = x;
    yCoor = y;
    pieceName = name;
  }

  public Square(int x, int y){
    xCoor = x;
    yCoor = y;
    pieceName = "";
  }

  // Returns x coordinate
  public int getXC(){
    return xCoor;
  }

  // Returns y coordinate
  public int getYC(){
    return yCoor;
  }

  // Returns piece name
  public String getName(){
      return pieceName;
  }
}
