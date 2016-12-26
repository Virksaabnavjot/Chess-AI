////////////////////////////////////////////////////////////////////////////////////////////////
/*This code helps us to understand what is happening when a user starts
to move pieces around the board*/
////////////////////////////////////////////////////////////////////////////////////////////////

int landingX = (e.getX()/75);
int landingY  = (e.getY()/75);
int xMovement = Math.abs((e.getX()/75)-startX);
int yMovement = Math.abs((e.getY()/75)-startY);
System.out.println("----------------------------------------------");
System.out.println("The piece being moved is : "+pieceName);
System.out.println("Starting coordinates are : "+"( "+startX+","+startY+")");
System.out.println("xMovement is : "+xMovement);
System.out.println("yMovement is : "+yMovement);
System.out.println("Landing coordinates are : "+"( "+landingX+","+landingY+")");
System.out.println("----------------------------------------------");
