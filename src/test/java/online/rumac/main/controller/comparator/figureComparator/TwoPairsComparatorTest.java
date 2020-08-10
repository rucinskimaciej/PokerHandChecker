package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.controller.comparator.handComparator.PokerHandComparator;
import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.deck.Deck;
import online.rumac.main.model.exceptions.NoSuchCardInDeckException;
import online.rumac.main.model.deck.Deck;
import online.rumac.main.model.hand.PokerHand;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TwoPairsComparatorTest extends FigureComparatorTest {
    @Test
    void comparator() throws NoSuchCardInDeckException {
        // given

        Deck deck = new Deck.Builder().build();
        PokerHand.Builder builder = new PokerHand.Builder();

        PokerHand twoPairsQandJHighA = builder.build(Set.of(
                deck.popCard("AH"),
                deck.popCard("JD"),
                deck.popCard("JH"),
                deck.popCard("QD"),
                deck.popCard("QH")
        ));

        PokerHand twoPairsQandJHigh2 = builder.build(Set.of(
                deck.popCard("2S"),
                deck.popCard("JS"),
                deck.popCard("JC"),
                deck.popCard("QS"),
                deck.popCard("QC")
        ));

        PokerHand twoPairs4andTenQHighA = builder.build(Set.of(
                deck.popCard("AD"),
                deck.popCard("4C"),
                deck.popCard("4S"),
                deck.popCard("10C"),
                deck.popCard("10S")
        ));

        List<PokerHand> hands = injectPokerFigure(PokerFigure.TWO_PAIRS, twoPairsQandJHighA, twoPairsQandJHigh2, twoPairs4andTenQHighA);

        // when
        hands.sort(new PokerHandComparator());

        // then
        var expected = List.of(twoPairs4andTenQHighA.getCards(), twoPairsQandJHigh2.getCards(), twoPairsQandJHighA.getCards());
        var actual = hands.stream().map(h -> h.getCards()).collect(Collectors.toList());
        assertEquals(expected, actual);

    }
}