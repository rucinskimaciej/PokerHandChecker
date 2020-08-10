package online.rumac.main.controller.figure.figureDefinition;

import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.hand.PokerHand;

import java.util.List;

import static online.rumac.main.controller.figure.Util.mapCardValues;

public class ThreeOfAKind extends Figure {

    @Override
    public PokerFigure check(PokerHand hand) {
        return isThreeOfAKind(hand) ? PokerFigure.THREE_OF_A_KIND : null;
    }

    private boolean isThreeOfAKind(PokerHand hand) {
        return mapCardValues(hand, List.of(1,3)).size() == 3;
    }
}
