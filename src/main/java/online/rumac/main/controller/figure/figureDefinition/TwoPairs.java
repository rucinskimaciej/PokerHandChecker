package online.rumac.main.controller.figure.figureDefinition;

import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.controller.figure.Util;
import online.rumac.main.controller.figure.figureDefinition.Figure;
import online.rumac.main.model.hand.PokerHand;

public class TwoPairs extends Figure {

    @Override
    public PokerFigure check(PokerHand hand) {
        return isTwoPairs(hand) ? PokerFigure.TWO_PAIRS : null;
    }

    private boolean isTwoPairs(PokerHand hand) {
        return Util.mapCardValues(hand, 2).size() == 2;
    }
}
