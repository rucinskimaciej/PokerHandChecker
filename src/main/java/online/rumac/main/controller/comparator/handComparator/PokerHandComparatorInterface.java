package online.rumac.main.controller.comparator.handComparator;

import online.rumac.main.model.hand.PokerHand;

import java.util.Comparator;

public interface PokerHandComparatorInterface extends Comparator<PokerHand> {

    int compareIfEqual(PokerHand o1, PokerHand o2);

}
