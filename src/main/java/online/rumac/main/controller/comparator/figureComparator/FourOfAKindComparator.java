package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.model.hand.PokerHand;

import static online.rumac.main.controller.figure.Util.getHighestWinningFigureCard;

public class FourOfAKindComparator extends FigureComparator {
    @Override
    protected int compareIfEqual(PokerHand o1, PokerHand o2) {
        return getHighestWinningFigureCard(o1, o2, 4);
    }
}
