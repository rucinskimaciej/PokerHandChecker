package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.controller.figure.Util;
import online.rumac.main.model.hand.PokerHand;

public class FullHouseComparator extends FigureComparator {

    @Override
    protected int compareIfEqual(PokerHand o1, PokerHand o2) {
        return Util.getHighestWinningFigureCard(o1, o2, 3);
    }
}
