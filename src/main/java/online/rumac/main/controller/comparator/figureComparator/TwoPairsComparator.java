package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.controller.figure.Util;
import online.rumac.main.model.hand.PokerHand;


import java.util.List;

public class TwoPairsComparator extends FigureComparator {
    @Override
    protected int compareIfEqual(PokerHand o1, PokerHand o2) {

        int higherPair = getHighestWiningPair(o1, o2);
        if (higherPair != 0) {
            return higherPair;
        }
        return Util.compareByHighCard(o1, o2);
    }

    private int getHighestWiningPair(PokerHand o1, PokerHand o2) {
        List<Integer> o1cardValuesMap = Util.cardValuesCountAsList(Util.mapCardValues(o1, 2));
        List<Integer> o2cardValuesMap = Util.cardValuesCountAsList(Util.mapCardValues(o2, 2));

        return Util.findListWithBiggestMaxValue(o1cardValuesMap, o2cardValuesMap);
    }
}
