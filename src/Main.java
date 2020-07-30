import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        GameOperations gameOperations = new GameOperations();
        UserInput userInput = new UserInput();
        MoveOperationWrap moveOperationWrap = new MoveOperationWrap();

        Card t2 = new Card("2", "Треф", 2);
        Card t3 = new Card("3", "Треф", 3);
        Card t4 = new Card("4", "Треф", 4);
        Card t5 = new Card("5", "Треф", 5);
        Card t6 = new Card("6", "Треф", 6);
        Card t7 = new Card("7", "Треф", 7);
        Card t8 = new Card("8", "Треф", 8);
        Card t9 = new Card("9", "Треф", 9);
        Card t10 = new Card("10", "Треф", 10);
        Card t11 = new Card("Валет", "Треф", 11);
        Card t12 = new Card("Дама", "Треф", 12);
        Card t13 = new Card("Король", "Треф", 13);
        Card t14 = new Card("Туз", "Треф", 14);

        Card p2 = new Card("2", "Пик", 2);
        Card p3 = new Card("3", "Пик", 3);
        Card p4 = new Card("4", "Пик", 4);
        Card p5 = new Card("5", "Пик", 5);
        Card p6 = new Card("6", "Пик", 6);
        Card p7 = new Card("7", "Пик", 7);
        Card p8 = new Card("8", "Пик", 8);
        Card p9 = new Card("9", "Пик", 9);
        Card p10 = new Card("10", "Пик", 10);
        Card p11 = new Card("Валет", "Пик", 11);
        Card p12 = new Card("Дама", "Пик", 12);
        Card p13 = new Card("Король", "Пик", 13);
        Card p14 = new Card("Туз", "Пик", 14);

        Card c2 = new Card("2", "Червы", 2);
        Card c3 = new Card("3", "Червы", 3);
        Card c4 = new Card("4", "Червы", 4);
        Card c5 = new Card("5", "Червы", 5);
        Card c6 = new Card("6", "Червы", 6);
        Card c7 = new Card("7", "Червы", 7);
        Card c8 = new Card("8", "Червы", 8);
        Card c9 = new Card("9", "Червы", 9);
        Card c10 = new Card("10", "Червы", 10);
        Card c11 = new Card("Валет", "Червы", 11);
        Card c12 = new Card("Дама", "Червы", 12);
        Card c13 = new Card("Король", "Червы", 13);
        Card c14 = new Card("Туз", "Червы", 14);

        Card b2 = new Card("2", "Буби", 2);
        Card b3 = new Card("3", "Буби", 3);
        Card b4 = new Card("4", "Буби", 4);
        Card b5 = new Card("5", "Буби", 5);
        Card b6 = new Card("6", "Буби", 6);
        Card b7 = new Card("7", "Буби", 7);
        Card b8 = new Card("8", "Буби", 8);
        Card b9 = new Card("9", "Буби", 9);
        Card b10 = new Card("10", "Буби", 10);
        Card b11 = new Card("Валет", "Буби", 11);
        Card b12 = new Card("Дама", "Буби", 12);
        Card b13 = new Card("Король", "Буби", 13);
        Card b14 = new Card("Туз", "Буби", 14);

        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12,
                t13, t14, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, b2, b3, b4, b5, b6, b7, b8,
                b9, b10, b11, b12, b13, b14, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14));

        System.out.println("Приветствую Вас, джентльмен. Сыграем в \"Дурака\"? Я перемешаю колоду карт.");
        Collections.shuffle(cards);

        ArrayList<Card> computerCards = new ArrayList<>();
        computerCards = gameOperations.distributionCards(cards, computerCards);
        cards.removeAll(computerCards);
        ArrayList<Card> playerCards = new ArrayList<>();
        playerCards = gameOperations.distributionCards(cards, playerCards);
        cards.removeAll(playerCards);


        while (playerCards.size() > 0 || computerCards.size() > 0) {
            boolean pl_move = false;
            while (pl_move == false) {
                System.out.println(" ");
                System.out.println("--ХОД ИГРОКА--");
                System.out.println("Осталось карт в колоде: " + cards.size());
                System.out.println("Карт у компьютера: " + computerCards.size());
                System.out.println("Набор карт игрока: " + playerCards);
                System.out.println("Ваш ход, Сэр. Введите номер карты, которой хотите походить.");

                moveOperationWrap = gameOperations.userMoveOperation(computerCards, playerCards, userInput.inp() - 11);
                computerCards = moveOperationWrap.getComputerCards();
                playerCards = moveOperationWrap.getPlayerCards();
                pl_move = moveOperationWrap.getMove();

                System.out.println("Набор игрока: " + playerCards);
                System.out.println("Добавляем карт из колоды...");

                playerCards = gameOperations.distributionCards(cards, playerCards);
                cards.removeAll(playerCards);
                computerCards = gameOperations.distributionCards(cards, computerCards);
                cards.removeAll(computerCards);
                if (playerCards.size() == 0) {
                    System.out.println("ВЫ ПОБЕДИЛИ!!!");
                    pl_move = true;
                    System.exit(0);
                }
            }

            boolean comp_move = false;
            while (comp_move == false) {
                System.out.println(" ");
                System.out.println("--ХОД КОМПЬЮТЕРА--");
                System.out.println("Осталось карт в колоде: " + cards.size());
                System.out.println("Карт у компьютера: " + computerCards.size());
                System.out.println("Набор карт игрока: " + playerCards);

                moveOperationWrap = gameOperations.computerMoveOperation(computerCards, playerCards);
                computerCards = moveOperationWrap.getComputerCards();
                playerCards = moveOperationWrap.getPlayerCards();
                comp_move = moveOperationWrap.getMove();

                System.out.println("Набор карт игрока: " + playerCards);
                System.out.println("Добавляем карт из колоды...");

                computerCards = gameOperations.distributionCards(cards, computerCards);
                cards.removeAll(computerCards);
                playerCards = gameOperations.distributionCards(cards, playerCards);
                cards.removeAll(playerCards);

                if (computerCards.size() == 0) {
                    System.out.println("Сожалю, Сэр, но Вы проиграли... Победил компьютер.");
                    comp_move = true;
                    System.exit(0);
                }
            }
        }
    }
}
