import java.util.*;

public class AIAgent {

    Random rand;

    public AIAgent() {
        rand = new Random();
    }

    /*
  The method randomMove takes as input a stack of potential moves that the AI agent
  can make. The agent uses a rondom number generator to randomly select a move from
  the inputted Stack and returns this to the calling agent.
     */
    public Move randomMove(Stack possibilities) {

        int moveID = rand.nextInt(possibilities.size());
        System.out.println("Agent randomly selected move : " + moveID);
        for (int i = 1; i < (possibilities.size() - (moveID)); i++) {
            possibilities.pop();
        }
        Move selectedMove = (Move) possibilities.pop();
        return selectedMove;
    }

    public Move nextBestMove(Stack whiteStack, Stack blackStack) {
        Stack backup = (Stack) whiteStack.clone();
        Stack black = (Stack) blackStack.clone();
        Move whiteMove, currentMove, bestMove;
        Square blackPosition;
        int score = 0;
        int highestScore = 0;
        bestMove = null;

        while (!whiteStack.empty()) {
            whiteMove = (Move) whiteStack.pop();
            currentMove = whiteMove;

            //check if centre is available
            if ((currentMove.getStart().getYC() < currentMove.getLanding().getYC())
                    && (currentMove.getLanding().getXC() == 3) && (currentMove.getLanding().getYC() == 3)
                    || (currentMove.getLanding().getXC() == 4) && (currentMove.getLanding().getYC() == 3)
                    || (currentMove.getLanding().getXC() == 3) && (currentMove.getLanding().getYC() == 4)
                    || (currentMove.getLanding().getXC() == 4) && (currentMove.getLanding().getYC() == 4)) {
                score = 1;
                //update bestmove
                if (score > highestScore) {
                    highestScore = score;
                    bestMove = currentMove;
                }
            }

            //compare white landing positions to black positions, return capture if available or random if not.
            while (!black.isEmpty()) {
                score = 0;
                blackPosition = (Square) black.pop();
                if ((currentMove.getLanding().getXC() == blackPosition.getXC()) && (currentMove.getLanding().getYC() == blackPosition.getYC())) {
                    //check piece score

                    if(blackPosition.getName().equals("BlackPawn")){
                        score = 2;
                    }
                    else if(blackPosition.getName().equals("BlackBishop")|| blackPosition.getName().equals("BlackKnight")){
                        score = 3;
                    }
                    else if(blackPosition.getName().equals("BlackRook")){
                        score = 4;
                    }
                    else if(blackPosition.getName().equals("BlackQueen")){
                        score = 5;
                    }
                    else{
                        score = 6;
                    }
                }
                //update bestmove
                if (score > highestScore) {
                    highestScore = score;
                    bestMove = currentMove;
                }
            }
            //reload black squares
            black = (Stack) blackStack.clone();
        }
        // use best move if available or just go random
        if (highestScore > 0) {
            System.out.println("Agent selected next best move.");
            return bestMove;
        }
        return randomMove(backup);

    }

    public Move twoLevelsDeep(Stack possibilities) {
        Move selectedMove = new Move();
        return selectedMove;
    }
}
