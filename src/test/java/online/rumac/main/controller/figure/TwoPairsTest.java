package online.rumac.main.controller.figure;

import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.model.card.Card;
import online.rumac.main.model.card.CardValue;
import online.rumac.main.model.card.Suit;
import org.junit.jupiter.api.Test;

import java.util.Set;

class TwoPairsTest {


    @Test
    void twoPairs() {
        // given
        PokerHand hand = PokerHand.build(Set.of(
                Card.build(CardValue.FIVE, Suit.H),
                Card.build(CardValue.J, Suit.C),
                Card.build(CardValue.FIVE, Suit.C),
                Card.build(CardValue.FOUR, Suit.H),
                Card.build(CardValue.FOUR, Suit.S)
        ));
        // when
        PokerFigure expected = PokerFigure.TWO_PAIRS;

        // then
    }


}