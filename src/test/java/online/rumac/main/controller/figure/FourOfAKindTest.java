package online.rumac.main.controller.figure;

import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.model.card.Card;
import online.rumac.main.model.card.CardValue;
import online.rumac.main.model.card.Suit;
import org.junit.jupiter.api.Test;

import java.util.Set;

class FourOfAKindTest {

    @Test
    void fourOfAKind() {
        // given
        PokerHand hand = PokerHand.build(Set.of(
                Card.build(CardValue.K, Suit.H),
                Card.build(CardValue.FOUR, Suit.D),
                Card.build(CardValue.FOUR, Suit.C),
                Card.build(CardValue.FOUR, Suit.H),
                Card.build(CardValue.FOUR, Suit.S)
        ));
        // when
        PokerFigure expected = PokerFigure.FOUR_OF_A_KIND;

        // then

    }


}