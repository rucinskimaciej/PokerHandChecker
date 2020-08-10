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

class FullHouseComparatorTest extends FigureComparatorTest {


    @Test
    void comparator() throws NoSuchCardInDeckException {
        // given

        Deck deck = Deck.build();

        PokerHand fullHouseQOnA = PokerHand.build(Set.of(
                deck.popCard("AH"),
                deck.popCard("AD"),
                deck.popCard("QD"),
                deck.popCard("QH"),
                deck.popCard("QC")
        ));

        PokerHand fullHouseKOnTwo = PokerHand.build(Set.of(
                deck.popCard("2H"),
                deck.popCard("2C"),
                deck.popCard("KD"),
                deck.popCard("KS"),
                deck.popCard("KC")
        ));

        List<PokerHand> hands = injectPokerFigure(PokerFigure.FULL_HOUSE, fullHouseQOnA, fullHouseKOnTwo);

        // when
        hands.sort(new PokerHandComparator());

        // then
        var expected = List.of(fullHouseQOnA.getCards(), fullHouseKOnTwo.getCards());
        var actual = hands.stream().map(h -> h.getCards()).collect(Collectors.toList());
        assertEquals(expected, actual);

    }

}