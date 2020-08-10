package online.rumac.main.controller.figure;

import online.rumac.main.controller.figure.figureDefinition.*;
import online.rumac.main.model.card.CardValue;
import online.rumac.main.model.hand.PokerHand;

import java.util.Map;
import java.util.Set;

public enum PokerFigure {
    HIGH_CARD,
    ONE_PAIR,
    TWO_PAIRS,
    THREE_OF_A_KIND,
    STRAIGHT,
    FLUSH,
    FULL_HOUSE,
    FOUR_OF_A_KIND,
    STRAIGHT_FLUSH,
    ROYAL_FLUSH;


    public static PokerFigure check(PokerHand hand) {

        switch (hand.getCardValueMap().size()) {
            case 5:
                return traverse(fiveUniqueCardValuesFigures, hand);
            case 4:
                return traverse(fourUniqueCardValuesFigures, hand);
            case 3:
                return traverse(threeUniqueCardValuesFigures, hand);
            case 2:
                return traverse(twoUniqueCardValuesFigures, hand);
            default:
                return null;
        }
    }

    private static PokerFigure traverse(Set<Figure> figures, PokerHand hand) {
        for (Figure figure : figures) {
            PokerFigure pokerFigure = figure.check(hand);
            if (pokerFigure != null) {
                return pokerFigure;
            }
        }
        return null;
    }

    private static final Set<Figure> fiveUniqueCardValuesFigures = Set.of(
            new RoyalFlush(),
            new StraightFlush(),
            new Straight(),
            new Flush(),
            new HighCard()
    );

    private static final Set<Figure> fourUniqueCardValuesFigures = Set.of(
            new OnePair()
    );

    private static final Set<Figure> threeUniqueCardValuesFigures = Set.of(
            new TwoPairs(),
            new ThreeOfAKind()
    );

    private static final Set<Figure> twoUniqueCardValuesFigures = Set.of(
            new FourOfAKind(),
            new FullHouse()
    );
}
