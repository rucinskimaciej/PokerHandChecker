package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.controller.figure.Util;
import online.rumac.main.model.hand.PokerHand;

public class StraightFlushComparator extends FigureComparator {
    @Override
    protected int compareIfEqual(PokerHand o1, PokerHand o2) {
        return Util.compareByHighCard(o1, o2);
    }
}
