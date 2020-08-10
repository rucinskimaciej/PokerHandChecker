package online.rumac.main.controller.figure.figureDefinition;

import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.hand.PokerHand;

import java.util.List;

import static online.rumac.main.controller.figure.Util.mapCardValues;

public class FullHouse extends Figure {


    @Override
    public PokerFigure check(PokerHand hand) {
        return isFullHouse(hand) ? PokerFigure.FULL_HOUSE : null;
    }

    private boolean isFullHouse(PokerHand hand) {
        return mapCardValues(hand, List.of(2, 3)).size() == 2;
    }
}
