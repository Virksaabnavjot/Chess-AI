/*
  This code helps us to understand what is happening when a user starts
  to move pieces around the board. We are using the standard output to show
  - the name of the piece that is being moved
  - the starting square of a piece that is clicked
  - the distance in the x-direction that a player is trying to move the piece
  - the distance in the y-direction that a player is trying to move the piece
  - the landing square of where a player is returning the piece to the board

  Having this information printed out to the standard output as we test and construct the
  solution allows us to understand the constructs of the game...This code snippet below
  should be pasted into the following place:

    public void mouseReleased(MouseEvent e) {

    ...
    ...
    ...
    Boolean validMove = false;

*/
int landingX = (e.getX()/75);
int landingY  = (e.getY()/75);
int xMovement = Math.abs((e.getX()/75)-startX);
int yMovement = Math.abs((e.getY()/75)-startY);
System.out.println("----------------------------------------------");
System.out.println("The piece that is being moved is : "+pieceName);
System.out.println("The starting coordinates are : "+"( "+startX+","+startY+")");
System.out.println("The xMovement is : "+xMovement);
System.out.println("The yMovement is : "+yMovement);
System.out.println("The landing coordinates are : "+"( "+landingX+","+landingY+")");
System.out.println("----------------------------------------------");
