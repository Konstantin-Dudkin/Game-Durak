import java.util.ArrayList;

public class MoveOperationWrap {
    ArrayList computerCards = new ArrayList();
    ArrayList playerCards = new ArrayList();
    boolean move;

    public ArrayList getComputerCards() {
        return computerCards;
    }

    public void setComputerCards(ArrayList computerCards) {
        this.computerCards = computerCards;
    }

    public ArrayList getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(ArrayList playerCards) {
        this.playerCards = playerCards;
    }

    public boolean getMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }
}
