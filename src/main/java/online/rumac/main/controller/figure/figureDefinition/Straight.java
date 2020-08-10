package online.rumac.main.controller.figure.figureDefinition;


import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.hand.PokerHand;

import static online.rumac.main.controller.figure.Util.isStraightType;
import static online.rumac.main.controller.figure.Util.ofOneSuit;

public class Straight extends Figure {

    @Override
    public PokerFigure check(PokerHand hand) {
        return isStraight(hand) ? PokerFigure.STRAIGHT : null;
    }

    private boolean isStraight(PokerHand hand) {
        return !ofOneSuit(hand) && isStraightType(hand);
    }
}
