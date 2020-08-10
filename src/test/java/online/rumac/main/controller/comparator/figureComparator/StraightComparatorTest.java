package online.rumac.main.controller.comparator.figureComparator;

import online.rumac.main.controller.comparator.handComparator.PokerHandComparator;
import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.exceptions.NoSuchCardInDeckException;
import online.rumac.main.model.deck.Deck;
import online.rumac.main.model.hand.PokerHand;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StraightComparatorTest extends FigureComparatorTest {


    @Test
    void comparator() throws NoSuchCardInDeckException {
        // given

        Deck deck = new Deck.Builder().build();
        PokerHand.Builder builder = new PokerHand.Builder();

        PokerHand high10 = builder.build(Set.of(
                deck.popCard("9C"),
                deck.popCard("8S"),
                deck.popCard("7H"),
                deck.popCard("6D"),
                deck.popCard("5C")
        ));

        PokerHand high9 = builder.build(Set.of(
                deck.popCard("8C"),
                deck.popCard("7S"),
                deck.popCard("6H"),
                deck.popCard("5D"),
                deck.popCard("4C")
        ));

        PokerHand high8 = builder.build(Set.of(
                deck.popCard("8D"),
                deck.popCard("7C"),
                deck.popCard("6S"),
                deck.popCard("5H"),
                deck.popCard("4D")
        ));

        PokerHand high7 = builder.build(Set.of(
                deck.popCard("6C"),
                deck.popCard("5S"),
                deck.popCard("4H"),
                deck.popCard("3D"),
                deck.popCard("2C")
        ));

        List<PokerHand> hands = injectPokerFigure(PokerFigure.STRAIGHT, high10, high8, high9, high7);

        // when
        hands.sort(new PokerHandComparator());

        // then
        var expected = List.of(high7.getCards(), high8.getCards(), high9.getCards(), high10.getCards());
        var actual = hands.stream().map(h -> h.getCards()).collect(Collectors.toList());
        assertEquals(expected, actual);

    }

}