package online.rumac.main.model.card;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        return Integer.compare(c1.getValue().ordinal(), c2.getValue().ordinal());
    }

    @Override
    public Comparator<Card> reversed() {
        return (c1, c2) -> new CardComparator().compare(c2, c1);
    }
}
