package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.controller.comparator.handComparator.PokerHandComparator;
import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.exceptions.NoSuchCardInDeckException;
import online.rumac.main.model.card.Deck;
import online.rumac.main.model.hand.PokerHand;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OnePairComparatorTest extends FigureComparatorTest {

    @Test
    void comparator() throws NoSuchCardInDeckException {
        // given

        Deck deck = Deck.build();

        PokerHand onePairOfQHighA = PokerHand.build(Set.of(
                deck.popCard("AC"),
                deck.popCard("2D"),
                deck.popCard("4H"),
                deck.popCard("QH"),
                deck.popCard("QC")
        ));

        PokerHand onePairOf2 = PokerHand.build(Set.of(
                deck.popCard("2H"),
                deck.popCard("2C"),
                deck.popCard("3C"),
                deck.popCard("4C"),
                deck.popCard("5C")
        ));

        PokerHand onePairOfQHighJ = PokerHand.build(Set.of(
                deck.popCard("JD"),
                deck.popCard("2S"),
                deck.popCard("4S"),
                deck.popCard("QS"),
                deck.popCard("QD")
        ));

        List<PokerHand> hands = injectPokerFigure(PokerFigure.ONE_PAIR, onePairOfQHighA, onePairOf2, onePairOfQHighJ);

        // when
        hands.sort(new PokerHandComparator());

        // then
        var expected = List.of(onePairOf2.getCards(), onePairOfQHighJ.getCards(), onePairOfQHighA.getCards());
        var actual = hands.stream().map(h -> h.getCards()).collect(Collectors.toList());
        assertEquals(expected, actual);

    }
}