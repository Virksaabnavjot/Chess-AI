class Square{
  public int xCoor;
  public int yCoor;
  public String pieceName;

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

  public int getXC(){
    return xCoor;
  }

  public int getYC(){
    return yCoor;
  }

  public String getName(){
      return pieceName;
  }
}
