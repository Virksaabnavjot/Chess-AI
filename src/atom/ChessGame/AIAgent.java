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
        Stack backupMove = (Stack) whiteStack.clone();
        Stack blackStackM = (Stack) blackStack.clone();
        Move whiteMove, currentMove, bestMove;
        Square blackPosition;
        int highestScore = 0;
        bestMove = null;
        int score = 0;

        while (!whiteStack.empty()) {
            whiteMove = (Move) whiteStack.pop();
            currentMove = whiteMove;

            //check if the centre of the board is occupied or not
            if ((currentMove.getStart().getYC() < currentMove.getLanding().getYC())
                    && (currentMove.getLanding().getXC() == 3) && (currentMove.getLanding().getYC() == 3)
                    || (currentMove.getLanding().getXC() == 4) && (currentMove.getLanding().getYC() == 3)
                    || (currentMove.getLanding().getXC() == 3) && (currentMove.getLanding().getYC() == 4)
                    || (currentMove.getLanding().getXC() == 4) && (currentMove.getLanding().getYC() == 4)) {
                score = 1;
                //updating the best move
                if (score > highestScore) {
                    highestScore = score;
                    bestMove = currentMove;
                }
            }

            //compare white landing positions to black positions, return capture if available or random if not.
            while (!blackStackM.isEmpty()) {
                score = 0;
                blackPosition = (Square) blackStackM.pop();
                if ((currentMove.getLanding().getXC() == blackPosition.getXC()) && (currentMove.getLanding().getYC() == blackPosition.getYC())) {

                    //checking piece score
                    if(blackPosition.getName().equals("BlackQueen")){
                        score = 5;
                    }
                    else if(blackPosition.getName().equals("BlackRook")){
                        score = 4;
                    }
                    else if(blackPosition.getName().equals("BlackBishop")|| blackPosition.getName().equals("BlackKnight")){
                        score = 3;
                    }
                    else if(blackPosition.getName().equals("BlackPawn")){
                        score = 2;
                    }
                    else{
                        score = 6;
                    }
                }
                //updating the best move
                if (score > highestScore) {
                    highestScore = score;
                    bestMove = currentMove;
                }
            }
            //reloading the black squares
            blackStackM = (Stack) blackStack.clone();
        }
        // Make the best move if not available make a random move.
        if (highestScore > 0) {
            System.out.println("selected AI Agent: Next best move");
            return bestMove;
        }
        return randomMove(backupMove);

    }

    public Move twoLevelsDeep(Stack possibilities) {
        Move selectedMove = new Move();
        return selectedMove;
    }
}
