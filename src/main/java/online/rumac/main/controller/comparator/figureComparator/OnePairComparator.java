package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.model.hand.PokerHand;

import static online.rumac.main.controller.figure.Util.*;

public class OnePairComparator extends FigureComparator {

    @Override
    protected int compareIfEqual(PokerHand o1, PokerHand o2) {

        int higherPair = getHighestWinningFigureCard(o1, o2, 2);
        if (higherPair != 0) {
            return higherPair;
        }
        return compareByHighCard(o1, o2);
    }

}
