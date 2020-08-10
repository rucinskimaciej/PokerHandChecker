package online.rumac.main.controller.figure.figureDefinition;

import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.hand.PokerHand;

import static online.rumac.main.controller.figure.Util.*;

public class Flush extends Figure {

    public PokerFigure check(PokerHand hand) {
        return isFlush(hand) ? PokerFigure.FLUSH : null;
    }

    private static boolean isFlush(PokerHand hand) {
        return !isStraightType(hand) && ofOneSuit(hand);
    }

}
