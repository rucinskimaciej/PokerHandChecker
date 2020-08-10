package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.model.hand.PokerHand;

import java.util.Comparator;

abstract class FigureComparator implements Comparator<PokerHand> {

    @Override
    public int compare(PokerHand o1, PokerHand o2) {
        if (o1.getPokerFigure().equals(o2.getPokerFigure())) {
            int comparator = compareIfEqual(o1, o2);
            return comparator;
        }
        return 0;
    }

    protected abstract int compareIfEqual(PokerHand o1, PokerHand o2);

}
