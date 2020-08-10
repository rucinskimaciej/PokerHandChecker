package online.rumac.main.controller.figure.figureDefinition;

import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.card.CardValue;
import online.rumac.main.model.hand.PokerHand;

import static online.rumac.main.controller.figure.Util.*;

public class RoyalFlush extends Figure {

    @Override
    public PokerFigure check(PokerHand hand) {
        return isRoyalFlush(hand) ? PokerFigure.ROYAL_FLUSH : null;
    }

    private boolean isRoyalFlush(PokerHand hand) {
        if (isStraightType(hand) && ofOneSuit(hand)) {
            return hand.getCards().stream().anyMatch(c -> CardValue.A.equals(c.getValue()));
        }
        return false;
    }
}
