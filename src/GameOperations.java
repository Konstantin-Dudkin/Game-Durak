import java.util.ArrayList;
import java.util.Collections;

public class GameOperations {
    UserInput userInput = new UserInput();


    public ArrayList distributionCards(ArrayList cards, ArrayList pl_comCards) {

        if (pl_comCards.size() >= 0 && pl_comCards.size() < 6) {
            if (cards.size() >= 6 - pl_comCards.size()) {
                int x = pl_comCards.size();
                for (int i = 0; i < 6 - x; i++) {
                    pl_comCards.add(i, cards.get(i));
                }
            } else {
                for (int i = 0; i < cards.size(); i++) {
                    pl_comCards.add(i, cards.get(i));
                }
            }
        }
        Collections.sort(pl_comCards);
        return pl_comCards;
    }

    public MoveOperationWrap userMoveOperation(ArrayList computerCards, ArrayList playerCards, int userMove) {
        MoveOperationWrap moveOperationWrap = new MoveOperationWrap();

        Card x = (Card) playerCards.get(userMove);
        playerCards.remove(userMove);
        Collections.sort(playerCards);
        System.out.println("Вы походили картой: " + x);
        for (int i = 0; i < computerCards.size(); i++) {
            Card y = (Card) computerCards.get(i);
            if (x.getSuit() == y.getSuit()) {
                if (x.getVeight() < y.getVeight()) {
                    System.out.println("ответ компьютера:" + y);
                    System.out.println("Компьютер: \"Бито!\"");
                    computerCards.remove(i);
                    Collections.sort(computerCards);
                    moveOperationWrap.setMove(true);
                    break;
                } else if (i == computerCards.size() - 1) {
                    System.out.println("Ответ Компьютера: \"Беру.\"");
                    computerCards.add(x);
                    Collections.sort(computerCards);
                    moveOperationWrap.setMove(false);
                    break;
                }
            } else if (i == computerCards.size() - 1) {
                System.out.println("Ответ Компьютера: \"Беру.\"");
                computerCards.add(x);
                Collections.sort(computerCards);
                moveOperationWrap.setMove(false);
                break;
            }
        }
        moveOperationWrap.setComputerCards(computerCards);
        moveOperationWrap.setPlayerCards(playerCards);
        return moveOperationWrap;
    }

    public MoveOperationWrap computerMoveOperation(ArrayList computerCards, ArrayList playerCards) {

        MoveOperationWrap moveOperationWrap = new MoveOperationWrap();
        Card x = (Card) computerCards.get(0);
        computerCards.remove(0);
        Collections.sort(computerCards);
        System.out.println("Компьютер походил картой: " + x);
        boolean bit = false;
        while (bit == false) {
            System.out.println("Ваш ответный ход, Сэр. Выберите карту. Если хотите забрать карту, то введите \"99\".");
            int chose = userInput.inp() - 1;
            if (chose == 98) {
                playerCards.add(x);
                Collections.sort(playerCards);
                bit = true;
            }
            else {
                Card y = (Card) playerCards.get(chose);
                System.out.println("Вы походили картой: " + y);
                if (x.getSuit() == y.getSuit()) {
                    if (x.getVeight() < y.getVeight()) {
                        System.out.println("Бито! Прекрасно, Сэр!");
                        playerCards.remove(y);
                        Collections.sort(playerCards);
                        bit = true;
                        moveOperationWrap.setMove(true);
                    } else {
                        System.out.println("Эта карта не подходит. Если хотите забрать карту компьютера в свой набор " + "\n" +
                                "карт введите \"1\"; если хотите выбрать другую карту, то введите любое другое значение");
                        int input = userInput.inp();
                        if (input == 1) {
                            playerCards.add(x);
                            Collections.sort(playerCards);
                            bit = true;
                        }
                    }
                } else {
                    System.out.println("Эта карта не подходит. Если хотите забрать карту компьютера в свой набор " + "\n" +
                            "карт введите \"1\"; если хотите выбрать другую карту, то введите любое другое значение");
                    int input = userInput.inp();
                    if (input == 1) {
                        playerCards.add(x);
                        Collections.sort(playerCards);
                        bit = true;
                    }
                }
            }
        }
        moveOperationWrap.setComputerCards(computerCards);
        moveOperationWrap.setPlayerCards(playerCards);
        return moveOperationWrap;
    }
}
