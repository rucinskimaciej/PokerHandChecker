package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.hand.PokerHand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FigureComparatorTest {

    List<PokerHand> injectPokerFigure(PokerFigure figure, PokerHand ... hands) {
        PokerHand.Builder builder = new PokerHand.Builder();
        return Arrays.stream(hands)
                .map(builder::build)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}