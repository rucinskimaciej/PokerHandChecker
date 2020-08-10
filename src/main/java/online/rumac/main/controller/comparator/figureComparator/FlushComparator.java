package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.model.card.CardComparator;
import online.rumac.main.model.hand.PokerHand;

import static online.rumac.main.controller.figure.Util.getHighCard;

public class FlushComparator extends FigureComparator {

    @Override
    public int compareIfEqual(PokerHand o1, PokerHand o2) {
        return new CardComparator().compare(getHighCard(o1.getCards()), getHighCard(o2.getCards()));
    }
}
