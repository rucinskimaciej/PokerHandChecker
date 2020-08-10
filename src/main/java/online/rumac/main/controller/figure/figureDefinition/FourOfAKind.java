package online.rumac.main.controller.figure.figureDefinition;

import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.hand.PokerHand;

import static online.rumac.main.controller.figure.Util.*;

public class FourOfAKind extends Figure {

    @Override
    public PokerFigure check(PokerHand hand) {
        return isFourOfAKind(hand) ? PokerFigure.FOUR_OF_A_KIND : null;
    }

    private boolean isFourOfAKind(PokerHand hand) {
        return mapCardValues(hand, 4).size() == 1;
    }



}
