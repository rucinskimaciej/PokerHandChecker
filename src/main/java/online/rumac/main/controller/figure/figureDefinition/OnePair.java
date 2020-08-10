package online.rumac.main.controller.figure.figureDefinition;

import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.controller.figure.Util;
import online.rumac.main.model.hand.PokerHand;

import java.util.List;

public class OnePair extends Figure {

    @Override
    public PokerFigure check(PokerHand hand) {
        return isOnePair(hand) ? PokerFigure.ONE_PAIR : null;
    }

    private boolean isOnePair(PokerHand hand) {
        return Util.mapCardValues(hand, List.of(1,2)).size() == 4;
    }
}
