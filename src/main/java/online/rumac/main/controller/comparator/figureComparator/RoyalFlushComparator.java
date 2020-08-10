package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.model.hand.PokerHand;

public class RoyalFlushComparator extends FigureComparator {
    @Override
    protected int compareIfEqual(PokerHand o1, PokerHand o2) {
        return 0; // intentionally => high card in RoyalFlush is Ace and two RF == tie;
    }
}
