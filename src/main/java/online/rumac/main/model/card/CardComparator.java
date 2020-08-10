package online.rumac.main.model.card;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        return Integer.compare(c1.getCardValue().ordinal(), c2.getCardValue().ordinal());
    }

    @Override
    public Comparator<Card> reversed() {
        return (c1, c2) -> new CardComparator().compare(c2, c1);
    }
}
