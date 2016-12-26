
import java.util.*;

public class AIAgent {

////////////////////////////////////////////////////////////////////////////////////////////////
/*The AIAgent Class provides 3 methods that return moves which our AI uses to play with the user*/
////////////////////////////////////////////////////////////////////////////////////////////////

    Random rand;

    public AIAgent() {
        rand = new Random();
    }

////////////////////////////////////////////////////////////////////////////////////////////////
/* Random Move */
////////////////////////////////////////////////////////////////////////////////////////////////
    public Move randomMove(Stack possibilities) {

        int moveID = rand.nextInt(possibilities.size());
        System.out.println("Agent randomly selected move : " + moveID);
        for (int i = 1; i < (possibilities.size() - (moveID)); i++) {
            possibilities.pop();
        }
        Move selectedMove = (Move) possibilities.pop();
        return selectedMove;
    }

///////////////////////////////////////////////////////////////////////////////////////////////
/* Best Move */
///////////////////////////////////////////////////////////////////////////////////////////////

    public Move nextBestMove(Stack whitePossibilitiesStack, Stack blackPossibilitiesStack) {
        Stack backupMove = (Stack) whitePossibilitiesStack.clone();
        Stack blackStackM = (Stack) blackPossibilitiesStack.clone();
        Move bestMove = null;
        Move whiteMove;
        Move presentMove;
        Square blackPosition;
        int strength = 0;
        int chosenPieceStrength = 0;

        while (!whitePossibilitiesStack.empty()) {
            whiteMove = (Move) whitePossibilitiesStack.pop();
            presentMove = whiteMove;

            //check if the centre of the board is occupied or not
            if ((presentMove.getStart().getYC() < presentMove.getLanding().getYC())
            && (presentMove.getLanding().getXC() == 3) && (presentMove.getLanding().getYC() == 3)
            || (presentMove.getLanding().getXC() == 4) && (presentMove.getLanding().getYC() == 3)
            || (presentMove.getLanding().getXC() == 3) && (presentMove.getLanding().getYC() == 4)
            || (presentMove.getLanding().getXC() == 4) && (presentMove.getLanding().getYC() == 4)) {

              strength = 1;

                //updating the best move
                if (strength > chosenPieceStrength) {
                    chosenPieceStrength = strength;
                    bestMove = presentMove;
                }
            }

            //compare white landing positions to black positions, return capture if available or random if not.
            while (!blackStackM.isEmpty()) {
                strength = 0;
                blackPosition = (Square) blackStackM.pop();
                if ((presentMove.getLanding().getXC() == blackPosition.getXC()) && (presentMove.getLanding().getYC() == blackPosition.getYC())) {

                    //Assign strength to pieces
                    if (blackPosition.getName().equals("BlackQueen")) {
                        strength = 5;
                    } else if (blackPosition.getName().equals("BlackRook")) {
                        strength = 4;
                    } else if (blackPosition.getName().equals("BlackBishop") || blackPosition.getName().equals("BlackKnight")) {
                        strength = 3;
                    } else if (blackPosition.getName().equals("BlackPawn")) {
                        strength = 2;
                    } else {
                        strength = 6;
                    }
                }
                //updating the best move
                if (strength > chosenPieceStrength) {
                    chosenPieceStrength = strength;
                    bestMove = presentMove;
                }
            }
            //reloading the black squares
            blackStackM = (Stack) blackPossibilitiesStack.clone();
        }

        // Make the best move if not available make a random move.
        if (chosenPieceStrength > 0) {
            System.out.println("Selected AI Agent - Next best move: " +chosenPieceStrength);
            return bestMove;
        }

        return randomMove(backupMove);

    }


////////////////////////////////////////////////////////////////////////////////////////////////
/* Two Level Deep */
///////////////////////////////////////////////////////////////////////////////////////////////
    public Move twoLevelsDeep(Stack whitePossibilitiesStack, Stack blackPossibilitiesStack) {
        Stack backupMove = (Stack) whitePossibilitiesStack.clone();
        Stack blackStackM = (Stack) blackPossibilitiesStack.clone();
        Move bestMove = null;
        Move whiteMove;
        Move presentMove;
        Square blackPosition;
        int strength = 0;
        int chosenPieceStrength = 0;

        while (!whitePossibilitiesStack.empty()) {
            whiteMove = (Move) whitePossibilitiesStack.pop();
            presentMove = whiteMove;

            //assign 1 strength to centre position on board
            if ((presentMove.getStart().getYC() < presentMove.getLanding().getYC())
                    && (presentMove.getLanding().getXC() == 3) && (presentMove.getLanding().getYC() == 3)
                    || (presentMove.getLanding().getXC() == 4) && (presentMove.getLanding().getYC() == 3)
                    || (presentMove.getLanding().getXC() == 3) && (presentMove.getLanding().getYC() == 4)
                    || (presentMove.getLanding().getXC() == 4) && (presentMove.getLanding().getYC() == 4)) {
                strength = 0;
                //assign best move
                if (strength > chosenPieceStrength) {
                    chosenPieceStrength = strength;
                    bestMove = presentMove;
                }
            }

            //return a attacking best move when piece has higher strength than centre position
            while (!blackStackM.isEmpty()) {
                strength = 0;
                blackPosition = (Square) blackStackM.pop();
                if ((presentMove.getLanding().getXC() == blackPosition.getXC()) && (presentMove.getLanding().getYC() == blackPosition.getYC())) {

                  //Assign strength to pieces
                  if (blackPosition.getName().equals("BlackQueen")) {
                      strength = 5;
                  } else if (blackPosition.getName().equals("BlackRook")) {
                      strength = 4;
                  } else if (blackPosition.getName().equals("BlackBishop") || blackPosition.getName().equals("BlackKnight")) {
                      strength = 3;
                  } else if (blackPosition.getName().equals("BlackPawn")) {
                      strength = 2;
                  } else {
                      strength = 6;
                  }
                }

                //updating the bestmove
                if (strength > chosenPieceStrength) {
                    chosenPieceStrength = strength;
                    bestMove = presentMove;
                }
            }

            //reloading the black squares
            blackStackM = (Stack) blackPossibilitiesStack.clone();
        }

        //Make the best move if not available make a random move.
        if (chosenPieceStrength > 0) {
            System.out.println("Selected AI Agent - Two Level Deep: " +chosenPieceStrength);
            return bestMove;
        }
        return randomMove(backupMove);
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////
/*The End of the Class*/
////////////////////////////////////////////////////////////////////////////////////////////////
