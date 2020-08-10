package online.rumac.main.controller.figure;

import online.rumac.main.model.card.Deck;
import online.rumac.main.model.hand.PokerHand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class PokerFigureTest {

    private Deck deck;

    @BeforeEach
    void setDeck() {
        deck = Deck.build();
    }

    @RepeatedTest(value = 10)
    void check() {
        // given
        PokerHand hand = PokerHand.build(deck);

        // when
        PokerFigure figure = PokerFigure.check(hand);

        // then
        System.out.println(String.format("%s => %s", hand, figure));
        assertNotNull(figure);
    }
}