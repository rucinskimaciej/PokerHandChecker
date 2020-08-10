package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.model.hand.PokerHand;

import static online.rumac.main.controller.figure.Util.compareByHighCard;

public class HighCardComparator extends FigureComparator {

    @Override
    public int compareIfEqual(PokerHand o1, PokerHand o2) {
        return compareByHighCard(o1, o2);
    }
}
