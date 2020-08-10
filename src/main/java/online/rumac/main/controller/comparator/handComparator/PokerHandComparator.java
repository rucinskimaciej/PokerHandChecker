package online.rumac.main.controller.comparator.handComparator;

import online.rumac.main.controller.comparator.figureComparator.*;
import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.hand.PokerHand;


public class PokerHandComparator implements PokerHandComparatorInterface {

    @Override
    public int compare(PokerHand o1, PokerHand o2) {
        if (!o1.getPokerFigure().equals(o2.getPokerFigure())) {
            return o1.getPokerFigure().compareTo(o2.getPokerFigure());
        }
        return compareIfEqual(o1, o2);
    }

    @Override
    public int compareIfEqual(PokerHand o1, PokerHand o2) {
        assert o1.getPokerFigure() == o2.getPokerFigure();
        PokerFigure figure = o1.getPokerFigure();

        switch (figure) {
            case HIGH_CARD:
                return new HighCardComparator().compare(o1, o2);
            case ONE_PAIR:
                return new OnePairComparator().compare(o1, o2);
            case TWO_PAIRS:
                return new TwoPairsComparator().compare(o1, o2);
            case THREE_OF_A_KIND:
                return new ThreeOfAKindComparator().compare(o1, o2);
            case STRAIGHT:
                return new StraightComparator().compare(o1, o2);
            case FLUSH:
                return new FlushComparator().compare(o1, o2);
            case FULL_HOUSE:
                return new FullHouseComparator().compare(o1, o2);
            case FOUR_OF_A_KIND:
                return new FourOfAKindComparator().compare(o1, o2);
            case STRAIGHT_FLUSH:
                return new StraightFlushComparator().compare(o1, o2);
            case ROYAL_FLUSH:
                return new RoyalFlushComparator().compare(o1, o2);
        }
        return 0;
    }

}
