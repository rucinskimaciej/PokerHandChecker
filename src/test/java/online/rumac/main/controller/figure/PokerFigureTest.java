package online.rumac.main.controller.figure;

import online.rumac.main.model.deck.Deck;
import online.rumac.main.model.hand.PokerHand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class PokerFigureTest {

    private Deck deck;

    @BeforeEach
    void setDeck() {
        deck = new Deck.Builder().build();
    }

    @RepeatedTest(value = 10)
    void check() {
        // given
        PokerHand hand = new PokerHand.Builder().build(deck);

        // when
        PokerFigure figure = PokerFigure.check(hand);

        // then
        System.out.printf("%s => %s%n", hand, figure);
        assertNotNull(figure);
    }
}