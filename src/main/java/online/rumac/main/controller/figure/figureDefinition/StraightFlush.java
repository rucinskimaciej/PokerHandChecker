package online.rumac.main.controller.figure.figureDefinition;

import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.card.CardValue;
import online.rumac.main.model.hand.PokerHand;

import static online.rumac.main.controller.figure.Util.isStraightType;
import static online.rumac.main.controller.figure.Util.ofOneSuit;

public class StraightFlush extends Figure {


    @Override
    public PokerFigure check(PokerHand hand) {
        return isStraightFlush(hand) ? PokerFigure.STRAIGHT_FLUSH : null;
    }

    private boolean isStraightFlush(PokerHand hand) {
        if (hand.getCards().stream().anyMatch(c -> CardValue.A.equals(c.getValue()))) {
            return false;
        }
        return isStraightType(hand) && ofOneSuit(hand);
    }
}
