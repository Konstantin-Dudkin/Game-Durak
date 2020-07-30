public class Card implements Comparable<Card> {

    public String suit;
    public String cardNum;
    public int veight;

    public Card(String cardNum, String suit, int veight) {
        this.cardNum = cardNum;
        this.suit = suit;
        this.veight = veight;
    }


    public int getVeight() {
        return veight;
    }

    public String getSuit() {
        return suit;
    }

    public String getCardNum() {
        return cardNum;
    }

    @Override
    public String toString() {
        return  cardNum + " " + suit;
    }

    @Override
    public int compareTo(Card o) {
        return this.getVeight() - o.getVeight();
    }

}


