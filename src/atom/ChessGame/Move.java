class Move{
  Square start;
  Square landing;

////////////////////////////////////////////////////////////////////////////////////////////////
/*Move Class, returns starting sqare and the landing square of the pieces*/
////////////////////////////////////////////////////////////////////////////////////////////////

  //Custom Constructor
  public Move(Square x, Square y){
    start = x;
    landing = y;
  }

  //Default Constructor
  public Move(){

  }

  //Return the starting sqare of the piece
  public Square getStart(){
    return start;
  }

  //Return the landing square of the piece
  public Square getLanding(){
    return landing;
  }
}
