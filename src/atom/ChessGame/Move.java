class Move{
  Square start;
  Square landing;

  public Move(Square x, Square y){
    start = x;
    landing = y;
  }

  public Move(){
    
  }

  public Square getStart(){
    return start;
  }

  public Square getLanding(){
    return landing;
  }
}
